package com.GiveaLot.givealot.Certificate;


import com.GiveaLot.givealot.Certificate.exceptions.*;
import com.GiveaLot.givealot.Certificate.rri.*;


public class CertificateServiceImpl implements CertificateService{

    public CertificateServiceImpl() {

    }
    /**
    *
     * @rows NotAuthorizedException
     */
    @Override
    public createPDFCertificateResponse createPDFCertificate(createPDFCertificateRequest request) throws Exception {
        createPDFCertificateResponse certificate = null;
        if (request==null){
            throw new InvalidRequestException("Exception: Certificate could not be created because the request object is null");
        }
        if (isAuthorized(true)){
            Certificate cert;
          /*  try {
             //   cert = new Certificate("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
            }catch (Exception e){
                throw new CertificateException("Problem creating Certificate");
            }*/
            cert = new Certificate("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
            certificate = new createPDFCertificateResponse();
            CertificateHelper createPDF = new CertificateHelper();
            try {
                certificate.setPDFCertificate(createPDF.createPDFDocument(cert));
            } catch (Exception e){
                throw new CertificateException("Problem creating Certificate");
            }
        }
        return certificate;
    }

    public boolean isAuthorized(boolean value) throws NotAuthorizedException{
        if (!value){
            throw new NotAuthorizedException("Error: User is not authorised to create Certificate");
        }
        return true;
    }
}
