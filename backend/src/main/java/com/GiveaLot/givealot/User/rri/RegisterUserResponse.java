package com.GiveaLot.givealot.User.rri;

public class RegisterUserResponse {

    private final boolean success;
    private final String message;

    public RegisterUserResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
