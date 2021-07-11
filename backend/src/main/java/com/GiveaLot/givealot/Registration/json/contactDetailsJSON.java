package com.GiveaLot.givealot.Registration.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class contactDetailsJSON {

    private String previous_step_organisationName;
    private String previous_step_organisationPassword;
    private String contactPerson;
    private String email;
    private String contactNumber;

    public contactDetailsJSON(@JsonProperty("orgName") String previous_step_organisationName,
                              @JsonProperty("orgPassword") String previous_step_organisationPassword,
                              @JsonProperty("contactPerson") String contactPerson,
                              @JsonProperty("email") String email,
                              @JsonProperty("contactNumber") String contactNumber)
    {
        this.previous_step_organisationName = previous_step_organisationName;
        this.previous_step_organisationPassword = previous_step_organisationPassword;
        this.contactPerson = contactPerson;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getPrevious_step_organisationName() {
        return previous_step_organisationName;
    }

    public void setPrevious_step_organisationName(String previous_step_organisationName) {
        this.previous_step_organisationName = previous_step_organisationName;
    }

    public String getPrevious_step_organisationPassword() {
        return previous_step_organisationPassword;
    }

    public void setPrevious_step_organisationPassword(String previous_step_organisationPassword) {
        this.previous_step_organisationPassword = previous_step_organisationPassword;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
