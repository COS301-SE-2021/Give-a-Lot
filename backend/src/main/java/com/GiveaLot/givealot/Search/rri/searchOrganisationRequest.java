package com.GiveaLot.givealot.Search.rri;

public class searchOrganisationRequest
{
    private String nameOfOrganisation;

    public searchOrganisationRequest(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }
}