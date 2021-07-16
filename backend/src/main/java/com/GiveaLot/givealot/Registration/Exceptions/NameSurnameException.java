package com.GiveaLot.givealot.Registration.Exceptions;

public class NameSurnameException extends Exception{
    private String message;

    public NameSurnameException(String message) {
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
