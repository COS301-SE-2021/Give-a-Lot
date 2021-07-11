package com.GiveaLot.givealot.Registration.json;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
*  this object will be returned by the controller
*  during organisation registration
* */


public class tempOrganisation {
    private Integer status;
    private String message;
    private String orgName;
    private String orgSlogan;
    private String orgDescription;
    private String orgSector;
    private String orgEmail;
    private String password;
    private String contactPerson;
    private String contactNumber;

    public tempOrganisation() {
        this.status = null;
        this.message = null;
        this.orgName = null;
        this.orgSlogan = null;
        this.orgDescription = null;
        this.orgSector = null;
        this.orgEmail = null;
        this.password = null;
        this.contactPerson = null;
        this.contactNumber = null;
    }

    /**
     * Getters
     **/

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
