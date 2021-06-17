package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.rri.*;
import com.GiveaLot.givealot.Organisation.exceptions.*;
import java.util.*;


public class OrganisationServiceImpl {
    enum Status{
        Active,
        UnderInvestigation,
        Suspended
    }
    Status status;

    addOrganisationResponse addOrganisation(addOrganisationRequest request)throws InvalidRequestException
    {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be added because the request object is null");
        }


        return null;
    }

    reactivateOrganisationResponse reactivateOrganisation(reactivateOrganisationRequest request)throws InvalidRequestException{
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }


        return null;
    }

    investigateOrganisationResponse investigateOrganisation(investigateOrganisationRequest request)throws InvalidRequestException{
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }


        return null;
    }

    suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest request) throws InvalidRequestException
    {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }


        return null;
    }


}
