package com.GiveaLot.givealot.User.response;

import com.GiveaLot.givealot.User.dataclass.User;

public class GetActivationDateResponse {

    private final String message;
    private final boolean success;
    String response;

    public GetActivationDateResponse(String message, boolean success, String response) {
        this.message = message;
        this.success = success;
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
