package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.addUserResponseJSON;

import java.util.List;

public class addOrganisationResponse {

    public addOrganisationResponse(){}

    List<addUserResponseJSON> addUserResponseJSON;
    public List<addUserResponseJSON> getAddUserResponseJSON()
    {
        return this.addUserResponseJSON;
    }

    public void setAddUserResponseJSON(List<addUserResponseJSON> addUserResponseJSON) {
        this.addUserResponseJSON = addUserResponseJSON;
    }
}
