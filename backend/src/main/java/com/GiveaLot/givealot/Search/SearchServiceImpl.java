package com.GiveaLot.givealot.Search;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.Search.rri.searchOrganisationRequest;
import com.GiveaLot.givealot.Search.rri.searchOrganisationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public searchOrganisationResponse search(searchOrganisationRequest request) throws InvalidInputException, ResultNotFoundException
    {
        String search_value = request.getNameOfOrganisation().toLowerCase(Locale.ROOT);
        if (search_value.length() == 0)
        {
            throw new InvalidInputException("empty search string");
        }
        else if (!search_value.matches("\\A\\p{ASCII}*\\z"))
        {
            throw new InvalidInputException("non-ascii characters");
        }
        else
        {
            try
            {
                searchHelper searchHelper = new searchHelper();
                List<searchResponseJSON> results = searchHelper.get_organisations_by_name(search_value);
                if(results != null)
                {
                    searchOrganisationResponse searchOrganisationResponse = new searchOrganisationResponse();
                    searchOrganisationResponse.setSearchJSONresponse(results);
                    return searchOrganisationResponse;
                }
                else return  null;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }


}

