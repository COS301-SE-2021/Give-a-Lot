package com.GiveaLot.givealot.CertificateUnitTest;

import com.GiveaLot.givealot.Certificate.CertificateServiceImpl;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateRequest;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateResponse;

public class CertificateTest {
    public static void main(String[] args) throws Exception {

        //set up server

        //Create pdf certificate
        createPDFCertificateRequest request;
        request = new createPDFCertificateRequest("The Charity Organisation", "We are all about giving back...", "charity@char.com", "1234 Give Back Avenue", "www.charityOrg.org");
        createPDFCertificateResponse response = new createPDFCertificateResponse();
        CertificateServiceImpl cert = new CertificateServiceImpl();
        cert.createPDFCertificate(request);

        //upload pdf to server
        String certName = request.name.replaceAll("\\s+","");
        String serverURL = "C:\\generateCertificates\\" + certName + ".pdf";

        //create json nft


    }





    //create json nft
}
