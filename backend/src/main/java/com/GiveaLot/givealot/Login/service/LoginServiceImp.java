package com.GiveaLot.givealot.Login.service;

import com.GiveaLot.givealot.Login.repository.*;
import com.GiveaLot.givealot.Login.request.*;
import com.GiveaLot.givealot.Login.response.*;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    public LoginResponse login(LoginRequest request) throws Exception {
        if(request == null)
        {
            throw new Exception("Exception: login request object is null");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().trim().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(request.getPassword() == null)
        {
            throw new Exception("Exception: password field is null");
        }
        else if(request.getPassword().trim().isEmpty()) {
            throw new Exception("Exception: password field is empty");
        }

        User user = userRepository.findUserByEmail(request.getEmail());

        if(user == null) {
            return this.loginOrganisation(request);
        }

        if(user.getAdmin())
        {
           return this.loginAdminUser(request);
        }
        else return this.loginGeneralUser(request);

    }

    @Override /*tested - works perfect*/
    public LoginResponse loginGeneralUser(LoginRequest request) throws Exception
    {
        if(request == null)
        {
            throw new Exception("Exception: login request object is null");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().trim().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(request.getPassword() == null)
        {
            throw new Exception("Exception: password field is null");
        }
        else if(request.getPassword().trim().isEmpty()) {
            throw new Exception("Exception: password field is empty");
        }

        User user = loginRepository.findUserByEmail(request.getEmail());

        if(user== null)
        {
            throw new Exception("password: user not found");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in successfully","general");
    }

    @Override /*tested - works perfect*/
    public LoginResponse loginOrganisation(LoginRequest request)throws Exception
    {
        if(request == null)
        {
            throw new Exception("please send a valid request");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is null");
        }
        else if(request.getEmail().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }

        Organisations user = organisationRepository.selectOrganisationByEmail(request.getEmail());

        if(user == null)
        {
            throw new Exception("organisation not found");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in succesfully","organisation");
    }

    @Override /*tested - works perfect*/
    public LoginResponse loginAdminUser(LoginRequest request) throws Exception{

        if(request == null)
        {
            throw new Exception("Exception: request object is not set");
        }
        else if(request.getEmail() == null)
        {
            throw new Exception("Exception: email field is not set");
        }
        else if(request.getEmail().isEmpty())
        {
            throw new Exception("Exception: email field is empty");
        }
        else if(loginRepository.findUserByEmail(request.getEmail()) == null)
        {
            throw new Exception("user not found");
        }

        User user = loginRepository.findUserByEmail(request.getEmail());

        if(!user.getAdmin())
        {
            throw new Exception("user is not an admin");
        }

        // salts and hashes of passwords
        String salt = getMd5(request.getEmail());
        String salted = getMd5(request.getPassword() + salt);

        if(!user.getPassword().equals(salted))
        {
            throw new Exception("user password is incorrect");
        }
        return new LoginResponse(true,"User logged in succesfully","admin");
    }

    public String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}
