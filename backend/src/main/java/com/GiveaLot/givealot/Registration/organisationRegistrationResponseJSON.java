package com.GiveaLot.givealot.Registration;

public class organisationRegistrationResponseJSON
{
    int status;
    String message;

    public organisationRegistrationResponseJSON(int status, String message) {
        this.status = status;
        this.message = message;
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
