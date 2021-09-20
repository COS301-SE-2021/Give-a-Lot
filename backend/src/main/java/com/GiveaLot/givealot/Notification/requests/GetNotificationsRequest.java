package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNotificationsRequest {
    private final String adminUserEmail;

    public GetNotificationsRequest(@JsonProperty("adminUserEmail")  String adminUserEmail) {
        this.adminUserEmail = adminUserEmail;
    }
    public String getAdminUserEmail() {
        return adminUserEmail;
    }
}
