package com.GiveaLot.givealot.Registration.Exceptions;

public class PasswordException extends Exception
{
    private String message;

    public PasswordException(String message) {
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
