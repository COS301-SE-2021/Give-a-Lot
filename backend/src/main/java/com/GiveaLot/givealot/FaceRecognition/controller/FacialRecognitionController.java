package com.GiveaLot.givealot.FaceRecognition.controller;

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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/frecognition")
public class FacialRecognitionController {
    @Autowired
    ServerAccess serverAccess;


    @PostMapping("/blur")
    public ResponseEntity<generalFaceRecognitionResponse> addOrgImage(@ModelAttribute AddFRImageMultipartRequest body)
    {
        try
        {
            serverAccess.uploadImageAnon(body.getOrgId(),body.getImage(), body.getType());
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
            File dest = new File("src/main/resources/localFiles/" + body + "/gallery/blur.jpg");
            FileInputStream input = new FileInputStream(dest);
            MultipartFile multipartFile = new MockMultipartFile("file",
                    dest.getName(), "image/png", IOUtils.toByteArray(input));

            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(multipartFile.getBytes());
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }
    }
}
