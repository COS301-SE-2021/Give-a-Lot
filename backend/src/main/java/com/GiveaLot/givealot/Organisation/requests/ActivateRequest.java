package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivateRequest {
    Long orgID;

    public ActivateRequest(@JsonProperty("orgID") Long orgID) {
        this.orgID = orgID;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

}
