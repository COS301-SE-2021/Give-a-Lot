package test.java.cs.givealot.CertificateUnitTest;
import main.java.cs.givealot.Certificate.CertificateHelper;
import main.java.cs.givealot.Certificate.dataclass.Certificate;
import main.java.cs.givealot.Certificate.exceptions.CertificateException;
import main.java.cs.givealot.Certificate.exceptions.InvalidRequestException;
import main.java.cs.givealot.Certificate.exceptions.NotAuthorizedException;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateRequest;
import main.java.cs.givealot.Certificate.rri.createPDFCertificateResponse;
import main.java.cs.givealot.Certificate.CertificateService;
import main.java.cs.givealot.Certificate.CertificateServiceImpl;
public class CertificateTest {
    public static void main(String[] args) throws Exception {
        createPDFCertificateRequest request;
        request = new createPDFCertificateRequest("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
        createPDFCertificateResponse response = new createPDFCertificateResponse();
        CertificateServiceImpl cert = new CertificateServiceImpl();
        cert.createPDFCertificate(request);
    }

    //set up server

    //create pdf

    //upload pdf to server

    //create json nft
}
