package com.GiveaLot.givealot.Search.controller;
import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Search.SearchService;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.Search.searchResponseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.GiveaLot.givealot.Search.rri.*;
import java.util.List;

@RestController
@RequestMapping("search/org/request")
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService)
    {
        this.searchService = searchService;
    }

    @PostMapping("/default")
    public List<searchResponseJSON>  search(@RequestBody searchOrganisationRequest request) throws InvalidInputException, ResultNotFoundException {
        try
        {
            searchOrganisationResponse response;
            response = searchService.search(request);

            for(searchResponseJSON v : response.getSearchResponseJSON())
            {
                System.out.println(v.getOrg_id());
            }

            List<searchResponseJSON> c = response.getSearchResponseJSON();

            return c;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return List.of();
        }
    }
}

