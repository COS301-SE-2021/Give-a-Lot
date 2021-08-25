package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgLogoRequest {
    private Long orgId;
    private File image;

    public AddOrgLogoRequest(@JsonProperty Long orgId,
                              @JsonProperty File image)
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}
