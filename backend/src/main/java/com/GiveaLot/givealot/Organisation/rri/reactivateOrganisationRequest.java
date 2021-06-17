package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class reactivateOrganisationRequest {
    enum Status{
        Active,
        UnderInvestigation,
        Suspended
    }
    reactivateOrganisationRequest.Status status;
    String orgEmail;

    reactivateOrganisationRequest(@JsonProperty("status") reactivateOrganisationRequest.Status status,
                               @JsonProperty("email") String orgEmail)
    {
        this.status=status;
        this.orgEmail = orgEmail;
    }

    //getters and setters

    public reactivateOrganisationRequest.Status getStatus() {
        return status;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setStatus(reactivateOrganisationRequest.Status status) {
        this.status = status;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
}
