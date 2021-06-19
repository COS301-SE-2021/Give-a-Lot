package com.GiveaLot.givealot.Search;
import com.GiveaLot.givealot.Search.exceptions.*;
import com.GiveaLot.givealot.Search.rri.*;

public interface SearchService
{
    searchOrganisationResponse search(searchOrganisationRequest request) throws InvalidInputException, ResultNotFoundException;
}
