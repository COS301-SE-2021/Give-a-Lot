package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.json.OrganisationResponseJSON;

import java.util.List;

public class addOrganisationResponse {

    public addOrganisationResponse(){}

    List<OrganisationResponseJSON> OrganisationResponseJSON;
    public List<OrganisationResponseJSON> getAddUserResponseJSON()
    {
        return this.OrganisationResponseJSON;
    }

    public void setOrganisationResponseJSON(List<OrganisationResponseJSON> OrganisationResponseJSON) {
        this.OrganisationResponseJSON = OrganisationResponseJSON;
    }
}