package com.GiveaLot.givealot.User.exception;

public class UserAlreadyValidationAccountException extends Exception{
    private final String errorMessage;

    public UserAlreadyValidationAccountException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
