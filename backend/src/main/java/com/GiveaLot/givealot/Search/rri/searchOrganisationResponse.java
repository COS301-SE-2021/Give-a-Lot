package com.GiveaLot.givealot.Search.rri;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Search.searchResponseJSON;

import java.util.List;

public class searchOrganisationResponse {
    private List<Organisation> organisations;
    private List<searchResponseJSON> searchResponseJSON;

    public searchOrganisationResponse() {
        this.organisations = null;
    }

    public void setOrganisations(List<Organisation> organisations) {
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations()
    {
        return organisations;
    }

    public void setSearchJSONresponse(List<searchResponseJSON> results) {
        this.searchResponseJSON = results;
    }

    public   List<com.GiveaLot.givealot.Search.searchResponseJSON> getSearchResponseJSON() {
        return searchResponseJSON;
    }
}