package com.GiveaLot.givealot.Login.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
    private final String username;
    private final String password;
    private final String role; /*user,admin, organisation*/

    public LoginRequest(@JsonProperty("username") String username,@JsonProperty("password")  String password, @JsonProperty("role")  String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}