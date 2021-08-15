package com.GiveaLot.givealot.User.rri;

public class ResetPasswordFinalizeResponse {
    private final String message;
    private final boolean success;

    public ResetPasswordFinalizeResponse(boolean success, String message) {
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
