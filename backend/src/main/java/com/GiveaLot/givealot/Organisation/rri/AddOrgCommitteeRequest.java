package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgCommitteeRequest {
    private String orgId;
    private String committee;

    public AddOrgCommitteeRequest(@JsonProperty String orgId,
                                  @JsonProperty String committee) {
        this.orgId = orgId;
        this.committee = committee;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }
}
