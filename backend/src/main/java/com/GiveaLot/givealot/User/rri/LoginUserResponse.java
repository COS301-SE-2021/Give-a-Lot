package com.GiveaLot.givealot.User.rri;

public class LoginUserResponse {
    private final String message;
    private final boolean success;

    public LoginUserResponse(boolean success, String message) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

}
