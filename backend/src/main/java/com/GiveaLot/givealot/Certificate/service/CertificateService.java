
package com.GiveaLot.givealot.Certificate.service;


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public interface CertificateService {

  public boolean addCertificate(long orgId) throws Exception;

    public boolean updateCertificate(long orgId) throws Exception;

    public File retrieveCertificate(long orgId, String orgName) throws Exception;

    //public boolean compare;

    public boolean createPDFDocument(Certificate cert, AddOrganisationRequest organisation, OrganisationPoints organisationPoints) throws Exception;

    public boolean checkRenewal() throws Exception;

    public boolean setupEmailServerProperties();

    public boolean sendEmail() throws Exception;

    public MimeMessage CertificateExpiredEmail(String orgName, String orgEmail) throws Exception;

    public boolean organisationRenewal(long orgId) throws Exception;

    public boolean adminRenewal(long orgId) throws Exception;
}



