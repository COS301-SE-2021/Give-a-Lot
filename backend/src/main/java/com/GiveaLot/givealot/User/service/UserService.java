package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse Register(RegisterUserRequest request) throws Exception;

    UserResponse ResetPasswordRequest(ResetPasswordRequestRequest request)throws Exception;

    UserResponse SetAdmin(SetAdminRequest request) throws Exception;

    User getUser(GetUserRequest request)throws UserNotAuthorisedException,Exception;
    List<User> GetUsers(GetUsersRequest request) throws UserNotAuthorisedException,Exception;
}
