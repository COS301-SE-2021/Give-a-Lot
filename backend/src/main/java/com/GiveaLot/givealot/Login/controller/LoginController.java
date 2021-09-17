package com.GiveaLot.givealot.Login.controller;

import com.GiveaLot.givealot.Login.request.ChangePasswordRequest;
import com.GiveaLot.givealot.Login.request.ForgotPasswordRequest;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.request.TokenRequest;
import com.GiveaLot.givealot.Login.response.ForgotPasswordResponse;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Login.service.LoginService;
import com.GiveaLot.givealot.Login.service.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/login/user")
public class LoginController {

    private final LoginServiceImp service;

    @Autowired
    LoginController( LoginServiceImp service)
    {
        this.service = service;
    }

    @PostMapping("/determine") /*tested - works perfect*/
    ResponseEntity<LoginResponse> login(@RequestBody @NonNull LoginRequest body)
    {
        LoginResponse response;

        try
        {
            System.out.println("1=========================================");
            System.out.println(body.getEmail());
            System.out.println(body.getPassword());
            response = service.login(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println("2=========================================");
            System.out.println(e);
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null, null), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/general") /*tested - works perfect*/
    ResponseEntity<LoginResponse> loginGeneralUser(@RequestBody @NonNull LoginRequest body)
    {
        LoginResponse response;

        try
        {
            response = service.loginGeneralUser(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null, null), HttpStatus.OK);
        }
    }

    @PostMapping("/forgot_password")
    ResponseEntity<ForgotPasswordResponse> forgotPassowrd(@RequestBody @NonNull ForgotPasswordRequest body)
    {
        ForgotPasswordResponse response;

        try
        {
            response = service.forgotPassward(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new ForgotPasswordResponse(false,"token not sent "+e), HttpStatus.OK);
        }
    }

    @PostMapping("/check_token") /*tested - works perfect*/
    ResponseEntity<ForgotPasswordResponse> checkToken(@RequestBody @NonNull TokenRequest body)
    {
        ForgotPasswordResponse response;

        try
        {
            response = service.checkToken(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new ForgotPasswordResponse(false,"tokens do not match"), HttpStatus.OK);
        }
    }
    @PostMapping("/update_password") /*tested - works perfect*/
    ResponseEntity<ForgotPasswordResponse> updatePassword(@RequestBody @NonNull ChangePasswordRequest body)
    {
        ForgotPasswordResponse response;

        try
        {
            response = service.changePassword(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new ForgotPasswordResponse(false,"password reset failed"), HttpStatus.OK);
        }
    }

    @PostMapping("/login_org") /*tested - works perfect*/
    ResponseEntity<LoginResponse> loginOrganisation(@RequestBody @NonNull LoginRequest body)
    {
        LoginResponse response;

        try
        {
            response = service.loginOrganisation(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null, null), HttpStatus.OK);
        }
    }

    @PostMapping("/admin") /*tested - works perfect*/
    ResponseEntity<LoginResponse> loginAdminUser(@RequestBody @NonNull LoginRequest body)
    {
        LoginResponse response;

        try
        {
            response = service.loginAdminUser(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null, null), HttpStatus.OK);
        }
    }
}
