package com.GiveaLot.givealot.Certificate.service;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Blockchain.service.BlockchainServiceImpl;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailService;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class CertificateServiceImpl implements CertificateService {

    private BlockchainService blockchainService;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    SendMailService service;



    @Autowired
    CertificateServiceImpl(SendMailService service)
   {
        this.service = service;
   }

    @Override
    public boolean addCertificate(long orgId) throws Exception {

        OrganisationPoints organisationPoints = new OrganisationPoints();

        organisationPoints.setPoints(0);

        Certificate cert= certificateRepository.selectCertificateById(orgId);

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);

       boolean certificateCreated = createPDFDocument(cert,organisation,organisationPoints);

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



        return true;
    }

    @Override
    public boolean updateCertificate(long orgId) throws Exception {

        //query organisation, certificate, org points, blockchain

        //we need to remove points from organisationpoints and add it to certificate, we need to remove certlevel from certificate and add it to blockchain

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);
        OrganisationPoints organisationPoints = organisationPointsRepository(orgId);
        Certificate cert = certificateRepository.selectCertificateById(orgId);

        boolean certificateCreated = createPDFDocument(cert,organisation,organisationPoints);

        if(!certificateCreated){
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = retrieveCertificate(orgId, organisation.getOrgName());

        String[] result = blockchainService
                .upgradeCertificate(0,orgId, certificate,0);

        String certificateHash = result[0];
        String txHash = result[1];

        Blockchain blockchain = new Blockchain(orgId,index,0,txHash,certificateHash);

        return true;
    }

    @Override
    public File retrieveCertificate(long orgId, String orgName) throws Exception {
        ServerAccess access = new ServerAccess();

        return access.downloadCertificate(orgId,orgName);
    }



    @Override
    public boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception {
        ServerAccess access = new ServerAccess();



        access.downloadCertificateTemplate(points);

        String templateCertificate = "backend/src/main/resources/TempCertificate/CertificateTemplate.pdf";
        String completeCertificate = "backend/src/main/resources/TempCertificate/CertificateComplete.pdf";

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
        }catch (Exception e){
            throw new Exception("Exception: unable to create certificate");
        }

        document.save(completeCertificate);
        document.close();

        access.uploadCertificate(organisation.getOrgId(), organisation.getOrgName());

        File deletion1 = new File(templateCertificate);
        File deletion2 = new File(completeCertificate);

        deletion1.delete();
        deletion2.delete();

        return true;

    }

    @Override
    public boolean checkRenewal() throws Exception {
        return false;
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
}
