package com.GiveaLot.givealot.User.requests;

import com.GiveaLot.givealot.User.dataclass.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUserRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public RegisterUserRequest(@JsonProperty("firstName") String firstName,
                               @JsonProperty("lastName")  String lastName,
                               @JsonProperty("email")  String email,
                               @JsonProperty("password")  String password) {
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
        User user = new User(firstName,lastName,email,password);
        return user;
    }

    @Override
    public String toString() {
        return "RegisterUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
