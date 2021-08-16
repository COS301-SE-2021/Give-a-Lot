package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgDonationInfoRequest {

    private long orgId;
    private String orgInfo;

    public AddOrgDonationInfoRequest(@JsonProperty long orgId,
                                     @JsonProperty String orgInfo) {
        this.orgId = orgId;
        this.orgInfo = orgInfo;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo;
    }
}
