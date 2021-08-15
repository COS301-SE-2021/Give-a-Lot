package com.GiveaLot.givealot.User.requests;

public class VerifyAccountRequest {
    private final String activationCode;
    private final String username;

    public VerifyAccountRequest(String activationCode, String id) {
        this.activationCode = activationCode;
        this.username = id;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getUsername() {
        return username;
    }
}
