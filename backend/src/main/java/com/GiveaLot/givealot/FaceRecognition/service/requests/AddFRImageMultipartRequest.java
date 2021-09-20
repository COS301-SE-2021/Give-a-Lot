package com.GiveaLot.givealot.FaceRecognition.service.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AddFRImageMultipartRequest {
    private Long orgId;
    private MultipartFile image;
    private int type;

    public AddFRImageMultipartRequest(@JsonProperty("orgId") Long orgId, @JsonProperty("image") MultipartFile image,@JsonProperty("type")int type) {
        this.orgId = orgId;
        this.image = image;
        this.type = type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
