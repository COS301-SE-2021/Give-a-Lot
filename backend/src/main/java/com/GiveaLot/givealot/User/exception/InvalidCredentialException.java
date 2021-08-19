package com.GiveaLot.givealot.User.exception;

public class InvalidCredentialException extends Exception{
    private final String errorMessage;

    public InvalidCredentialException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
