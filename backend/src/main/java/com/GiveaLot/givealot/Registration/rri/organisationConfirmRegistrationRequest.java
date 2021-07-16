package com.GiveaLot.givealot.Registration.rri;

import com.GiveaLot.givealot.Registration.json.tempOrganisation;

public class organisationConfirmRegistrationRequest
{
    private tempOrganisation tempOrganisation;

    public organisationConfirmRegistrationRequest(tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }

    public tempOrganisation getTempOrganisation() {
        return tempOrganisation;
    }

    public void setOrganisationKey(tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }
}