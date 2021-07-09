package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.organisationRegistrationResponseJSON;

public class organisationGetImageResponse {

    com.GiveaLot.givealot.Registration.organisationRegistrationResponseJSON organisationRegistrationResponseJSON;

    public organisationGetImageResponse(organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }

    public organisationRegistrationResponseJSON getOrganisationRegistrationResponseJSON() {
        return organisationRegistrationResponseJSON;
    }

    public void setOrganisationRegistrationResponseJSON(organisationRegistrationResponseJSON organisationRegistrationResponseJSON) {
        this.organisationRegistrationResponseJSON = organisationRegistrationResponseJSON;
    }
}
