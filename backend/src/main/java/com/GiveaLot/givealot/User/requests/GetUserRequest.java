package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserRequest {
    private final String generalUserEmail;
    private final String adminUser;

    public GetUserRequest(@JsonProperty("generalUserEmail") String generalUserEmail,@JsonProperty("adminUser")  String adminUser) {
        this.generalUserEmail = generalUserEmail;
        this.adminUser = adminUser;
    }

    public String getGeneralUserEmail() {
        return generalUserEmail;
    }

    public String getAdminUser() {
        return adminUser;
    }
}
