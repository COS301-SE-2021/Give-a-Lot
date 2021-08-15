package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgWebsiteRequest
{
    private String orgId;
    private String website;

    public AddOrgWebsiteRequest(@JsonProperty ("orgId") String orgId,
                                @JsonProperty ("website") String website)
    {
        this.orgId = orgId;
        this.website = website;
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
}
