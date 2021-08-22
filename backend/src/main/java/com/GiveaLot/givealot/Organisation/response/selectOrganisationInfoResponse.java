package com.GiveaLot.givealot.Organisation.response;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;

public class selectOrganisationInfoResponse {
    private String code;
    private String message;
    private OrganisationInfo response;

    public selectOrganisationInfoResponse(String code, String message, OrganisationInfo response) {
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

    public OrganisationInfo getResponse() {
        return response;
    }

    public void setResponse(OrganisationInfo response) {
        this.response = response;
    }
}
