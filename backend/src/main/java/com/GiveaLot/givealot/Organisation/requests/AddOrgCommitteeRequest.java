package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgCommitteeRequest {
    private Long orgId;
    private String committee;

    public AddOrgCommitteeRequest(@JsonProperty ("orgId") Long orgId,
                                  @JsonProperty ("committee") String committee) {
        this.orgId = orgId;
        this.committee = committee;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }
}
