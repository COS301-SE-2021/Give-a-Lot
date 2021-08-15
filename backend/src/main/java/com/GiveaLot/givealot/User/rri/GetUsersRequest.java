package com.GiveaLot.givealot.User.rri;

public class GetUsersRequest {
    private final String JWTToken;

    public GetUsersRequest(String JWTToken) {
        this.JWTToken = JWTToken;
    }

    public String getJWTToken() {
        return JWTToken;
    }
}
