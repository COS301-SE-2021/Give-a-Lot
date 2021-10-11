package com.GiveaLot.givealot.Organisation.response;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

public class getNumberOfOrganisationsResponse {
    private String code;
    private String message;
    private int response;

    public getNumberOfOrganisationsResponse(String code, String message, int response) {
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
