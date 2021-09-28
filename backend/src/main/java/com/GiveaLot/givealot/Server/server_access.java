package com.GiveaLot.givealot.Server;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface server_access {
    File downloadImageJPG(long orgId, int index) throws Exception;

    ChannelSftp setupJsch() throws JSchException;

    void createOrganisationDirectory(long orgId, String orgName) throws Exception;

    void uploadCertificate(long orgId, String orgName) throws Exception;

    void downloadCertificateTemplate(int points) throws Exception;

    File downloadCertificate(long orgId, String orgName) throws Exception;

    void uploadAuditDocument(long orgId, String orgName, MultipartFile document) throws Exception;

    File downloadAuditDoc(long orgId, String orgName) throws Exception;

    void uploadImageQRCode(long orgId, MultipartFile imageMPF) throws Exception;

    void uploadImageJPG(long orgId, MultipartFile image, int numberOfImages) throws Exception;

    File downloadImageLogo(long orgId) throws Exception;

    void uploadImagePNG(long orgId, MultipartFile imageMPF) throws Exception;

    void uploadImageLogo(long orgId, MultipartFile imageMPF) throws Exception;

    void deleteQR(long orgId) throws JSchException;

    void deleteLogo(long orgId) throws JSchException;

    void deleteImage(long orgId, int number) throws JSchException;

    void uploadImageAnon(long orgId, MultipartFile imageMPF, int type) throws Exception;

    void uploadReport(long orgId, File report, String date) throws Exception;

    File downloadImagePNG(long orgId, int index) throws Exception;

    File downloadCertificatePNG(long orgId, String orgName) throws Exception;

    void uploadCertificatePNG(long orgId, String orgName) throws Exception;

    File downloadBlurredImage(long orgId, String orgName) throws Exception;

    public void uploadBlurredImage(long orgId, String orgName) throws Exception;


}
