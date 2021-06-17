package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class investigateOrganisationRequest {
    enum Status{
        Active,
        UnderInvestigation,
        Suspended
    }
    investigateOrganisationRequest.Status status;
    String orgEmail;

    investigateOrganisationRequest(@JsonProperty("status") investigateOrganisationRequest.Status status,
                               @JsonProperty("email") String orgEmail)
    {
        this.status=status;
        this.orgEmail = orgEmail;
    }

    //getters and setters

    public investigateOrganisationRequest.Status getStatus() {
        return status;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setStatus(investigateOrganisationRequest.Status status) {
        this.status = status;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
}
