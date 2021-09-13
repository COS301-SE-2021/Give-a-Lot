package com.GiveaLot.givealot.Search.Service;

import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Search.response.searchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

@Service
public class searchServiceImp implements searchService
{
    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    BrowseRepository browseRepository;

    @Override
    public searchResponse searchOrganisations(String search_str) throws Exception {

        if(search_str == null)
            throw new Exception("query is null");
        else if(search_str.isEmpty())
            return new searchResponse("search_200_ok", "success", List.of(),List.of());

        List<Organisations> results_by_name = organisationRepository.searchOrganisationByName(search_str);
        List<Organisations> results_by_description = organisationRepository.searchOrganisationByDescription(search_str);

        List<Organisations> merge_results = new ArrayList<>();
        merge_results.addAll(results_by_name);
        merge_results.addAll(results_by_description);

        List<Organisations> listWithoutDuplicates = new ArrayList<>(
                new LinkedHashSet<>(merge_results));

        List<Organisations> suggestions = new ArrayList<>();

        if(listWithoutDuplicates.size() > 0)
        {
            for(Organisations org : listWithoutDuplicates)
            {
                List<Organisations> tmp_orgs = browseRepository.getOrganisationsBySector(org.getOrgSector());
                if(tmp_orgs != null)
                {
                    for(int i = 0; i < tmp_orgs.size() && i < 10; i++)
                    {
                        suggestions.add(tmp_orgs.get(i));
                    }
                }
            }
            Collections.shuffle (suggestions);
        }

        return new searchResponse("search_200_OK", "success",listWithoutDuplicates,suggestions);
    }
}
