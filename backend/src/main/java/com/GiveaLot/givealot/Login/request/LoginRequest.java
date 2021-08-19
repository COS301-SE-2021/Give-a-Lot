package com.GiveaLot.givealot.Login.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {
    private final String email;
    private final String password;
    private final String role; /*user,admin, organisation*/

    public LoginRequest(@JsonProperty("username") String email,@JsonProperty("password")  String password, @JsonProperty("role")  String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return role;
    }
}