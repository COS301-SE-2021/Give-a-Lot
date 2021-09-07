package com.GiveaLot.givealot.media.Controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import lombok.var;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MediaController {

    @RequestMapping(value = "/cert/version/png/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getImageCertificate(HttpServletResponse response,@PathVariable("orgId") Long orgId) throws IOException
    {
        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/certificate/CertificateImage.png");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @RequestMapping(value = "/cert/version/pdf/{orgId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPDFCertificate(HttpServletResponse response,@PathVariable("orgId") Long orgId) throws IOException
    {
        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/certificate/CertificateComplete.pdf");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);
    }
}
