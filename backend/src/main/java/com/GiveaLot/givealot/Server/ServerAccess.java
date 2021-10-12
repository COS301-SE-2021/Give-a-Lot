
package com.GiveaLot.givealot.Server;

import com.GiveaLot.givealot.FaceRecognition.service.FaceRecognitionServiceImpl;
import com.GiveaLot.givealot.Organisation.model.OrganisationGallery;
import com.GiveaLot.givealot.Organisation.repository.OrganisationGalleryRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Service
public class ServerAccess implements server_access{


    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    @Autowired
    private OrganisationGalleryRepository organisationGalleryRepository;

    ServerConfig config = new ServerConfig();

    private String remoteHost = config.getRemoteHost();
    private String username = config.getUsername();
    private String password = config.getPassword();

    private String remoteDir = "/home/ubuntu/";

    private Session session;

    @Override
    public ChannelSftp setupJsch() throws JSchException {

        JSch jsch = new JSch();
        jsch.setKnownHosts("src/main/java/com/GiveaLot/givealot/Server/known_hosts");
        session = jsch.getSession(username, remoteHost);
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.setPassword(password);
        session.connect();
        return (ChannelSftp) session.openChannel("sftp");
    }

    @Override
    public void createOrganisationDirectory(long orgId, String orgName) throws Exception {
        /*System.out.println("=============set - up==========");
        ChannelSftp channelSftp = setupJsch();
        System.out.println("=============set - up complete==========");
        try {
            System.out.println("=============connecting==========");
            channelSftp.connect();
            System.out.println("=============connecting complete==========");
            String orgIdString = String.valueOf(orgId);
            String orgNameSpace = orgName.replaceAll("\\s+", "");

            System.out.println("=============create remote directories==========");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString);
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Reports");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Documents");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/Backup");
            channelSftp.mkdir(remoteDir + "Organisations/" + orgIdString + "/" + "Certificates");
            channelSftp.put(remoteDir + "Organisations/" + orgIdString + "/" + orgNameSpace);
            System.out.println("=============create remote directories complete==========");


            String localStorage = "src/main/resources/localFiles/" + orgIdString;
            String localImageStorage = "src/main/resources/localFiles/" + orgIdString + "/gallery";
            String localImageStorage2 = "src/main/resources/localFiles/" + orgIdString + "/gallery/backup";
            String localCertificateStorage = "src/main/resources/localFiles/" + orgIdString + "/certificate";


            System.out.println("============= v1 File construction==========");
            File directoryLocal = new File(localStorage);
            File directoryImageLocal = new File(localImageStorage);
            File directoryImageLocal2 = new File(localImageStorage2);
            File directoryCertLocal = new File(localCertificateStorage);

            System.out.println("============= v1 File construction complete==========");

            System.out.println("============= v2 File construction==========");
            directoryLocal.mkdir();
            directoryImageLocal.mkdir();
            directoryImageLocal2.mkdir();
            directoryCertLocal.mkdir();
            System.out.println("============= v2 File construction complete==========");


            if (directoryLocal.mkdir()) {
                throw new Exception("Exception: local directory could not be created");
            }
            if (directoryImageLocal.mkdir()) {
                throw new Exception("Exception: image directory could not be created");
            }
            if (directoryImageLocal2.mkdir()) {
                throw new Exception("Exception: image backup directory could not be created");
            }
            if (directoryCertLocal.mkdir()) {
                throw new Exception("Exception: certificate directory could not be created");
            }

        } catch (Exception e) {
            throw new Exception("Exception: Failed to interact with the server: " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }*/
    }

