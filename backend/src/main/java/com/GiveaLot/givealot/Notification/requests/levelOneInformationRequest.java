package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class levelOneInformationRequest {
    Long orgId;

    public levelOneInformationRequest(@JsonProperty("orgId") Long orgId) {
        this.orgId = orgId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
