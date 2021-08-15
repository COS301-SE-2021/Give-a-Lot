package com.GiveaLot.givealot.User.rri;

public class UpdateAccountInfoResponse {
    private final String message;
    private final boolean success;

    public UpdateAccountInfoResponse(boolean success, String message) {
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
