package main.java.cs.givealot.verification.rri;
import java.lang.String;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;


public class generateCertificatePDF {
    public byte [] generate_pdf(String name_of_organisation,
                                String description_of_organisation,
                                String email_of_organisation,
                                String address_of_organisation)
    {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try
        {
            String file_name = "C:\\Users\\Nqobani_Xpl\\Desktop\\save_pdf\\test_certificate.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, out);

            document.open();
            document.add(new Paragraph(
                    "some sample text"
            ));


            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
