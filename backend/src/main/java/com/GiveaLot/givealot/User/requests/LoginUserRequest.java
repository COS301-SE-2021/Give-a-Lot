package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginUserRequest {
    private final String email;
    private final String password;

    public LoginUserRequest(@JsonProperty String email,
                            @JsonProperty String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
