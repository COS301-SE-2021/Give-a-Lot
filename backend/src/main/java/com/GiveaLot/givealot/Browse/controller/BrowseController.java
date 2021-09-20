package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseRecommendedResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("v1/browse")
public class BrowseController {

    private final BrowseServiceImp service;
    private responseJSON response;

    @Autowired
    BrowseController(BrowseServiceImp browseServiceImp, responseJSON response)
    {
        this.response = response;
        this.service = browseServiceImp;
    }

    @GetMapping("/sectors")
    ResponseEntity<responseJSON> browseOrganisationsBySectors()
    {
        response.setObject(null);

        try
        {
           List<browseOrganisationsBySectorResponse> res = service.browseOrganisationsBySectors();

           if(res != null)
           {
               response = new responseJSON("ok_org_br_200","success",res);
               return new ResponseEntity<>(response,HttpStatus.OK);
           }
            response = new responseJSON("bad_org_br_500","unsuccessful" ,null);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            response = new responseJSON("bad_org_br_500","Exception: browse failed due to " + e,null);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/sectors/recommendations/{userId}")
    ResponseEntity<responseJSON> browseOrganisationsRecommended(@PathVariable("userId") String userId)
    {
        response.setObject(null);
        try
        {
            for(int i = 0; i < userId.length(); i++)
            {
                if(!Character.isDigit(userId.charAt(i)))
                {
                    if(!userId.equalsIgnoreCase("default"))
                        return new ResponseEntity<>(new responseJSON("bad_org_br_401","this id is not authorized", null),HttpStatus.UNAUTHORIZED);
                    else userId = "-1";
                }
            }

            List<browseRecommendedResponse> res = service.getRecommendedOrganisations(Long.valueOf(userId));

            if(res != null)
            {
                response = new responseJSON("ok_org_br_200","success",res);
                return new ResponseEntity<>(response,HttpStatus.OK);

            }
            response = new responseJSON("bad_org_br_500","unsuccessful",null);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            response = new responseJSON("bad_org_br_500","Exception: browse failed due to " + e,null);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }
}
