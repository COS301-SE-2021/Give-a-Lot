package com.GiveaLot.givealot.Certificate.controller;

import com.GiveaLot.givealot.Certificate.service.CertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@CrossOrigin("*")
public class certificateController {

    @Autowired
    CertificateServiceImpl service;

    @PostMapping("/compare")
    ResponseEntity<String> compareCertificate(@RequestBody File file)
    {
        try
        {
            boolean res = service.compareCertificate(file);
            if(res)
                return new ResponseEntity<>("compare ran to completion: TRUE", HttpStatus.OK);
            else return new ResponseEntity<>("compare ran to completion: FALSE", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("error with certificate compare: " + e, HttpStatus.OK);
        }
    }
}
