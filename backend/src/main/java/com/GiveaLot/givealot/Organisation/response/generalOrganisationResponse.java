package com.GiveaLot.givealot.Organisation.response;

public class generalOrganisationResponse {

    private String code;
    private String message;

    public generalOrganisationResponse(String code, String message) {
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
