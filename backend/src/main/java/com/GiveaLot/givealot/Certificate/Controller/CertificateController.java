package com.GiveaLot.givealot.Certificate.Controller;

import com.GiveaLot.givealot.Certificate.requests.RetrieveCertificateRequest;
import com.GiveaLot.givealot.Certificate.service.CertificateServiceImpl;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.util.StreamUtils;
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

    @Autowired
    OrganisationRepository organisationRepo;

    @PostMapping("/certificate/compare")
    public ResponseEntity<Long> compareCertificate(@RequestParam("selectedFile") MultipartFile certificate) throws Exception
    {
       try
       {
           Long res_org_id = service.compareCertificate(certificate);
           if(res_org_id < 0)
               return new ResponseEntity<>(res_org_id, HttpStatus.NOT_FOUND);
           else return new ResponseEntity<>(res_org_id, HttpStatus.OK);
       }
       catch (Exception e)
       {
           System.out.println("oops: " + e);
           return new ResponseEntity<>(-999L, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/certificate/download/{orgId}")
    public ResponseEntity<Resource> download(@PathVariable("orgId") Long orgId) throws Exception {

        String orgName = organisationRepo.selectOrganisationById(orgId).getOrgName();

        File file = service.retrieveCertificate(new RetrieveCertificateRequest(orgId,orgName));
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=certificate.pdf");
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

    @GetMapping("/image/logo/org/download/{orgId}")
    public ResponseEntity<byte []> download_logo(@PathVariable("orgId") Long orgId) throws Exception {

        String orgName = organisationRepo.selectOrganisationById(orgId).getOrgName();

        File file = service.retrieveLogo(orgId);
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=logo.png");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        byte [] image_as_byte_array = resource.getByteArray();


        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image_as_byte_array);
    }
}
