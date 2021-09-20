package com.GiveaLot.givealot.FaceRecognition.service.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AddFRImageMultipartRequest {
    private Long orgId;
    private MultipartFile image;

    public AddFRImageMultipartRequest(@JsonProperty("orgId") Long orgId,
                                       @JsonProperty ("image") MultipartFile image)
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

    public void setImages(MultipartFile image) {
        this.image = image;
    }

}
