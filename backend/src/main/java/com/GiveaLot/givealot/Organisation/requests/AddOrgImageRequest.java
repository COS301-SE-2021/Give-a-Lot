package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgImageRequest
{
    private String orgId;
    private File image;

    public AddOrgImageRequest(@JsonProperty String orgId,
                              @JsonProperty File image)
    {
        this.orgId = orgId;
        this.image = image;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}
