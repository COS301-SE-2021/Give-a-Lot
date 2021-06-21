package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.dataclass.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class investigateOrganisationRequest {

    Status status;
    String orgEmail;

    String org_id;
    String admin_id;

    public investigateOrganisationRequest(@JsonProperty("org_id") String org_id, @JsonProperty("admin_id") String admin_id)
    {
        this.org_id = org_id;
        this.admin_id = admin_id;
    }

    investigateOrganisationRequest(Status status,
                                String orgEmail)
    {
        this.status=status;
        this.orgEmail = orgEmail;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public String getOrg_id() {
        return org_id;
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
