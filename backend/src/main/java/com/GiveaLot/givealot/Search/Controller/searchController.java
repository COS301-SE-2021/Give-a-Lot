package com.GiveaLot.givealot.Search.Controller;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Search.Service.searchServiceImp;
import com.GiveaLot.givealot.Search.response.searchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("search/")
public class searchController
{
    @Autowired
    searchServiceImp service;

    @GetMapping("/organisation/browse/{q}")
    public ResponseEntity<searchResponse> searchOrganisations(@PathVariable("q") String query)
    {
        try
        {
            System.out.println("searching for " + query);
            return new ResponseEntity<>(service.searchOrganisations(query), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new searchResponse("search_500_BAD","failed",null,null), HttpStatus.BAD_REQUEST);
        }
    }
}