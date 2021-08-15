package com.GiveaLot.givealot.User.rri;

import com.GiveaLot.givealot.User.model.User;

public class GetCurrentUserResponse {
    private final String message;
    private final boolean success;
    private final User user;

    public GetCurrentUserResponse(boolean success, String message, User user) {
        this.message = message;
        this.success = success;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public User getUser() {
        return user;
    }
}
