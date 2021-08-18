package com.GiveaLot.givealot.User.response;

import com.GiveaLot.givealot.User.dataclass.User;

import java.util.List;

public class getUserResponse
{
    private final String message;
    private final boolean success;
    private final String JWTToken;
    User response;

    public getUserResponse(boolean success, String message, String JWTToken, User res)
    {
        this.message = message;
        this.success = success;
        this.JWTToken = JWTToken;
        this.response = res;
    }

    public User getResponse() {
        return response;
    }

    public void setResponse(User response) {
        this.response = response;
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
