package com.GiveaLot.givealot.Notification.response;

public class getNumberOfNotificationsResponse {
    private String code;
    private String message;
    private int response;

    public getNumberOfNotificationsResponse(String code, String message, int response) {
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

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
