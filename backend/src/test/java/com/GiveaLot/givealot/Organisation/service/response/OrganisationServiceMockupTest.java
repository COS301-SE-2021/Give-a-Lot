package com.GiveaLot.givealot.Organisation.service.response;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrganisationServiceMockup.class})
@ExtendWith(SpringExtension.class)
public class OrganisationServiceMockupTest {
    @MockBean
    private OrganisationService organisationService;

    @Autowired
    private OrganisationServiceMockup organisationServiceMockup;

    @Test
    public void testConstructor() {
        new OrganisationServiceMockup(new OrganisationServiceImp());
    }

    @Test
    public void testSelectOrganisation() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("Contact Number");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("Status");
        organisations.setOrgSector("Org Sector");
        organisations.setContactPerson("Contact Person");
        organisations.setSlogan("Slogan");
        organisations.setOrgDescription("Org Description");
        organisations.setOrgName("Org Name");
        organisations.setDirectory("/tmp");
        when(this.organisationService.selectOrganisation(anyLong())).thenReturn(organisations);
        assertSame(organisations, this.organisationServiceMockup.selectOrganisation(123L));
        verify(this.organisationService).selectOrganisation(anyLong());
    }
}

