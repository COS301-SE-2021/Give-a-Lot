package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class AddOrgQRCodeRequest {
    private Long orgId;
    private MultipartFile image;

    public AddOrgQRCodeRequest(@JsonProperty Long orgId,
                              @JsonProperty MultipartFile image)
    {
        this.orgId = orgId;
        this.image = image;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
