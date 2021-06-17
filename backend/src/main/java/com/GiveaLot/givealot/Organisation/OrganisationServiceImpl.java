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
    suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest suspendOrganisationRequest) throws InvalidRequestException
    {
       if(suspendOrganisationRequest.getOrgEmail() == null)
       {
           throw new InvalidRequestException("Invalid organisation email");
       }


        return null;
    }


}
