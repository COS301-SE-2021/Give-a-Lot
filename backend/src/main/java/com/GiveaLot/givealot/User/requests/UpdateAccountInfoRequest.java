package com.GiveaLot.givealot.User.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateAccountInfoRequest {
    private String email;
    private String firstName;
    private String lastName;
    private final String JWTToken;


    public UpdateAccountInfoRequest(@JsonProperty String email,
                                    @JsonProperty String firstName,
                                    @JsonProperty String lastName, String jwtToken) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        JWTToken = jwtToken;
    }
    public UpdateAccountInfoRequest(String JWTToken) {
        this.JWTToken = JWTToken;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJWTToken() {
        return JWTToken;
    }
}
