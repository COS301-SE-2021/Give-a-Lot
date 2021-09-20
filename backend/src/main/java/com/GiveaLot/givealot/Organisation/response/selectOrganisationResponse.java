package com.GiveaLot.givealot.Organisation.response;

import com.GiveaLot.givealot.Organisation.model.Organisations;

import java.util.List;

public class selectOrganisationResponse {
    private String code;
    private String message;
    private OrganisationResponseObject response;

    public selectOrganisationResponse(String code, String message, OrganisationResponseObject response) {
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

    public OrganisationResponseObject getResponse() {
        return response;
    }

    public void setResponse(OrganisationResponseObject response) {
        this.response = response;
    }
}
