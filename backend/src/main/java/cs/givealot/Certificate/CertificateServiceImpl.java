package main.java.cs.givealot.Certificate;


import main.java.cs.givealot.Certificate.exceptions.InvalidRequestException;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateRequest;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateResponse;

public class CertificateServiceImpl implements CertificateService{

    public CertificateServiceImpl() {

    }


    public createPDFCertificateResponse createPDFCertificate(createPDFCertificateRequest request) throws Exception{
        createPDFCertificateResponse certificate = null;
        if (request==null) {
            throw new InvalidRequestException("Exception: Certificate could not be created because request object is null");
        }
    }
}
