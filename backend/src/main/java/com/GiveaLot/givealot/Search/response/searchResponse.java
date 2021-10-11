package com.GiveaLot.givealot.Search.response;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "search_results")
public class searchResponse
{
    private final String code;
    private final String message;
    private final List<Organisations> results;
    private final List<Organisations> suggestions;

    public searchResponse(String code, String message, List<Organisations> results, List<Organisations> suggestions) {
        this.code = code;
        this.message = message;
        this.results = results;
        this.suggestions = suggestions;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Organisations> getResults() {
        return results;
    }

    public List<Organisations> getSuggestions() {
        return suggestions;
    }
}
