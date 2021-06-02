package main.java.cs.givealot.Certificate;

import main.java.cs.givealot.Certificate.dataclass.Certificate;
import java.lang.String;
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
                String file_name = "C:\\generateCertificates\\test_certificate.pdf";
                Document document = new Document();
                PdfWriter.getInstance(document, out);

                document.open();
                document.add(new Paragraph(
                        "some sample text"
                ));


                document.close();
                return document;
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
