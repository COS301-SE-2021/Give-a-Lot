package com.GiveaLot.givealot.Organisation.requests;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOrganisationsRequest {
    private final Long adminId;

    public GetOrganisationsRequest(@JsonProperty("adminId") Long adminId) {
        this.adminId = adminId;
    }


    public Long getAdminId() {
        return adminId;
    }
}
