package com.GiveaLot.givealot.IntegrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.GiveaLot.givealot.Organisation.controller.OrganisationController;
import com.GiveaLot.givealot.Organisation.requests.AddOrgAddressRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgCommitteeRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgDonationInfoRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgEstDateRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest;
import com.GiveaLot.givealot.Organisation.requests.AddSocialsRequest;
import com.GiveaLot.givealot.Organisation.requests.GetOrganisationsRequest;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrganisationController.class})
@ExtendWith(SpringExtension.class)
public class OrganisationControllerTest {
    @Autowired
    private OrganisationController organisationController;

    @MockBean
    private OrganisationServiceImp organisationServiceImp;

    @MockBean
    private responseJSON responseJSON;

    @Test
    public void testAddOrgAddress() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/address")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgAddressRequest(123L, "42 Main St")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrgAddressVariable() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/v1/organisation/add/address", "variable")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgAddressRequest(123L, "42 Main St")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrgCommittee() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/committee")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgCommitteeRequest(123L, "Committee")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrgDonationInfo() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/donation/info")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgDonationInfoRequest(123L, "Org Info")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrgEstDate() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/estdate")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgEstDateRequest("2020-03-01", 123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrgSocials() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/socials")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddSocialsRequest("Type", 123L, "https://example.org/example")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testAddOrgWebsite() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/website")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgWebsiteRequest(123L, "Website")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddOrganisation() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/org")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrganisationRequest("Org Name", "Slogan", "Org Description",
                        "Org Sector", "jane.doe@example.org", "Contact Person", "Contact Number", "iloveyou")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testConfirmValidity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/v1/organisation/delete/validity/confirm/{orgId}/{adminId}/{type}/{confirm}", "Type", 123L, true, 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

   /* @Test
    public void testAddOrgImage() {
        OrganisationServiceImp service = mock(OrganisationServiceImp.class);
        OrganisationController organisationController = new OrganisationController(service, new responseJSON());
        ResponseEntity<generalOrganisationResponse> actualAddOrgImageResult = organisationController.addOrgImage(
                new AddOrgImageRequest(123L, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertNull(actualAddOrgImageResult.getBody());
        assertEquals("<200 OK OK,[]>", actualAddOrgImageResult.toString());
        assertEquals(HttpStatus.OK, actualAddOrgImageResult.getStatusCode());
        assertTrue(actualAddOrgImageResult.getHeaders().isEmpty());
    }*/


   /* @Test
    public void testGetOrganisations() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/get/organisations")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationsRequest("jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/

    @Test
    public void testGetOrganisationsTemporal() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/get/organisations/temporal");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testInvestigateOrganisation() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/organisation/investigate/{orgId}",
                123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testNumberOfImages() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/count/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReactivateOrganisation() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/organisation/activate/{orgId}",
                123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgAddress() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/address/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testRemoveOrgAuditDoc() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/audit/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testRemoveOrgAuditor() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/auditor/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testRemoveOrgCommittee() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/committee/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgDonationInfo() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/donationinfo/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgEstDate() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/estdate/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgImage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgSocials() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/socials/{orgId}/{type}", "Type", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    public void testRemoveOrgTaxRef() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/taxref/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoveOrgWebsite() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/website/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSelectOrganisation() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/sel/organisation/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSelectOrganisationPoints() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/organisation/points/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSuspendOrganisation() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/organisation/suspend/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

