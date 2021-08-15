package com.GiveaLot.givealot.User.exception;

public class UserNotAuthorisedException extends Exception {
    private final String errorMessage;

    public UserNotAuthorisedException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
