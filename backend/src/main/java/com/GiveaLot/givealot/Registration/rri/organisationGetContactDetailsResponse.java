package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON;

public class organisationGetContactDetailsResponse
{
    organisationRegistrationResponseJSON organisationRegistrationResponseJSON;

    public organisationGetContactDetailsResponse(com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }

    public organisationRegistrationResponseJSON getOrganisationRegistrationResponseJSON() {
        return organisationRegistrationResponseJSON;
    }

    public void setOrganisationRegistrationResponseJSON(organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }
}
