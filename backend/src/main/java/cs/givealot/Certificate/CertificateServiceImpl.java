package main.java.cs.givealot.Certificate;


import main.java.cs.givealot.Certificate.exceptions.CertificateException;
import main.java.cs.givealot.Certificate.exceptions.InvalidRequestException;
import main.java.cs.givealot.Certificate.exceptions.NotAuthorizedException;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateRequest;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateResponse;

public class CertificateServiceImpl implements CertificateService{

    public CertificateServiceImpl() {

    }
    /**
    * @return
     * @throws NotAuthorizedException
     * @throws CertificateException
     * @throws InvalidRequestException
     */
    @Override
    public createPDFCertificateResponse createPDFCertificate(createPDFCertificateRequest request) throws Exception {
        createPDFCertificateResponse certificate = null;
        if (request==null){
            throw new InvalidRequestException("Exception: Certificate could not be created because the request object is null");
        }
        return null;
    }
}
