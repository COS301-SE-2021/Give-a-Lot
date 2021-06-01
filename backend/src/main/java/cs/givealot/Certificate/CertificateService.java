package main.java.cs.givealot.Certificate;

import main.java.cs.givealot.Certificate.exceptions.CertificateException;
import main.java.cs.givealot.Certificate.exceptions.InvalidRequestException;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateRequest;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateResponse;

public interface CertificateService {

    /**
     * Generates a new Certificate .
     * @param request:createPDFCertificateRequest Object
     * @return createPDFCertificateResponse object that holds the created pdf
     * @throws NotAuthorizedException if user is not an admin that is trying to generate report
     * @throws CertificateException if Report could not be generated for some reason
     * @throws InvalidRequestException if the request object is not correct
     */
    createPDFCertificateResponse generateSalesReport(createPDFCertificateRequest request) throws Exception;
}
