package com.GiveaLot.givealot.Events.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class generalResponse {
    String code;
    String message;

    public generalResponse(String code,
                           String message)
    {
        this.code = code;
        this.message = message;
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
}
