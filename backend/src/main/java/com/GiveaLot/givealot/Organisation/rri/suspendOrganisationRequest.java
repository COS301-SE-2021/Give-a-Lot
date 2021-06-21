package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.dataclass.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

public class suspendOrganisationRequest {

    Status status;
    String orgEmail;
    String org_id;
    String admin_id;

    public suspendOrganisationRequest(@JsonProperty("org_id") String org_id, @JsonProperty("admin_id") String admin_id)
    {
        this.org_id = org_id;
        this.admin_id = admin_id;
    }

    suspendOrganisationRequest(Status status,
                               String orgEmail)
    {
        this.status=status;
        this.orgEmail = orgEmail;
    }

    //getters and setters

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

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
