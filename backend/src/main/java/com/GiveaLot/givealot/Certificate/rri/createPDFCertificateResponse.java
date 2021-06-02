package com.GiveaLot.givealot.Certificate.rri;

import javax.swing.text.Document;

public class createPDFCertificateResponse {
    private Document PDFCert;

    public createPDFCertificateResponse(){}
    public Document getPDFCertificate(){return PDFCert;};

    public void setPDFCertificate(Document pdfDocument) {this.PDFCert = pdfDocument; }
}
