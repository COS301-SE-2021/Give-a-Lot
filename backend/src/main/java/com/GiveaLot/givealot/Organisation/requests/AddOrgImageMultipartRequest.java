package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class AddOrgImageMultipartRequest {
    private Long orgId;
    private List<MultipartFile> images;

    public AddOrgImageMultipartRequest(@JsonProperty ("orgId") Long orgId,
                              @JsonProperty ("images") List<MultipartFile> images)
    {
        this.orgId = orgId;
        this.images = images;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
