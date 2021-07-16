package com.GiveaLot.givealot.Registration.Exceptions;

public class EmailException extends Exception
{
    private String message;

    public EmailException(String message) {
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
