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
import java.util.ArrayList;
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

            List<String>id = new ArrayList<>();

            List<Date> expiry = new ArrayList<>();;

            int j = 0;
            while(rs.next()){
                id.add(rs.getString("orgId"));
                expiry.add(format.parse(rs.getString("dateExpiry")));
                j++;

            }
            System.out.println("Success");
            int i = 0;
            while (i < j) {
                System.out.println("//////////////////////////////////////////");
                
                Date sqlDate = expiry.get(i);

                boolean check = dateCurrent.after(sqlDate);
                if (check) {

                    System.out.println(sqlDate);
                    System.out.println(" is before ");
                    System.out.println(dateCurrent);
                    System.out.println("Expired");

                    String queryUpdate1 = "update public.\"Certificate\" set \"orgRenewal\" = false where \"orgId\" = '" + id.get(i) + "';";

                    String queryUpdate2 = "update public.\"Certificate\" set \"adminRenewal\" = false where \"orgId\" = '" + id.get(i) + "';";

                    state.executeUpdate(queryUpdate1);
                    state.executeUpdate(queryUpdate2);



                } else {

                    System.out.println(sqlDate);
                    System.out.println(" is after ");
                    System.out.println(dateCurrent);
                    System.out.println("Valid");

                }
                i++;
            }

            try {
                rs.close();
                state.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        } catch (Exception e) {
            throw new SQLException("Exception: Check database could not be fulfilled");
        }

    }

    public void orgRenew(String orgId) throws SQLException {

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

            String query = "update public.\"Certificate\" set \"orgRenewal\" = true where \"orgId\" = '" + orgId + "';";
            //System.out.println(query);

            state.executeUpdate(query);

            state.close();

        } catch (Exception e) {
            throw new SQLException("Exception: Update database could not be fulfilled");
        }
    }
    public void adminRenew(String orgId) throws SQLException {

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

            java.util.Date dateCurrent = new Date();
            java.util.Date dateEx = new Date();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            String dateCreated = format.format(dateCurrent);

            int year = dateCurrent.getYear();
            dateEx.setYear(year+1);
            String dateExpiry = format.format(dateEx);

            String query = "update public.\"Certificate\" set \"adminRenewal\" = true, \"dateCreated\" = '" + dateCreated + "', \"dateExpiry\" = '" + dateExpiry+ "' where \"orgId\" = '" + orgId + "';";
            //System.out.println(query);

            state.executeUpdate(query);

            state.close();

        } catch (Exception e) {
            throw new SQLException("Exception: Update database could not be fulfilled");
        }
    }

    public static void main(String[] args) throws SQLException, ParseException {
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

        //help.checkRenewal();

        help.adminRenew("c900d315725860232e9dfbdb723215fe");




    }
}
