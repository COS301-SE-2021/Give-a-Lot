package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvestigateRequest {
    Long orgID;

    public InvestigateRequest(@JsonProperty("orgID") Long orgID) {
        this.orgID = orgID;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }
}
