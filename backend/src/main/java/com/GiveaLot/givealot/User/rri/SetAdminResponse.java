package com.GiveaLot.givealot.User.rri;

public class SetAdminResponse {
    private final boolean success;
    private final String message;

    public SetAdminResponse(boolean success, String message) {
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
