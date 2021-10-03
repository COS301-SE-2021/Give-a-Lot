package com.GiveaLot.givealot.media.MediaService;

public interface MediaService {
    boolean orgIdExists(Long orgId);
    String getOrganisationStatus(Long orgId) throws Exception;

    byte[] getOrganisationQrCode(Long orgId) throws Exception;

    byte[] getOrganisationCertificateAsPDF(Long valueOf)throws Exception;
}
