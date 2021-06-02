package main.java.cs.givealot.Certificate;

import main.java.cs.givealot.Certificate.dataclass.Certificate;

import java.io.FileOutputStream;
import java.lang.String;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import main.java.cs.givealot.Certificate.exceptions.CertificateException;


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
                String file_name = "C:\\generateCertificates\\Cert.pdf";
                Document document = new Document();
                PdfWriter.getInstance(document,new FileOutputStream(file_name));

                document.open();
                document.add(new Paragraph("This certificate represents the authenticity of " + cert.getNameOfOrganisation()));
                document.add(new Paragraph( cert.getDescriptionOFOrganisation()));
                document.add(new Paragraph( cert.getEmail()));
                document.add(new Paragraph( cert.getAddress()));
                document.add(new Paragraph( cert.getUrl()));

                document.close();
                System.out.println("Should be working");
                return document;

            } catch (Exception e) {
                throw new CertificateException("Problem creating Certificate");
            }
        }
    }
