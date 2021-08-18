package com.GiveaLot.givealot.User.response;

import com.GiveaLot.givealot.User.dataclass.User;

import java.util.List;

public class UserResponse {
    private final String message;
    private final boolean success;
    private final String JWTToken;
    List<User> response;
    public UserResponse(boolean success, String message, String JWTToken, List<User> res)
    {
        this.message = message;
        this.success = success;
        this.JWTToken = JWTToken;
        this.response = res;
    }

    public List<User> getResponse() {
        return response;
    }

    public void setResponse(List<User> response) {
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
