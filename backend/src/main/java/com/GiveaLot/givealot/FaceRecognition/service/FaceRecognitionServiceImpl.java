package com.GiveaLot.givealot.FaceRecognition.service;

import com.GiveaLot.givealot.FaceRecognition.repository.BlurRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FaceRecognitionServiceImpl implements FaceRecognitionService {

    @Autowired
    private BlurRepository blurRepository;

    @Override
    public void FacePixel(long orgId) throws IOException, InterruptedException {
        System.out.println("=====saved blurred start======");
        try {
            /** Executes python.exe script to blur the image **/

            String id = String.valueOf(orgId);
            ProcessBuilder processBuilder = new ProcessBuilder("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/face_pixel.exe", id)
                    .directory(new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            File src = new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg");
            File dest = new File("src/main/resources/localFiles/" + orgId + "/gallery/blur.jpg");
            FileUtils.copyFile(src, dest);

            /*FileInputStream input = new FileInputStream(dest);
            MockMultipartFile multipartFile = new MockMultipartFile("file",
                    dest.getName(), "image/png", IOUtils.toByteArray(input));



            if(blurRepository == null)
            {
                System.out.println("=====null repository======");
            }
            else {
                FaceBlur faceBlur = blurRepository.selectBlurDataById(orgId);
                if (faceBlur == null) {
                    faceBlur = new FaceBlur();
                    faceBlur.setOrg_id(orgId);

                    blurRepository.save(faceBlur);
                }

                System.out.println("=====saved blurred image======");
                blurRepository.updateBlur(orgId, multipartFile.getBytes());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /** Deletes all unnecessary files **/

            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").delete();
            }
            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").delete();
            }
        }
    }

    public void FaceBlur(long orgId) throws IOException, InterruptedException {
        System.out.println("=====saved blurred image 2======");
        try {
            /** Executes python.exe script to blur the image **/

            String id = String.valueOf(orgId);
            ProcessBuilder processBuilder = new ProcessBuilder("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/face_blur.exe", id)
                    .directory(new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            File src = new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg");
            File dest = new File("src/main/resources/localFiles/" + orgId + "/gallery/blur.jpg");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            /** Deletes all unnecessary files **/

            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").delete();
            }
            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").delete();
            }
        }
    }

    public boolean FaceBlurSuspend(long orgId, int num) throws IOException, InterruptedException {
        try {

            /** Retrieves image from localfiles and copies it to the working directory **/

            String localFile = "src/main/resources/localFiles/" + orgId + "/gallery/image" + num + ".jpg";
            FileUtils.copyFile(new File(localFile), new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg"));

            /** Executes python.exe script to blur the image **/

            String id = String.valueOf(orgId);
            ProcessBuilder processBuilder = new ProcessBuilder("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/face_blur.exe", id)
                    .directory(new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            File src = new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg");
            FileUtils.copyFile(src, new File(localFile));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            /** Deletes all unnecessary files **/

            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").delete();
            }
            if (new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").exists()) {
                new File("src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").delete();
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        FaceRecognitionServiceImpl tester = new FaceRecognitionServiceImpl();
    }
}

