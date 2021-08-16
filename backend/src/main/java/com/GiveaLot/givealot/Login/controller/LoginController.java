package com.GiveaLot.givealot.Login.controller;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Login.service.LoginService;
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

    private LoginService service;

    @Autowired
    LoginController(@Qualifier("loginServiceImp") LoginService service)
    {
        this.service = service;
    }
    @PostMapping("/general")
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
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/general")
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
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/admin")
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
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null), HttpStatus.BAD_REQUEST);
        }
    }
}
