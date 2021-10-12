package com.GiveaLot.givealot.FaceRecognition.controller;

import com.GiveaLot.givealot.FaceRecognition.dataclass.FaceBlur;
import com.GiveaLot.givealot.FaceRecognition.repository.BlurRepository;
import com.GiveaLot.givealot.FaceRecognition.service.requests.AddFRImageMultipartRequest;
import com.GiveaLot.givealot.FaceRecognition.service.response.generalFaceRecognitionResponse;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/frecognition")
public class FacialRecognitionController {
    @Autowired
    ServerAccess serverAccess;

    @Autowired
    BlurRepository blurRepository;


    @PostMapping("/blur")
    public ResponseEntity<generalFaceRecognitionResponse> addOrgImage(@ModelAttribute AddFRImageMultipartRequest body)
    {
        try
        {
            serverAccess.uploadImageAnon(body.getOrgId(),body.getImage(), body.getType());

            File dest = new File("backend/src/main/resources/localFiles/" + body.getOrgId() + "/gallery/blur.jpg");

            FileInputStream input = new FileInputStream(dest);
            MockMultipartFile multipartFile = new MockMultipartFile("file",
                    dest.getName(), "image/png", IOUtils.toByteArray(input));



            if(blurRepository == null)
            {
                System.out.println("=====null repository======");
            }
            else {
                FaceBlur faceBlur = blurRepository.selectBlurDataById(body.getOrgId());
                if (faceBlur == null) {
                    faceBlur = new FaceBlur();
                    faceBlur.setOrg_id(body.getOrgId());

                    blurRepository.save(faceBlur);
                }

                System.out.println("=====saved blurred image======");
                blurRepository.updateBlur(body.getOrgId(), multipartFile.getBytes());
            }
            return new ResponseEntity<>(new generalFaceRecognitionResponse("added_blur","success"), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalFaceRecognitionResponse("add_blur_500_err","failed: " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/blur/get/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getImageCertificate(@PathVariable("orgId") Long body)
    {
        try {
            byte [] blurred_image = blurRepository.selectBlurDataById(body).getImage_bytes();
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(blurred_image);
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }
    }
}
