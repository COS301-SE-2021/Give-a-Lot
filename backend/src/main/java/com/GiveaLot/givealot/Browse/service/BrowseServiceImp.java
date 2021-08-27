package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseSectorOrganisation;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.sectorsRepository;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    com.GiveaLot.givealot.Organisation.repository.sectorsRepository sectorsRepository;

    @Override
    public List<Organisations> getRecommendedOrganisations(Long userId) throws Exception {
        if(userId == null)
            throw new Exception("Exception: id is null, cannot continue");
        else
        {
            /* if the user is not logged in (default user id) or has not built any interactions yet
            *  pull random organisations
            *  based on what most users interact with
            */
            List<String> orderedSectors = null;

            if(userRepository.findUserById(userId) == null || browseRecommenderRepository.getInteractionsForUser(userId).size() == 0) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorGeneral();
            }
            else if(userRepository.findUserById(userId) != null && browseRecommenderRepository.getInteractionsForUser(userId).size() == 0) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorGeneral();
            }
            else if(userRepository.findUserById(userId) != null) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorUser(userId);
            }
            else throw new Exception("Exception: abnormal - consult the backend team");

            final int n = 3;
            if(orderedSectors.size() > 0)
            {
                /*
                 * get top n sectors
                 */
                List<String> sectors = new ArrayList<>();
                for (int idx = 0; idx < n && idx < orderedSectors.size(); idx++) {
                    sectors.add(idx, orderedSectors.get(idx));
                }

                /*
                 *  now pick at-most n organisations from each sector
                 */

                // config
                final int upper_bound = 3;
                List<Organisations> response = new ArrayList<>();
                for (String sector : sectors)
                {
                    List<Organisations> organisations_by_sector_tmp = browseRepository.getOrganisationsBySector(sector);
                    if (organisations_by_sector_tmp == null) /* move on to the next sector*/
                        continue;

                    for (int index = 0; index < organisations_by_sector_tmp.size() && index < upper_bound; index++)
                        response.add(organisations_by_sector_tmp.get(index));
                }

                Collections.shuffle(response);
                return response;
            }
            else
            {
               /*
               *  get top n
               */

                orderedSectors = sectorsRepository.getSectorsDescendingByOrganisations();

               List<String> sectors = new LinkedList<>();
                System.out.println("here now " + orderedSectors.size());

                for (int idx = 0; idx < n && idx < orderedSectors.size(); idx++) {
                    System.out.println(orderedSectors.get(idx));
                    sectors.add(idx, orderedSectors.get(idx));
                }

                /*
                *  now pick at-most n organisations from each sector
                */

                // config
                final int upper_bound = 5;
                List<Organisations> response = new ArrayList<>();
                for (String sector : sectors) {
                    List<Organisations> organisations_by_sector_tmp = browseRepository.getOrganisationsBySector(sector);
                    if (organisations_by_sector_tmp == null) /* move on to the next sector*/
                        continue;

                    for (int index = 0; index < organisations_by_sector_tmp.size() && index < upper_bound; index++)
                        response.add(organisations_by_sector_tmp.get(index));
                }

                Collections.shuffle(response);
                return response;

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
                    browseSectorOrganisation.add(new browseSectorOrganisation(org.getOrgId(), org.getOrgName(),org.getDateAdded(), null,null,org.getOrgDescription()));
                }
                res.add(new browseOrganisationsBySectorResponse(sector, browseSectorOrganisation));
            }/* don't throw an exception if the query failed, query other sectors instead*/
        }
        return res;
    }
}
