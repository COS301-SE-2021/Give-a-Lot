package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuspendRequest {
    Long orgID;

    public SuspendRequest(@JsonProperty("orgID") Long orgID) {
        this.orgID = orgID;
    }


    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }
}
