package com.GiveaLot.givealot.IntegrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.controller.OrganisationController;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.ActivateRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgAddressRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgCommitteeRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgDonationInfoRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgEstDateRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgNGORequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.requests.AddSectorRequest;
import com.GiveaLot.givealot.Organisation.requests.AddSocialsRequest;
import com.GiveaLot.givealot.Organisation.requests.GetOrganisationCertificateLevelRequest;
import com.GiveaLot.givealot.Organisation.requests.GetOrganisationsRequest;
import com.GiveaLot.givealot.Organisation.requests.InvestigateRequest;
import com.GiveaLot.givealot.Organisation.requests.SuspendRequest;
import com.GiveaLot.givealot.Organisation.requests.emailExistsRequest;
import com.GiveaLot.givealot.Organisation.requests.getNumOrganisationPerMonthRequest;
import com.GiveaLot.givealot.Organisation.requests.updateOrganisationInfoRequest;
import com.GiveaLot.givealot.Organisation.response.OrganisationResponseObject;
import com.GiveaLot.givealot.Organisation.response.generalOrganisationResponse;
import com.GiveaLot.givealot.Organisation.response.getNumberOfOrganisationsResponse;
import com.GiveaLot.givealot.Organisation.response.getOrgCertLevelResponse;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import com.GiveaLot.givealot.Organisation.response.getSectorsResponse;
import com.GiveaLot.givealot.Organisation.response.numberOfImagesResponse;
import com.GiveaLot.givealot.Organisation.response.organisationPointsResponse;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationInfoResponse;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationResponse;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrganisationController.class})
@ExtendWith(SpringExtension.class)
class OrganisationControllerTest {
    @Autowired
    private OrganisationController organisationController;

    @MockBean
    private OrganisationServiceImp organisationServiceImp;

    @MockBean
    private responseJSON responseJSON;

