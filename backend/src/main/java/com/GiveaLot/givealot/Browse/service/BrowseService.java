package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseRecommendedResponse;
import com.GiveaLot.givealot.Browse.response.browseSectorOrganisation;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrowseService
{
    /*
    *  recommended based on user previous interactions,searches and default
    *  default -> organisations with more interaction compared to the rest
    * */

    List<browseRecommendedResponse> getRecommendedOrganisations(Long userId) throws Exception;

    List<browseOrganisationsBySectorResponse> browseOrganisationsBySectors() throws Exception;
}
