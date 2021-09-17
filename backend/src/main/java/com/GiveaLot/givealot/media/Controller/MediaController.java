package com.GiveaLot.givealot.media.Controller;

import java.io.IOException;
import com.GiveaLot.givealot.media.MediaService.MediaServiceImp;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController {

    @Autowired
    MediaServiceImp service;

    @RequestMapping(value = "/cert/version/png/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getImageCertificate(@PathVariable("orgId") String orgId)
    {
        try
        {
            if(!service.orgIdExists(Long.valueOf(orgId)))
            {
                return ResponseEntity
                        .notFound().build();
            }
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }

        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/certificate/CertificateImage.png");

        byte[] bytes = null;
        try {
            bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        }
        catch (IOException e)
        {
            return ResponseEntity
                    .notFound().build();

        }


    }

    @RequestMapping(value = "/logo/version/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getOrganisationLogo(@PathVariable("orgId") String orgId)
    {
        try
        {
            if(!service.orgIdExists(Long.valueOf(orgId)))
            {
                return ResponseEntity
                        .notFound().build();
            }
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }

        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/gallery/logo.jpg");

        byte[] bytes = null;
        try {
            bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        }
        catch (IOException e) /*if jpg fails, then try PNG*/
        {
            //try PNG

            imgFile = new ClassPathResource("localFiles/" +orgId+ "/gallery/logo.png");
            bytes = null;
            try
            {
                bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(bytes);
            }
            catch (IOException e2)
            {
                return ResponseEntity
                        .notFound().build();
            }
        }
    }

    @RequestMapping(value = "/cert/version/pdf/{orgId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPDFCertificate(@PathVariable("orgId") String orgId)
    {
        try
        {
            if(!service.orgIdExists(Long.valueOf(orgId)))
            {
                return ResponseEntity
                        .notFound().build();
            }
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }

        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/certificate/CertificateComplete.pdf");

        byte[] bytes = null;
        try {
            bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(bytes);
        }
        catch (IOException e)
        {
            return ResponseEntity
                 .notFound().build();
        }
    }

    @RequestMapping(value = "/cert/version/qr_code/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getQRCode(@PathVariable("orgId") String orgId) {
        try {
            if (!service.orgIdExists(Long.valueOf(orgId))) {
                return ResponseEntity
                        .notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity
                    .notFound().build();
        }

        var imgFile = new ClassPathResource("localFiles/" + orgId + "/gallery/QRCode.png");

        byte[] bytes = null;
        try {
            bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        }
        catch (IOException e)
        {
            var fallback = new ClassPathResource("localFiles/fallback/QRCodeDefault.jpeg");
            bytes = null;

            try {
                bytes = StreamUtils.copyToByteArray(fallback.getInputStream());
                return ResponseEntity
                        .ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(bytes);
            }
            catch (IOException ew)
            {
                return ResponseEntity
                        .notFound().build();
            }
        }
    }
}