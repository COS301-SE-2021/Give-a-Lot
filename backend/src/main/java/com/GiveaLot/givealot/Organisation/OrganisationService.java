package com.GiveaLot.givealot.Organisation;


import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationResponse;

public interface OrganisationService {
    /**
     * Generates a new Report .
     * @param request:addOrganisationRequest Object
     * @return addOrganisationResponse object that holds ...
     * @throws OrgException if Report could not be generated for some reason

     */

    addOrganisationResponse addOrganisation(addOrganisationRequest request) throws Exception;
}
