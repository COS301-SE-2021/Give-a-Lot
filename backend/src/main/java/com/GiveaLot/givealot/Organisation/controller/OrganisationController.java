package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.json.OrganisationResponseJSON;
import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.getOrganisationResponse;
import com.GiveaLot.givealot.Organisation.json.get_OrganisationResponseJSON;
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
    public OrganisationController(OrganisationServiceImpl OrganisationServiceImpl)
    {
        this.OrganisationServiceImpl = OrganisationServiceImpl;
    }

    public OrganisationController() {
        this.OrganisationServiceImpl = new OrganisationServiceImpl();
    }

    @CrossOrigin
    @PostMapping("/register")
    public List<OrganisationResponseJSON>add_organisation(@RequestBody addOrganisationRequest request)
    {
        try
        {
            addOrganisationResponse addOrganisationResponse;
            addOrganisationResponse = OrganisationServiceImpl.addOrganisation(request);
            System.out.println("got here in organisation " + request.getOrgName());

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

    @CrossOrigin
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

    @CrossOrigin
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

    @CrossOrigin
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

    @CrossOrigin
    @PostMapping("/get")
    List<get_OrganisationResponseJSON>get_organisation (@RequestBody getOrganisationRequest request)
    {
        try
        {
            getOrganisationResponse getOrganisationResponse;
            getOrganisationResponse = OrganisationServiceImpl.getOrganisation(request);

            if(getOrganisationResponse != null)
            {
                System.out.println("hello here");
                return getOrganisationResponse.get_OrganisationResponseJSON();
            }
        }
        catch(Exception e)
        {
            return List.of(new get_OrganisationResponseJSON("404", "not available", null,null,null));
        }
        return List.of(new get_OrganisationResponseJSON("500", "server related... make sure the connection works", null,null,null));
    }
}
