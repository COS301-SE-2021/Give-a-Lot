package com.GiveaLot.givealot.Browse.controller;

import com.GiveaLot.givealot.Browse.BrowseServiceImp;
import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.Browse.rri.browseResponseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("browse")
public class BrowseController
{
    private final BrowseServiceImp BrowseServiceImp;

    @Autowired
    public BrowseController(com.GiveaLot.givealot.Browse.BrowseServiceImp browseServiceImp) {
        BrowseServiceImp = browseServiceImp;
    }

    @GetMapping
    public List<browseResponseJSON> search()
    {
        browseRequest browseRequest = null;
        browseResponse browseResponse;
        browseResponse = BrowseServiceImp.browse(browseRequest);
        return browseResponse.getOrganisations();
    }
}
