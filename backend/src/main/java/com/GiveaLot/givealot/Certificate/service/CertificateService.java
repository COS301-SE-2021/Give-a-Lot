
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

    boolean addCertificate(long orgId, Certificate certificate) throws Exception;

    boolean updateCertificate(long orgId) throws Exception;

    File retrieveCertificate(RetrieveCertificateRequest request) throws Exception;

    boolean createPDFDocument(Certificate cert, Organisations organisation, int points) throws Exception;

    boolean checkRenewal() throws Exception;

    boolean CertificateExpiredEmail(String orgName, String orgEmail) throws Exception;

    boolean organisationRenewal(long orgId) throws Exception;

    boolean adminRenewal(long orgId) throws Exception;

    long compareCertificate(MultipartFile certificate) throws Exception;

    File retrieveCertificateAsPNG(RetrieveCertificateRequest request) throws Exception;

}



