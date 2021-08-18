package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResetPasswordRequestRequest {
    private final String email;
    private final String newPassword;

    public ResetPasswordRequestRequest(@JsonProperty ("userEmail") String email,@JsonProperty ("newPassword") String newPassword) {

        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
