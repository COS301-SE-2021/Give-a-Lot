package com.GiveaLot.givealot.Certificate;



import java.io.FileOutputStream;
import java.lang.String;

import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;


public class CertificateHelper {

    //Creates the pdf
    public CertificateHelper(){}
    public Document createPDFDocument(Certificate cert) throws Exception{
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try
            {
                String certName = cert.getNameOfOrganisation().replaceAll("\\s+","");
                String file_name = "C:\\generateCertificates\\"+ certName +".pdf";
                Document document = new Document();
                PdfWriter.getInstance(document,new FileOutputStream(file_name));

                document.open();
                document.add(new Paragraph("This certificate represents the authenticity of " + cert.getNameOfOrganisation()));
                document.add(new Paragraph( cert.getDescriptionOFOrganisation()));
                document.add(new Paragraph( cert.getEmail()));
                document.add(new Paragraph( cert.getAddress()));
                document.add(new Paragraph( cert.getUrl()));

                document.close();
                return document;

            } catch (Exception e) {
                throw new CertificateException("Problem creating Certificate");
            }
        }
    }
