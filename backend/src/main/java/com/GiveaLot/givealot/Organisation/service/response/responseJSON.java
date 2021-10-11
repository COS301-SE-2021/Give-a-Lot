package com.GiveaLot.givealot.Organisation.service.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Service;

@JsonPropertyOrder({"code", "message", ""})
@JsonRootName("result")
@Service
public class responseJSON {
    private String code;
    private String message;
    private Object object;

    public responseJSON(String code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }


    public responseJSON() {
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

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return this.object;
    }
}
