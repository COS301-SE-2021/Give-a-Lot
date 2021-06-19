package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.OrganisationResponseJSON;

import java.util.List;

public class investigateOrganisationResponse
{
    List<OrganisationResponseJSON> OrganisationResponseJSON;

    public investigateOrganisationResponse()
    {}

    public List<OrganisationResponseJSON> getAddUserResponseJSONS()
    {
        return OrganisationResponseJSON;
    }

    public void setOrganisationResponseJSON(List<OrganisationResponseJSON> OrganisationResponseJSON)
    {
        this.OrganisationResponseJSON = OrganisationResponseJSON;
    }
}