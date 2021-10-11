package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseRecommendedResponse;
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
    BlockChainRepository blockChainRepository;

    @Autowired
    com.GiveaLot.givealot.Organisation.repository.sectorsRepository sectorsRepository;

    @Override
    public List<browseRecommendedResponse> getRecommendedOrganisations(Long userId) throws Exception {
        if(userId == null)
            throw new Exception("Exception: id is null, cannot continue");
        else
        {
            /* if the user is not logged in (default user id) or has not built any interactions yet
            *  pull random organisations
            *  based on what most users interact with
            */
            List<String> orderedSectors = null;

            /* -1 is a default - db can't store negatives as user ID, this
            *   represents a user who has not signed in */
            if(userRepository.findUserById(userId) == null && userId == -1) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorGeneral();
            }
            /*
            * new user, has not interactions record yet, suggest for them using the default strategy
            */
            else if(userRepository.findUserById(userId) != null && browseRecommenderRepository.getInteractionsForUser(userId).size() == 0) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorGeneral();
            }
            /*
            * this user does not exist
            * */
            else if(userRepository.findUserById(userId) != null && browseRecommenderRepository.getInteractionsForUser(userId).size() > 0) {
                orderedSectors = browseRecommenderRepository.getInteractionsbySectorUser(userId);
            }
            else throw new Exception("Exception: user not registered");

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
                List<browseRecommendedResponse> response = new LinkedList<>();

                for (String sector : sectors)
                {
                    List<Organisations> organisations_by_sector_tmp = browseRepository.getOrganisationsBySector(sector);
                    if (organisations_by_sector_tmp == null) /* move on to the next sector*/
                        continue;

                    for (int index = 0; index < organisations_by_sector_tmp.size() && index < upper_bound; index++)
                    {
                        long curr_lvl;
                        Blockchain blockchain_get_level = blockChainRepository.selectBlockchainOrgId(organisations_by_sector_tmp.get(index).getOrgId());
                        if(blockchain_get_level != null)
                            curr_lvl = blockchain_get_level.getLevel();
                        else continue;

                        response.add(new browseRecommendedResponse(organisations_by_sector_tmp.get(index).getOrgId(),
                                                                    organisations_by_sector_tmp.get(index).getOrgName(),
                                                                    organisations_by_sector_tmp.get(index).getDateAdded(),
                                                                    null,
                                                                    (int)curr_lvl,
                                                                    organisations_by_sector_tmp.get(index).getOrgDescription(),
                                                                    organisations_by_sector_tmp.get(index).getOrgSector()));
                    }
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
                final int upper_bound = 3;
                List<browseRecommendedResponse> response = new ArrayList<>();
                for (String sector : sectors)
                {
                    List<Organisations> organisations_by_sector_tmp = browseRepository.getOrganisationsBySector(sector);
                    if (organisations_by_sector_tmp == null) /* move on to the next sector*/
                        continue;

                    for (int index = 0; index < organisations_by_sector_tmp.size() && index < upper_bound; index++)
                    {
                        long curr_lvl;
                        Blockchain blockchain_get_level = blockChainRepository.selectBlockchainOrgId(organisations_by_sector_tmp.get(index).getOrgId());
                        if(blockchain_get_level != null)
                            curr_lvl = blockchain_get_level.getLevel();
                        else continue;

                        response.add(new browseRecommendedResponse(organisations_by_sector_tmp.get(index).getOrgId(),
                                organisations_by_sector_tmp.get(index).getOrgName(),
                                organisations_by_sector_tmp.get(index).getDateAdded(),
                                null,
                                (int)curr_lvl,
                                organisations_by_sector_tmp.get(index).getOrgDescription(),
                                organisations_by_sector_tmp.get(index).getOrgSector()));
                    }
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
            System.out.println("1================================" + sector + "================================");
            if(tmpOrgs != null && tmpOrgs.size() > 0) {

                List<browseSectorOrganisation> browseSectorOrganisation = new LinkedList<>();

                for (Organisations org : tmpOrgs)
                {

                    Blockchain blockchain_get_level = blockChainRepository.selectBlockchainOrgId(org.getOrgId());

                    long curr_lvl = -1L;
                    if(blockchain_get_level != null)
                        curr_lvl = blockchain_get_level.getLevel();
                   // else continue; //prevents showing organisations without a known level


                    browseSectorOrganisation.add(new browseSectorOrganisation(org.getOrgId(), org.getOrgName(),org.getDateAdded(), null,(int)curr_lvl,org.getOrgDescription()));
                }
                res.add(new browseOrganisationsBySectorResponse(sector, browseSectorOrganisation));
            }/* don't throw an exception if the query failed, query other sectors instead*/
        }
        return res;
    }
}
