package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSocialsRequest
{
    private String type;
    private long orgId;
    private String url;

    public AddSocialsRequest(
                             @JsonProperty ("type") String type,
                             @JsonProperty ("orgId") long orgId,
                             @JsonProperty ("url") String url) {
        this.url = url;
        this.type = type;
        this.orgId = orgId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
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
