package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgDonationInfoRequest {

    private String orgId;
    private String orgInfo;

    public AddOrgDonationInfoRequest(@JsonProperty String orgId,
                                     @JsonProperty String orgInfo) {
        this.orgId = orgId;
        this.orgInfo = orgInfo;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo;
    }
}
