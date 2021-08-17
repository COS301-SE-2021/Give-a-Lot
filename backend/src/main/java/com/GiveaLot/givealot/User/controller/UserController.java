package com.GiveaLot.givealot.User.controller;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.model.User;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/user")
@CrossOrigin("*")
@RestController
public class UserController {

    private final UserServiceImp userServiceImp;
    private final responseJSON response;


    @Autowired
    public UserController(UserServiceImp userServiceImp,responseJSON response) {
        this.userServiceImp = userServiceImp;
        this.response = response;

    }

    @PostMapping("/register/user")
    public responseJSON addUser(@RequestBody @NonNull User body)
    {
        response.setObject(null);
        try
        {
            if(userServiceImp.Register(new RegisterUserRequest(body.getFirstname(),body.getLastname(),body.getEmail(),body.getPassword())))
            {
                response.setCode("user_add_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("user_add_err_501");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/setadmin/user")
    public responseJSON setAdmin(@RequestBody @NonNull SetAdminRequest body)
    {
        response.setObject(null);
        try
        {
            if(userServiceImp.SetAdmin(body))
            {
                response.setCode("add_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("add_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    @PutMapping("/resetPassword/user")
    public responseJSON resetPassword(@RequestBody @NonNull ResetPasswordRequestRequest body)
    {
        response.setObject(null);
        try
        {
            if(userServiceImp.ResetPasswordRequest(body))
            {
                response.setCode("add_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("add_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/get/user")
    public responseJSON getUser(@RequestBody @NonNull GetUserRequest body)
    {
        response.setObject(null);
        try
        {
            User res = userServiceImp.getUser(body);
            if(res != null)
            {
                response.setCode("user_sel_ok_200");
                response.setMessage("success");
            }
            response.setObject(res);
        }
        catch (Exception e)
        {
            response.setCode("user_sel_bad_500");
            response.setMessage("unsuccessful " + e.toString());
        }
        return response;
    }

    @GetMapping("/get/users")
    public responseJSON getUsers(@RequestBody @NonNull GetUsersRequest body)
    {
        response.setObject(null);
        try
        {
            List<User> res = userServiceImp.GetUsers(body);
            if(res != null)
            {
                response.setCode("user_sel_ok_200");
                response.setMessage("success");
            }
            response.setObject(res);
        }
        catch (Exception e)
        {
            response.setCode("user_sel_bad_500");
            response.setMessage("unsuccessful " + e.toString());
        }
        return response;
    }
}
