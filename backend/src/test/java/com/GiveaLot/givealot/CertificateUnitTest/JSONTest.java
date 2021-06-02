package com.GiveaLot.givealot.CertificateUnitTest;
import com.GiveaLot.givealot.Certificate.CertificateServiceImpl;
import com.GiveaLot.givealot.Certificate.JSONServiceImpl;
import com.GiveaLot.givealot.Certificate.rri.createJSONRequest;
import com.GiveaLot.givealot.Certificate.rri.createJSONResponse;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateRequest;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateResponse;
public class JSONTest {
    public static void main(String[] args) throws Exception {

        //set up server

        //Create pdf certificate
        createPDFCertificateRequest CRequest;
        CRequest = new createPDFCertificateRequest("Child Welfare", "Kids are the heart of the world", "ChildWelfare@char.com", "1234 Give Back Avenue", "www.ChildWelfare.org");
        createPDFCertificateResponse response = new createPDFCertificateResponse();
        CertificateServiceImpl cert = new CertificateServiceImpl();
        cert.createPDFCertificate(CRequest);

        //upload pdf to server
        String certName = CRequest.name.replaceAll("\\s+","");
        String serverURL = "C:\\generateCertificates\\" + certName + ".pdf";

        //create json nft

        createJSONRequest JRequest;
        JRequest = new createJSONRequest("Child Welfare", "Kids are the heart of the world", "https://server.com/Certificate/ChildWelfare.pdf", "https://server.com/Image/ChildWelfare.png");
        createJSONResponse JResponse = new createJSONResponse();
        JSONServiceImpl json = new JSONServiceImpl();
        json.createJSON(JRequest);


    }





    //create json nft
}