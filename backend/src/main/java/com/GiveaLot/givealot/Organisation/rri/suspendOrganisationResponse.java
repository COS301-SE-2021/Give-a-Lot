package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.json.OrganisationResponseJSON;

import java.util.List;

public class suspendOrganisationResponse
{
    List<OrganisationResponseJSON> OrganisationResponseJSON;

    public suspendOrganisationResponse()
    {}

    public List<OrganisationResponseJSON> getAddUserResponseJSONS() {
        return OrganisationResponseJSON;
    }

    public void setOrganisationResponseJSON(List<OrganisationResponseJSON> OrganisationResponseJSON) {
        this.OrganisationResponseJSON = OrganisationResponseJSON;
    }
}