    @Test
    void testAddOrgDonationInfo() throws Exception {
        when(this.organisationServiceImp.addOrgDonationURL((AddOrgDonationInfoRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/donation/info")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgDonationInfoRequest(123L, "Org Info")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgDonationInfoFail() throws Exception {
        when(this.organisationServiceImp.addOrgDonationURL((AddOrgDonationInfoRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/donation/info")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgDonationInfoRequest(123L, "Org Info")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_don_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgQRCode() throws Exception {
        when(this.organisationServiceImp
                .addOrgDonationQRCode((com.GiveaLot.givealot.Organisation.requests.AddOrgQRCodeRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/qrcode");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgQRCodeFail() throws Exception {
        when(this.organisationServiceImp
                .addOrgDonationQRCode((com.GiveaLot.givealot.Organisation.requests.AddOrgQRCodeRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/qrcode");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_qr_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEmailExists() throws Exception {
        when(this.organisationServiceImp.emailExists((emailExistsRequest) any())).thenReturn(true);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/check/email")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new emailExistsRequest("jane.doe@example.org")));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    @Test
    void testEmailExistsFail() throws Exception {
        when(this.organisationServiceImp.emailExists((emailExistsRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/check/email")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new emailExistsRequest("jane.doe@example.org")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        ResultActions resultActions = actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

/*    @Test
    void testSelectOrganisation() throws Exception {
        when(this.organisationServiceImp.selectOrganisation((Long) any(), (Long) any()))
                .thenReturn(new selectOrganisationResponse("Code", "Not all who wander are lost",
                        new OrganisationResponseObject("Org Name", "Slogan", "Org Description", "Org Sector", 1L,
                                "https://example.org/example", "https://example.org/example", "Istagram URl", 10)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/sel/organisation/{orgId}/{userId}", "42", "42");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"response\":{\"orgName\":\"Org Name\",\"slogan\":"
                                        + "\"Slogan\",\"orgDescription\":\"Org Description\",\"orgSector\":\"Org Sector\",\"certificateLevel\":1,\"facebookUrl"
                                        + "\":\"https://example.org/example\",\"twitterUrl\":\"https://example.org/example\",\"istagramURl\":\"Istagram"
                                        + " URl\",\"numberOfImages\":10}}"));
    }*/

    @Test
    void testSelectOrganisationFail() throws Exception {
        when(this.organisationServiceImp.selectOrganisation((Long) any(), (Long) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/sel/organisation/{orgId}/{userId}", "42", "42");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"sel_org_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"response"
                                        + "\":null}"));
    }

    @Test
    void testSelectOrganisationInfo() throws Exception {
        when(this.organisationServiceImp.selectOrganisationInfo((Long) any()))
                .thenReturn(new selectOrganisationInfoResponse("Code", "Not all who wander are lost", new OrganisationInfo()));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/sel/organisation/info/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"response\":{\"orgId\":null,\"address\":null,"
                                        + "\"numberOfImages\":null,\"numberOfReports\":null,\"website\":null,\"auditorDetails\":null,\"committeeDetails\""
                                        + ":null,\"auditDocument\":null,\"twitter\":null,\"facebook\":null,\"instagram\":null,\"establishmentDate\":null,"
                                        + "\"donationURL\":null,\"ngodate\":null,\"ngonumber\":null}}"));
    }

    @Test
    void testSelectOrganisationInfoFail() throws Exception {
        when(this.organisationServiceImp.selectOrganisationInfo((Long) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/organisation/sel/organisation/info/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"sel_org_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"response"
                                        + "\":null}"));
    }

    @Test
    void testGetOrganisations() throws Exception {
        when(this.organisationServiceImp.getOrganisations((GetOrganisationsRequest) any())).thenReturn(
                new getOrganisationsResponse("Code", "Not all who wander are lost", new ArrayList<Organisations>()));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/get/organisations")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationsRequest(123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"response\":[]}"));
    }

    @Test
    void testGetOrganisationsFail() throws Exception {
        when(this.organisationServiceImp.getOrganisations((GetOrganisationsRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/get/organisations")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationsRequest(123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"get_orgs_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"response"
                                        + "\":null}"));
    }

    @Test
    void testAddOrganisation() throws Exception {
        when(this.organisationServiceImp
                .addOrganisation((com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/org");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrganisationFail() throws Exception {
        when(this.organisationServiceImp
                .addOrganisation((com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/org");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"org_add_err_501\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testSuspendOrganisation() throws Exception {
        when(this.organisationServiceImp.suspendOrganisation((SuspendRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/suspend/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new SuspendRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testSuspendOrganisationFail() throws Exception {
        when(this.organisationServiceImp.suspendOrganisation((SuspendRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/suspend/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new SuspendRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"org_sus_err_501\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testReactivateOrganisation() throws Exception {
        when(this.organisationServiceImp.reactivateOrganisation((ActivateRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/activate/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ActivateRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testReactivateOrganisationFail() throws Exception {
        when(this.organisationServiceImp.reactivateOrganisation((ActivateRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/activate/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ActivateRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"org_rea_err_500\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testInvestigateOrganisation() throws Exception {
        when(this.organisationServiceImp.investigateOrganisation((InvestigateRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/investigate/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new InvestigateRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testInvestigateOrganisationFail() throws Exception {
        when(this.organisationServiceImp.investigateOrganisation((InvestigateRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/v1/organisation/investigate/orgId")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new InvestigateRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"org_inv_err_500\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgWebsite() throws Exception {
        when(this.organisationServiceImp.addOrgWebsite((AddOrgWebsiteRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/website")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgWebsiteRequest(123L, "Website")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgWebsiteFail() throws Exception {
        when(this.organisationServiceImp.addOrgWebsite((AddOrgWebsiteRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/website")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgWebsiteRequest(123L, "Website")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"org_web_err_500\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgWebsite() throws Exception {
        when(this.organisationServiceImp.removeOrgWebsite((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/website/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgWebsiteFail() throws Exception {
        when(this.organisationServiceImp.removeOrgWebsite((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/website/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_web_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgAddress() throws Exception {
        when(this.organisationServiceImp.addOrgAddress((AddOrgAddressRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/address")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgAddressRequest(123L, "42 Main St")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgAddressFail() throws Exception {
        when(this.organisationServiceImp.addOrgAddress((AddOrgAddressRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/address")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgAddressRequest(123L, "42 Main St")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_addr_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgAddress() throws Exception {
        when(this.organisationServiceImp.removeOrgAddress((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/address/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgAddressFail() throws Exception {
        when(this.organisationServiceImp.removeOrgAddress((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/address/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_addr_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgSocials() throws Exception {
        when(this.organisationServiceImp.addOrgSocials((AddSocialsRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/socials")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddSocialsRequest("Type", 123L, "https://example.org/example")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgSocialsFail() throws Exception {
        when(this.organisationServiceImp.addOrgSocials((AddSocialsRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/socials")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddSocialsRequest("Type", 123L, "https://example.org/example")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_soc_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgAuditDoc() throws Exception {
        when(this.organisationServiceImp
                .addOrgAuditDoc((com.GiveaLot.givealot.Organisation.requests.AddOrgAuditInfoRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/audit");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgAuditDocFail() throws Exception {
        when(this.organisationServiceImp
                .addOrgAuditDoc((com.GiveaLot.givealot.Organisation.requests.AddOrgAuditInfoRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/audit");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_audoc_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgAuditDoc() throws Exception {
        when(this.organisationServiceImp.removeOrgAuditDoc((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/audit/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgAuditDocFail() throws Exception {
        when(this.organisationServiceImp.removeOrgAuditDoc((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/audit/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_audoc_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgCommittee() throws Exception {
        when(this.organisationServiceImp.addOrgCommittee((AddOrgCommitteeRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/committee")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgCommitteeRequest(123L, "Committee")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgCommitteeFail() throws Exception {
        when(this.organisationServiceImp.addOrgCommittee((AddOrgCommitteeRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/committee")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgCommitteeRequest(123L, "Committee")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_cmt_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgCommittee() throws Exception {
        when(this.organisationServiceImp.removeOrgCommittee((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/committee/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgCommitteeFail() throws Exception {
        when(this.organisationServiceImp.removeOrgCommittee((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/committee/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_cmt_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgNGODate() throws Exception {
        when(this.organisationServiceImp.addOrgNGODate((AddOrgNGORequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/ngopdate")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgNGODateFail() throws Exception {
        when(this.organisationServiceImp.addOrgNGODate((AddOrgNGORequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/ngopdate")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_ngo_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgNGO() throws Exception {
        when(this.organisationServiceImp.addOrgNGO((AddOrgNGORequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/orgNgo")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgNGOFail() throws Exception {
        when(this.organisationServiceImp.addOrgNGO((AddOrgNGORequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/orgNgo")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_ngo_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgEstDate() throws Exception {
        when(this.organisationServiceImp.addOrgEstDate((AddOrgEstDateRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/estdate")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgEstDateRequest("2020-03-01", 123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgEstDateFail() throws Exception {
        when(this.organisationServiceImp.addOrgEstDate((AddOrgEstDateRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/estdate")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddOrgEstDateRequest("2020-03-01", 123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_est_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgEstDate() throws Exception {
        when(this.organisationServiceImp.removeOrgEstDate((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/estdate/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgEstDateFail() throws Exception {
        when(this.organisationServiceImp.removeOrgEstDate((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/estdate/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_est_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgImage() throws Exception {
        when(this.organisationServiceImp
                .addOrgImage((com.GiveaLot.givealot.Organisation.requests.AddOrgImageMultipartRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/image");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgImageFail() throws Exception {
        when(this.organisationServiceImp
                .addOrgImage((com.GiveaLot.givealot.Organisation.requests.AddOrgImageMultipartRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/image");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_imgs_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgImage() throws Exception {
        when(this.organisationServiceImp.removeOrgImage((Long) any(), anyInt()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgImageFail() throws Exception {
        when(this.organisationServiceImp.removeOrgImage((Long) any(), anyInt()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_img_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddOrgLogo() throws Exception {
        when(this.organisationServiceImp.addOrgLogo((com.GiveaLot.givealot.Organisation.requests.AddOrgLogoRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/logo");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddOrgLogoFail() throws Exception {
        when(this.organisationServiceImp.addOrgLogo((com.GiveaLot.givealot.Organisation.requests.AddOrgLogoRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/organisation/add/logo");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_est_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgLogo() throws Exception {
        when(this.organisationServiceImp.removeOrgLogo((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/organisation/delete/logo/{orgId}",
                123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgLogoFail() throws Exception {
        when(this.organisationServiceImp.removeOrgLogo((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/organisation/delete/logo/{orgId}",
                123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_img_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testNumberOfImages() throws Exception {
        when(this.organisationServiceImp.numberOfImages((Long) any()))
                .thenReturn(new numberOfImagesResponse("Code", "Not all who wander are lost", 10));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/count/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"number_of_images\":10}"));
    }

    @Test
    void testNumberOfImagesFail() throws Exception {
        when(this.organisationServiceImp.numberOfImages((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/images/count/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"num_img_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"number_of_images"
                                        + "\":null}"));
    }

    @Test
    void testSelectOrganisationPoints() throws Exception {
        when(this.organisationServiceImp.selectOrganisationPoints((Long) any()))
                .thenReturn(new organisationPointsResponse("Code", "Not all who wander are lost", new OrganisationPoints(1L)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/organisation/points/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"response\":{\"orgId\":1,\"addressIsValid\":false"
                                        + ",\"websiteIsValid\":false,\"auditIsValid\":false,\"committeeIsValid\":false,\"ngoNoIsValid\":false,"
                                        + "\"ngoDateIsValid\":false,\"twitterIsValid\":false,\"facebookIsValid\":false,\"instagramIsValid\":false,"
                                        + "\"estDateIsValid\":false,\"numberOfImages\":0,\"socialMediaType\":null,\"donationURLIsValid\":false,"
                                        + "\"qrCodeIsValid\":false}}"));
    }

    @Test
    void testSelectOrganisationPointsFail() throws Exception {
        when(this.organisationServiceImp.selectOrganisationPoints((Long) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/organisation/points/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"num_img_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"response"
                                        + "\":null}"));
    }

    @Test
    void testAddSector() throws Exception {
        when(this.organisationServiceImp.addSector((AddSectorRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/sector")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddSectorRequest("Sector", "42")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddSectorFail() throws Exception {
        when(this.organisationServiceImp.addSector((AddSectorRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/add/sector")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new AddSectorRequest("Sector", "42")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_sec_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testGetSectors() throws Exception {
        when(this.organisationServiceImp.getSectors())
                .thenReturn(new getSectorsResponse("Code", "Not all who wander are lost", new ArrayList<String>()));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/organisation/get/sectors");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"sectors\":[]}"));
    }

    @Test
    void testGetSectorsFail() throws Exception {
        when(this.organisationServiceImp.getSectors()).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/organisation/get/sectors");
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"get_sec_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\",\"sectors\":null}"));
    }

    @Test
    void testGetNumberOfOrganisations() throws Exception {
        when(this.organisationServiceImp.getNumberOfOrganisations((GetOrganisationsRequest) any()))
                .thenReturn(new getNumberOfOrganisationsResponse("Code", "Not all who wander are lost", 1));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/v1/organisation/get/num_organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationsRequest(123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"response\":1}"));
    }

    @Test
    void testGetNumberOfOrganisationsFail() throws Exception {
        when(this.organisationServiceImp.getNumberOfOrganisations((GetOrganisationsRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/v1/organisation/get/num_organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationsRequest(123L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"get_num_notifications_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\","
                                        + "\"response\":0}"));
    }

    @Test
    void testUpdateOrganisationInfo() throws Exception {
        when(this.organisationServiceImp.updateOrganisationInfo((updateOrganisationInfoRequest) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/v1/organisation/update/info/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new updateOrganisationInfoRequest(123L, "Type", "42")));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testUpdateOrganisationInfoFail() throws Exception {
        when(this.organisationServiceImp.updateOrganisationInfo((updateOrganisationInfoRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/v1/organisation/update/info/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new updateOrganisationInfoRequest(123L, "Type", "42")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"update_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testGetOrganisationCertLevel() throws Exception {
        when(this.organisationServiceImp.getOrgCertLevel((GetOrganisationCertificateLevelRequest) any()))
                .thenReturn(new getOrgCertLevelResponse("Code", "Not all who wander are lost", 1L));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/get/org_level")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationCertificateLevelRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\",\"level\":1}"));
    }

    @Test
    void testGetOrganisationCertLevelFail() throws Exception {
        when(this.organisationServiceImp.getOrgCertLevel((GetOrganisationCertificateLevelRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/organisation/get/org_level")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetOrganisationCertificateLevelRequest(1L)));
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"get_org_cert_level_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\","
                                        + "\"level\":0}"));
    }

    @Test
    void testRemoveOrgDonationInfo() throws Exception {
        when(this.organisationServiceImp.removeOrgDonationURL((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/donationinfo/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgDonationInfoFail() throws Exception {
        when(this.organisationServiceImp.removeOrgDonationURL((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/donationinfo/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_don_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgNGODate() throws Exception {
        when(this.organisationServiceImp.removeNGDate((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/ngodate/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgNGODateFail() throws Exception {
        when(this.organisationServiceImp.removeNGDate((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/ngodate/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_ngo_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgQRCode() throws Exception {
        when(this.organisationServiceImp.removeOrgDonationQRCode((Long) any()))
                .thenReturn(new generalOrganisationResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/qrcode/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testRemoveOrgQRCodeFail() throws Exception {
        when(this.organisationServiceImp.removeOrgDonationQRCode((Long) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/qrcode/{orgId}", 123L);
        MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rem_img_500_err\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testRemoveOrgSocials() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/v1/organisation/delete/socials/{orgId}/{type}", "Type", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.organisationController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

