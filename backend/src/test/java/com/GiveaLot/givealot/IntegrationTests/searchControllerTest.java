package com.GiveaLot.givealot.IntegrationTests;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Search.Controller.searchController;
import com.GiveaLot.givealot.Search.Service.searchServiceImp;
import com.GiveaLot.givealot.Search.response.searchResponse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {searchController.class})
@ExtendWith(SpringExtension.class)
class searchControllerTest {
    @Autowired
    private searchController searchController;

    @MockBean
    private searchServiceImp searchServiceImp;

    @Test
    void testSearchOrganisations() throws Exception {
        ArrayList<Organisations> results = new ArrayList<Organisations>();
        when(this.searchServiceImp.searchOrganisations((String) any()))
                .thenReturn(new searchResponse("Code", "Not all who wander are lost", results, new ArrayList<Organisations>()));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/search/organisation/browse/{q}", "foo");
        MockMvcBuilders.standaloneSetup(this.searchController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"results\":[],\"suggestions\":[]}"));
    }

    @Test
    void testSearchOrganisationsFail() throws Exception {
        when(this.searchServiceImp.searchOrganisations((String) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/search/organisation/browse/{q}", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.searchController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"search_500_BAD\",\"message\":\"failed\",\"results\":null,\"suggestions\":null}"));
    }
}

