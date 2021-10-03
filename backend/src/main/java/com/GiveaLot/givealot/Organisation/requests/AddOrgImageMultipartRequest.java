package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class AddOrgImageMultipartRequest {
    private Long orgId;

    private MultipartFile image;

    public AddOrgImageMultipartRequest(@JsonProperty("orgId") Long orgId,
                             @JsonProperty("image") MultipartFile image)
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

    public MultipartFile getImages() {
        return image;
    }

    public void setImages(MultipartFile images) {
        this.image = images;
    }
}
