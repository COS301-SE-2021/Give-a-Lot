package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Search.Service.searchServiceImp;
import com.GiveaLot.givealot.Search.response.searchResponse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {searchServiceImp.class})
@ExtendWith(SpringExtension.class)
class searchServiceImpTest {
    @MockBean
    private BrowseRepository browseRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @Autowired
    private searchServiceImp searchServiceImp;

    @Test
    void testSearchOrganisations() throws Exception {
        when(this.organisationRepository.searchOrganisationByDescription((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        when(this.organisationRepository.searchOrganisationByName((String) any())).thenReturn(organisationsList);
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        assertEquals(organisationsList, actualSearchOrganisationsResult.getSuggestions());
        assertEquals(organisationsList, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations10() throws Exception {
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        assertThrows(Exception.class, () -> this.searchServiceImp.searchOrganisations(null));
    }

    @Test
    void testSearchOrganisations11() throws Exception {
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("");
        assertEquals("search_200_ok", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertTrue(suggestions.isEmpty());
        assertSame(suggestions, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
    }

    @Test
    void testSearchOrganisations12() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("search_200_OK");
        organisations1.setOrgSector("search_200_OK");
        organisations1.setContactPerson("search_200_OK");
        organisations1.setSlogan("search_200_OK");
        organisations1.setOrgDescription("search_200_OK");
        organisations1.setOrgName("search_200_OK");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        Organisations organisations2 = new Organisations();
        organisations2.setOrgId(123L);
        organisations2.setPassword("iloveyou");
        organisations2.setContactNumber("42");
        organisations2.setOrgEmail("jane.doe@example.org");
        organisations2.setStatus("search_200_OK");
        organisations2.setOrgSector("search_200_OK");
        organisations2.setContactPerson("search_200_OK");
        organisations2.setSlogan("search_200_OK");
        organisations2.setOrgDescription("search_200_OK");
        organisations2.setOrgName("search_200_OK");
        organisations2.setDirectory("/tmp");
        organisations2.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations2);
        organisationsList1.add(organisations1);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertEquals(1, suggestions.size());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository, atLeast(1)).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations2() throws Exception {
        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertTrue(suggestions.isEmpty());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations3() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("search_200_OK");
        organisations1.setOrgSector("search_200_OK");
        organisations1.setContactPerson("search_200_OK");
        organisations1.setSlogan("search_200_OK");
        organisations1.setOrgDescription("search_200_OK");
        organisations1.setOrgName("search_200_OK");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations1);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertEquals(1, suggestions.size());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations4() throws Exception {
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        assertThrows(Exception.class, () -> this.searchServiceImp.searchOrganisations(null));
    }

    @Test
    void testSearchOrganisations5() throws Exception {
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("");
        assertEquals("search_200_ok", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertTrue(suggestions.isEmpty());
        assertSame(suggestions, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
    }

    @Test
    void testSearchOrganisations6() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("search_200_OK");
        organisations1.setOrgSector("search_200_OK");
        organisations1.setContactPerson("search_200_OK");
        organisations1.setSlogan("search_200_OK");
        organisations1.setOrgDescription("search_200_OK");
        organisations1.setOrgName("search_200_OK");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        Organisations organisations2 = new Organisations();
        organisations2.setOrgId(123L);
        organisations2.setPassword("iloveyou");
        organisations2.setContactNumber("42");
        organisations2.setOrgEmail("jane.doe@example.org");
        organisations2.setStatus("search_200_OK");
        organisations2.setOrgSector("search_200_OK");
        organisations2.setContactPerson("search_200_OK");
        organisations2.setSlogan("search_200_OK");
        organisations2.setOrgDescription("search_200_OK");
        organisations2.setOrgName("search_200_OK");
        organisations2.setDirectory("/tmp");
        organisations2.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations2);
        organisationsList1.add(organisations1);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertEquals(1, suggestions.size());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository, atLeast(1)).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations7() throws Exception {
        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        assertEquals(organisationsList, actualSearchOrganisationsResult.getSuggestions());
        assertEquals(organisationsList, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations8() throws Exception {
        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertTrue(suggestions.isEmpty());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }

    @Test
    void testSearchOrganisations9() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("search_200_OK");
        organisations.setOrgSector("search_200_OK");
        organisations.setContactPerson("search_200_OK");
        organisations.setSlogan("search_200_OK");
        organisations.setOrgDescription("search_200_OK");
        organisations.setOrgName("search_200_OK");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("search_200_OK");
        organisations1.setOrgSector("search_200_OK");
        organisations1.setContactPerson("search_200_OK");
        organisations1.setSlogan("search_200_OK");
        organisations1.setOrgDescription("search_200_OK");
        organisations1.setOrgName("search_200_OK");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList1 = new ArrayList<Organisations>();
        organisationsList1.add(organisations1);
        when(this.organisationRepository.searchOrganisationByDescription((String) any())).thenReturn(organisationsList1);
        when(this.organisationRepository.searchOrganisationByName((String) any()))
                .thenReturn(new ArrayList<Organisations>());
        searchResponse actualSearchOrganisationsResult = this.searchServiceImp.searchOrganisations("Search str");
        assertEquals("search_200_OK", actualSearchOrganisationsResult.getCode());
        List<Organisations> suggestions = actualSearchOrganisationsResult.getSuggestions();
        assertEquals(organisationsList, suggestions);
        assertEquals(1, suggestions.size());
        assertEquals(organisationsList1, actualSearchOrganisationsResult.getResults());
        assertEquals("success", actualSearchOrganisationsResult.getMessage());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.organisationRepository).searchOrganisationByDescription((String) any());
        verify(this.organisationRepository).searchOrganisationByName((String) any());
    }
}

