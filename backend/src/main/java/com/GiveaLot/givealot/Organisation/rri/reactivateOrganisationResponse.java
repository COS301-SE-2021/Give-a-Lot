package com.GiveaLot.givealot.Organisation.rri;

import com.GiveaLot.givealot.Organisation.addUserResponseJSON;

import java.util.List;

public class reactivateOrganisationResponse {

    List<addUserResponseJSON> addUserResponseJSON;

    public reactivateOrganisationResponse()
    {}

    public List<addUserResponseJSON> getAddUserResponseJSONS() {
        return addUserResponseJSON;
    }

    public void setAddUserResponseJSON(List<addUserResponseJSON> addUserResponseJSON) {
        this.addUserResponseJSON = addUserResponseJSON;
    }
}
