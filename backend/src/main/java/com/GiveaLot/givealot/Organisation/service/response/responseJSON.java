package com.GiveaLot.givealot.Organisation.service.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Service;

@JsonPropertyOrder({"code", "message", ""})
@JsonRootName("result")
@Service
public class responseJSON implements response
{
    private String code;
    private String message;
    private Object object;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object getObject() {
        return this.object;
    }
}
