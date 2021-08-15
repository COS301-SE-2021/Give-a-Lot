
package com.GiveaLot.givealot.Server;

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
    private String remoteHost = "209.97.142.151";
    private String username = "ubuntu";
    private String password = "COS301-DsP";

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

    public File downloadCertificate(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "Certificate.pdf";

            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "Certificate.pdf");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadAuditDocument(long orgId, String orgName, File document) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            document.renameTo(new File("backend/src/main/resources/TempDocument/audit.pdf"));

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempDocument/audit.pdf";

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

    public File downloadAuditDoc(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "AuditDocument.pdf";

            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "AuditDocument.pdf");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadTaxReference(long orgId, String orgName, File document) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            document.renameTo(new File("backend/src/main/resources/TempDocument/taxRef.pdf"));

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempDocument/taxRef.pdf";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "TaxReference.pdf");

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

    public File downloadTaxRef(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "TaxReference.pdf";

            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "TaxReference.pdf");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadImageJPG(long orgId, String orgName, File image) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            image.renameTo(new File("backend/src/main/resources/TempDocument/image.jpg"));

            channelSftp.connect();

            //Query to organisation points for number of images

            int imageNumber = 0;

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempDocument/image.jpg";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery" + imageNumber + ".jpg");

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

    public File downloadImageJPG(long orgId, int index) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + index + ".jpg";

            File fileLocation = new File("image" + index + ".jpg");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public void uploadImagePNG(long orgId, String orgName, File image) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            image.renameTo(new File("backend/src/main/resources/TempDocument/image.png"));

            channelSftp.connect();

            //Query to organisation points for number of images

            int imageNumber = 1;

            String orgIdString = String.valueOf(orgId);
            String localFile = "backend/src/main/resources/TempDocument/image.png";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + imageNumber + ".png");

            File deletion = new File(localFile);
            deletion.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public File downloadImagePNG(long orgId, int index) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + index + ".png";

            File fileLocation = new File("image" + index + ".png");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        }catch (Exception e){
            throw new Exception("Exception: Failed to download certificate");
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerAccess access = new ServerAccess();

        File file = new File("C:/logo.png");

        //File doc = access.downloadCertificate(45,"New Org");

        //access.uploadTaxReference(45,"New Org",doc);

        File image = access.downloadImagePNG(45,0);

        access.uploadImagePNG(45,"New Org", image);
    }


}

