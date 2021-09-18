package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.request.ChangePasswordRequest;
import com.GiveaLot.givealot.Login.request.ForgotPasswordRequest;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.request.TokenRequest;
import com.GiveaLot.givealot.Login.response.ForgotPasswordResponse;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    //logs in a general user
    LoginResponse loginGeneralUser(LoginRequest body) throws Exception;
    LoginResponse loginOrganisation(LoginRequest body)throws Exception;
    LoginResponse loginAdminUser(LoginRequest body)throws Exception;
    ForgotPasswordResponse forgotPassward(ForgotPasswordRequest body)throws Exception;
    ForgotPasswordResponse checkToken(TokenRequest body)throws Exception;
    ForgotPasswordResponse changePassword(ChangePasswordRequest body)throws Exception;
}
