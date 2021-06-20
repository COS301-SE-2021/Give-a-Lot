package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.OrganisationResponseJSON;
import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.rri.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisation")
public class OrganisationController
{
    OrganisationServiceImpl OrganisationServiceImpl;

    @Autowired
    OrganisationController(OrganisationServiceImpl OrganisationServiceImpl)
    {
        this.OrganisationServiceImpl = OrganisationServiceImpl;
    }

    @PostMapping("/register")
    List<OrganisationResponseJSON>add_organisation(@RequestBody addOrganisationRequest request)
    {
        try
        {
            addOrganisationResponse addOrganisationResponse;
            addOrganisationResponse = OrganisationServiceImpl.addOrganisation(request);

            if(addOrganisationResponse != null)
                return addOrganisationResponse.getAddUserResponseJSON();
            else
            {
                OrganisationResponseJSON OrganisationResponseJSON = new OrganisationResponseJSON(420,"failed to add");
                return List.of(OrganisationResponseJSON);
            }
        }
        catch(Exception e)
        {
            OrganisationResponseJSON OrganisationResponseJSON = new OrganisationResponseJSON(500,"server error, custom add organisation");
            return List.of(OrganisationResponseJSON);
        }
    }

    @PostMapping("/suspend")
    List<OrganisationResponseJSON>suspend_organisation (@RequestBody suspendOrganisationRequest request)
    {
        try
        {
            suspendOrganisationResponse suspendOrganisationResponse;
            suspendOrganisationResponse = OrganisationServiceImpl.suspendOrganisation(request);

            if(suspendOrganisationResponse == null)
            {
                return List.of(new OrganisationResponseJSON(500,"server error suspend"));
            }
            else
            {
               return suspendOrganisationResponse.getAddUserResponseJSONS();
            }
        }
        catch(Exception e)
        {
            return List.of(new OrganisationResponseJSON(403,e.getMessage()));
        }
    }

    @PostMapping("/activate")
    List<OrganisationResponseJSON>activate_organisation (@RequestBody reactivateOrganisationRequest request)
    {
        try
        {
            reactivateOrganisationResponse reactivateOrganisationResponse;
            reactivateOrganisationResponse = OrganisationServiceImpl.reactivateOrganisation(request);

            if(reactivateOrganisationResponse == null)
            {
                return List.of(new OrganisationResponseJSON(500,"server error activate"));
            }
            else
            {
                return reactivateOrganisationResponse.getAddUserResponseJSONS();
            }
        }
        catch(Exception e)
        {
            return List.of(new OrganisationResponseJSON(403,e.getMessage()));
        }
    }

    @PostMapping("/investigate")
    List<OrganisationResponseJSON>investigate_organisation (@RequestBody investigateOrganisationRequest request)
    {
        try
        {
            investigateOrganisationResponse investigateOrganisationResponse;
            investigateOrganisationResponse = OrganisationServiceImpl.investigateOrganisation(request);

            if(investigateOrganisationResponse == null)
            {
                return List.of(new OrganisationResponseJSON(500,"server error investigate"));
            }
            else
            {
                return investigateOrganisationResponse.getAddUserResponseJSONS();
            }
        }
        catch(Exception e)
        {
            return List.of(new OrganisationResponseJSON(403,e.getMessage()));
        }
    }
}
