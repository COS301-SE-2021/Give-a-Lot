package com.GiveaLot.givealot.Certificate.service;


import com.GiveaLot.givealot.Certificate.dao.CertificateDAOInterface;
import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.itextpdf.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class CertificateService {

    private final CertificateDAOInterface certificateDAOInterface;

    @Autowired
    CertificateService(@Qualifier("temp") CertificateDAOInterface certificateDAOInterface){
        this.certificateDAOInterface = certificateDAOInterface;
    }

    public Document createPDFDocument(Certificate cert) throws Exception {
        return certificateDAOInterface.createPDFDocument(cert);
    }

    public boolean checkRenewal() throws Exception {
        return certificateDAOInterface.checkRenewal();
    }

    public boolean setupEmailServerProperties() {
        return certificateDAOInterface.setupEmailServerProperties();
    }

    public boolean sendEmail() throws Exception {
        return certificateDAOInterface.sendEmail();
    }

    public MimeMessage CertificateExpiredEmail(String orgName, String orgEmail) throws Exception {
        return certificateDAOInterface.CertificateExpiredEmail(orgName, orgEmail);
    }

    public boolean organisationRenewal(String orgId) throws Exception{
        return certificateDAOInterface.organisationRenewal(orgId);
    }

    public boolean adminRenewal(String orgId) throws Exception{
        return certificateDAOInterface.adminRenewal(orgId);
    }
}
