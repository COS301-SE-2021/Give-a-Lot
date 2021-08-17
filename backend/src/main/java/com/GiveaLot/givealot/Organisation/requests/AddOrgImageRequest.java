package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgImageRequest
{
    private long orgId;
    private File image;

    public AddOrgImageRequest(@JsonProperty long orgId,
                              @JsonProperty File image)
    {
        this.orgId = orgId;
        this.image = image;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}
