package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetActivationDateRequest {
    private final String adminUser;

    public GetActivationDateRequest(@JsonProperty("adminUserEmail")  String adminUser) {
        this.adminUser = adminUser;
    }
    public String getAdminUser() {
        return adminUser;
    }
}
