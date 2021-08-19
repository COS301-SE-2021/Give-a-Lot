package com.GiveaLot.givealot.Report.controller;

import com.GiveaLot.givealot.Report.requests.createReportRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ReportController.class})
@ExtendWith(SpringExtension.class)
public class ReportControllerTest {
    @Autowired
    private ReportController reportController;

    @Test
    public void testCreateReport() throws Exception {
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

    @Test
    public void testCreateReport10() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "?", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport100() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "rep_org_succ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport101() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "Reporter Email")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport102() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "report successful")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport103() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "42")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport104() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 0, null)
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

    @Test
    public void testCreateReport105() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
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

    @Test
    public void testCreateReport106() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "?", null)
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

    @Test
    public void testCreateReport107() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
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

    @Test
    public void testCreateReport108() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", " ", null)
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

    @Test
    public void testCreateReport109() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "dd-MM-yyyy HH:mm:ss", null)
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

    @Test
    public void testCreateReport11() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, null, "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport110() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "[^a-zA-Z0-9]", null)
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

    @Test
    public void testCreateReport111() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 1, null)
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

    @Test
    public void testCreateReport112() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "", null)
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

    @Test
    public void testCreateReport113() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", -1, null)
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

    @Test
    public void testCreateReport114() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "rep_org_succ", null)
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

    @Test
    public void testCreateReport115() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "Uri Vars", null)
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

    @Test
    public void testCreateReport116() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", Integer.MIN_VALUE, null)
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

    @Test
    public void testCreateReport117() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "report successful", null)
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

    @Test
    public void testCreateReport118() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "42", null)
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

    @Test
    public void testCreateReport119() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, 0)
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

    @Test
    public void testCreateReport12() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, " ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport120() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
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

    @Test
    public void testCreateReport121() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, "?")
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

    @Test
    public void testCreateReport122() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
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

    @Test
    public void testCreateReport123() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, " ")
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

    @Test
    public void testCreateReport124() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "dd-MM-yyyy HH:mm:ss")
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

    @Test
    public void testCreateReport125() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "[^a-zA-Z0-9]")
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

    @Test
    public void testCreateReport126() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, 1)
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

    @Test
    public void testCreateReport127() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, "")
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

    @Test
    public void testCreateReport128() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, -1)
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

    @Test
    public void testCreateReport129() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "rep_org_succ")
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

    @Test
    public void testCreateReport13() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "dd-MM-yyyy HH:mm:ss",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport130() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "Uri Vars")
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

    @Test
    public void testCreateReport131() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, Integer.MIN_VALUE)
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

    @Test
    public void testCreateReport132() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "report successful")
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

    @Test
    public void testCreateReport133() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, "42")
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

    @Test
    public void testCreateReport134() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(0L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport135() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport136() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(-1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport137() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MAX_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport138() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MIN_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport139() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "?", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport14() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "[^a-zA-Z0-9]", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport140() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, null, "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport141() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, " ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport142() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "dd-MM-yyyy HH:mm:ss",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport143() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "[^a-zA-Z0-9]", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport144() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport145() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "rep_org_succ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport146() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "report successful",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport147() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "42", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport148() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "?", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport149() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", null, "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport15() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport150() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", " ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport151() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "dd-MM-yyyy HH:mm:ss", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport152() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "[^a-zA-Z0-9]", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport153() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport154() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "rep_org_succ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport155() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "report successful", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport156() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "42", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport157() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "?", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport158() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", null, "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport159() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", " ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport16() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "rep_org_succ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport160() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description",
                        "dd-MM-yyyy HH:mm:ss", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport161() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "[^a-zA-Z0-9]", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport162() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport163() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "rep_org_succ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport164() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "report successful", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport165() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "42", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport166() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "?")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport167() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", null)));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport168() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", " ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport169() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "dd-MM-yyyy HH:mm:ss")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport17() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "report successful",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport170() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "[^a-zA-Z0-9]")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport171() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport172() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "rep_org_succ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport173() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "Reporter Email")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport174() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "report successful")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport175() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "42")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport176() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 0, null, null)
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

    @Test
    public void testCreateReport177() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport178() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "?", null, null)
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

    @Test
    public void testCreateReport179() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport18() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "42", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport180() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", " ", null, null)
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

    @Test
    public void testCreateReport181() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "dd-MM-yyyy HH:mm:ss", null, null)
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

    @Test
    public void testCreateReport182() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "[^a-zA-Z0-9]", null, null)
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

    @Test
    public void testCreateReport183() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 1, null, null)
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

    @Test
    public void testCreateReport184() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "", null, null)
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

    @Test
    public void testCreateReport185() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", -1, null, null)
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

    @Test
    public void testCreateReport186() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "rep_org_succ", null, null)
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

    @Test
    public void testCreateReport187() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "Uri Vars", null, null)
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

    @Test
    public void testCreateReport188() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", Integer.MIN_VALUE, null, null)
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

    @Test
    public void testCreateReport189() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "report successful", null, null)
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

    @Test
    public void testCreateReport19() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "?", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport190() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "42", null, null)
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

    @Test
    public void testCreateReport191() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, 0, null)
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

    @Test
    public void testCreateReport192() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport193() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "?", null)
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

    @Test
    public void testCreateReport194() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport195() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, " ", null)
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

    @Test
    public void testCreateReport196() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "dd-MM-yyyy HH:mm:ss", null)
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

    @Test
    public void testCreateReport197() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "[^a-zA-Z0-9]", null)
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

    @Test
    public void testCreateReport198() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, 1, null)
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

    @Test
    public void testCreateReport199() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "", null)
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

    @Test
    public void testCreateReport2() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
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

    @Test
    public void testCreateReport20() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", null, "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport200() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, -1, null)
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

    @Test
    public void testCreateReport201() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "rep_org_succ", null)
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

    @Test
    public void testCreateReport202() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "Uri Vars", null)
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

    @Test
    public void testCreateReport203() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, Integer.MIN_VALUE, null)
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

    @Test
    public void testCreateReport204() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "report successful", null)
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

    @Test
    public void testCreateReport205() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, "42", null)
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

    @Test
    public void testCreateReport206() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null, 0)
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

    @Test
    public void testCreateReport207() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport208() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "?")
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

    @Test
    public void testCreateReport209() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport21() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", " ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport210() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, " ")
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

    @Test
    public void testCreateReport211() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "dd-MM-yyyy HH:mm:ss")
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

    @Test
    public void testCreateReport212() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "[^a-zA-Z0-9]")
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

    @Test
    public void testCreateReport213() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null, 1)
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

    @Test
    public void testCreateReport214() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "")
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

    @Test
    public void testCreateReport215() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, -1)
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

    @Test
    public void testCreateReport216() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "rep_org_succ")
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

    @Test
    public void testCreateReport217() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "Uri Vars")
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

    @Test
    public void testCreateReport218() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, Integer.MIN_VALUE)
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

    @Test
    public void testCreateReport219() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "report successful")
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

    @Test
    public void testCreateReport22() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "dd-MM-yyyy HH:mm:ss", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport220() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, "42")
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

    @Test
    public void testCreateReport221() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(0L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport222() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport223() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(-1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport224() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MAX_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport225() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MIN_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport226() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "?", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport227() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, null, "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport228() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, " ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport229() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "dd-MM-yyyy HH:mm:ss",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport23() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "[^a-zA-Z0-9]", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport230() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "[^a-zA-Z0-9]", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport231() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport232() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "rep_org_succ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport233() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "report successful",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport234() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "42", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport235() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "?", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport236() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", null, "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport237() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", " ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport238() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "dd-MM-yyyy HH:mm:ss", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport239() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "[^a-zA-Z0-9]", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport24() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport240() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport241() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "rep_org_succ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport242() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "report successful", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport243() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "42", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport244() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "?", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport245() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", null, "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport246() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", " ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport247() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description",
                        "dd-MM-yyyy HH:mm:ss", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport248() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "[^a-zA-Z0-9]", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport249() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport25() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "rep_org_succ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport250() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "rep_org_succ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport251() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "report successful", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport252() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "42", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport253() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "?")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport254() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", null)));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport255() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", " ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport256() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "dd-MM-yyyy HH:mm:ss")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport257() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "[^a-zA-Z0-9]")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport258() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport259() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "rep_org_succ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport26() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "report successful", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport260() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "Reporter Email")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport261() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "report successful")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport262() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "42")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport263() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/report/organisation");
        postResult.content("Not all who wander are lost");
        MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport264() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/report/organisation");
        postResult.content((byte[]) null);
        MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport265() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/report/organisation");
        postResult.principal(new UserPrincipal("principal"));
        MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport266() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/report/organisation");
        postResult.characterEncoding("UTF-8");
        MockHttpServletRequestBuilder contentTypeResult = postResult.contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport27() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "42", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport28() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "?", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport29() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", null, "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport3() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null, null)
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

    @Test
    public void testCreateReport30() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", " ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport31() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description",
                        "dd-MM-yyyy HH:mm:ss", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport32() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "[^a-zA-Z0-9]", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport33() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport34() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "rep_org_succ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport35() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "report successful", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport36() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "42", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport37() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "?")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport38() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", null)));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport39() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", " ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport4() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", null, null, null)
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

    @Test
    public void testCreateReport40() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "dd-MM-yyyy HH:mm:ss")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport41() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "[^a-zA-Z0-9]")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport42() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport43() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "rep_org_succ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport44() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "Reporter Email")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport45() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "report successful")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport46() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "42")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport47() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 0)
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

    @Test
    public void testCreateReport48() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
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

    @Test
    public void testCreateReport49() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "?")
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

    @Test
    public void testCreateReport5() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(0L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport50() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
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

    @Test
    public void testCreateReport51() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", " ")
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

    @Test
    public void testCreateReport52() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "dd-MM-yyyy HH:mm:ss")
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

    @Test
    public void testCreateReport53() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "[^a-zA-Z0-9]")
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

    @Test
    public void testCreateReport54() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", 1)
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

    @Test
    public void testCreateReport55() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "")
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

    @Test
    public void testCreateReport56() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", -1)
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

    @Test
    public void testCreateReport57() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "rep_org_succ")
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

    @Test
    public void testCreateReport58() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "Uri Vars")
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

    @Test
    public void testCreateReport59() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", Integer.MIN_VALUE)
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

    @Test
    public void testCreateReport6() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport60() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders
                .post("/report/organisation", "report successful")
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

    @Test
    public void testCreateReport61() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", "42")
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

    @Test
    public void testCreateReport62() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(0L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport63() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport64() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(-1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport65() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MAX_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport66() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MIN_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport67() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "?", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport68() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, null, "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport69() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, " ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport7() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(-1L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport70() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "dd-MM-yyyy HH:mm:ss",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport71() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "[^a-zA-Z0-9]", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport72() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport73() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "rep_org_succ", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport74() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "report successful",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport75() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "42", "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport76() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "?", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport77() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", null, "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport78() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", " ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport79() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "dd-MM-yyyy HH:mm:ss", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport8() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MAX_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport80() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "[^a-zA-Z0-9]", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport81() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport82() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "rep_org_succ", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport83() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "report successful", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport84() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "42", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport85() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "?", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport86() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", null, "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport87() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", " ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport88() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description",
                        "dd-MM-yyyy HH:mm:ss", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport89() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "[^a-zA-Z0-9]", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport9() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new createReportRequest(Long.MIN_VALUE, "Org Name",
                        "Report Description", "Report Type", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport90() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport91() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "rep_org_succ", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport92() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "report successful", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport93() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "42", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport94() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "?")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport95() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", null)));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport96() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", " ")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport97() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "dd-MM-yyyy HH:mm:ss")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport98() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper.writeValueAsString(
                new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "[^a-zA-Z0-9]")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void testCreateReport99() throws Exception {
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/report/organisation", null)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new createReportRequest(123L, "Org Name", "Report Description", "Report Type", "")));
        MockMvcBuilders.standaloneSetup(this.reportController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}

