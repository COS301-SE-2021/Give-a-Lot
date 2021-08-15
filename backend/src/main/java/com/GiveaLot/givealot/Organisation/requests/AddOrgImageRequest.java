package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgImageRequest
{
    private String orgId;
    private String image;

    public AddOrgImageRequest(@JsonProperty String orgId,
                              @JsonProperty String image)
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
