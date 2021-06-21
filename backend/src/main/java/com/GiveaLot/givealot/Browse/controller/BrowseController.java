package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.BrowseServiceImp;
import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.Browse.browseResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("browse")
public class BrowseController
{
    private final BrowseServiceImp BrowseServiceImp;

    @Autowired
    public BrowseController(com.GiveaLot.givealot.Browse.BrowseServiceImp browseServiceImp)
    {
        BrowseServiceImp = browseServiceImp;
    }

    @PostMapping
    public List<browseResponseJSON> search()
    {
        browseRequest browseRequest = null;
        browseResponse browseResponse;

        try
        {
            browseResponse = BrowseServiceImp.browse(browseRequest);
            return browseResponse.getOrganisations();
        }
        catch (Exception e)
        {
            /*return a list of null fields*/
            return List.of(new browseResponseJSON(null,null,null,null,null,null,false));
        }
    }
}
