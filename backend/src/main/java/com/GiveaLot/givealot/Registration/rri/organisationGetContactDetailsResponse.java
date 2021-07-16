package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.json.contactDetailsJSON;
import com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;

public class organisationGetContactDetailsResponse
{
    com.GiveaLot.givealot.Registration.json.tempOrganisation tempOrganisation;

    public organisationGetContactDetailsResponse(tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }

    public com.GiveaLot.givealot.Registration.json.tempOrganisation getTempOrganisation() {
        return tempOrganisation;
    }

    public void setTempOrganisation(com.GiveaLot.givealot.Registration.json.tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }
}
