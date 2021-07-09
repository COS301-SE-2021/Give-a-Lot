package com.GiveaLot.givealot.Registration;

public class organisationRegistrationResponseJSON
{
    private int status;
    private String message;
    private String organisationKey;


    public organisationRegistrationResponseJSON(int status, String message, String organisationKey) {
        this.status = status;
        this.message = message;
        this.organisationKey = organisationKey;
    }

    public String getOrganisationKey() {
        return organisationKey;
    }

    public void setOrganisationKey(String organisationKey) {
        this.organisationKey = organisationKey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
