package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSocialsRequest
{

    private String type;
    private String orgId;
    private String url;

    public AddSocialsRequest(
                             @JsonProperty String type,
                             @JsonProperty String orgId,
                             @JsonProperty String url) {
        this.url = url;
        this.type = type;
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
