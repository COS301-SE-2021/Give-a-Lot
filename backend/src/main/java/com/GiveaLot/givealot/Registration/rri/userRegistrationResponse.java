package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.json.userRegistrationResponseJSON;

public class userRegistrationResponse
{
    userRegistrationResponseJSON userRegistrationResponseJSON;

    public userRegistrationResponse(userRegistrationResponseJSON userRegistrationResponseJSON) {
        this.userRegistrationResponseJSON = userRegistrationResponseJSON;
    }

    public  userRegistrationResponseJSON getUserRegistrationResponseJSON() {
        return userRegistrationResponseJSON;
    }

    public void setUserRegistrationResponseJSON(userRegistrationResponseJSON userRegistrationResponseJSON) {
        this.userRegistrationResponseJSON = userRegistrationResponseJSON;
    }
}
