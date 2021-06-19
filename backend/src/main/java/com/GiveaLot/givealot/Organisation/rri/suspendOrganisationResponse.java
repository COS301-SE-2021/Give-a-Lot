package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.addUserResponseJSON;

import java.util.List;

public class suspendOrganisationResponse
{
    List<addUserResponseJSON> addUserResponseJSON;

    public suspendOrganisationResponse()
    {}

    public List<addUserResponseJSON> getAddUserResponseJSONS() {
        return addUserResponseJSON;
    }

    public void setAddUserResponseJSON(List<addUserResponseJSON> addUserResponseJSON) {
        this.addUserResponseJSON = addUserResponseJSON;
    }
}
