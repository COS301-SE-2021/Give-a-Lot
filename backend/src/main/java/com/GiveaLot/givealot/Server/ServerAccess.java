package com.GiveaLot.givealot.Server;

import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.InputStream;

public class ServerAccess {
    private String remoteHost = "";
    private String username = "";
    private String password = "";

    private String remoteDir = "/home/ubuntu/";

    private Session session;

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.setKnownHosts("C:/Users/joshu/.ssh/known_hosts");
        session = jsch.getSession(username, remoteHost);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setPassword(password);
        session.connect();
        return (ChannelSftp) session.openChannel("sftp");
    }

    public void createOrganisationDirectory(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String orgNameSpace = orgName.replaceAll("\\s+", "");

            String remoteDir = "/home/ubuntu/Organisations/";

            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString);
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Reports");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Documents");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Certificates");
            channelSftp.put( remoteDir + "Organisations/" + orgIdString + "/" + orgNameSpace);

        }catch (Exception e){
            throw new Exception("Exception: Failed to interact with the server");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadCertificate(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempCertificate/CertificateComplete.pdf";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "Certificate.pdf");

        }catch (Exception e){
            throw new Exception("Exception: Failed to interact with the server");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void downloadCertificateTemplate(int points) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();


            String templateLocation;

            if (points < 20) {
                templateLocation = remoteDir + "Templates/cert0Template.pdf";

            } else if (points >= 20 && points < 40) {
                templateLocation = remoteDir + "Templates/cert1Template.pdf";

            } else if (points >= 40 && points < 60) {
                templateLocation = remoteDir + "Templates/cert2Template.pdf";

            } else if (points >= 60 && points < 80) {
                templateLocation = remoteDir + "Templates/cert3Template.pdf";

            } else if (points >= 80 && points < 100) {
                templateLocation = remoteDir + "Templates/cert4Template.pdf";

            } else if (points == 100) {
                templateLocation = remoteDir + "Templates/cert5Template.pdf";

            } else {
                throw new Exception("Exception: Invalid certificate level");
            }

            File fileLocation = new File("backend/src/main/resources/TempCertificate/CertificateTemplate.pdf");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);


        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate template");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }

    }

    public void uploadAuditDocument(long orgId, String orgName, File document) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            document.renameTo(new File("backend/src/main/resources/TempCertificate/audit.pdf"));


            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempCertificate/audit.pdf";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "AuditDocument.pdf");

            File deletion = new File(localFile);
            deletion.delete();
        }catch (Exception e){
            throw new Exception("Exception: Failed to interact with the server");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadTaxReference(long orgId, String orgName, File document) throws Exception {

        ChannelSftp channelSftp = setupJsch();
        File file = new File("backend/src/main/resources/taxRef.pdf");
        try {

            System.out.println(file.createNewFile());

            System.out.println(file.getAbsolutePath());

            if (!file.renameTo(document)){
                System.out.println("failed to move");
                throw new Exception("Exception: Failed to recreate the document");
            }

            System.out.println("works2");
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "./backend/src/main/resources/TempCertificate/taxRef.pdf";

            System.out.println("works3");

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "TaxReference.pdf");

            System.out.println("works4");



        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            file.delete();
            channelSftp.exit();
            session.disconnect();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerAccess access = new ServerAccess();

        File file = new File("C:/auditDoc.pdf");

        access.uploadTaxReference(45,"New Org",file);
    }


}
