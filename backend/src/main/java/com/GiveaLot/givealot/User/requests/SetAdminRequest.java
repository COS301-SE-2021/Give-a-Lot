package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetAdminRequest {
    private final String adminEmail;
    private final String generalUserEmail;

    public SetAdminRequest(@JsonProperty("generalUserEmail") String generalUserEmail,@JsonProperty("adminEmail") String AdminEmail) {
        this.adminEmail = AdminEmail;
        this.generalUserEmail = generalUserEmail;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getGeneralUserEmail() {
        return generalUserEmail;
    }

    @Override
    public String toString() {
        return "SetAdminRequest{" +
                "adminEmail='" + adminEmail + '\'' +
                ", generalUserEmail='" + generalUserEmail + '\'' +
                '}';
    }
}
