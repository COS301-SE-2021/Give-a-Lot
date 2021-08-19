package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSocialsRequest
{
    private String type;
    private Long orgId;
    private String url;

    public AddSocialsRequest(
                             @JsonProperty ("socialType") String type,
                             @JsonProperty ("orgId") Long orgId,
                             @JsonProperty ("url") String url) {
        this.url = url;
        this.type = type;
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
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
