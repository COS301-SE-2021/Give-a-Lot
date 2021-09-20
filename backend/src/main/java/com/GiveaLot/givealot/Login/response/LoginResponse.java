package com.GiveaLot.givealot.Login.response;

public class LoginResponse {
    private final String message;
    private final boolean success;
    private final String JWTToken;
    private final String curr_user_email;
    private final Long id;

    public LoginResponse(String curr_user_email,boolean success, String message, String JWTToken,Long id)
    {
        this.message = message;
        this.success = success;
        this.JWTToken = JWTToken;
        this.id = id;
        this.curr_user_email = curr_user_email;
    }

    public String getCurr_user_email() {
        return curr_user_email;
    }

    public Long getId() {
        return id;
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

