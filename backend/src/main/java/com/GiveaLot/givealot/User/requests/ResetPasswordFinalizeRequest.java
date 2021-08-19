package com.GiveaLot.givealot.User.requests;

public class ResetPasswordFinalizeRequest {

    private final String validationCode;
    private final String newPassword;

    public ResetPasswordFinalizeRequest(String resetCode, String newPassword) {
        this.validationCode = resetCode;
        this.newPassword = newPassword;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
