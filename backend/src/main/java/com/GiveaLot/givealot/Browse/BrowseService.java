package com.GiveaLot.givealot.Browse;
import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.Search.rri.searchOrganisationRequest;
import com.GiveaLot.givealot.Search.rri.searchOrganisationResponse;
import org.springframework.stereotype.Service;

@Service
public interface BrowseService {
    browseResponse search(browseRequest request);
}
