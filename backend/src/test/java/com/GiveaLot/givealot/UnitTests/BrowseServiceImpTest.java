package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.response.browseSectorOrganisation;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BrowseServiceImp.class})
@ExtendWith(SpringExtension.class)
public class BrowseServiceImpTest {
    @MockBean
    private BrowseRecommenderRepository browseRecommenderRepository;

    @MockBean
    private BrowseRepository browseRepository;

    @Autowired
    private BrowseServiceImp browseServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testGetRecommendedOrganisations() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        when(this.browseRepository.getAllSectors()).thenReturn(new ArrayList<String>());
        assertTrue(this.browseServiceImp.getRecommendedOrganisations(123L).isEmpty());
        verify(this.userRepository).findUserById(anyLong());
        verify(this.browseRepository).getAllSectors();
    }

 /*   @Test
    public void testGetRecommendedOrganisationsAll() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);
        when(this.browseRecommenderRepository.getInteractionsbySector((Long) any(), (String) any())).thenReturn(1);
        assertTrue(this.browseServiceImp.getRecommendedOrganisations(123L).isEmpty());
        verify(this.userRepository).findUserById(anyLong());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.browseRecommenderRepository).getInteractionsbySector((Long) any(), (String) any());
    }*/

/*    @Test
    public void testGetRecommendedOrganisationsSpecific() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");

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

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);
        when(this.browseRecommenderRepository.getInteractionsbySector((Long) any(), (String) any())).thenReturn(1);
        assertEquals(1, this.browseServiceImp.getRecommendedOrganisations(123L).size());
        verify(this.userRepository).findUserById(anyLong());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.browseRecommenderRepository).getInteractionsbySector((Long) any(), (String) any());
    }*/

    @Test
    public void testBrowseOrganisationsBySectors() throws Exception {
        when(this.browseRepository.getAllSectors()).thenReturn(new ArrayList<String>());
        assertTrue(this.browseServiceImp.browseOrganisationsBySectors().isEmpty());
        verify(this.browseRepository).getAllSectors();
    }

    @Test
    public void testBrowseOrganisationsBySectorsAll() throws Exception {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);
        List<browseOrganisationsBySectorResponse> actualBrowseOrganisationsBySectorsResult = this.browseServiceImp
                .browseOrganisationsBySectors();
        assertEquals(1, actualBrowseOrganisationsBySectorsResult.size());
        browseOrganisationsBySectorResponse getResult = actualBrowseOrganisationsBySectorsResult.get(0);
        assertTrue(getResult.getOrganisations().isEmpty());
        assertEquals("foo", getResult.getSector());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
    }

    @Test
    public void testBrowseOrganisationsBySectorsSpecific() throws Exception {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");

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

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);
        List<browseOrganisationsBySectorResponse> actualBrowseOrganisationsBySectorsResult = this.browseServiceImp
                .browseOrganisationsBySectors();
        assertEquals(1, actualBrowseOrganisationsBySectorsResult.size());
        browseOrganisationsBySectorResponse getResult = actualBrowseOrganisationsBySectorsResult.get(0);
        List<browseSectorOrganisation> organisations1 = getResult.getOrganisations();
        assertEquals(1, organisations1.size());
        assertEquals("foo", getResult.getSector());
        browseSectorOrganisation getResult1 = organisations1.get(0);
        assertNull(getResult1.getDateAdded());
        assertEquals("Org Name", getResult1.getOrgName());
        assertEquals(123L, getResult1.getOrgId().longValue());
        assertNull(getResult1.getImgUrl());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
    }
}

