package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.repository.LoginRepository;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    LoginRepository loginRepository;
    @Override
    public LoginResponse loginGeneralUser(LoginRequest body) throws Exception{

        if(body == null)
        {
            throw new Exception("please send a valid request");
        }
        if(loginRepository.findUserByEmail(body.getEmail()) == null)
        {
            throw new Exception("user not found");

        }
        User user = loginRepository.findUserByEmail(body.getEmail());

        if(!user.getPassword().equals(body.getPassword()))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in succesfully","1");
    }

    @Override
    public LoginResponse loginOrganisation(LoginRequest body)throws Exception {
        if(body == null)
        {
            throw new Exception("please send a valid request");
        }
        if(loginRepository.findOrganisationByEmail(body.getEmail()) == null)
        {
            throw new Exception("organisation not found");

        }
        User user = loginRepository.findOrganisationByEmail(body.getEmail());

        if(!user.getPassword().equals(body.getPassword()))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in succesfully","1");
    }

    @Override
    public LoginResponse loginAdminUser(LoginRequest body) throws Exception{

        if(body == null)
        {
            throw new Exception("please send a valid request");
        }
        if(loginRepository.findUserByEmail(body.getEmail()) == null)
        {
            throw new Exception("user not found");

        }
        User user = loginRepository.findUserByEmail(body.getEmail());

        if(!user.getAdmin())
        {
            throw new Exception("user is not an admin");
        }

        if(!user.getPassword().equals(body.getPassword()))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in succesfully","1");    }
}
