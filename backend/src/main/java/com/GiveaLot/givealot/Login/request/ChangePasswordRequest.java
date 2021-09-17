package com.GiveaLot.givealot.Login.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordRequest {
    String password;
    String userEmail;

    public ChangePasswordRequest(@JsonProperty("password") String password,@JsonProperty("userEmail") String userEmail) {
        this.password = password;
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }



    public String getUserEmail() {
        return userEmail;
    }


}
