package com.GiveaLot.givealot.Search.controller;
import com.GiveaLot.givealot.Search.SearchService;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.GiveaLot.givealot.Search.rri.*;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("search")
    public List<User> search(@RequestBody String v) throws InvalidInputException, ResultNotFoundException {
        /*
            @Todo catch exceptions
        * */

        searchOrganisationResponse response;
        searchOrganisationRequest request = new searchOrganisationRequest(v);
        response = searchService.search(request);

        return response.getOrganisations();
    }
}