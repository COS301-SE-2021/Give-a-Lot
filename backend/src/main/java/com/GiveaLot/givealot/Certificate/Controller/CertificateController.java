package com.GiveaLot.givealot.Certificate.Controller;

import com.GiveaLot.givealot.Certificate.service.CertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class CertificateController {

    @Autowired
    CertificateServiceImpl service;

    @PostMapping("/certificate/compare")
    public boolean compareCertificate(@RequestBody @NonNull MultipartFile certificate) throws Exception {

       try
       {
           return  service.compareCertificate(certificate);
       }
       catch (Exception e)
       {
           System.out.println("ooops: " + e);
           return false;
       }

    }
}
