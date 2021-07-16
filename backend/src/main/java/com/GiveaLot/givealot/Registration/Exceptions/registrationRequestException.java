package com.GiveaLot.givealot.Registration.Exceptions;

public class registrationRequestException extends Exception{
    private String message;

    public registrationRequestException(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
