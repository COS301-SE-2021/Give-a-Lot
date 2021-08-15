package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.InvalidCredentialException;
import com.GiveaLot.givealot.User.exception.ResetPasswordTimedOutException;
import com.GiveaLot.givealot.User.exception.UserAlreadyValidationAccountException;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import com.GiveaLot.givealot.User.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean Register(RegisterUserRequest request) throws Exception{
        if (request == null) {
            throw new Exception("Registration not set");
        }
        if(request.getEmail()==null)
        {
            throw new Exception("Registration not set, email not valid");

        }
        User userEmail = userRepository.findUserByEmail(request.getEmail());
        if (userEmail != null) {
            throw new  Exception("The email has already been taken.");
        }

        if(request.getFirstName()==null)
        {
            throw new Exception("Registration not set, firstname not valid");

        }
        if(request.getLastName() == null){
            throw new Exception("Registration not set, lastname not valid");

        }
        if (request.getPassword() == null)
        {
            throw new Exception("Registration not set, password not valid");

        }
        User newUser = request.getUser();
        newUser.setAdmin(false);
        newUser.setActivateDate(LocalDateTime.now());

        userRepository.save(newUser);
        return false;
    }


    @Override
    public boolean ResetPasswordRequest(ResetPasswordRequestRequest request) throws Exception{
        if (request == null) {
            throw new Exception("Reset not set");
        }

        User currentUser = userRepository.findUserByEmail(request.getEmail());
        if(currentUser == null)
        {
            throw new Exception("this user is not registered");
        }

        userRepository.updatePassword(currentUser.getEmail(),request.getNewPassword());
        return true;
    }


    @Override
    public boolean SetAdmin(SetAdminRequest request) throws Exception {
        if (request == null) {
            throw new Exception("Please send a valid request object.");
        }

        User Admin = userRepository.findUserByEmail(request.getAdminEmail());

        if (Admin==null) {
            throw new Exception( "The admin user trying to call setAdmin was not found.");
        }

        if(!Admin.getAdmin())
        {
            throw new Exception( "The current user is not an admin user");

        }
        User generalUser = userRepository.findUserByEmail(request.getGeneralUserEmail());

        int count = userRepository.updateAdmin(generalUser.getEmail(), true);

        if (count == 0) {
            throw new Exception( "The update did not occur correctly. Please try again.");
        }
        return true;
    }

    @Override
    public User getUser(GetUserRequest request) throws UserNotAuthorisedException {
        User admin = userRepository.findUserByEmail(request.getAdminUser());
        if(!admin.getAdmin())
        {
            throw new UserNotAuthorisedException("current user is not an admin");
        }
        return userRepository.findUserByEmail(request.getGeneralUserEmail());

    }

    @Override
    public List<User> GetUsers(GetUsersRequest request) throws UserNotAuthorisedException
        {
            User admin = userRepository.findUserByEmail(request.getAdminUser());

            if(!admin.getAdmin())
            {
                throw new UserNotAuthorisedException("current user is not an admin");
            }
             return userRepository.findAll();
        }
}
