package com.GiveaLot.givealot.media.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.GiveaLot.givealot.media.MediaService.MediaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("media")
public class MediaController {

    @Autowired
    MediaServiceImp service;

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
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getPDFCertificate(@PathVariable("orgId") String orgId)
    {
        try {
            byte[] bytes = service.getOrganisationCertificateAsPDF(Long.valueOf(orgId));
            System.out.println(Arrays.toString(bytes));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(bytes);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @RequestMapping(value = "/version/qr_code/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getQRCode(@PathVariable("orgId") String orgId)
    {
        byte[] bytes;
        try {
            bytes = service.getOrganisationQrCode(Long.valueOf(orgId));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(bytes);
        }
        catch (Exception e)
        {
            System.out.println("======QR CODE ERROR======= " + e);
            var fallback = new ClassPathResource("localFiles/fallback/QRCodeDefault.jpeg");

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

    @RequestMapping(value = "/version/qr_code/admin/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getQRCodeAsAdmin(@PathVariable("orgId") String orgId)
    {
        byte[] bytes;
        try {
            bytes = service.getOrganisationQrCodeAdmin(Long.valueOf(orgId));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(bytes);
        }
        catch (Exception e)
        {

                return ResponseEntity
                        .notFound().build();

        }
    }


    @RequestMapping(value = "/version/cert_png/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getImageCertificate(@PathVariable("orgId") String orgId)
    {
        byte[] bytes;
        try {
            bytes = service.getOrganisationCertificateAsPNG(Long.valueOf(orgId));
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(bytes);
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }
    }

    @RequestMapping(value = "/version/gallery/images/{orgId}/{imageId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getGalleryImage(@PathVariable("orgId") Long orgId,@PathVariable("imageId") Long imageId)
    {
        byte[] bytes;
        try {
            bytes = service.getGalleryImages(orgId, imageId);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(bytes);
        }
        catch (Exception e)
        {
            return ResponseEntity
                    .notFound().build();
        }
    }

    @RequestMapping(value = "/pixelorblur/version/{orgId}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)
    public ResponseEntity<byte[]> getPixelOrBlur(@PathVariable("orgId") String orgId)
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

        var imgFile = new ClassPathResource("localFiles/" +orgId+ "/gallery/blur.jpg");
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
}