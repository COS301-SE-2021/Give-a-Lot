package com.GiveaLot.givealot.FaceRecognition.service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FaceRecognitionServiceImpl {

    public File FacePixel(long orgId) throws IOException, InterruptedException {
        try {
            String id = String.valueOf(orgId);
            ProcessBuilder processBuilder = new ProcessBuilder("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/face_pixel.exe", id)
                    .directory(new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            File src = new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/pixel" + orgId + ".jpg");
            File dest = new File("backend/src/main/resources/localFiles/" + orgId + "/gallery/pixel.jpg");
            FileUtils.copyFile(src, dest);
            return dest;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").exists()){
                new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").delete();
            }
            if (new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/pixel" + orgId + ".jpg").exists()){
                new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/pixel" + orgId + ".jpg").delete();
            }
        }
        return null;
    }

    public File FaceBlur(long orgId) throws IOException, InterruptedException {
        try {
            String id = String.valueOf(orgId);
            ProcessBuilder processBuilder = new ProcessBuilder("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/face_blur.exe", id)
                    .directory(new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service"));
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            File src = new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg");
            File dest = new File("backend/src/main/resources/localFiles/" + orgId + "/gallery/blur.jpg");
            FileUtils.copyFile(src, dest);
            return dest;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").exists()){
                new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/temp" + orgId + ".jpg").delete();
            }
            if (new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").exists()){
                new File("backend/src/main/java/com/GiveaLot/givealot/FaceRecognition/service/tempImages/blur" + orgId + ".jpg").delete();
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        FaceRecognitionServiceImpl tester = new FaceRecognitionServiceImpl();
        System.out.println(tester.FaceBlur(56).exists());
    }
}
