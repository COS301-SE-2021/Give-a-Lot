package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/sectors/{userId}")
    responseJSON browseOrganisationsRecommended(@PathVariable("userId")  @NonNull Long userId)
    {
        response.setObject(null);
        try
        {
            List<Organisations> res = service.getRecommendedOrganisations(userId);

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
