package com.GiveaLot.givealot.FaceRecognition.service.controller;

import com.GiveaLot.givealot.FaceRecognition.service.FaceRecognitionServiceImpl;
import com.GiveaLot.givealot.FaceRecognition.service.requests.AddFRImageMultipartRequest;
import com.GiveaLot.givealot.FaceRecognition.service.response.generalFaceRecognitionResponse;
import com.GiveaLot.givealot.Organisation.requests.AddOrgImageMultipartRequest;
import com.GiveaLot.givealot.Organisation.response.generalOrganisationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/frecognition")
public class FacialRecognitionController {
    @Autowired
    FaceRecognitionServiceImpl faceRecognitionService;

    @PostMapping("/blur")
    public ResponseEntity<generalFaceRecognitionResponse> addOrgImage(@ModelAttribute AddFRImageMultipartRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = faceRecognitionService.FaceBlur(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_blur_500_err","failed: " + e), HttpStatus.BAD_REQUEST);
        }
    }
}
