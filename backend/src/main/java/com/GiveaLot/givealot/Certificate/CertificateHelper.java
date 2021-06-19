package com.GiveaLot.givealot.Certificate;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.FileOutputStream;
import java.lang.String;

import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import javax.mail.MessagingException;
import javax.mail.Transport;
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
    Session newSession = null;
    MimeMessage mimeMessage = null;
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

    public void checkRenewal() throws SQLException, ParseException, MessagingException, IOException {
//        try {
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

                    String email = "select \"orgEmail\"from public.\"Organisations\" where \"orgId\"='"+id.get(i)+"';";
                    String name = "select \"orgName\" from public.\"Organisations\" where \"orgId\"='"+id.get(i)+"';";

                    ResultSet remail = state.executeQuery(email);
                    ResultSet rname = state.executeQuery(name);

                    String emailString="";
                    String nameString="";

                    while(remail.next()){
                        emailString =remail.getString(1);
                    }
                    while(rname.next()){
                        nameString =remail.getString(1);
                    }
                    setupServerProperties();
                    OrganisationExpiredEmail(emailString,nameString);
                    sendEmail();
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
    }
    private void sendEmail() throws MessagingException {
        String fromUser = "u19104546@tuks.co.za";  //Enter sender email id
        String fromUserPassword = "lvcpmtxpajyrfmdp";  //Enter sender gmail password , this will be authenticated by gmail smtp server
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent!!!");
    }
    void setupServerProperties()
    {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
    }
    MimeMessage OrganisationExpiredEmail(String email,String name) throws AddressException, MessagingException, IOException {
        String emailReceipients = email;  //Enter list of email recepients
        String emailSubject = "Givealot Certficate Expired";
        String emailBody = "Hey "+name+" \nWe hope this message finds you well we have written this message to you to notify you that your certificate has expired" +
                "if you would like to renew it plese kindly go to your portal and click on the renew button \nThank you for your patience\n \nRegards\nGivealot";
        mimeMessage = new MimeMessage(newSession);
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients));

        mimeMessage.setSubject(emailSubject);

        // CREATE MIMEMESSAGE
        // CREATE MESSAGE BODY PARTS
        // CREATE MESSAGE MULTIPART
        // ADD MESSAGE BODY PARTS ----> MULTIPART
        // FINALLY ADD MULTIPART TO MESSAGECONTENT i.e. mimeMessage object


        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody,"text/plain");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;
    }

    public static void main(String[] args) throws SQLException, ParseException, MessagingException, IOException {
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
