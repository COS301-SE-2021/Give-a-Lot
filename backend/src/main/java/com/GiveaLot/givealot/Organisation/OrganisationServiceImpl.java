package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.rri.*;
import com.GiveaLot.givealot.Organisation.exceptions.*;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


@Service
public class OrganisationServiceImpl
{
    enum Status{
        Active,
        UnderInvestigation,
        Suspended
    }
    Session newSession = null;
    MimeMessage mimeMessage = null;

    OrganisationHelper help = new OrganisationHelper();

    public addOrganisationResponse addOrganisation(addOrganisationRequest request) throws InvalidRequestException, NoSuchAlgorithmException, SQLException, MessagingException, IOException {
        if (request == null)
        {
            throw new InvalidRequestException("Exception: Organisation could not be added because the request object is null");
        }

        Organisation org = new Organisation(request.getOrgName(),request.getOrgDescription(),request.getOrgSector(),request.getOrgEmail(),request.getPassword(),request.getContactPerson(),request.getContactNumber());

        try
        {
            help.addOrg(org);

            this.setupServerProperties();
            this.OrganisationAddedEmail();
            this.sendEmail();

            addOrganisationResponse addOrganisationResponse = new addOrganisationResponse();
            addOrganisationResponse.setOrganisationResponseJSON( List.of(new OrganisationResponseJSON(200, "ok")));
            return addOrganisationResponse;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public reactivateOrganisationResponse reactivateOrganisation(reactivateOrganisationRequest request) throws OrgException, NoSuchAlgorithmException, SQLException, MessagingException, IOException {
        if(request == null)
        {
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        else if(!help.user_isAdmin(request.getAdmin_id()))
        {
            throw new OrgException("Exception: not authorized");
        }
        try
        {
            try
            {
                Organisation org = new Organisation();
                org.setOrgId(request.getOrg_id());
                help.reactivateOrg(org);
                this.setupServerProperties();
                this.OrganisationReactivatedEmail();
                this.sendEmail();

                reactivateOrganisationResponse reactivateOrganisationResponse = new reactivateOrganisationResponse();
                reactivateOrganisationResponse.setAddUserResponseJSON(List.of(new OrganisationResponseJSON(200, "ok")));
                return reactivateOrganisationResponse;
            }
            catch (Exception e)
            {
                reactivateOrganisationResponse reactivateOrganisationResponse = new reactivateOrganisationResponse();
                reactivateOrganisationResponse.setAddUserResponseJSON(List.of(new OrganisationResponseJSON(420, e.getMessage())));
                return reactivateOrganisationResponse;
            }
        }
        catch (Exception e)
        {
            reactivateOrganisationResponse reactivateOrganisationResponse = new reactivateOrganisationResponse();
            reactivateOrganisationResponse.setAddUserResponseJSON(List.of(new OrganisationResponseJSON(500, e.getMessage())));
            return reactivateOrganisationResponse;
        }
    }

    public investigateOrganisationResponse investigateOrganisation(investigateOrganisationRequest request) throws OrgException, MessagingException, IOException {
        if(request == null)
        {
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        else if(!help.user_isAdmin(request.getAdmin_id()))
        {
            throw new OrgException("Exception: not authorized");
        }
        try
        {
            try
            {
                Organisation org = new Organisation();
                org.setOrgId(request.getOrg_id());
                help.investigateOrg(org);
                this.setupServerProperties();
                this.OrganisationUnderInvestigationEmail();
                this.sendEmail();

                investigateOrganisationResponse investigateOrganisationResponse = new investigateOrganisationResponse();
                investigateOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(200, "ok")));
                return investigateOrganisationResponse;
            }
            catch (Exception e)
            {
                investigateOrganisationResponse investigateOrganisationResponse = new investigateOrganisationResponse();
                investigateOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(420, e.getMessage())));
                return investigateOrganisationResponse;
            }
        }
        catch (Exception e)
        {
            investigateOrganisationResponse investigateOrganisationResponse = new investigateOrganisationResponse();
            investigateOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(500, e.getMessage())));
            return investigateOrganisationResponse;
        }
    }

    public suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest request) throws OrgException, MessagingException, IOException {

        if(request == null)
        {
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        else if(!help.user_isAdmin(request.getAdmin_id()))
        {
            throw new OrgException("Exception: not authorized");
        }
        try
        {
            try
            {
                Organisation org = new Organisation();
                org.setOrgId(request.getOrg_id());
                help.suspendOrg(org);

                this.setupServerProperties();
                this.OrganisationSuspendedEmail();
                this.sendEmail();

                suspendOrganisationResponse suspendOrganisationResponse = new suspendOrganisationResponse();
                suspendOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(200, "ok")));
                return suspendOrganisationResponse;
            }
            catch (Exception e)
            {
                suspendOrganisationResponse suspendOrganisationResponse = new suspendOrganisationResponse();
                suspendOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(420, e.getMessage())));
                return suspendOrganisationResponse;
            }
        }
        catch (Exception e)
        {
            suspendOrganisationResponse suspendOrganisationResponse = new suspendOrganisationResponse();
            suspendOrganisationResponse.setOrganisationResponseJSON(List.of(new OrganisationResponseJSON(500, e.getMessage())));
            return suspendOrganisationResponse;
        }
    }

     void setupServerProperties()
    {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties,null);
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

    MimeMessage OrganisationUnderInvestigationEmail() throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {"u19104546@tuks.co.za"};  //Enter list of email recepients
        String emailSubject = "Givealot Status Change";
        String emailBody = "Hey \nWe hope this message finds you well we have written this message to you to notify you that due to numerous reports your status has changed " +
                "due to this your account is under investigation and the status will be updated accordingly \n Thank you for your patience\n \nRegards\nGivealot";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
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

    MimeMessage OrganisationReactivatedEmail() throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {"u19104546@tuks.co.za"};  //Enter list of email recepients
        String emailSubject = "Givealot Status Change";
        String emailBody = "Hey \n Congratulations your Organisation has been Reactivated on the Givealot platform \n Thank you for your patience\n \nRegards\nGivealot";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
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
    MimeMessage OrganisationAddedEmail() throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {"u19104546@tuks.co.za"};  //Enter list of email recepients
        String emailSubject = "Givealot Status Change";
        String emailBody = "Hey \n Congratulations your Organisation has been added to the Givealot platform \n Thank you for your patience\n \nRegards\nGivealot";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
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
    MimeMessage OrganisationSuspendedEmail() throws AddressException, MessagingException, IOException {
        String[] emailReceipients = {"u19104546@tuks.co.za"};  //Enter list of email recepients
        String emailSubject = "Givealot Status Change";
        String emailBody = "Hey \nWe hope this message finds you well we have written this message to you to notify you that due to numerous reports your status has changed " +
                "due to this your account is under review and the status will be updated accordingly \n Thank you for your patience\n \nRegards\nGivealot";
        mimeMessage = new MimeMessage(newSession);

        for (int i =0 ;i<emailReceipients.length;i++)
        {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
        }
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

    public static void main(String args[]) throws AddressException, MessagingException, IOException
    {
        OrganisationServiceImpl mail = new OrganisationServiceImpl();
        mail.setupServerProperties();
        mail.OrganisationReactivatedEmail();
        mail.sendEmail();
    }
}