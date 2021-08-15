package com.GiveaLot.givealot.User.rri;

import com.GiveaLot.givealot.User.model.User;

import java.util.List;

public class GetUsersResponse {
    private final String message;
    private final boolean success;
    private final List<User> userList;

    public GetUsersResponse(boolean success, String message, List<User> userList) {
        this.message = message;
        this.success = success;
        this.userList = userList;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<User> getUserList() {
        return userList;
    }
}
