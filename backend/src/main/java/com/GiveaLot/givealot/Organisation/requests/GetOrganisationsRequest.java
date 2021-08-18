package com.GiveaLot.givealot.Organisation.requests;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOrganisationsRequest
{
    private final String adminUserEmail;

    public GetOrganisationsRequest(@JsonProperty("adminUserEmail")  String adminUserEmail) {
        this.adminUserEmail = adminUserEmail;
    }
    public String getAdminUserEmail() {
        return adminUserEmail;
    }
}
