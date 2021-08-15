package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUsersRequest {
    private final String adminUser;

    public GetUsersRequest(@JsonProperty("adminUser")  String adminUser) {
        this.adminUser = adminUser;
    }
    public String getAdminUser() {
        return adminUser;
    }
}
