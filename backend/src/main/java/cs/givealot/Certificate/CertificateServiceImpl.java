package main.java.cs.givealot.Certificate;


import main.java.cs.givealot.Certificate.exceptions.CertificateException;
import main.java.cs.givealot.Certificate.exceptions.InvalidRequestException;
import main.java.cs.givealot.Certificate.exceptions.NotAuthorizedException;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateRequest;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateResponse;
import
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
        if (isAuthorized(true)){
            Certificate cert = null;
            try {
                cert = new Certificate("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
            }catch (Exception e){
                throw new CertificateException("Problem creating Certifcate");
            }
            cert = new Certificate("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
            certificate = new createPDFCertificateResponse();

            certificate.setPDFCertificate(createPDF())
        }
        return certificate;
    }

    public boolean isAuthorized(boolean value) throws NotAuthorizedException{
        if (value==false){
            throw new NotAuthorizedException("Error: User is not authorised to create Certifcate");
        }
        return true;
    }
}
