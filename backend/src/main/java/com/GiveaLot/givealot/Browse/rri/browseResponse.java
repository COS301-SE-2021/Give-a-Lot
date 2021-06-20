package com.GiveaLot.givealot.Browse.rri;

import com.GiveaLot.givealot.User.dataclass.User;

import java.util.List;

public class browseResponse
{
    private List<browseResponseJSON> organisations;

    public browseResponse()
    {
        this.organisations = null;
    }
    public List<browseResponseJSON> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(List<browseResponseJSON> organisations)
    {
        this.organisations = organisations;
    }
}
