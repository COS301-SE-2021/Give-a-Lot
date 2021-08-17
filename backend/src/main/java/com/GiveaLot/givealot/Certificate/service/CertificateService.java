
package com.GiveaLot.givealot.Certificate.service;


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface CertificateService {

  public boolean addCertificate(long orgId) throws Exception;

    public boolean updateCertificate(long orgId) throws Exception;

    public File retrieveCertificate(long orgId, String orgName) throws Exception;

    //public boolean compare;

    public boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception;
    public boolean checkRenewal() throws Exception;

    public boolean CertificateExpiredEmail(String orgName, String orgEmail) throws Exception;

    public boolean organisationRenewal(long orgId) throws Exception;

    public boolean adminRenewal(long orgId) throws Exception;
}