    @Override
    public void uploadCertificate(long orgId, String orgName) throws Exception {
        /*ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgIdString + "/certificate/CertificateComplete.pdf";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "Certificate.pdf");

        } catch (Exception e) {
            throw new Exception("Exception:uploadCertificate Failed to interact with the server "+ e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }*/
    }
    @Override
    public void uploadCertificatePNG(long orgId, String orgName) throws Exception {
        /*ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgIdString + "/certificate/CertificateImage.png";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "CertificateImage.png");

        } catch (Exception e) {
            throw new Exception("Exception:uploadCertificatePNG Failed to interact with the server " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }*/
    }
    @Override
    public File downloadCertificatePNG(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();
            System.out.println("==========connected==============");
            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "CertificateImage.png";


            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "CertificateImage.png");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            System.out.println("==========file retrieved============");
            return fileLocation;

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
            System.out.println("==========disconnected============");
        }
    }

    @Override
    public void uploadBlurredImage(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgIdString + "/gallery/blur.jpg";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery" + "/" + orgName.replaceAll("\\s+", "") + "blur.jpg");

        } catch (Exception e) {
            throw new Exception("Exception: Failed to interact with the server");
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }
    @Override
    public File downloadBlurredImage(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Gallery" + "/" + orgName.replaceAll("\\s+", "") + "blur.jpg";

            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "blur.jpg");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate");
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void downloadCertificateTemplate(int points) throws Exception {
        //ChannelSftp channelSftp = setupJsch();
        try {

            //channelSftp.connect();

            String templateLocation;

            System.out.println("===============downloadCertificateTemplate()=================");
            remoteDir = "src/main/resources/certificateTemplates";
            if (points < 20) {
                templateLocation = "src/main/resources/certificateTemplates/cert0Template.pdf";

            } else if (points >= 20 && points < 40) {
                templateLocation = remoteDir + "/cert1Template.pdf";

            } else if (points >= 40 && points < 60) {
                templateLocation = remoteDir + "/cert2Template.pdf";

            } else if (points >= 60 && points < 80) {
                templateLocation = remoteDir + "/cert3Template.pdf";

            } else if (points >= 80 && points < 100) {
                templateLocation = remoteDir + "/cert4Template.pdf";

            } else if (points == 100) {
                templateLocation = remoteDir + "/cert5Template.pdf";

            } else {
                throw new Exception("Exception: Invalid certificate level");
            }

            File fileLocation = new File("src/main/resources/TempCertificate/CertificateTemplate.pdf");

            FileUtils.copyFile(new File(templateLocation), fileLocation);


        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate template: " + e);
        } /*finally {
            channelSftp.exit();
            session.disconnect();
        }*/

        System.out.println("===============downloadCertificateTemplate() exit=================");
    }

    @Override
    public File downloadCertificate(long orgId, String orgName) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();
            System.out.println("==========connected - download pdf============");

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Certificates" + "/" + orgName.replaceAll("\\s+", "") + "Certificate.pdf";

            File fileLocation = new File(orgName.replaceAll("\\s+", "") + "Certificate.pdf");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            System.out.println("==========file retrieved============");
            return fileLocation;

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate");
        } finally {
            channelSftp.exit();
            session.disconnect();
            System.out.println("==========disconnected============");
        }
    }

    @Override
    public void uploadAuditDocument(long orgId, String orgName, MultipartFile document) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            File image = new File("src/main/resources/TempDocument/audit.pdf");
            if (!image.exists()) {
                image.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(image)) {
                os.write(document.getBytes());
            }
            image.renameTo(new File("src/main/resources/TempDocument/audit.pdf"));
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/TempDocument/audit.pdf";

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Documents" + "/" + orgName.replaceAll("\\s+", "") + "AuditDocument.pdf");

            File deletion = new File(localFile);
            deletion.delete();
        } catch (Exception e) {
            throw new Exception("Exception: Failed to interact with the server" + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
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

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate");
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void uploadImageQRCode(long orgId, MultipartFile imageMPF) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            File image = new File("src/main/resources/TempDocument/imageQr.png");
            if (!image.exists()){
                image.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(image)) {
                os.write(imageMPF.getBytes());
            }
            image.renameTo(new File("src/main/resources/TempDocument/imageQr.png"));

            System.out.println(image.exists());

            channelSftp.connect();
            String orgIdString = String.valueOf(orgId);
            String localFile = "frontend/givealot/src/localFiles/" + orgId + "/gallery/QRCode.png";

            FileUtils.copyFile(image, new File(localFile));

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/QRCode.png");


            image.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public File downloadImageQRCode(long orgId) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/QRCode.png";

            File fileLocation = new File("QRCode" + orgId + ".png");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download logo: message ------> " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }


    @Override
    public void uploadImageJPG(long orgId, MultipartFile image, int numberOfImages) throws Exception {

        System.out.println("================saving image to db================");
        OrganisationGallery newGalleryImage = new OrganisationGallery();
        newGalleryImage.setOrgId(orgId);
        newGalleryImage.setImage(image.getBytes());
        newGalleryImage.setName("image" + numberOfImages);
        organisationGalleryRepository.save(newGalleryImage);
        System.out.println("================saving image to db finished================");

        ChannelSftp channelSftp = setupJsch();
        try {

            File imageHolder = new File("src/main/resources/TempDocument/image.jpg");
            if (!imageHolder.exists()) {
                imageHolder.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(imageHolder)) {
                os.write(image.getBytes());
            }
            imageHolder.renameTo(new File("src/main/resources/TempDocument/image.jpg"));

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "/gallery/image" + numberOfImages + ".jpg";
            FileUtils.copyFile(imageHolder, new File(localFile));

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + numberOfImages + ".jpg");

            organisationInfoRepository.incrementNumImagesd(orgId);
            imageHolder.delete();
        } catch (Exception e) {
            throw new Exception("Exception: Failed to interact with the server: " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
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

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate");
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public File downloadImageLogo(long orgId) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);

            String templateLocation;

            templateLocation = remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/logo.png";

            File fileLocation = new File("logo" + orgId + ".png");
            InputStream stream = channelSftp.get(templateLocation);
            FileUtils.copyInputStreamToFile(stream, fileLocation);

            return fileLocation;

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download logo: message ------> " + e);
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void uploadImagePNG(long orgId, MultipartFile imageMPF) throws Exception {


        ChannelSftp channelSftp = setupJsch();

        try {
            File image = new File("src/main/resources/TempDocument/TempImg.png");

            if (!image.exists()) {

                image.createNewFile();

            }
            try (OutputStream os = new FileOutputStream(image)) {

                os.write(imageMPF.getBytes());

            }

            image.renameTo(new File("src/main/resources/TempDocument/image.png"));
            channelSftp.connect();

            int imageNumber = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfImages() + 1;

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "/gallery/image" + imageNumber + ".png";
            FileUtils.copyFile(image, new File(localFile));

            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + imageNumber + ".png");


            image.delete();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void uploadImageLogo(long orgId, MultipartFile imageMPF) throws Exception {
        ChannelSftp channelSftp = setupJsch();
        try {
            File image = new File("src/main/resources/TempDocument/image.png");
            if (!image.exists()) {
                image.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(image)) {
                os.write(imageMPF.getBytes());
            }
            image.renameTo(new File("src/main/resources/TempDocument/image.png"));

            channelSftp.connect();

            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "/gallery/logo.png";

            FileUtils.copyFile(image, new File(localFile));

            System.out.println("=======================uploading logo image to server================");
            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/logo.png");
            System.out.println("=======================uploading logo image to server end================");
            image.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

//    public void uploadImageQRCode(long orgId, MultipartFile imageMPF) throws Exception {
//        ChannelSftp channelSftp = setupJsch();
//        try {
//            File image = new File("src/main/resources/TempDocument/imageQr.png");
//            if (!image.exists()) {
//                image.createNewFile();
//            }
//            try (OutputStream os = new FileOutputStream(image)) {
//                os.write(imageMPF.getBytes());
//            }
//            image.renameTo(new File("src/main/resources/TempDocument/imageQr.png"));
//
//            channelSftp.connect();
//            String orgIdString = String.valueOf(orgId);
//            String localFile = "src/main/resources/localFiles/" + orgId + "/gallery/QRCode.png";
//
//            FileUtils.copyFile(image, new File(localFile));
//
//            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/QRCode.png");
//
//
//            image.delete();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            channelSftp.exit();
//            session.disconnect();
//        }
//    }

    @Override
    public void deleteQR(long orgId) throws JSchException {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();
            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "gallery/QRCode.png";

            File image = new File(localFile);

            channelSftp.rm(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/QRCode.png");
            image.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void deleteLogo(long orgId) throws JSchException {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();
            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "gallery/logo.png";

            File image = new File(localFile);

            channelSftp.rm(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/logo.png");
            image.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void deleteImage(long orgId, int number) throws JSchException {
        ChannelSftp channelSftp = setupJsch();
        try {
            channelSftp.connect();
            String orgIdString = String.valueOf(orgId);
            String localFile = "src/main/resources/localFiles/" + orgId + "gallery/image" + number + ".png";

            File image = new File(localFile);

            channelSftp.rm(remoteDir + "Organisations/" + orgIdString + "/" + "Gallery/image" + number + ".png");
            image.delete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
    public void uploadImageAnon(long orgId, MultipartFile imageMPF, int type) throws Exception {

        try {
            File image = new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg");
            if (!image.exists()) {
                image.createNewFile();
            }
            try (OutputStream os = new FileOutputStream(image)) {
                os.write(imageMPF.getBytes());
            }
            image.renameTo(new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg"));

            FaceRecognitionServiceImpl faceRecognitionService = new FaceRecognitionServiceImpl();
            if (type==0){
                faceRecognitionService.FaceBlur(orgId);
            }
            else if (type ==1){
                faceRecognitionService.FacePixel(orgId);
            }
            else{
                throw new Exception("Exception: invalid type");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadReport(long orgId, File report, String date) throws Exception {

        ChannelSftp channelSftp = setupJsch();
        try {

            //report.renameTo(new File("src/main/resources/TempDocument/report.txt"));

            channelSftp.connect();


            int reportNumber = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfReports();

            String orgIdString = String.valueOf(orgId);

            String localFile = "src/main/resources/localFiles/" + orgId + "/reports/report" + reportNumber + ".txt";

            FileUtils.copyFile(report, new File(localFile));


            channelSftp.put(localFile, remoteDir + "Organisations/" + orgIdString + "/" + "Reports/report" + reportNumber + "-" + date + ".txt");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //report.delete();
            channelSftp.exit();
            session.disconnect();
        }
    }

    @Override
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

        } catch (Exception e) {
            throw new Exception("Exception: Failed to download certificate");
        } finally {
            channelSftp.exit();
            session.disconnect();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerAccess access = new ServerAccess();

        File img = access.downloadCertificatePNG(133, "CHOSA South Africa");

        System.out.println(img.exists());


//
    }


}

