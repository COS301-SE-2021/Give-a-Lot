package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.media.MediaService.MediaServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MediaServiceImp.class})
@ExtendWith(SpringExtension.class)
class MediaServiceImpTest {
    @Autowired
    private MediaServiceImp mediaServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @Test
    void testOrgIdExists() {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertTrue(this.mediaServiceImp.orgIdExists(123L));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testOrgIdExistsFail() {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(false);
        assertFalse(this.mediaServiceImp.orgIdExists(123L));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testGetOrganisationStatus() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("Status");
        organisations.setOrgSector("Org Sector");
        organisations.setContactPerson("Contact Person");
        organisations.setSlogan("Slogan");
        organisations.setOrgDescription("Org Description");
        organisations.setOrgName("Org Name");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertEquals("status", this.mediaServiceImp.getOrganisationStatus(123L));
        verify(this.organisationRepository).existsById((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testGetOrganisationStatusFail() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("Status");
        organisations.setOrgSector("Org Sector");
        organisations.setContactPerson("Contact Person");
        organisations.setSlogan("Slogan");
        organisations.setOrgDescription("Org Description");
        organisations.setOrgName("Org Name");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(false);
        assertNull(this.mediaServiceImp.getOrganisationStatus(123L));
        verify(this.organisationRepository).existsById((Long) any());
    }

}

