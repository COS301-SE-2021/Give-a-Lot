package com.GiveaLot.givealot.Login.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenRequest {
    String token;

    public TokenRequest(@JsonProperty("token") String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
