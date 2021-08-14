package com.GiveaLot.givealot.Certificate.dao;

import com.GiveaLot.givealot.Blockchain.dao.BlockchainDAOInterface;
import com.GiveaLot.givealot.Blockchain.dao.BlockchainDASTemp;
import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

        boolean certificateCreated = createPDFDocument();

        if(!certificateCreated){
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = retrieveCertificate(orgId);

        String[] result = blockchainService
                .uploadCertificate(orgId, certificate);

        String certificateHash = result[0];
        String txHash = result[1];

        long index = blockchainService.findCertificateIndex(orgId);

        //query to add current latest tx hash, index, certificate hash and level to blockchain table;



        return true;
    }

    @Override
    public boolean updateCertificate(long orgId) throws Exception {
        BlockchainService blockchainService = new BlockchainService(new BlockchainDASTemp());

        //query organisation, certificate, org points, blockchain

        //we need to remove points from organisationpoints and add it to certificate, we need to remove certlevel from certificate and add it to blockchain

        boolean certificateCreated = createPDFDocument();

        if(!certificateCreated){
            throw new Exception("Exception: Problem creating and storing certificate");
        }

        File certificate = retrieveCertificate(orgId);

        String[] result = blockchainService
                .upgradeCertificate(0,orgId, certificate,0);

        String certificateHash = result[0];
        String txHash = result[1];

        //query to add current latest tx hash, certificate hash and level to blockchain table;

        return true;
    }

    @Override
    public File retrieveCertificate(long orgId) {

        return null;
    }

    @Override
    public boolean createPDFDocument(Certificate cert, Organisation organisation, OrganisationPoints organisationPoints) throws Exception {

        int points = organisationPoints.getPoints();

        String CertificateDestination = organisation.getDirectory() + "certificate/";

        String templateCertificate;

        if (points<20){
            //Level 0
            templateCertificate = "location on the server";
        }
        else if (points>=20 && points<40){
            //Level 1
            templateCertificate = "location on the server";
        }
        else if (points>=40 && points<60){
            //Level 2
            templateCertificate = "location on the server";
        }
        else if (points>=60 && points<80){
            //Level 3
            templateCertificate = "location on the server";
        }
        else if (points>=80 && points<100){
            //Level 4
            templateCertificate = "location on the server";
        }
        else if (points>=100){
            //Level 5
            templateCertificate = "location on the server";
        }
        else{
            throw new Exception("Exception: Points Exceed limit");
        }

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

        document.save(CertificateDestination);
        document.close();

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
