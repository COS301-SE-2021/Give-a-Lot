package com.GiveaLot.givealot.Login.response;

public class LoginResponse {
    private final String message;
    private final boolean success;
    private final String JWTToken;

    public LoginResponse(boolean success, String message, String JWTToken)
    {
        this.message = message;
        this.success = success;
        this.JWTToken = JWTToken;
    }

    public String getMessage()
    { return message; }

    public boolean isSuccess() {
        return success;
    }

    public String getJWTToken() {
        return JWTToken;
    }
}

