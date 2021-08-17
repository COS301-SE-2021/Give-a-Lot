package com.GiveaLot.givealot.Organisation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.junit.jupiter.api.Test;

public class OrganisationControllerTest {
    @Test
    public void testAddOrganisation() {
        OrganisationServiceImp service = new OrganisationServiceImp();
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(service, responseJSON);
        responseJSON actualAddOrganisationResult = organisationController
                .addOrganisation(new AddOrganisationRequest("Org Name", "Slogan", "Org Description", "Org Sector",
                        "jane.doe@example.org", "Contact Person", "Contact Number", "iloveyou"));
        assertSame(responseJSON, actualAddOrganisationResult);
        assertEquals("org_add_err_501", actualAddOrganisationResult.getCode());
        assertNull(actualAddOrganisationResult.getObject());
        assertEquals("unsuccessful null", actualAddOrganisationResult.getMessage());
    }

    @Test
    public void testAddOrganisation2() {
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(null, responseJSON);
        responseJSON actualAddOrganisationResult = organisationController
                .addOrganisation(new AddOrganisationRequest("Org Name", "Slogan", "Org Description", "Org Sector",
                        "jane.doe@example.org", "Contact Person", "Contact Number", "iloveyou"));
        assertSame(responseJSON, actualAddOrganisationResult);
        assertEquals("org_add_err_501", actualAddOrganisationResult.getCode());
        assertNull(actualAddOrganisationResult.getObject());
        assertEquals("unsuccessful null", actualAddOrganisationResult.getMessage());
    }

    @Test
    public void testAddOrganisation3() {
        OrganisationServiceImp service = mock(OrganisationServiceImp.class);
        responseJSON responseJSON = new responseJSON();
        OrganisationController organisationController = new OrganisationController(service, responseJSON);
        responseJSON actualAddOrganisationResult = organisationController
                .addOrganisation(new AddOrganisationRequest("Org Name", "Slogan", "Org Description", "Org Sector",
                        "jane.doe@example.org", "Contact Person", "Contact Number", "iloveyou"));
        assertSame(responseJSON, actualAddOrganisationResult);
        assertNull(actualAddOrganisationResult.getObject());
    }
}

