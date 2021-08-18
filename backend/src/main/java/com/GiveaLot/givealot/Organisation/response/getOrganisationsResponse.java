package com.GiveaLot.givealot.Organisation.response;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.User.response.UserResponse;

import java.util.List;

public class getOrganisationsResponse  {
    private String code;
    private String message;
    private List<Organisations> response;

    public getOrganisationsResponse(String code, String message, List<Organisations> response) {
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

    public List<Organisations> getResponse() {
        return response;
    }

    public void setResponse(List<Organisations> response) {
        this.response = response;
    }
}
