package com.GiveaLot.givealot.Organisation;
import com.GiveaLot.givealot.Organisation.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Organisation.rri.*;

public interface OrganisationService {
    /**
     * This use case returns a response indicating that the organisation has been suspended
     * @param suspendOrganisationRequest Request to use case
     * @return Return the status of the organisation
     */
    suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest suspendOrganisationRequest)throws InvalidRequestException;
}
