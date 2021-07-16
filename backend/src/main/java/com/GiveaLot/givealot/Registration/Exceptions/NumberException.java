package com.GiveaLot.givealot.Registration.Exceptions;

public class NumberException extends Exception{
    private String message;

    public NumberException(String message) {
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
