package com.GiveaLot.givealot.Registration.rri;

public class organisationConfirmRegistrationRequest
{
    private String organisationKey;

    public organisationConfirmRegistrationRequest(String organisationKey) {
        this.organisationKey = organisationKey;
    }

    public String getOrganisationKey() {
        return organisationKey;
    }

    public void setOrganisationKey(String organisationKey) {
        this.organisationKey = organisationKey;
    }
}