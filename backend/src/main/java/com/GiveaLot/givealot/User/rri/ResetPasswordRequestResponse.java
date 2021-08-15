package com.GiveaLot.givealot.User.rri;

public class ResetPasswordRequestResponse {
    private final String message;
    private final boolean success;

    public ResetPasswordRequestResponse(boolean success, String message) {
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
