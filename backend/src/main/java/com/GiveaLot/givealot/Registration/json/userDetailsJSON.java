package com.GiveaLot.givealot.Registration.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userDetailsJSON
{
        private String userFirstName;
        private String userLastName;
        private String userEmail;
        private String password;

    public userDetailsJSON(
                           @JsonProperty("name") String userFirstName,
                           @JsonProperty("surname") String userLastName,
                           @JsonProperty("email") String userEmail,
                           @JsonProperty("password") String password)
    {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
