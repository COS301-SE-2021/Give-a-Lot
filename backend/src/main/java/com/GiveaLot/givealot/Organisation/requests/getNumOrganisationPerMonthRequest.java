package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getNumOrganisationPerMonthRequest {
    private final String adminUserEmail;

    public getNumOrganisationPerMonthRequest(@JsonProperty("adminUserEmail") String adminUserEmail) {
        this.adminUserEmail = adminUserEmail;
    }

    public String getAdminUserEmail() {
        return adminUserEmail;
    }
}
