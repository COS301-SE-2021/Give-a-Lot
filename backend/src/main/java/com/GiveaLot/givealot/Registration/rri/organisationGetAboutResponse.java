package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON;

public class organisationGetAboutResponse
{
    organisationRegistrationResponseJSON organisationRegistrationResponseJSON;

    public organisationGetAboutResponse(com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }

    public organisationRegistrationResponseJSON getOrganisationRegistrationResponseJSON() {
        return organisationRegistrationResponseJSON;
    }

    public void setOrganisationRegistrationResponseJSON(organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }
}
