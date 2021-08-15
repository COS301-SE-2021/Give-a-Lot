package com.GiveaLot.givealot.User.requests;

import com.GiveaLot.givealot.User.dataclass.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUserRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public RegisterUserRequest(@JsonProperty String firstName,
                               @JsonProperty String lastName,
                               @JsonProperty String email,
                               @JsonProperty String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User getUser()
    {
        User user = new User(getFirstName(),getLastName(),getEmail(),getPassword());
        return user;
    }


}
