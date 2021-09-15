package com.GiveaLot.givealot.Login.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForgotPasswordRequest {
   private final String email;

    public ForgotPasswordRequest(@JsonProperty("email") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
