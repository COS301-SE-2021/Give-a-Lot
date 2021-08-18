package com.GiveaLot.givealot.User.controller;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.requests.*;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.response.getUserResponse;
import com.GiveaLot.givealot.User.response.userResponseGeneral;
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
    ResponseEntity<userResponseGeneral> addUser(@RequestBody @NonNull RegisterUserRequest body)
    {
        userResponseGeneral userResponse;
        try
        {
            userResponse = userServiceImp.Register(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new userResponseGeneral("add_usr_bad_500","failed :" + e), HttpStatus.OK);
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
    public ResponseEntity<userResponseGeneral>  setAdmin(@RequestBody @NonNull SetAdminRequest body)
    {
        userResponseGeneral userResponse;
        System.out.println(body);
        try
        {
            userResponse = userServiceImp.SetAdmin(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new userResponseGeneral("set_ad_500_bad","Failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/resetPassword/user") /* tested - all good */
    public ResponseEntity<userResponseGeneral>  resetPassword(@RequestBody @NonNull ResetPasswordRequestRequest body)
    {
        userResponseGeneral userResponse;
        try
        {
            userResponse = userServiceImp.ResetPasswordRequest(body);
            return new ResponseEntity<>(userResponse,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new userResponseGeneral("res_pass_bad_500","failed: " + e), HttpStatus.OK);
        }

    }

    @PostMapping("/get/user") /*tested all good*/
    public ResponseEntity<getUserResponse>  getUser(@RequestBody @NonNull GetUserRequest body)
    {
        getUserResponse userResponse;
        try
        {
            User res = userServiceImp.getUser(body);
            if(res != null)
            {
                userResponse = new getUserResponse(true,"successful","1", res);
                return new ResponseEntity<>(userResponse,HttpStatus.OK);

            }
            return new ResponseEntity<>(new getUserResponse(false,"unsuccessful",null, res), HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new getUserResponse(false,e.toString(),null, null), HttpStatus.OK);
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
                userResponse = new UserResponse(true,"successful","1", res);
                return new ResponseEntity<>(userResponse,HttpStatus.OK);
            }
            return new ResponseEntity<>(new UserResponse(false,"unsuccessful",null, res), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new UserResponse(false,e.toString(),null, null), HttpStatus.OK);
        }
    }
}
