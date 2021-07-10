package com.GiveaLot.givealot.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class tempOrganisation {
    String orgName;
    String orgSlogan;
    String orgDescription;
    String orgSector;
    String orgEmail;
    String password;
    String contactPerson;
    String contactNumber;

    public tempOrganisation() {
        this.orgName = "";
        this.orgSlogan = "";
        this.orgDescription = "";
        this.orgSector = "";
        this.orgEmail = "";
        this.password = "";
        this.contactPerson = "";
        this.contactNumber = "";
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
