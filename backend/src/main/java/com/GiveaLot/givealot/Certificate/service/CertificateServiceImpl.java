package com.GiveaLot.givealot.Certificate.service;
import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.requests.RetrieveCertificateRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.service.eventsServiceImp;
import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailService;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationDataRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
    private SendMailService sendMailService;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private BlockChainRepository blockChainRepository;

    @Autowired
    private ServerAccess access = new ServerAccess();

    @Autowired
    private final SendMailService service;

    @Autowired
    private eventsServiceImp eventsService;

    @Autowired
    private OrganisationDataRepository organisationDataRepository;

    @Autowired
    public CertificateServiceImpl(BlockchainService blockchainService, OrganisationRepository organisationRepository, CertificateRepository certificateRepository, BlockChainRepository blockChainRepository, SendMailService service) {
        this.blockchainService = blockchainService;
        this.organisationRepository = organisationRepository;
        this.certificateRepository = certificateRepository;
        this.blockChainRepository = blockChainRepository;
        this.service = service;
    }

    @Override
    public boolean addCertificate(long orgId, Certificate cert) throws Exception {

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);

        System.out.println("=================================================");
        boolean certificateCreated = createPDFDocument(cert, organisation, 0);

        if (!certificateCreated) {
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        //File certificate = retrieveCertificate(new RetrieveCertificateRequest(orgId, organisation.getOrgName()));
        System.out.println("hello ============= addCertificate");
        File certificate = new File("src/main/resources/localFiles/"+orgId+"/certificate/CertificateComplete.pdf");
        /*System.out.println("===============saving certificate to db=================");
        //byte [] byte_pdf = FileUtils.readFileToByteArray(certificate);


        FileInputStream input = new FileInputStream(certificate);
        MultipartFile multipartFile = new MockMultipartFile("file",
                certificate.getName(), "application/pdf", IOUtils.toByteArray(input));

        organisationDataRepository.updateCertificate(orgId,multipartFile.getBytes());
        System.out.println("===============saving certificate to db complete=================");*/

        String[] result = blockchainService
                .uploadCertificate(orgId, certificate);
        String certificateHash = result[0];
        String txHash = result[1];
        long index = blockchainService.findCertificateIndex(orgId);

        Blockchain blockchain = new Blockchain(orgId, index, 0, txHash, certificateHash);

        blockChainRepository.save(blockchain);
        System.out.println("===============saving certificate to db exit=================");
        return true;
    }

    @Override
    public boolean updateCertificate(long orgId) throws Exception {

        Organisations organisation = organisationRepository.selectOrganisationById(orgId);
        Certificate cert = certificateRepository.selectCertificateById(orgId);
        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(orgId);

        boolean certificateCreated = createPDFDocument(cert, organisation, cert.getPoints());

        if (!certificateCreated) {
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = new File("src/main/resources/localFiles/"+orgId+"/certificate/CertificateComplete.pdf");

        String[] result = blockchainService
                .upgradeCertificate(blockchain.getIndex(), orgId, certificate, blockchain.getLevel());

        String certificateHash = result[0];
        String txHash = result[1];
        long lev = blockchain.getLevel();
        blockChainRepository.UpdateBlockchain(blockchain.getIndex(), blockchain.getLevel() + 1, txHash, certificateHash, orgId);

        Date dateCurrent = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);
        eventsService.addTimelineEvent(new addTimeLineEventRequest(orgId, dateCreated, "certificate upgraded", "congratulations, your certificate was upgraded to level " + (lev + 1)));

        Mail mail = new Mail(organisation.getOrgEmail(), "Givealot Certificate Upgrade", "Congratulations your organisation has successfully upgraded their certificate from level: " + lev + " to level:" + lev + 1 + "\n" +
                "\n Thank you for supporting safe and authentic practices we look forward for you next upgrade" +
                "\n" +
                "\n" +
                "Kind Regards \n" +
                "Give A Lot Team");

        sendMailService.sendMail(mail);
        System.out.println("Email sent successfully");
        return true;
    }

    @Override
    public void refreshCertificates(long bottom, long top) throws Exception {
        for (long i = bottom; i < top+1; i++) {
            updateCertificate(i);
            System.out.println("[Organisation " + i + " has been refreshed]");
        }
        System.out.println("[Certificates have been refreshed]");
    }

    @Override
    public File retrieveCertificate(RetrieveCertificateRequest request) throws Exception {
        System.out.println(request.getOrgId() + " --certificate-- " + request.getOrgName());
        return access.downloadCertificate(request.getOrgId(), request.getOrgName());
    }

    @Override
    public File retrieveCertificateAsPNG(RetrieveCertificateRequest request) throws Exception {
        System.out.println(request.getOrgId() + " --certificate png-- " + request.getOrgName());
        return access.downloadCertificatePNG(request.getOrgId(), request.getOrgName());
    }

    public File retrieveLogo(Long orgId) throws Exception {
        System.out.println(orgId + " --logo-- " );
        return access.downloadImageLogo(orgId);
    }

    @Override
    public boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception {
        access.downloadCertificateTemplate(points);
        System.out.println("===============createPDFDocument()=================");

        if(!new File("/app/src/main/resources/localFiles/" + organisation.getOrgId() + "/certificate/").mkdir()){
            String orgIdString = String.valueOf(organisation.getOrgId());
            String localStorage = "src/main/resources/localFiles/" + orgIdString;
            String localImageStorage = "src/main/resources/localFiles/" + orgIdString + "/gallery";
            String localImageStorage2 = "src/main/resources/localFiles/" + orgIdString + "/gallery/backup";
            String localCertificateStorage = "src/main/resources/localFiles/" + orgIdString + "/certificate";
            System.out.println(localCertificateStorage);

            File directoryLocal = new File(localStorage);
            File directoryImageLocal = new File(localImageStorage);
            File directoryImageLocal2 = new File(localImageStorage2);
            File directoryCertLocal = new File(localCertificateStorage);

            directoryLocal.mkdir();
            directoryImageLocal.mkdir();
            directoryImageLocal2.mkdir();
            directoryCertLocal.mkdir();
            System.out.println("complete");
        }

        if (points != 0) {
            File deletion = new File("src/main/resources/src/localFiles/" + organisation.getOrgId() + "certificate/CertificateComplete.pdf");
            deletion.delete();
        }


        String templateCertificate = "/app/src/main/resources/TempCertificate/CertificateTemplate.pdf";
        String completeCertificate = "/app/src/main/resources/localFiles/" + organisation.getOrgId() + "/certificate/CertificateComplete.pdf";

        /** Setup the pdf file **/

        File template = new File(templateCertificate);
        System.out.println("works");
        PDDocument document = PDDocument.load(template);
        PDDocumentCatalog catalog = document.getDocumentCatalog();

        PDAcroForm acroForm = catalog.getAcroForm();

        /** Assign acroform fields **/
        System.out.println("works");
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
        } catch (Exception e) {
            throw new Exception("Exception: unable to create certificate: " + e);
        }
        System.out.println("works");


        document.save(completeCertificate);
        document.close();
        System.out.println("works");

        imageCreator(completeCertificate, organisation.getOrgId());


        access.uploadCertificate(organisation.getOrgId(), organisation.getOrgName());
        access.uploadCertificatePNG(organisation.getOrgId(), organisation.getOrgName());

        File deletion1 = new File(templateCertificate);

        deletion1.delete();

        return true;

    }

    public void imageCreator(String filepath, long orgId) throws Exception {
        try {
            PDDocument document = PDDocument.load(new File(filepath));

            System.out.println("===============saving certificate to db=================");
            File pdf_tmp = new File(filepath);
            FileInputStream input = new FileInputStream(pdf_tmp);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    pdf_tmp.getName(), "application/pdf", IOUtils.toByteArray(input));

            organisationDataRepository.updateCertificate(orgId,multipartFile.getBytes());

            System.out.println("===============saving certificate to db complete=================");


            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 50, ImageType.RGB);

                // suffix in filename will be used as the file format
                ImageIOUtil.writeImage(bim, "src/main/resources/localFiles/" + orgId + "/certificate/CertificateImage.png", 50);
            }
            document.close();

            File image_tmp = new File("src/main/resources/localFiles/" + orgId + "/certificate/CertificateImage.png");

            input = new FileInputStream(image_tmp);
            multipartFile = new MockMultipartFile("file",
                    image_tmp.getName(), "image/png", IOUtils.toByteArray(input));
            organisationDataRepository.updateCertificateImage(orgId,multipartFile.getBytes());


        }catch (Exception e){
            throw new Exception("Exception: unable to create certificate image: " + e);
        }

    }

    @Override
    public boolean checkRenewal() throws Exception {
        List<Certificate> certificateList = certificateRepository.findAll();

        Date dateCurrent = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        List<Long> id = new ArrayList<>();
        List<Date> expiry = new ArrayList<>();
        ;

        for (int i = 0; i < certificateList.size(); i++) {
            id.add(certificateList.get(i).getOrgId());
            expiry.add(format.parse(certificateList.get(i).getDateExpiry()));
        }

        for (int i = 0; i < id.size(); i++) {
            if (expiry.get(i) == null)
                throw new NullPointerException();

            Date sqlDate = expiry.get(i);

            boolean check = dateCurrent.after(sqlDate);
            if (check) {
                certificateRepository.updateOrgRenewal(id.get(i), false);
                certificateRepository.updateAdminRenewal(id.get(i), false);
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
        certificateRepository.updateOrgRenewal(orgId, true);
        return true;
    }

    @Override
    public boolean adminRenewal(long orgId) throws Exception {
        certificateRepository.updateAdminRenewal(orgId, true);
        return true;
    }

    @Override
    public long compareCertificate(MultipartFile certificate) throws Exception {
        File certCmp = new File("TempCompareCertificate.pdf");
        if (!certCmp.exists()) {
            certCmp.createNewFile();
        }

        try (OutputStream os = new FileOutputStream(certCmp)) {
            os.write(certificate.getBytes());
        }

        System.out.println("============comparing certificate===========");
        Blockchain blockchain = blockChainRepository.selectBlockchainCertificateHash(
                blockchainService.hashCertificate(certCmp));
        if (blockchain == null) {
            return -1;
        }
        return blockchainService.compareCertificateHash(blockchain.getIndex(), blockchain.getOrgId(), certCmp);
    }


}
