package com.GiveaLot.givealot.User.service;


import com.GiveaLot.givealot.User.exception.*;
import com.GiveaLot.givealot.User.rri.VerifyAccountResponse;
import com.GiveaLot.givealot.User.rri.*;
import org.springframework.stereotype.Service;

@Service
public interface UserService {



    RegisterUserResponse Register(RegisterUserRequest request);

    VerifyAccountResponse VerifyAccount(VerifyAccountRequest request) throws UserAlreadyValidationAccountException;

    LoginUserResponse Login(LoginUserRequest request) throws InvalidCredentialException;


    UpdateAccountInfoResponse UpdateAccountInfo(UpdateAccountInfoRequest request);


    ResetPasswordRequestResponse ResetPasswordRequest(ResetPasswordRequestRequest request);


    ResetPasswordFinalizeResponse ResetPasswordFinalize(ResetPasswordFinalizeRequest request) throws ResetPasswordTimedOutException;


    GetCurrentUserResponse GetCurrentUser(GetCurrentUserRequest request);


    SetAdminResponse SetAdmin(SetAdminRequest request) throws UserNotAuthorisedException;


    GetUsersResponse GetUsers(GetUsersRequest request) throws UserNotAuthorisedException;


}
