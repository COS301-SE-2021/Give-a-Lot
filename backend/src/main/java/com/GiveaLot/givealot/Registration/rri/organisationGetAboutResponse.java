package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.organisationRegistrationResponseJSON;

public class organisationGetAboutResponse
{
    organisationRegistrationResponseJSON organisationRegistrationResponseJSON;

    public organisationGetAboutResponse(com.GiveaLot.givealot.Registration.organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }

    public organisationRegistrationResponseJSON getOrganisationRegistrationResponseJSON() {
        return organisationRegistrationResponseJSON;
    }

    public void setOrganisationRegistrationResponseJSON(organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }
}
