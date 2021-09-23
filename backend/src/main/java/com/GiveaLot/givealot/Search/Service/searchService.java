package com.GiveaLot.givealot.Search.Service;
import com.GiveaLot.givealot.Search.response.searchResponse;

public interface searchService{
    searchResponse searchOrganisations(String search_str) throws Exception;
}
