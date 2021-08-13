package com.GiveaLot.givealot.Certificate.dao;

import com.GiveaLot.givealot.Certificate.model.Certificate;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.itextpdf.text.Document;

import javax.mail.internet.MimeMessage;

public interface CertificateDAOInterface {
    public boolean createPDFDocument(Certificate cert, Organisation organisation, OrganisationPoints organisationPoints, String templateDirectory) throws Exception;

    public boolean checkRenewal() throws Exception;

    public boolean setupEmailServerProperties();

    public boolean sendEmail() throws Exception;

    public MimeMessage CertificateExpiredEmail(String orgName, String orgEmail) throws Exception;

    public boolean organisationRenewal(String orgId) throws Exception;

    public boolean adminRenewal(String orgId) throws Exception;
}
