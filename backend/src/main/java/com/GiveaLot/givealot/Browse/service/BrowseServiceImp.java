package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseSectorOrganisation;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class BrowseServiceImp implements BrowseService{

    @Autowired
    BrowseRepository browseRepository;

    @Autowired
    BrowseRecommenderRepository browseRecommenderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Override
    public List<Organisations> getRecommendedOrganisations(Long userId) throws Exception {
        if(userId == null)
            throw new Exception("Exception: id is null, cannot continue");
        else if(userRepository.findUserById(userId) == null)
        {
            /* if the user is not logged in (default user id)
            *  pull random organisations
            *  based on what most users interact with
            */
        }
        else
        {
            /*
            *  get recommended organisations tailored for the current user
            * */
            List<String> tmp_sectors = browseRepository.getAllSectors();
            if(tmp_sectors == null) /* possibly no organisations registered yet*/
            {
                /*no guesses, check
                */
                if(organisationRepository.getAllOrganisations() == null)
                    return null;
                else /* fatal error */
                {
                    throw new Exception("Exception: error fetching sectors");
                }
            }

            List<Integer> tmp_interactions = new LinkedList<>();
            for(String tmp_sector : tmp_sectors)
            {
                Integer interactions = browseRecommenderRepository.getInteractionsbySector(userId,tmp_sector);
                if(interactions != null)
                {
                    System.out.println("debug msg: interactions from " + tmp_sector + " => " + interactions);
                    tmp_interactions.add(interactions);
                }
                else {
                    /*
                    * recovery - remove sector and continue as normal
                    * */
                    tmp_sectors.remove(tmp_sector);
                }
            }

            /*
               sector arr       ["s1","s2","s3",......"s(i)"]
               interactions arr [n1,  n2,  n3,......"n(i)"]
             */

            /*
                sort interactions in descending order
                bubble sort - O(n^2) worst case but should suffice for now
             */
            int i, j;
            Integer tmp_iterations = null;
            String temp_sector = null;

            for(i = 0; i < tmp_interactions.size(); i++)
            {
                for(j = i+1; j < tmp_interactions.size(); j++)
                {
                    if(tmp_interactions.get(j) > tmp_interactions.get(i))
                    {
                        tmp_iterations = tmp_interactions.get(i);
                        temp_sector = tmp_sectors.get(i);

                        tmp_interactions.set(i,tmp_interactions.get(j));
                        tmp_sectors.set(i,tmp_sectors.get(j));

                        tmp_interactions.set(j,tmp_iterations);
                        tmp_sectors.set(j,temp_sector);
                    }
                }
            }

            /*
            *  now pick at-most n organisations from each sector
            */

            // config
            final int upper_bound = 5;

            for(String sector : tmp_sectors)
            {
                List<Organisations> organisations_by_sector_tmp = browseRepository.getOrganisationsBySector(sector);

                for(int index = 0; index < organisations_by_sector_tmp.size() && index < upper_bound; index++)
                {

                }
            }

        }
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
