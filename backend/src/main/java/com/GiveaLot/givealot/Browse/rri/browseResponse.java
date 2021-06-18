package com.GiveaLot.givealot.Browse.rri;

import com.GiveaLot.givealot.User.dataclass.User;

import java.util.List;

public class browseResponse
{
    private List<User> organisations;

    public browseResponse()
    {
        this.organisations = null;
    }
    public List<User> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(List<User> organisations) {
        this.organisations = organisations;
    }
}
