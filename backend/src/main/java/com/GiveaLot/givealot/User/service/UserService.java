package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.User.model.User;
import com.GiveaLot.givealot.User.requests.RegisterUserRequest;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.requests.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean Register(RegisterUserRequest request) throws Exception;

    boolean ResetPasswordRequest(ResetPasswordRequestRequest request)throws Exception;

    boolean SetAdmin(SetAdminRequest request) throws Exception;

    User getUser(GetUserRequest request)throws UserNotAuthorisedException,Exception;
    List<User> GetUsers(GetUsersRequest request) throws UserNotAuthorisedException,Exception;
}
