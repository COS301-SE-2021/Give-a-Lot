package com.GiveaLot.givealot.media.MediaService;

import java.util.List;

public interface MediaService {
    boolean orgIdExists(Long orgId);
    String getOrganisationStatus(Long orgId) throws Exception;

    byte[] getOrganisationQrCode(Long orgId) throws Exception;

    byte[] getOrganisationCertificateAsPDF(Long valueOf)throws Exception;

    byte[] getGalleryImages(Long orgId, Long imageId) throws Exception;

    byte[] getOrganisationCertificateAsPNG(Long valueOf) throws Exception;


    byte[] getOrganisationQrCodeAdmin(Long orgId) throws Exception;
}
