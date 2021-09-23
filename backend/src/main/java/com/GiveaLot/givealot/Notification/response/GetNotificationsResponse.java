package com.GiveaLot.givealot.Notification.response;

import com.GiveaLot.givealot.Notification.dataclass.Notification;
import com.GiveaLot.givealot.Organisation.model.Organisations;

import java.util.List;

public class GetNotificationsResponse {
    private String code;
    private String message;
    private List<Notification> response;

    public GetNotificationsResponse(String code, String message, List<Notification> response) {
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

    public List<Notification> getResponse() {
        return response;
    }

    public void setResponse(List<Notification> response) {
        this.response = response;
    }
}
