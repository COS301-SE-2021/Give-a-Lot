package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgWebsiteRequest {
    private Long orgId;
    private String website;

    public AddOrgWebsiteRequest(@JsonProperty("orgId") Long orgId,
                                @JsonProperty("website") String website) {
        this.orgId = orgId;
        this.website = website;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
