package com.GiveaLot.givealot.User.service;

import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.response.GetActivationDateResponse;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.response.getNumberofUsersResponse;
import com.GiveaLot.givealot.User.response.userResponseGeneral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    userResponseGeneral Register(RegisterUserRequest request) throws Exception;

    userResponseGeneral ResetPasswordRequest(ResetPasswordRequestRequest request)throws Exception;

    userResponseGeneral SetAdmin(SetAdminRequest request) throws Exception;

    User getUser(GetUserRequest request)throws UserNotAuthorisedException,Exception;
    List<User> GetUsers(GetUsersRequest request) throws UserNotAuthorisedException,Exception;

    getNumberofUsersResponse getNumberOfUser(GetUsersRequest request)throws Exception;

/*
    GetActivationDateResponse getDateByMonth(GetActivationDateRequest request)throws Exception;
*/
}
