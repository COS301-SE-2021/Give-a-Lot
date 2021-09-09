package com.GiveaLot.givealot.Certificate.Controller;

import com.GiveaLot.givealot.Certificate.requests.RetrieveCertificateRequest;
import com.GiveaLot.givealot.Certificate.service.CertificateServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;

import java.io.File;
import java.nio.file.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class CertificateController {

    @Autowired
    CertificateServiceImpl service;

    @PostMapping("/certificate/compare")
    public ResponseEntity<Boolean> compareCertificate(@RequestParam("selectedFile") MultipartFile certificate) throws Exception {
       try
       {
           if(certificate == null)
           {
               System.out.println("certificate is null");
           }

           return new ResponseEntity<>(service.compareCertificate(certificate), HttpStatus.OK);
       }
       catch (Exception e)
       {
           System.out.println("ooops: " + e);
           return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);

       }
    }

    @GetMapping("/certificate/download")
    public ResponseEntity<Resource> download(RetrieveCertificateRequest body) throws Exception {
    File file = service.retrieveCertificate(body);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=img.jpg");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
