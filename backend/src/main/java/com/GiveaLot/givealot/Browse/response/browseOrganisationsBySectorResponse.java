package com.GiveaLot.givealot.Browse.response;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "organisations")
public class browseOrganisationsBySectorResponse {

    private String sector;
    private List<browseSectorOrganisation> Organisations;

    public browseOrganisationsBySectorResponse(String sector, List<browseSectorOrganisation> organisations) {
        this.sector = sector;
        Organisations = organisations;
    }


    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<browseSectorOrganisation> getOrganisations() {
        return Organisations;
    }

    public void setOrganisations(List<browseSectorOrganisation> organisations) {
        Organisations = organisations;
    }
}
