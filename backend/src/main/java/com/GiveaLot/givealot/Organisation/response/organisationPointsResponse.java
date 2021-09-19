package com.GiveaLot.givealot.Organisation.response;


import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;

public class organisationPointsResponse {

    private String code;
    private String message;
    private OrganisationPoints response;

    public organisationPointsResponse(String code, String message, OrganisationPoints response) {
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

    public OrganisationPoints getResponse() {
        return response;
    }

    public void setResponse(OrganisationPoints response) {
        this.response = response;
    }
}
