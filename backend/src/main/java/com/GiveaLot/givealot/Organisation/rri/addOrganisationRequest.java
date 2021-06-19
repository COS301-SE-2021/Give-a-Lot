package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class addOrganisationRequest {
    String orgName;
    String orgDescription;
    String orgSector;
    String orgEmail;
    String password;
    String contactPerson;
    String contactNumber;

    addOrganisationRequest(
            @JsonProperty("orgName") String orgName,
            @JsonProperty("orgDescription") String orgDescription,
            @JsonProperty("orgSector") String orgSector,
            @JsonProperty("orgEmail") String orgEmail,
            @JsonProperty("password") String password,
            @JsonProperty("contactPerson") String contactPerson,
            @JsonProperty("contactNumber") String contactNumber) {
        this.orgName = orgName;
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

}
