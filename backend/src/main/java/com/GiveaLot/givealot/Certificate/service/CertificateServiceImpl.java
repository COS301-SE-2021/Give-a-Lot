package com.GiveaLot.givealot.Certificate.service;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailService;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Configurable
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private BlockchainService blockchainService;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private BlockChainRepository blockChainRepository;

    @Autowired
    private final ServerAccess access = new ServerAccess();

    @Autowired
    private final SendMailService service;

    @Autowired
    public CertificateServiceImpl(SendMailService service)
   {
        this.service = service;
   }

    @Override
    public boolean addCertificate(long orgId, Certificate cert) throws Exception {

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);

       boolean certificateCreated = createPDFDocument(cert,organisation,0);

        if(!certificateCreated){
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = retrieveCertificate(orgId, organisation.getOrgName());

        String[] result = blockchainService
                .uploadCertificate(orgId, certificate);
        String certificateHash = result[0];
        String txHash = result[1];
        long index = blockchainService.findCertificateIndex(orgId);

        Blockchain blockchain = new Blockchain(orgId,index,0,txHash,certificateHash);

        blockChainRepository.save(blockchain);

        return true;
    }

    @Override
    public boolean updateCertificate(long orgId) throws Exception {

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);
        Certificate cert = certificateRepository.selectCertificateById(orgId);
        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(orgId);

        boolean certificateCreated = createPDFDocument(cert,organisation,cert.getPoints());

        if(!certificateCreated){
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = retrieveCertificate(orgId, organisation.getOrgName());

        String[] result = blockchainService
                .upgradeCertificate(0,orgId, certificate,0);

        String certificateHash = result[0];
        String txHash = result[1];

        blockChainRepository.UpdateBlockchain(blockchain.getIndex(),blockchain.getLevel()+1,txHash,certificateHash,orgId);

        return true;
    }

    @Override
    public File retrieveCertificate(long orgId, String orgName) throws Exception {
        return access.downloadCertificate(orgId,orgName);
    }

    @Override
    public boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception {
        access.downloadCertificateTemplate(points);

        if (points!=0){
            File deletion = new File("frontend/givealot/localFiles/" + organisation.getOrgId() + "certificate/CertificateComplete.pdf");
            deletion.delete();
        }

        String templateCertificate = "backend/src/main/resources/TempCertificate/CertificateTemplate.pdf";
        String completeCertificate = "frontend/givealot/localFiles/" + organisation.getOrgId() + "/certificate/CertificateComplete.pdf";

        /** Setup the pdf file **/

        File template = new File(templateCertificate);

        PDDocument document = Loader.loadPDF(template);
        PDDocumentCatalog catalog = document.getDocumentCatalog();

        PDAcroForm acroForm = catalog.getAcroForm();

        /** Assign acroform fields **/

        try {

            if (acroForm != null) {

                PDField field = (PDField) acroForm.getField("name"); // Name
                field.setValue(organisation.getOrgName().toUpperCase());

                field = (PDField) acroForm.getField("slogan"); // Slogan
                field.setValue(organisation.getSlogan());


                field = (PDField) acroForm.getField("created"); // Date Created
                field.setValue(cert.getDateCreated());

                field = (PDField) acroForm.getField("expiry"); // Date Expiry
                field.setValue(cert.getDateExpiry());

                acroForm.flatten();

            }
            System.out.println("works2");
        }catch (Exception e){
            throw new Exception("Exception: unable to create certificate: " + e);
        }
        System.out.println("works3");

        document.save(completeCertificate);
        document.close();

        access.uploadCertificate(organisation.getOrgId(), organisation.getOrgName());

        File deletion1 = new File(templateCertificate);

        deletion1.delete();

        return true;

    }

    @Override
    public boolean checkRenewal() throws Exception {
        List<Certificate> certificateList = certificateRepository.findAll();

        Date dateCurrent = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        List<Long> id = new ArrayList<>();
        List<Date> expiry = new ArrayList<>();;

        for (int i = 0; i < certificateList.size(); i++) {
            id.add(certificateList.get(i).getOrgId());
            expiry.add(format.parse(certificateList.get(i).getDateExpiry()));
        }

        for (int i = 0; i < id.size(); i++) {
            if(expiry.get(i)==null)
                throw new NullPointerException();

            Date sqlDate = expiry.get(i);

            boolean check = dateCurrent.after(sqlDate);
            if (check) {
                certificateRepository.updateOrgRenewal(id.get(i),false);
                certificateRepository.updateAdminRenewal(id.get(i),false);
            }
        }
        return true;
    }

    @Override
    public boolean CertificateExpiredEmail(String orgName, String orgEmail) throws Exception {
        Mail mail = new Mail();

        mail.setRecipient(orgEmail);
        mail.setSubject("Givealot Certificate Expiried");
        mail.setMessage("Good day we hope this email finds you well,\n We regret to inform you that your certificate has expired please log in to your portal to renew it" +
                "\n Kind Regards\n" +
                "Givalot Team");

        service.sendMail(mail);

        return true;
    }

    @Override
    public boolean organisationRenewal(long orgId) throws Exception {
        certificateRepository.updateOrgRenewal(orgId,true);
        return true;
    }

    @Override
    public boolean adminRenewal(long orgId) throws Exception {
        certificateRepository.updateAdminRenewal(orgId,true);
        return true;
    }

    @Override
    public boolean compareCertificate(File certificate) throws Exception {

        Blockchain blockchain = blockChainRepository.selectBlockchainCertificateHash(
                blockchainService.hashCertificate(certificate));
        return blockchainService.compareCertificateHash(blockchain.getIndex(),blockchain.getOrgId(),certificate);
    }


}
