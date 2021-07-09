package com.GiveaLot.givealot.Registration.rri;

public class organisationGetAboutRequest
{
    private String organisationSlogan;
    private String organisationDescription;
    private String organisationShortDescription;
    private String organisationKey;

    public organisationGetAboutRequest(String organisationSlogan, String organisationDescription, String organisationShortDescription, String organisationKey) {
        this.organisationSlogan = organisationSlogan;
        this.organisationDescription = organisationDescription;
        this.organisationShortDescription = organisationShortDescription;
        this.organisationKey = organisationKey;
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

    public String getOrganisationShortDescription() {
        return organisationShortDescription;
    }

    public void setOrganisationShortDescription(String organisationShortDescription) {
        this.organisationShortDescription = organisationShortDescription;
    }

    public void setOrganisationKey(String organisationKey) {
        this.organisationKey = organisationKey;
    }

    public String getOrganisationKey() {
        return organisationKey;
    }
}
