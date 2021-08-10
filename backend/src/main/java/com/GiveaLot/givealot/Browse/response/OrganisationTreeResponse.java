package com.GiveaLot.givealot.Browse.response;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Organisations")
@JsonPropertyOrder({"sector", "OrganisationData"})
public class OrganisationTreeResponse
{
    private String sector;
    private Object OrganisationData;

    public OrganisationTreeResponse(String sector, Object organisationData) {
        this.sector = sector;
        OrganisationData = organisationData;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Object getOrganisationData() {
        return OrganisationData;
    }

    public void setOrganisationData(Object organisationData) {
        OrganisationData = organisationData;
    }
}