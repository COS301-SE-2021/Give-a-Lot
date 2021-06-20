package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getOrganisationRequest
{
    String org_id;

    public getOrganisationRequest( @JsonProperty("org_id") String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }
}
