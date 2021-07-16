package com.GiveaLot.givealot.Registration.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class confirmJSON {
    private String orgName;
    private String orgSlogan;
    private String orgDescription;
    private String orgSector;
    private String orgEmail;
    private String password;
    private String contactPerson;
    private String contactNumber;

    public confirmJSON(@JsonProperty("orgName") String orgName,
                       @JsonProperty("orgSlogan") String orgSlogan,
                       @JsonProperty("orgDescription") String orgDescription,
                       @JsonProperty("orgSector") String orgSector,
                       @JsonProperty("orgEmail") String orgEmail,
                       @JsonProperty("orgPassword") String password,
                       @JsonProperty("contactPerson") String contactPerson,
                       @JsonProperty("contactNumber") String contactNumber)
    {
        this.orgName = orgName;
        this.orgSlogan = orgSlogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.password = password;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
    }

    /**
     * Getters
     **/

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getOrgSector() {
        return orgSector;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgSlogan() {
        return orgSlogan;
    }

    /**Setters**/

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrgSector(String orgSector) {
        this.orgSector = orgSector;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public void setOrgSlogan(String orgSlogan) {
        this.orgSlogan = orgSlogan;
    }
}
