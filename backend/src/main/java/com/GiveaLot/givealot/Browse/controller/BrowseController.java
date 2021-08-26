package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.response.getUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
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
            response = new responseJSON("bad_org_br_500","unsuccess" ,null);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            response = new responseJSON("bad_org_br_500","Exception: browse failed due to " + e,null);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/sectors/{userId}")
    ResponseEntity<responseJSON> browseOrganisationsRecommended(@PathVariable("userId")  @NonNull Long userId)
    {
        response.setObject(null);
        try
        {
            List<Organisations> res = service.getRecommendedOrganisations(userId);

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
