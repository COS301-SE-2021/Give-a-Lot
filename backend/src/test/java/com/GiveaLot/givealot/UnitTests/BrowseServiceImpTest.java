package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Browse.model.Browse;
import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Browse.repository.BrowseRepository;
import com.GiveaLot.givealot.Browse.response.browseOrganisationsBySectorResponse;
import com.GiveaLot.givealot.Browse.service.BrowseServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.sectorsRepository;
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
class BrowseServiceImpTest {
    @MockBean
    private BlockChainRepository blockChainRepository;

    @MockBean
    private BrowseRecommenderRepository browseRecommenderRepository;

    @MockBean
    private BrowseRepository browseRepository;

    @Autowired
    private BrowseServiceImp browseServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private sectorsRepository sectorsRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testGetRecommendedOrganisations() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        when(this.sectorsRepository.getSectorsDescendingByOrganisations()).thenReturn(new ArrayList<String>());
        when(this.browseRecommenderRepository.getInteractionsbySectorGeneral()).thenReturn(new ArrayList<String>());
        when(this.browseRecommenderRepository.getInteractionsForUser((Long) any())).thenReturn(new ArrayList<Browse>());
        assertTrue(this.browseServiceImp.getRecommendedOrganisations(123L).isEmpty());
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
        verify(this.sectorsRepository).getSectorsDescendingByOrganisations();
        verify(this.browseRecommenderRepository).getInteractionsForUser((Long) any());
        verify(this.browseRecommenderRepository).getInteractionsbySectorGeneral();
    }

    @Test
    void testGetRecommendedOrganisations2() throws Exception {
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());

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
        when(this.sectorsRepository.getSectorsDescendingByOrganisations()).thenReturn(stringList);
        when(this.browseRecommenderRepository.getInteractionsbySectorGeneral()).thenReturn(new ArrayList<String>());
        when(this.browseRecommenderRepository.getInteractionsForUser((Long) any())).thenReturn(new ArrayList<Browse>());
        assertTrue(this.browseServiceImp.getRecommendedOrganisations(123L).isEmpty());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
        verify(this.sectorsRepository).getSectorsDescendingByOrganisations();
        verify(this.browseRecommenderRepository).getInteractionsForUser((Long) any());
        verify(this.browseRecommenderRepository).getInteractionsbySectorGeneral();
    }

    @Test
    void testGetRecommendedOrganisations3() throws Exception {
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

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        when(this.sectorsRepository.getSectorsDescendingByOrganisations()).thenReturn(stringList);
        when(this.browseRecommenderRepository.getInteractionsbySectorGeneral()).thenReturn(new ArrayList<String>());
        when(this.browseRecommenderRepository.getInteractionsForUser((Long) any())).thenReturn(new ArrayList<Browse>());
        assertEquals(1, this.browseServiceImp.getRecommendedOrganisations(123L).size());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.sectorsRepository).getSectorsDescendingByOrganisations();
        verify(this.browseRecommenderRepository).getInteractionsForUser((Long) any());
        verify(this.browseRecommenderRepository).getInteractionsbySectorGeneral();
    }

    @Test
    void testGetRecommendedOrganisations4() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(null);
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

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        Organisations organisations2 = new Organisations();
        organisations2.setOrgId(123L);
        organisations2.setPassword("iloveyou");
        organisations2.setContactNumber("42");
        organisations2.setOrgEmail("jane.doe@example.org");
        organisations2.setStatus("Status");
        organisations2.setOrgSector("Org Sector");
        organisations2.setContactPerson("Contact Person");
        organisations2.setSlogan("Slogan");
        organisations2.setOrgDescription("Org Description");
        organisations2.setOrgName("Org Name");
        organisations2.setDirectory("/tmp");
        organisations2.setDateAdded("2020-03-01");

        Organisations organisations3 = new Organisations();
        organisations3.setOrgId(123L);
        organisations3.setPassword("iloveyou");
        organisations3.setContactNumber("42");
        organisations3.setOrgEmail("jane.doe@example.org");
        organisations3.setStatus("Status");
        organisations3.setOrgSector("Org Sector");
        organisations3.setContactPerson("Contact Person");
        organisations3.setSlogan("Slogan");
        organisations3.setOrgDescription("Org Description");
        organisations3.setOrgName("Org Name");
        organisations3.setDirectory("/tmp");
        organisations3.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations3);
        organisationsList.add(organisations2);
        organisationsList.add(organisations1);
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        when(this.sectorsRepository.getSectorsDescendingByOrganisations()).thenReturn(stringList);
        when(this.browseRecommenderRepository.getInteractionsbySectorGeneral()).thenReturn(new ArrayList<String>());
        when(this.browseRecommenderRepository.getInteractionsForUser((Long) any())).thenReturn(new ArrayList<Browse>());
        assertEquals(3, this.browseServiceImp.getRecommendedOrganisations(123L).size());
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
        verify(this.blockChainRepository, atLeast(1)).selectBlockchainOrgId(anyLong());
        verify(this.sectorsRepository).getSectorsDescendingByOrganisations();
        verify(this.browseRecommenderRepository).getInteractionsForUser((Long) any());
        verify(this.browseRecommenderRepository).getInteractionsbySectorGeneral();
    }

    @Test
    void testBrowseOrganisationsBySectors() throws Exception {
        when(this.browseRepository.getAllSectors()).thenReturn(new ArrayList<String>());
        assertTrue(this.browseServiceImp.browseOrganisationsBySectors().isEmpty());
        verify(this.browseRepository).getAllSectors();
    }

    @Test
    void testBrowseOrganisationsBySectors2() throws Exception {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(new ArrayList<Organisations>());
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);
        assertTrue(this.browseServiceImp.browseOrganisationsBySectors().isEmpty());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
    }

    @Test
    void testBrowseOrganisationsBySectors3() throws Exception {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("foo");

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

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.browseRepository.getOrganisationsBySector((String) any())).thenReturn(organisationsList);
        when(this.browseRepository.getAllSectors()).thenReturn(stringList);

        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);
        List<browseOrganisationsBySectorResponse> actualBrowseOrganisationsBySectorsResult = this.browseServiceImp
                .browseOrganisationsBySectors();
        assertEquals(1, actualBrowseOrganisationsBySectorsResult.size());
        browseOrganisationsBySectorResponse getResult = actualBrowseOrganisationsBySectorsResult.get(0);
        assertEquals(1, getResult.getOrganisations().size());
        assertEquals("foo", getResult.getSector());
        verify(this.browseRepository).getAllSectors();
        verify(this.browseRepository).getOrganisationsBySector((String) any());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
    }
}

