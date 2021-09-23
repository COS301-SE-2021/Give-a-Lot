package com.GiveaLot.givealot.IntegrationTests;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Report.controller.ReportController;
import com.GiveaLot.givealot.Report.requests.appealReportRequest;
import com.GiveaLot.givealot.Report.requests.createReportRequest;
import com.GiveaLot.givealot.Report.requests.getReportRequest;
import com.GiveaLot.givealot.Report.requests.reportRequest;
import com.GiveaLot.givealot.Report.response.generalReportResponse;
import com.GiveaLot.givealot.Report.service.ReportServiceImpl;
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

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ReportController.class})
@ExtendWith(SpringExtension.class)
class ReportControllerTest {
    @MockBean
    private responseJSON responseJSON;

    @Autowired
    private ReportController reportController;

    @MockBean
    private ReportServiceImpl reportServiceImpl;

    @Test
    void testReportOrganisation() throws Exception {
        when(this.reportServiceImpl.reportOrganisation((reportRequest) any()))
                .thenReturn(new generalReportResponse("Status", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/org/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new reportRequest(123L, 123L, "Report Type", "The characteristics of someone or something")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":\"Status\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testReportOrganisationFail() throws Exception {
        when(this.reportServiceImpl.reportOrganisation((reportRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/org/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new reportRequest(123L, 123L, "Report Type", "The characteristics of someone or something")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"rep_org_failed\",\"message\":\"report unsuccessful java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testGetAllReportsFail() throws Exception {
        when(this.reportServiceImpl.getAllReports((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/get/all")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new getReportRequest(123L)));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"rep_get_failed\",\"message\":\"report unsuccessful\",\"object\":null}"));
    }

    @Test
    void testAppealReport() throws Exception {
        when(this.reportServiceImpl.appealReport((Long) any(), (Long) any()))
                .thenReturn(new generalReportResponse("Status", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/appeal/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new appealReportRequest(123L, 123L)));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":\"Status\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAppealReportFail() throws Exception {
        when(this.reportServiceImpl.appealReport((Long) any(), (Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/appeal/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new appealReportRequest(123L, 123L)));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":\"rep_appeal_failed\",\"message\":\"report unsuccessful\"}"));
    }

    @Test
    void testGetAppealedReportsFail() throws Exception {
        when(this.reportServiceImpl.getAppealedReports((Long) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/get/appealed")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new getReportRequest(123L)));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"get_appeal_failed\",\"message\":\"report unsuccessful\",\"object\":null}"));
    }

    @Test
    void testCreateReport() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}

