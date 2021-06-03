package com.GiveaLot.givealot.Search.rri;

import com.GiveaLot.givealot.User.dataclass.User;

import java.util.List;

public class searchOrganisationResponse {
    private List<User> organisations;

    public searchOrganisationResponse() {
        this.organisations = null;
    }

    public void setOrganisations(List<User> organisations) {
        this.organisations = organisations;
    }

    public List<User> getOrganisations()
    {
        return organisations;
    }
}