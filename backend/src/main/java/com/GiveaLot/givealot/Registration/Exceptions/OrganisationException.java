package com.GiveaLot.givealot.Registration.Exceptions;

public class OrganisationException extends Exception{
    private String message;

    public OrganisationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
