package com.GiveaLot.givealot.Search.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class searchOrganisationRequest
{
    private String nameOfOrganisation;

    public searchOrganisationRequest(@JsonProperty("nameOfOrganisation") String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }
}