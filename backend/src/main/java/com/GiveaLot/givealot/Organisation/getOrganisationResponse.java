package com.GiveaLot.givealot.Organisation;

import java.util.List;

public class getOrganisationResponse
{
    List<get_OrganisationResponseJSON> get_OrganisationResponseJSON;


    public getOrganisationResponse() {
        get_OrganisationResponseJSON = null;
    }

    public List<get_OrganisationResponseJSON> get_OrganisationResponseJSON()
    {
        return get_OrganisationResponseJSON;
    }

    public void setGet_OrganisationResponseJSON(List<get_OrganisationResponseJSON> get_OrganisationResponseJSON)
    {
        this.get_OrganisationResponseJSON = get_OrganisationResponseJSON;
    }
}
