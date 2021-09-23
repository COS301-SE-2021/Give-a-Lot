package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class levelsRequest {
    Long orgId;

    public levelsRequest(@JsonProperty("orgId")Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrg_id(Long orgId) {
        this.orgId = orgId;
    }
}
