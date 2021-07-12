package com.GiveaLot.givealot.Registration.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AboutDetailsJSON {

    private String previous_step_organisationName;
    private String previous_step_organisationPassword;
    private String previous_step_contactPerson;
    private String previous_step_email;
    private String previous_step_contactNumber;
    private String organisationSector;
    private String organisationDescription;
    private String organisationSlogan;

    public AboutDetailsJSON(@JsonProperty("orgName") String previous_step_organisationName,
                            @JsonProperty("orgPassword") String previous_step_organisationPassword,
                            @JsonProperty("contactPerson") String previous_step_contactPerson,
                            @JsonProperty("orgEmail") String previous_step_email,
                            @JsonProperty("contactNumber") String previous_step_contactNumber,
                            @JsonProperty("orgSector") String organisationSector,
                            @JsonProperty("orgDescription") String organisationDescription,
                            @JsonProperty("orgSlogan")  String organisationSlogan)
    {
        this.previous_step_organisationName = previous_step_organisationName;
        this.previous_step_organisationPassword = previous_step_organisationPassword;
        this.previous_step_contactPerson = previous_step_contactPerson;
        this.previous_step_email = previous_step_email;
        this.previous_step_contactNumber = previous_step_contactNumber;
        this.organisationSector = organisationSector;
        this.organisationDescription = organisationDescription;
        this.organisationSlogan = organisationSlogan;
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

    public String getPrevious_step_contactPerson() {
        return previous_step_contactPerson;
    }

    public void setPrevious_step_contactPerson(String previous_step_contactPerson) {
        this.previous_step_contactPerson = previous_step_contactPerson;
    }

    public String getPrevious_step_email() {
        return previous_step_email;
    }

    public void setPrevious_step_email(String previous_step_email) {
        this.previous_step_email = previous_step_email;
    }

    public String getPrevious_step_contactNumber() {
        return previous_step_contactNumber;
    }

    public void setPrevious_step_contactNumber(String previous_step_contactNumber) {
        this.previous_step_contactNumber = previous_step_contactNumber;
    }

    public String getOrganisationSector() {
        return organisationSector;
    }

    public void setOrganisationSector(String organisationSector) {
        this.organisationSector = organisationSector;
    }

    public String getOrganisationDescription() {
        return organisationDescription;
    }

    public void setOrganisationDescription(String organisationDescription) {
        this.organisationDescription = organisationDescription;
    }

    public String getOrganisationSlogan() {
        return organisationSlogan;
    }

    public void setOrganisationSlogan(String organisationSlogan) {
        this.organisationSlogan = organisationSlogan;
    }
}
