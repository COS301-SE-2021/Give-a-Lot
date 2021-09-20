package com.GiveaLot.givealot.FaceRecognition.controller;

import com.GiveaLot.givealot.FaceRecognition.service.requests.AddFRImageMultipartRequest;
import com.GiveaLot.givealot.FaceRecognition.service.response.generalFaceRecognitionResponse;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            serverAccess.uploadImageAnon(body.getOrgId(),body.getImage());
            return new ResponseEntity<>(new generalFaceRecognitionResponse("added_blur","success"), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalFaceRecognitionResponse("add_blur_500_err","failed: " + e), HttpStatus.BAD_REQUEST);
        }
    }
}
