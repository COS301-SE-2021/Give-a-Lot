package com.GiveaLot.givealot.User.controller;

import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register/user") /*tested - all good*/
    ResponseEntity<UserResponse> addUser(@RequestBody @NonNull RegisterUserRequest body)
    {
        UserResponse userResponse;
        try
        {
            userResponse = userServiceImp.Register(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null), HttpStatus.OK);
        }
    }
  /*  @PostMapping("/login_org") /*tested - works perfect
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
            return new ResponseEntity<>(new LoginResponse(false,e.toString(),null), HttpStatus.OK);
        }
    }*/

    @PostMapping("/setadmin/user") /* tested - all good */
    public ResponseEntity<UserResponse>  setAdmin(@RequestBody @NonNull SetAdminRequest body)
    {
        UserResponse userResponse;
        try
        {
            userResponse = userServiceImp.SetAdmin(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null), HttpStatus.OK);
        }
    }

    @PostMapping("/resetPassword/user") /* tested - all good */
    public ResponseEntity<UserResponse>  resetPassword(@RequestBody @NonNull ResetPasswordRequestRequest body)
    {
        UserResponse userResponse;
        try
        {
            userResponse = userServiceImp.ResetPasswordRequest(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null), HttpStatus.OK);
        }

    }

    @PostMapping("/get/user") /*tested all good*/
    public ResponseEntity<UserResponse>  getUser(@RequestBody @NonNull GetUserRequest body)
    {
        UserResponse userResponse;
        try
        {
            User res = userServiceImp.getUser(body);
            if(res != null)
            {
                userResponse = new UserResponse(true,"successful","1");
                return new ResponseEntity<>(userResponse,HttpStatus.OK);

            }
            return new ResponseEntity<>(new UserResponse(false,"unsuccessful",null), HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null), HttpStatus.OK);

        }
    }

    @GetMapping("/get/users") /*tested all good*/
    public ResponseEntity<UserResponse>  getUsers(@RequestBody @NonNull GetUsersRequest body)
    {
        UserResponse userResponse;
        try
        {
            List<User> res = userServiceImp.GetUsers(body);
            if(res != null)
            {
                userResponse = new UserResponse(true,"successful","1");
                return new ResponseEntity<>(userResponse,HttpStatus.OK);
            }
            return new ResponseEntity<>(new UserResponse(false,"unsuccessful",null), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null), HttpStatus.OK);
        }
    }
}
