package com.GiveaLot.givealot.IntegrationTests;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Browse.controller.BrowseController;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseRecommendedResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;

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

@ContextConfiguration(classes = {BrowseController.class})
@ExtendWith(SpringExtension.class)
class BrowseControllerTest {
    @Autowired
    private BrowseController browseController;

    @MockBean
    private BrowseServiceImp browseServiceImp;

    @MockBean
    private responseJSON responseJSON;

    @Test
    void testBrowseOrganisationsRecommended() throws Exception {
        doNothing().when(this.responseJSON).setObject((Object) any());
        when(this.browseServiceImp.getRecommendedOrganisations((Long) any()))
                .thenReturn(new ArrayList<browseRecommendedResponse>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/browse/sectors/recommendations/{userId}", "42");
        MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"ok_org_br_200\",\"message\":\"success\",\"object\":[]}"));
    }

    @Test
    void testBrowseOrganisationsRecommendedFail() throws Exception {
        doNothing().when(this.responseJSON).setObject((Object) any());
        when(this.browseServiceImp.getRecommendedOrganisations((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/browse/sectors/recommendations/{userId}", "42");
        MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"bad_org_br_500\",\"message\":\"Exception: browse failed due to java.lang.Exception: An error"
                                        + " occurred\",\"object\":null}"));
    }

    @Test
    void testBrowseOrganisationsBySectors() throws Exception {
        doNothing().when(this.responseJSON).setObject((Object) any());
        when(this.browseServiceImp.browseOrganisationsBySectors())
                .thenReturn(new ArrayList<browseOrganisationsBySectorResponse>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/browse/sectors");
        MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"ok_org_br_200\",\"message\":\"success\",\"object\":[]}"));
    }

    @Test
    void testBrowseOrganisationsBySectorsFail() throws Exception {
        doNothing().when(this.responseJSON).setObject((Object) any());
        when(this.browseServiceImp.browseOrganisationsBySectors()).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/browse/sectors");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"bad_org_br_500\",\"message\":\"Exception: browse failed due to java.lang.Exception: An error"
                                        + " occurred\",\"object\":null}"));
    }
}

