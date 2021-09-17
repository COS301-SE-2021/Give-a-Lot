package com.GiveaLot.givealot.Login.controller;

import com.GiveaLot.givealot.Login.request.LoginRequest;
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
