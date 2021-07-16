package com.GiveaLot.givealot.Registration.rri;

public class organisationGetAboutRequest
{
    private String organisationSlogan;
    private String organisationDescription;
    private String organisationSector;


    public organisationGetAboutRequest(String organisationSlogan, String organisationDescription, String organisationSector) {
        this.organisationSlogan = organisationSlogan;
        this.organisationDescription = organisationDescription;
        this.organisationSector = organisationSector;
    }

    public String getOrganisationSlogan() {
        return organisationSlogan;
    }

    public void setOrganisationSlogan(String organisationSlogan) {
        this.organisationSlogan = organisationSlogan;
    }

    public String getOrganisationDescription() {
        return organisationDescription;
    }

    public void setOrganisationDescription(String organisationDescription) {
        this.organisationDescription = organisationDescription;
    }

    public String getOrganisationSector() {
        return organisationSector;
    }

    public void setOrganisationSector(String organisationSector) {
        this.organisationSector = organisationSector;
    }
}
