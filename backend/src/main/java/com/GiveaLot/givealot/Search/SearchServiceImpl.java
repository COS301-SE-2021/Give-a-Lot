package com.GiveaLot.givealot.Search;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.Search.rri.searchOrganisationRequest;
import com.GiveaLot.givealot.Search.rri.searchOrganisationResponse;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.mockData.mockUsers;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public searchOrganisationResponse search(searchOrganisationRequest request) throws InvalidInputException, ResultNotFoundException {
        String search_value = request.getNameOfOrganisation();
        if (search_value.length() == 0) throw new InvalidInputException("empty search string");
        else if (!search_value.matches("\\A\\p{ASCII}*\\z")) throw new InvalidInputException("non-ascii characters");
        mockUsers mockusers = new mockUsers();
        List<User> results = new LinkedList<>();
        for (User u : mockusers.getUsers())
        {
            if(similarity(u.getNameOfOrganisation().toLowerCase(), search_value.toLowerCase()) > 1)
            {
                results.add(0,u);
            }
            else if(similarity(u.getNameOfOrganisation(), search_value) > 0.2) {
                if (results.size() == 0) {
                    results.add(0, u);
                } else {
                    results.add(1, u);
                }
            }
        }

        searchOrganisationResponse searchOrganisationResponse = new searchOrganisationResponse();
        searchOrganisationResponse.setOrganisations(results);
        return searchOrganisationResponse;
    }

    public static double similarity(String s1, String s2)
    {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length())
        {
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) { return 1.0; /* both strings are zero length */ }

        return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
    }

    public static int editDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                    costs[j] = j;
                else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1))
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0)
                costs[s2.length()] = lastValue;
        }
        return costs[s2.length()];
    }
}

