package com.GiveaLot.givealot.Browse.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;

import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BrowseController.class})
@ExtendWith(SpringExtension.class)
public class BrowseControllerTest {
    @Autowired
    private BrowseController browseController;

    @MockBean
    private BrowseServiceImp browseServiceImp;

    @MockBean
    private responseJSON responseJSON;

    @Test
    public void testBrowseOrganisationsBySectors() throws Exception {
        doNothing().when(this.responseJSON).setObject((Object) any());
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
    public void testBrowseOrganisationsRecommended() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/browse/sectors/{userId}", 123L);
        MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"ok_org_br_200\",\"message\":\"success\",\"object\":[]}"));
    }

    @Test
    public void testBrowseOrganisationsRecommended2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/browse/sectors/{userId}", 123L);
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.browseController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"ok_org_br_200\",\"message\":\"success\",\"object\":[]}"));
    }

    @Test
    public void testConstructor() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: the constructed class does not have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the class.
        //   See https://diff.blue/R002

        BrowseServiceImp browseServiceImp = new BrowseServiceImp();
        new BrowseController(browseServiceImp, new responseJSON());

    }
}

