package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationResponse;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceImpl implements OrganisationService{

    @Override
    public addOrganisationResponse addOrganisation(addOrganisationRequest request) throws Exception
    {
        addOrganisationResponse orgRes = null;
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be added because request is null");
        }

        try {

            //Add organisation to database

        }catch (Exception e){
            throw new OrgException("Exception: Problem adding Organisation to database");
        }
        return orgRes;
    }
}
