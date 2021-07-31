package com.GiveaLot.givealot.Organisation.service.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.stereotype.Service;

@JsonPropertyOrder({"code", "message"})
@JsonRootName("result")
@Service
public class responseJSON
{
    private String code;
    private String message;

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
