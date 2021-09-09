
package com.GiveaLot.givealot.Certificate.service;


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.requests.RetrieveCertificateRequest;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public interface CertificateService {

  public boolean addCertificate(long orgId, Certificate certificate) throws Exception;

    public boolean updateCertificate(long orgId) throws Exception;

    public File retrieveCertificate(RetrieveCertificateRequest request) throws Exception;

    //public boolean compare;

    public boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception;
    public boolean checkRenewal() throws Exception;

    public boolean CertificateExpiredEmail(String orgName, String orgEmail) throws Exception;

    public boolean organisationRenewal(long orgId) throws Exception;

    public boolean adminRenewal(long orgId) throws Exception;

  public long compareCertificate(MultipartFile certificate) throws Exception;

}



