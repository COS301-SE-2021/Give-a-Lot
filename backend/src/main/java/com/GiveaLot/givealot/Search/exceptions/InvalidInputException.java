package com.GiveaLot.givealot.Search.exceptions;

public class InvalidInputException extends Exception{
    private String message;

    public InvalidInputException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}