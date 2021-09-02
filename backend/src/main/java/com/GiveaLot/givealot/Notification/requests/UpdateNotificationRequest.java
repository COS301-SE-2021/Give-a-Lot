package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateNotificationRequest {

    private Long org_id;

    public UpdateNotificationRequest(@JsonProperty("org_id") Long org_id) {
        this.org_id = org_id;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }
}
