package com.GiveaLot.givealot.Certificate.service;


import com.GiveaLot.givealot.Certificate.dao.CertificateDAOInterface;
import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.itextpdf.text.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class CertificateService {

    private final CertificateDAOInterface certificateDAOInterface;

    @Autowired
    CertificateService(@Qualifier("CertificateTemp") CertificateDAOInterface certificateDAOInterface){
        this.certificateDAOInterface = certificateDAOInterface;
    }

    public boolean addCertificate(long orgId){
        return certificateDAOInterface.addCertificate(orgId);
    }

    public File retrieveCertificate(long orgId){
        return certificateDAOInterface.retrieveCertificate(orgId);
    }

    public boolean createPDFDocument(Certificate cert, Organisation organisation, OrganisationPoints organisationPoints) throws Exception {
        return certificateDAOInterface.createPDFDocument(cert,organisation,organisationPoints);
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

    public boolean organisationRenewal(long orgId) throws Exception{
        return certificateDAOInterface.organisationRenewal(orgId);
    }

    public boolean adminRenewal(long orgId) throws Exception{
        return certificateDAOInterface.adminRenewal(orgId);
    }
}
