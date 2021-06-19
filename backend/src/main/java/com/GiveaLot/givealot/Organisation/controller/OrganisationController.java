package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.addUserResponseJSON;
import com.GiveaLot.givealot.Organisation.rri.*;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
    List<addUserResponseJSON>add_organisation(@RequestBody addOrganisationRequest request)
    {
        try
        {
            System.out.println(request.getOrgName());
            addOrganisationResponse addOrganisationResponse;
            addOrganisationResponse = OrganisationServiceImpl.addOrganisation(request);

            if(addOrganisationResponse != null)
                return addOrganisationResponse.getAddUserResponseJSON();
            else
            {
                addUserResponseJSON addUserResponseJSON = new addUserResponseJSON(420,"failed to add");
                return List.of(addUserResponseJSON);
            }
        }
        catch(Exception e)
        {
            addUserResponseJSON addUserResponseJSON = new addUserResponseJSON(500,"server error, custom add organisation");
            return List.of(addUserResponseJSON);
        }
    }

    @PostMapping("/suspend")
    List<addUserResponseJSON>suspend_organisation (@RequestBody suspendOrganisationRequest request)
    {
        try
        {
            suspendOrganisationResponse suspendOrganisationResponse;
            suspendOrganisationResponse = OrganisationServiceImpl.suspendOrganisation(request);

            if(suspendOrganisationResponse == null)
            {
                return List.of(new addUserResponseJSON(500,"server error suspend"));
            }
            else
            {
               return suspendOrganisationResponse.getAddUserResponseJSONS();
            }
        }
        catch(Exception e)
        {
            return List.of(new addUserResponseJSON(403,e.getMessage()));
        }
    }

    @PostMapping("/suspend")
    List<addUserResponseJSON>activate_organisation (@RequestBody reactivateOrganisationRequest request)
    {
        try
        {
            reactivateOrganisationResponse reactivateOrganisationResponse;
            reactivateOrganisationResponse = OrganisationServiceImpl.reactivateOrganisation(request);

            if(reactivateOrganisationResponse == null)
            {
                return List.of(new addUserResponseJSON(500,"server error suspend"));
            }
            else
            {
                return reactivateOrganisationResponse.getAddUserResponseJSONS();
            }
        }
        catch(Exception e)
        {
            return List.of(new addUserResponseJSON(403,e.getMessage()));
        }
    }
}
