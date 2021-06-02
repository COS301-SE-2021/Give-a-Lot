package main.java.cs.givealot.Certificate.rri;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class createPDFCertificateResponse {
    private byte [] cert;
    private Document PDFCert;

//    public createPDFCertificateResponse(byte [] certificate)
//    {
//        this.cert = certificate;
//    }

//
//    public createPDFCertificateResponse(){}
//    public Document getPDFCertificate(){return PDFCert;};
//
    public void createPDFCertificateResponse(Document pdfDocument) {this.PDFCert = pdfDocument; }
}
