package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getNumUserPerMonthRequest {
    private final String adminUserEmail;

    public getNumUserPerMonthRequest(@JsonProperty("adminUserEmail") String adminUserEmail) {
        this.adminUserEmail = adminUserEmail;
    }

    public String getAdminUserEmail() {
        return adminUserEmail;
    }
}
