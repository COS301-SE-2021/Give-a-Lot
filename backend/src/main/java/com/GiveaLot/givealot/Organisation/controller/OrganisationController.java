package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.addUserResponseJSON;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationResponse;
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
            System.out.println("controller test");
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
}
