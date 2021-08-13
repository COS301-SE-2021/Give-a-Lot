package com.GiveaLot.givealot.Certificate.dao;

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

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CertificateDASTemp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createPDFDocument(Certificate cert, Organisation organisation, OrganisationPoints organisationPoints, String templateDirectory) throws Exception {

        int points = organisationPoints.getPoints();

        String CertificateDestination = organisation.getDirectory() + "certificate/";

        String templateCertificate = "";

        if (points<20){
            //Level 0
            templateCertificate = "/tmp/templates/certificateTemplate0";
        }
        else if (points>=20 && points<40){
            //Level 1
            templateCertificate = "/tmp/templates/certificateTemplate1";
        }
        else if (points>=40 && points<60){
            //Level 2
            templateCertificate = "/tmp/templates/certificateTemplate2";
        }
        else if (points>=60 && points<80){
            //Level 3
            templateCertificate = "/tmp/templates/certificateTemplate3";
        }
        else if (points>=80 && points<100){
            //Level 4
            templateCertificate = "/tmp/templates/certificateTemplate4";
        }
        else if (points>=100){
            //Level 5
            templateCertificate = "/tmp/templates/certificateTemplate5";
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
                field.setValue(organisation.getOrgName());

                field = (PDField) acroForm.getField("email"); // Email
                field.setValue(organisation.getOrgEmail());

                field = (PDField) acroForm.getField("slogan"); // Slogan
                field.setValue(organisation.getSlogan());

                field = (PDField) acroForm.getField("sector"); // Sector
                field.setValue(organisation.getOrgSector());

                field = (PDField) acroForm.getField("contact"); // Contact Person
                field.setValue(organisation.getContactPerson());

                field = (PDField) acroForm.getField("number"); // Contact Number
                field.setValue(organisation.getContactNumber());

                field = (PDField) acroForm.getField("created"); // Date Created
                field.setValue(cert.getDateCreated());

                field = (PDField) acroForm.getField("expiry"); // Date Expiry
                field.setValue(cert.getDateExpiry());
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
    public boolean organisationRenewal(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean adminRenewal(String orgId) throws Exception {
        return false;
    }
}
