
package com.GiveaLot.givealot.Certificate.dao;

import com.GiveaLot.givealot.Blockchain.dao.BlockchainDAOInterface;
import com.GiveaLot.givealot.Blockchain.dao.BlockchainDASTemp;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;

import com.GiveaLot.givealot.Server.ServerAccess;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Repository("CertificateTemp")
public class CertificateDASTemp implements CertificateDAOInterface{

    @Autowired
    public CertificateDASTemp() {

    }


    @Override
    public boolean addCertificate(long orgId) throws Exception {
        BlockchainService blockchainService = new BlockchainService(new BlockchainDASTemp());

        OrganisationPoints organisationPoints = new OrganisationPoints();

        organisationPoints.setPoints(0);

        //query organisation, certificate

//        boolean certificateCreated = createPDFDocument(cert,organisation,organisationPoints);
//
//        if(!certificateCreated){
//            throw new Exception("Exception: Problem creating and storing certificate");
//        }
//
//        File certificate = retrieveCertificate(orgId, organisation.getOrgName());
//
//        String[] result = blockchainService
//                .uploadCertificate(orgId, certificate);
//
//        String certificateHash = result[0];
//        String txHash = result[1];
//
//        long index = blockchainService.findCertificateIndex(orgId);

        //query to add current latest tx hash, index, certificate hash and level to blockchain table;



        return true;
    }

    @Override
    public boolean updateCertificate(long orgId) throws Exception {
        BlockchainService blockchainService = new BlockchainService(new BlockchainDASTemp());

        //query organisation, certificate, org points, blockchain

        //we need to remove points from organisationpoints and add it to certificate, we need to remove certlevel from certificate and add it to blockchain

//        boolean certificateCreated = createPDFDocument(cert,organisation,organisationPoints);
//
//        if(!certificateCreated){
//            throw new Exception("Exception: Problem creating and storing certificate");
//        }
//
//        File certificate = retrieveCertificate(orgId, organisation.getOrgName());
//
//        String[] result = blockchainService
//                .upgradeCertificate(0,orgId, certificate,0);
//
//        String certificateHash = result[0];
//        String txHash = result[1];
//
//        //query to add current latest tx hash, certificate hash and level to blockchain table;

        return true;
    }

    @Override
    public File retrieveCertificate(long orgId, String orgName) throws Exception {
        ServerAccess access = new ServerAccess();

        return access.downloadCertificate(orgId,orgName);
    }

    @Override
    public boolean compareUploadedCertificate(File certificate) throws Exception {
        BlockchainDASTemp blockchainDASTemp = new BlockchainDASTemp();

        return blockchainDASTemp.compareCertificateHash(certificate);
    }


    @Override
    public boolean createPDFDocument(Certificate cert, Organisation organisation, OrganisationPoints organisationPoints) throws Exception {
        ServerAccess access = new ServerAccess();

        int points = organisationPoints.getPoints();


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
    public boolean setupEmailServerProperties() {
        return false;
    }

    @Override
    public boolean sendEmail() throws Exception {
        return false;
    }

    @Override
    public MimeMessage CertificateExpiredEmail(String orgName, String orgEmail) throws Exception {
        return null;
    }

    @Override
    public boolean organisationRenewal(long orgId) throws Exception {
        return false;
    }

    @Override
    public boolean adminRenewal(long orgId) throws Exception {
        return false;
    }
}

