package com.GiveaLot.givealot.Organisation.controller;


import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationRowMapper;
import com.GiveaLot.givealot.Organisation.requests.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {OrganisationController.class})
@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrganisationControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private OrganisationController organisationController;

    @MockBean
    private OrganisationService organisationService;

    @MockBean
    private responseJSON responseJSON;

    @Autowired
    private MockMvc mockMvc;

    OrganisationRowMapper rowMapper;

    @Test
    public void testConstructor() {

        OrganisationService service = mock(OrganisationService.class);
        new OrganisationController(service, new responseJSON());

    }

    @Test
    @Sql("/test.sql")
    public void selectOrganisationTest() throws Exception {
        ResponseEntity<Organisation> responseEntity = testRestTemplate.getForEntity("/v1/organisation/info/12345",Organisation.class);
        assertEquals("12345", responseEntity.getBody().getOrgId());
    }


    @Test
    public void testAddOrganisation() {
        OrganisationService service = mock(OrganisationService.class);
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(service, responseJSON);
        responseJSON actualAddOrganisationResult = organisationController
                .addOrganisation(new Organisation("Org Name", "Slogan", "Org Description", "Org Sector", "jane.doe@example.org",
                        "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou"));
        assertSame(responseJSON, actualAddOrganisationResult);
        assertEquals("org_add_bad_500", actualAddOrganisationResult.getCode());
        assertNull(actualAddOrganisationResult.getObject());
        assertEquals("unsuccessful", actualAddOrganisationResult.getMessage());
    }

    @Test
    public void testAddOrganisation2() {
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(null, responseJSON);
        responseJSON actualAddOrganisationResult = organisationController
                .addOrganisation(new Organisation("Org Name", "Slogan", "Org Description", "Org Sector", "jane.doe@example.org",
                        "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou"));
        assertSame(responseJSON, actualAddOrganisationResult);
        assertEquals("org_add_err_501", actualAddOrganisationResult.getCode());
        assertNull(actualAddOrganisationResult.getObject());
        assertEquals("unsuccessful null", actualAddOrganisationResult.getMessage());
    }

    @Test
    public void testAddOrgWebsite() {
        OrganisationService service = mock(OrganisationService.class);
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(service, responseJSON);
        responseJSON actualAddOrgWebsiteResult = organisationController
                .addOrgWebsite(new AddOrgWebsiteRequest("42", "Website"));
        assertSame(responseJSON, actualAddOrgWebsiteResult);
        assertEquals("add_bad_201", actualAddOrgWebsiteResult.getCode());
        assertNull(actualAddOrgWebsiteResult.getObject());
        assertEquals("unsuccessful", actualAddOrgWebsiteResult.getMessage());
    }

    @Test
    public void testAddOrgWebsite2() {
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(null, responseJSON);
        responseJSON actualAddOrgWebsiteResult = organisationController
                .addOrgWebsite(new AddOrgWebsiteRequest("42", "Website"));
        assertSame(responseJSON, actualAddOrgWebsiteResult);
        assertEquals("add_bad_500", actualAddOrgWebsiteResult.getCode());
        assertNull(actualAddOrgWebsiteResult.getObject());
        assertEquals("unsuccessful null", actualAddOrgWebsiteResult.getMessage());
    }

}

