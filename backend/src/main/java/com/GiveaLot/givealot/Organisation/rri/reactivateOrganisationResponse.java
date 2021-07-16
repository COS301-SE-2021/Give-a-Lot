package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.json.OrganisationResponseJSON;

import java.util.List;

public class reactivateOrganisationResponse {

    List<OrganisationResponseJSON> OrganisationResponseJSON;

    public reactivateOrganisationResponse()
    {}

    public List<OrganisationResponseJSON> getAddUserResponseJSONS() {
        return OrganisationResponseJSON;
    }

    public void setAddUserResponseJSON(List<OrganisationResponseJSON> OrganisationResponseJSON) {
        this.OrganisationResponseJSON = OrganisationResponseJSON;
    }
}
