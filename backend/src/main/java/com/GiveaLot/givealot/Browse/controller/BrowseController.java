package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/browse")
public class BrowseController {

    private BrowseServiceImp service;
    private responseJSON response;
    @Autowired
    BrowseController(BrowseServiceImp browseServiceImp, responseJSON response)
    {
        this.response = response;
        this.service = browseServiceImp;
    }

    @GetMapping("/sectors")
    responseJSON browseOrganisationsBySectors()
    {
        response.setObject(null);

        try
        {
           List<browseOrganisationsBySectorResponse> res = service.browseOrganisationsBySectors();

           if(res != null)
           {
               response.setCode("ok_org_br_200");
               response.setMessage("success");
               response.setObject(res);
           }
        }
        catch (Exception e)
        {
            response.setCode("bad_org_br_500");
            response.setMessage("Exception: browse failed due to " + e);
        }

        return response;
    }
}
