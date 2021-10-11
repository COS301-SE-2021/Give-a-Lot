package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgDonationInfoRequest {

    private Long orgId;
    private String orgInfo;

    public AddOrgDonationInfoRequest(@JsonProperty("orgId") long orgId,
                                     @JsonProperty("orgInfo") String orgInfo) {
        this.orgId = orgId;
        this.orgInfo = orgInfo;
    }


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo;
    }
}
