package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponse loginGeneralUser(LoginRequest body) throws Exception;
    LoginResponse loginOrganisation(LoginRequest body)throws Exception;
    LoginResponse loginAdminUser(LoginRequest body)throws Exception;
}
