package com.GiveaLot.givealot.Organisation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Organisation {

    private String orgName;
    private String slogan;
    private String orgDescription;
    private String orgSector;
    private String orgEmail;
    private String orgId;
    private String status;
    private String contactPerson;
    private String contactNumber;


    public Organisation(@JsonProperty String orgId,
                        @JsonProperty String orgName,
                        @JsonProperty String slogan,
                        @JsonProperty String orgDescription,
                        @JsonProperty String orgSector,
                        @JsonProperty String orgEmail,
                        @JsonProperty String status,
                        @JsonProperty String contactPerson,
                        @JsonProperty String contactNumber)
    {
        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.orgId = orgId;
        this.status = status;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
    }
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgSector() {
        return orgSector;
    }

    public void setOrgSector(String orgSector) {
        this.orgSector = orgSector;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
