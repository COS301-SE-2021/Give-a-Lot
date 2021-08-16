package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse loginGeneralUser(LoginRequest body);
    LoginResponse loginOrganisation(LoginRequest body);
    LoginResponse loginAdminUser(LoginRequest body);
}
