package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetLevelRequest {
    private final Long orgid;

    public GetLevelRequest(@JsonProperty("orgid")  Long orgid) {
        this.orgid = orgid;
    }

    public Long getOrgid() {
        return orgid;
    }
}
