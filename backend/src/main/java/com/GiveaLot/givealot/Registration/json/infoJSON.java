package com.GiveaLot.givealot.Registration.json;


import com.fasterxml.jackson.annotation.JsonProperty;

/*
*  used in the first step of organisation
*  to get post request parameters
* */
public class infoJSON
{
    private String organisationName;
    private String organisationPassword;
    private String confirmPassword;

    public infoJSON(@JsonProperty("orgName") String organisationName,
                    @JsonProperty("orgPassword") String organisationPassword,
                    @JsonProperty("orgPasswordConfirm") String confirmPassword)
    {

        this.organisationName = organisationName;
        this.organisationPassword = organisationPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getOrganisationPassword() {
        return organisationPassword;
    }

    public void setOrganisationPassword(String organisationPassword) {
        this.organisationPassword = organisationPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
