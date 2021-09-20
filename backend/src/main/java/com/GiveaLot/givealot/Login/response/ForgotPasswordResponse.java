package com.GiveaLot.givealot.Login.response;

public class ForgotPasswordResponse {
    private final String message;
    private final boolean success;

    public ForgotPasswordResponse(boolean success, String message)
    {
        this.message = message;
        this.success = success;
    }


    public String getMessage()
    { return message; }

    public boolean isSuccess() {
        return success;
    }

}
