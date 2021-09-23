package com.GiveaLot.givealot.media.MediaService;

public interface MediaService {
    boolean orgIdExists(Long orgId);
    String getOrganisationStatus(Long orgId) throws Exception;
}
