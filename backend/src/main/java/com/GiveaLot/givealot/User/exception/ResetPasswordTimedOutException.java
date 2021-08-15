package com.GiveaLot.givealot.User.exception;

public class ResetPasswordTimedOutException extends Exception{
    private final String errorMessage;

    public ResetPasswordTimedOutException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
