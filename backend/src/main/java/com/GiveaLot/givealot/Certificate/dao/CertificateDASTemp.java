package com.GiveaLot.givealot.Certificate.dao;

import com.GiveaLot.givealot.datasource.TempDataSource;
import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.itextpdf.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.mail.internet.MimeMessage;

@Repository("CertificateTemp")
public class CertificateDASTemp implements CertificateDAOInterface{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CertificateDASTemp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Document createPDFDocument(Certificate cert) throws Exception {
        return null;
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
