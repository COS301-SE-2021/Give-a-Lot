package com.GiveaLot.givealot.Certificate;

import com.GiveaLot.givealot.Certificate.exceptions.*;
import com.GiveaLot.givealot.Certificate.rri.*;


public interface CertificateService {

    /**
     * Generates a new Certificate .
     * @param request:createPDFCertificateRequest Object
     * @return createPDFCertificateResponse object that holds the created pdf
     * @throws NotAuthorizedException if user is not an admin that is trying to generate report
     * @throws CertificateException if Report could not be generated for some reason
     * @throws InvalidRequestException if the request object is not correct
     */
    createPDFCertificateResponse createPDFCertificate(createPDFCertificateRequest request) throws Exception;
}
