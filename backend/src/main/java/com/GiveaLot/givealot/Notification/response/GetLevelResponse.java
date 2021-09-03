package com.GiveaLot.givealot.Notification.response;

import com.GiveaLot.givealot.Notification.dataclass.Notification;

import java.util.List;

public class GetLevelResponse {
    private String code;
    private String message;
    private long response;

    public GetLevelResponse(String code, String message, long response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
