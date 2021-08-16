package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService{
    @Override
    public LoginResponse loginGeneralUser(LoginRequest body) {
        return null;
    }

    @Override
    public LoginResponse loginOrganisation(LoginRequest body) {
        return null;
    }

    @Override
    public LoginResponse loginAdminUser(LoginRequest body) {
        return null;
    }
}
