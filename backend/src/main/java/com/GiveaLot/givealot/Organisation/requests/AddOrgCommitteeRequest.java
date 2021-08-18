package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgCommitteeRequest {
    private long orgId;
    private String committee;

    public AddOrgCommitteeRequest(@JsonProperty ("orgId") long orgId,
                                  @JsonProperty ("committee") String committee) {
        this.orgId = orgId;
        this.committee = committee;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }
}
