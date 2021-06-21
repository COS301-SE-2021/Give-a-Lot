package com.GiveaLot.givealot.Certificate;


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Certificate.exceptions.NotAuthorizedException;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateRequest;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateResponse;


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
    /** Creates a PDF certificate **/
    public createPDFCertificateResponse createPDFCertificate(createPDFCertificateRequest request) throws Exception {
        createPDFCertificateResponse certificate = null;
        if (request==null){
            throw new InvalidRequestException("Exception: Certificate could not be created because the request object is null");
        }
        if (isAuthorized(true)){
            Certificate cert = null;
            try {
                cert = new Certificate("", "", "", "", "");
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
        else
        {
            throw new NotAuthorizedException("Error: User is not authorised to create Certificate");
        }
        return certificate;
    }

    /** Checks that the user is authorized to create the certificate **/
    public boolean isAuthorized(boolean value) throws NotAuthorizedException{
        if (!value){
            throw new NotAuthorizedException("Error: User is not authorised to create Certificate");
        }
        return true;
    }
}
