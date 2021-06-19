package com.GiveaLot.givealot.Search.exceptions;

public class ResultNotFoundException extends Exception {
    private String message;

    public ResultNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}