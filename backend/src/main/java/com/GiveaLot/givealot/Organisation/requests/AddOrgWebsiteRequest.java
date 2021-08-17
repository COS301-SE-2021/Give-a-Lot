package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgWebsiteRequest
{
    private long orgId;
    private String website;

    public AddOrgWebsiteRequest(@JsonProperty ("orgId") long orgId,
                                @JsonProperty ("website") String website)
    {
        this.orgId = orgId;
        this.website = website;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
