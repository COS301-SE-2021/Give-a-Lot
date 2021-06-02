package main.java.cs.givealot.Certificate;


import main.java.cs.givealot.Certificate.dataclass.Certificate;
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
        if (isAuthorized(true)){
            Certificate cert = null;
            try {
                cert = new Certificate("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
            }catch (Exception e){
                throw new CertificateException("Problem creating Certificate");
            }
            cert = new Certificate(request.name, request.description, request.email, request.address, request.url);
            certificate = new createPDFCertificateResponse();
            CertificateHelper createPDF = new CertificateHelper();
            try {
                certificate.createPDFCertificateResponse(createPDF.createPDFDocument(cert));
            } catch (Exception e){
                throw new CertificateException("Problem creating Certificate");
            }
        }
        return certificate;
    }

    public boolean isAuthorized(boolean value) throws NotAuthorizedException{
        if (value==false){
            throw new NotAuthorizedException("Error: User is not authorised to create Certificate");
        }
        return true;
    }
}
