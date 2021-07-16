package com.GiveaLot.givealot.Registration.rri;
import com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;

public class organisationGetInfoResponse
{
    tempOrganisation tempOrganisation;

    public organisationGetInfoResponse(tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }

    public com.GiveaLot.givealot.Registration.json.tempOrganisation getTempOrganisation() {
        return tempOrganisation;
    }

    public void setTempOrganisation(com.GiveaLot.givealot.Registration.json.tempOrganisation tempOrganisation) {
        this.tempOrganisation = tempOrganisation;
    }
}
