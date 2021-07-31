package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSocialsRequest
{
    private String website;
    private String type;
    private String orgId;

    public AddSocialsRequest(@JsonProperty String website,
                             @JsonProperty String type,
                             @JsonProperty String orgId) {
        this.website = website;
        this.type = type;
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
