package com.GiveaLot.givealot.CertificateUnitTest;


import com.GiveaLot.givealot.Certificate.CertificateHelper;
import com.GiveaLot.givealot.Certificate.CertificateServiceImpl;
import com.GiveaLot.givealot.Certificate.PDFtoString;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Certificate.exceptions.JSONException;
import com.GiveaLot.givealot.Certificate.exceptions.NotAuthorizedException;
import com.GiveaLot.givealot.Certificate.rri.createJSONRequest;
import com.GiveaLot.givealot.Certificate.rri.createJSONResponse;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateRequest;
import com.GiveaLot.givealot.Certificate.rri.createPDFCertificateResponse;
import com.itextpdf.text.Document;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CertificateUnitTest {

    @InjectMocks

    createPDFCertificateRequest request1;
    createPDFCertificateRequest request2;

    createPDFCertificateResponse response1;

    CertificateServiceImpl certificateServiceImpl = new CertificateServiceImpl();
    CertificateHelper certificateHelper;

    Certificate cert1;
    Certificate cert2;
    Certificate cert3;

    Document doc1;

    PDFtoString con;

    String certificate;







    @BeforeEach
    void setUp() throws Exception {

        certificateHelper = new CertificateHelper();




        request2= new createPDFCertificateRequest("The Organisation", "Some description", "theorganisation@gmail.com", "1234 Charity Road","www.organisation.com");

        cert1= new Certificate();
        cert2= new Certificate(request2.name,request2.description,request2.email,request2.address,request2.url);
        cert3 = new Certificate("Name",request2.description,request2.email,request2.address,request2.url);

        response1 = certificateServiceImpl.createPDFCertificate(request2);

        con = new PDFtoString();

        certificate = "This certificate represents the authenticity of The OrganisationSome descriptiontheorganisation@gmail.com1234 Charity Roadwww.organisation.com";

        //System.out.println(con.PDFtoString());
    }

    @Test
    @Description("Assumes that the createPDFCertificate Request is null")
    void TEST_SHOULD_RETURN_INVALID_REQUEST_EXCEPTION(){
        Throwable throwError = assertThrows(InvalidRequestException.class, () -> certificateServiceImpl.createPDFCertificate(request1));
        assertEquals("Exception: Invalid request received", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Certificate object is default")
    void TEST_SHOULD_RETURN_JSON_EXCEPTION(){
        Throwable throwError = assertThrows(CertificateException.class, () -> certificateHelper.createPDFDocument(cert1));
        assertEquals("Exception: Certificate data is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Certificate document is open")
    void TEST_EMPTY_JSON_OBJECT(){
        Throwable throwError = assertThrows(CertificateException.class, () -> certificateHelper.createPDFDocument(cert3));
        assertEquals("Exception: Document cannot be overwritten when open", throwError.getMessage());
    }

    @Test
    @Description("Assumes the user is not authorized")
    void TEST_IS_NOT_AUTH(){
        Throwable throwError = assertThrows(NotAuthorizedException.class, () -> certificateServiceImpl.isAuthorized(false));
        assertEquals("Error: User is not authorised to create Certificate", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the returned document contains the correct data")
    void TEST_RETURNS_JSON_OBJECT() {
        assertEquals(con.PDFtoString(),certificate);
    }

}
