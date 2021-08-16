package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseSectorOrganisation;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BrowseServiceImp implements BrowseService{

    @Autowired
    BrowseRepository browseRepository;

    @Override
    public List<Organisations> getRecommendedOrganisations(Long userId)
    {
        return null;
    }

    @Override
    public List<browseOrganisationsBySectorResponse> browseOrganisationsBySectors() throws Exception {

        List<String> sectors = browseRepository.getAllSectors();
        List<browseOrganisationsBySectorResponse> res = new LinkedList<>();

        if(sectors == null)
            throw new Exception("Exception: error retrieving sectors");

        for(String sector : sectors)
        {
            /*
            *  get organisations for the sector
            */
            List<Organisations> tmpOrgs = browseRepository.getOrganisationsBySector(sector);

            if(tmpOrgs != null) {

                List<browseSectorOrganisation> browseSectorOrganisation = new LinkedList<>();

                for (Organisations org : tmpOrgs)
                {
                    browseSectorOrganisation.add(new browseSectorOrganisation(org.getOrgId(), org.getOrgName(),null, null));
                }
                res.add(new browseOrganisationsBySectorResponse(sector, browseSectorOrganisation));
            }/* don't throw an exception if the query failed, query other sectors instead*/
        }
        return res;
    }
}
