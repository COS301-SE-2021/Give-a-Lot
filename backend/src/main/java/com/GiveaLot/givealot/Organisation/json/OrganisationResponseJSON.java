package com.GiveaLot.givealot.Organisation.json;

public class OrganisationResponseJSON
{
    int code;
    String status;

    public OrganisationResponseJSON(int http_code, String status) {
        this.code = http_code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
