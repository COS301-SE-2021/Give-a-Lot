
package com.GiveaLot.givealot.Server;

import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.InputStream;

public class ServerAccess {

    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    private String remoteHost = "";
    private String username = "";
    private String password = "";

    private String remoteDir = "/home/ubuntu/";

    private Session session;

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        //jsch.setKnownHosts("C:/Users/joshu/.ssh/known_hosts");
        jsch.setKnownHosts("backend/src/main/java/com/GiveaLot/givealot/Server/known_hosts");
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

            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString);
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Reports");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Documents");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Certificates");
            channelSftp.put( remoteDir + "Organisations/" + orgIdString + "/" + orgNameSpace);

            String localImageStorage = "frontend/givealot/localFiles/" + orgIdString + "/gallery/";
            String localCertificateStorage = "frontend/givealot/localFiles/" + orgIdString + "/certificate/";

            File directoryImageLocal = new File(localImageStorage);
            File directoryCertLocal = new File(localCertificateStorage);

            if (directoryImageLocal.mkdir()){
                throw new Exception("Exception: image directory could not be created");
            }
            if (directoryCertLocal.mkdir()){
                throw new Exception("Exception: certificate directory could not be created");
            }

        }catch (Exception e){
            throw new Exception("Exception: Failed to interact with the server: " + e);
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

            //Query to certificate for number of images

            int imageNumber = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfImages() + 1;

            String orgIdString = String.valueOf(orgId);
            String localFile = "frontend/givealot/localFiles/" + orgId + "/gallery/image" + imageNumber + ".jpg";

            FileUtils.copyFile(image, new File(localFile));

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery" + imageNumber + ".jpg");

            image.delete();
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

            //Query to certificate for number of images

            int imageNumber = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfImages() + 1;

            String orgIdString = String.valueOf(orgId);
            String localFile = "frontend/givealot/localFiles/" + orgId + "gallery/image" + imageNumber + ".png";

            FileUtils.copyFile(image, new File(localFile));

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + imageNumber + ".png");

//            File deletion = new File(localFile);
//            deletion.delete();
            image.delete();
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

        access.createOrganisationDirectory(6,"The Local Guys");

        //File doc = access.downloadCertificate(45,"New Org");

        //access.uploadTaxReference(45,"New Org",doc);

//        File image = access.downloadImagePNG(45,0);
//
//        access.uploadImagePNG(45,"New Org", image);
    }


}

