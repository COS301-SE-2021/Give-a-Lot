package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.dataclass.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class reactivateOrganisationRequest {

    Status status;
    String orgEmail;

    reactivateOrganisationRequest(@JsonProperty("status") Status status,
                               @JsonProperty("email") String orgEmail)
    {
        this.status=status;
        this.orgEmail = orgEmail;
    }

    //getters and setters

    public Status getStatus() {
        return status;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }
}
