package com.GiveaLot.givealot.User.controller;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.model.User;
import com.GiveaLot.givealot.User.rri.RegisterUserRequest;
import com.GiveaLot.givealot.User.rri.RegisterUserResponse;
import com.GiveaLot.givealot.User.service.UserService;
import com.GiveaLot.givealot.User.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/user")
@RestController
public class UserController {


    private final UserServiceImpl service;

    private final responseJSON response;

    @Autowired
    public UserController(UserServiceImpl service, responseJSON response)
    {
        this.service = service;
        this.response = response;
    }
    @PostMapping("/addUser/user")
    public responseJSON addUser(@RequestBody @NonNull User body)
    {
        response.setObject(null);
        try
        {
            RegisterUserRequest request = new RegisterUserRequest(body.getFirstname(), body.getLastname(), body.getEmail(), body.getPassword());

            RegisterUserResponse response = service.Register(request);
            response.isSuccess();
            return null;
        }
        catch (Exception e)
        {
            response.setCode("org_add_err_501");
            response.setMessage("unsuccessful " + e.getMessage());
            return response;
        }
    }



}
