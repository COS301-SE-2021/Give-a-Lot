package com.GiveaLot.givealot.Certificate;



import java.io.FileOutputStream;
import java.lang.String;

import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;
import java.util.List;


public class CertificateHelper {

    //Creates the pdf
    public CertificateHelper() {
    }

    public Document createPDFDocument(Certificate cert) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            String certName = cert.getNameOfOrganisation().replaceAll("\\s+", "");
            String file_name = "C:\\generateCertificates\\" + certName + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));

            document.open();
            document.add(new Paragraph("This certificate represents the authenticity of " + cert.getNameOfOrganisation()));
            document.add(new Paragraph(cert.getDescriptionOFOrganisation()));
            document.add(new Paragraph(cert.getEmail()));
            document.add(new Paragraph(cert.getAddress()));
            document.add(new Paragraph(cert.getUrl()));

            document.close();
            return document;

        } catch (Exception e) {
            throw new CertificateException("Problem creating Certificate");
        }
    }

    public void checkRenewal() throws SQLException {
        try {
            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            Date dateCurrent = new Date();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //String dateCurr = format.format(dateCurrent);

            System.out.println("Success");
            String query = "select * from public.\"Certificate\";";

            System.out.println(query);
            ResultSet rs = state.executeQuery(query);


            System.out.println("Success");
            try {
                while (rs.next()) {
                    System.out.println("//////////////////////////////////////////");
                    rs.getString("dateExpiry");
                    Date sqlDate = format.parse(rs.getString("dateExpiry"));

                    boolean check = dateCurrent.after(sqlDate);
                    if (check){
                        System.out.println(sqlDate);
                        System.out.println(" is before ");
                        System.out.println(dateCurrent);
                        System.out.println("Expired");
                    }else{
                        System.out.println(sqlDate);
                        System.out.println(" is after ");
                        System.out.println(dateCurrent);
                        System.out.println("Valid");
                    }
                }
            } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

    } catch (Exception e) {
            throw new SQLException("Exception: Check database could not be fulfilled");
        }
    }

    public static void main(String[] args) throws  SQLException {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateCreated = new Date();
//        Date dateExpiry = new Date();
//
//        dateExpiry.setYear(dateExpiry.getYear()+1);
//        System.out.println(format.format(dateCreated));
//        System.out.println(format.format(dateExpiry));
//
//        if (dateCreated.compareTo(dateExpiry) > 0){
//            System.out.println("Past Expiry");
//        }

        CertificateHelper help = new CertificateHelper();

        help.checkRenewal();




    }
}
