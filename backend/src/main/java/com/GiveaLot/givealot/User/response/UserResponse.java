package com.GiveaLot.givealot.User.response;

public class UserResponse {
    private final String message;
    private final boolean success;
    private final String JWTToken;

    public UserResponse(boolean success, String message, String JWTToken)
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
