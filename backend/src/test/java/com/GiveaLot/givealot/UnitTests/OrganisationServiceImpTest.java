package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Browse.model.Browse;
import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Notification.repository.NotificationRepository;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.model.Sectors;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.organisationPointsRepository;
import com.GiveaLot.givealot.Organisation.repository.sectorsRepository;
import com.GiveaLot.givealot.Organisation.requests.ActivateRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgAddressRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgAuditInfoRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgCommitteeRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgDonationInfoRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgEstDateRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgImageMultipartRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgLogoRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgNGORequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgQRCodeRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrganisationRequest;
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
import com.GiveaLot.givealot.Organisation.response.getNumOrganisationPerMonthResponse;
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
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrganisationServiceImpTest {
    @MockBean
    private BlockChainRepository blockChainRepository;

    @MockBean
    private BrowseRecommenderRepository browseRecommenderRepository;

    @MockBean
    private CertificateRepository certificateRepository;

    @MockBean
    private NotificationRepository notificationRepository;

    @MockBean
    private OrganisationInfoRepository organisationInfoRepository;

    @MockBean
    private organisationPointsRepository organisationPointsRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationServiceImp organisationServiceImp;

    @MockBean
    private sectorsRepository sectorsRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testGetOrganisations() throws Exception {
        when(this.organisationRepository.findAll()).thenReturn(new ArrayList<Organisations>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        getOrganisationsResponse actualOrganisations = this.organisationServiceImp
                .getOrganisations(new GetOrganisationsRequest(123L));
        assertEquals("get_orgs_200_ok", actualOrganisations.getCode());
        assertTrue(actualOrganisations.getResponse().isEmpty());
        assertEquals("success", actualOrganisations.getMessage());
        verify(this.organisationRepository).findAll();
        verify(this.userRepository).findUserById(anyLong());
    }

    @Test
    void testGetOrganisationsFail() throws Exception {
        when(this.organisationRepository.findAll()).thenReturn(new ArrayList<Organisations>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        assertThrows(UserNotAuthorisedException.class,
                () -> this.organisationServiceImp.getOrganisations(new GetOrganisationsRequest(123L)));
        verify(this.userRepository).findUserById(anyLong());
    }

    @Test
    void testSelectOrganisationAdmin() throws Exception {
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
        responseJSON actualSelectOrganisationAdminResult = this.organisationServiceImp.selectOrganisationAdmin(123L);
        assertEquals("sel_org_200_ok", actualSelectOrganisationAdminResult.getCode());
        assertSame(organisations, actualSelectOrganisationAdminResult.getObject());
        assertEquals("success", actualSelectOrganisationAdminResult.getMessage());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testSelectOrganisationAdminFail() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.selectOrganisationAdmin(null));
    }

    @Test
    void testSelectOrganisation() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

        Browse browse = new Browse();
        browse.setInteractions(1);
        browse.setSector("Sector");
        browse.setUserId(123L);
        when(this.browseRecommenderRepository.updateInteractions((Long) any(), anyInt(), (String) any())).thenReturn(1);
        when(this.browseRecommenderRepository.getRowByUserIdAndSector((Long) any(), (String) any())).thenReturn(browse);
        selectOrganisationResponse actualSelectOrganisationResult = this.organisationServiceImp.selectOrganisation(123L,
                123L);
        assertEquals("sel_org_200_ok", actualSelectOrganisationResult.getCode());
        assertEquals("success", actualSelectOrganisationResult.getMessage());
        OrganisationResponseObject response = actualSelectOrganisationResult.getResponse();
        assertEquals("Twitter", response.getTwitterUrl());
        assertEquals("Slogan", response.getSlogan());
        assertEquals("Org Sector", response.getOrgSector());
        assertEquals("Org Name", response.getOrgName());
        assertEquals("Org Description", response.getOrgDescription());
        assertEquals(10, response.getNumberOfImages().intValue());
        assertEquals("Instagram", response.getIstagramURl());
        assertEquals("Facebook", response.getFacebookUrl());
        assertEquals(1L, response.getCertificateLevel().longValue());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationPointsRepository).getNumberOfImages((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.userRepository).findUserById(anyLong());
        verify(this.browseRecommenderRepository).getRowByUserIdAndSector((Long) any(), (String) any());
        verify(this.browseRecommenderRepository).updateInteractions((Long) any(), anyInt(), (String) any());
    }

    @Test
    void testSelectOrganisationInfo() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        selectOrganisationInfoResponse actualSelectOrganisationInfoResult = this.organisationServiceImp
                .selectOrganisationInfo(123L);
        assertEquals("sel_org_200_OK", actualSelectOrganisationInfoResult.getCode());
        assertSame(organisationInfo, actualSelectOrganisationInfoResult.getResponse());
        assertEquals("success", actualSelectOrganisationInfoResult.getMessage());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testSelectOrganisationInfo2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.selectOrganisationInfo(null));
    }

    @Test
    void testAddOrganisation() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrganisation(new AddOrganisationRequest("Org Name", "Slogan",
                        "Org Description", "Org Sector", "jane.doe@example.org", "Contact Person", "42", "iloveyou",
                        new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    void testAddOrganisationFail() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrganisation(new AddOrganisationRequest(null, "Slogan", "Org Description",
                        "Org Sector", "jane.doe@example.org", "Contact Person", "42", "iloveyou",
                        new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))));
    }

    @Test
    void testSuspendOrganisation() throws Exception {
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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(0);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.suspendOrganisation(new SuspendRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }

    @Test
    void testSuspendOrganisationFail() throws Exception {
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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(-1);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.suspendOrganisation(new SuspendRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }

    @Test
    void testReactivateOrganisation() throws Exception {
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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(0);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.reactivateOrganisation(new ActivateRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }

    @Test
    void testReactivateOrganisationFail() throws Exception {
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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(-1);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.reactivateOrganisation(new ActivateRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }


    @Test
    void testInvestigateOrganisation() throws Exception {
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(0);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.investigateOrganisation(new InvestigateRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }

    @Test
    void testInvestigateOrganisationFail() throws Exception {
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        when(this.organisationRepository.updateStatus((Long) any(), (String) any())).thenReturn(10);
        when(this.organisationRepository.selectOrganisationById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.investigateOrganisation(new InvestigateRequest(1L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
        verify(this.organisationRepository).updateStatus((Long) any(), (String) any());
    }

    @Test
    void testAddOrgWebsite() throws Exception {
        when(this.organisationInfoRepository.addOrgWebsite((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgWebsite(new AddOrgWebsiteRequest(123L, "Website")));
        verify(this.organisationInfoRepository).addOrgWebsite((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgWebsiteFail() throws Exception {
        when(this.organisationInfoRepository.addOrgWebsite((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgWebsiteResult = this.organisationServiceImp
                .addOrgWebsite(new AddOrgWebsiteRequest(123L, "Website"));
        assertEquals("add_web_200_ok", actualAddOrgWebsiteResult.getCode());
        assertEquals("success", actualAddOrgWebsiteResult.getMessage());
        verify(this.organisationInfoRepository).addOrgWebsite((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgWebsite() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgWebsite((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgWebsiteResult = this.organisationServiceImp.removeOrgWebsite(123L);
        assertEquals("rem_web_200_ok", actualRemoveOrgWebsiteResult.getCode());
        assertEquals("success", actualRemoveOrgWebsiteResult.getMessage());
        verify(this.organisationInfoRepository).removeOrgWebsite((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgWebsiteFail() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgWebsite((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgWebsite(123L));
        verify(this.organisationInfoRepository).removeOrgWebsite((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgAddress() throws Exception {
        when(this.organisationInfoRepository.addOrgAddress((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgAddress(new AddOrgAddressRequest(123L, "42 Main St")));
        verify(this.organisationInfoRepository).addOrgAddress((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgAddressFail() throws Exception {
        when(this.organisationInfoRepository.addOrgAddress((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgAddressResult = this.organisationServiceImp
                .addOrgAddress(new AddOrgAddressRequest(123L, "42 Main St"));
        assertEquals("add_addr_200_ok", actualAddOrgAddressResult.getCode());
        assertEquals("success", actualAddOrgAddressResult.getMessage());
        verify(this.organisationInfoRepository).addOrgAddress((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgAddress() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgAddress((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgAddressResult = this.organisationServiceImp.removeOrgAddress(123L);
        assertEquals("rem_addr_200_OK", actualRemoveOrgAddressResult.getCode());
        assertEquals("success", actualRemoveOrgAddressResult.getMessage());
        verify(this.organisationInfoRepository).removeOrgAddress((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgAddressFail() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgAddress((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgAddress(123L));
        verify(this.organisationInfoRepository).removeOrgAddress((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgLogo() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgLogo(new AddOrgLogoRequest(null,
                new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))));
    }

    @Test
    void testRemoveOrgLogo() throws Exception {
        assertNull(this.organisationServiceImp.removeOrgLogo(123L));
    }

    @Test
    void testAddOrgSocials() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .addOrgSocials(new AddSocialsRequest("Type", 123L, "https://example.org/example")));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgSocials2() throws Exception {
        when(this.organisationInfoRepository.addTwitter((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .addOrgSocials(new AddSocialsRequest("twitter", 123L, "https://example.org/example")));
        verify(this.organisationInfoRepository).addTwitter((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgSocials3() throws Exception {
        when(this.organisationInfoRepository.addTwitter((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgSocialsResult = this.organisationServiceImp
                .addOrgSocials(new AddSocialsRequest("twitter", 123L, "https://example.org/example"));
        assertEquals("add_soc_200_OK", actualAddOrgSocialsResult.getCode());
        assertEquals("success", actualAddOrgSocialsResult.getMessage());
        verify(this.organisationInfoRepository).addTwitter((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgSocials4() throws Exception {
        when(this.organisationInfoRepository.addTwitter((Long) any(), (String) any())).thenReturn(null);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgSocials(null));
    }

    @Test
    void testRemoveOrgSocials() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgSocials(123L, "Type"));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgSocials2() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgSocials(null, "Type"));
    }

    @Test
    void testRemoveOrgSocials3() throws Exception {
        when(this.organisationInfoRepository.removeTwitter((Long) any())).thenReturn(1);

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
        generalOrganisationResponse actualRemoveOrgSocialsResult = this.organisationServiceImp.removeOrgSocials(123L,
                "twitter");
        assertEquals("rem_soc_200_OK", actualRemoveOrgSocialsResult.getCode());
        assertEquals("success", actualRemoveOrgSocialsResult.getMessage());
        verify(this.organisationInfoRepository).removeTwitter((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgSocials4() throws Exception {
        when(this.organisationInfoRepository.removeTwitter((Long) any())).thenReturn(0);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgSocials(123L, "twitter"));
        verify(this.organisationInfoRepository).removeTwitter((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgAuditDoc() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgAuditDoc(new AddOrgAuditInfoRequest(null,
                new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))));
    }

    @Test
    void testRemoveOrgAuditDoc() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeAuditDoc((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgAuditDocResult = this.organisationServiceImp.removeOrgAuditDoc(123L);
        assertEquals("rem_audoc_200_OK", actualRemoveOrgAuditDocResult.getCode());
        assertEquals("success", actualRemoveOrgAuditDocResult.getMessage());
        verify(this.organisationInfoRepository).removeAuditDoc((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgAuditDoc2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeAuditDoc((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgAuditDoc(123L));
        verify(this.organisationInfoRepository).removeAuditDoc((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgCommittee() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgCommittee(new AddOrgCommitteeRequest(123L, "Committee")));
        verify(this.organisationInfoRepository).addCommittee((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgCommittee2() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgCommitteeResult = this.organisationServiceImp
                .addOrgCommittee(new AddOrgCommitteeRequest(123L, "Committee"));
        assertEquals("add_cmt_200_OK", actualAddOrgCommitteeResult.getCode());
        assertEquals("success", actualAddOrgCommitteeResult.getMessage());
        verify(this.organisationInfoRepository).addCommittee((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgCommittee3() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(null);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgCommittee(null));
    }

    @Test
    void testAddOrgCommittee4() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(null);

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

        AddOrgCommitteeRequest addOrgCommitteeRequest = new AddOrgCommitteeRequest(123L, "Committee");
        addOrgCommitteeRequest.setCommittee(null);
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgCommittee(addOrgCommitteeRequest));
    }

    @Test
    void testAddOrgCommittee5() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgCommittee(new AddOrgCommitteeRequest(null, "Committee")));
    }

    @Test
    void testAddOrgCommittee6() throws Exception {
        when(this.organisationInfoRepository.addCommittee((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgCommittee(new AddOrgCommitteeRequest(123L, "")));
    }

    @Test
    void testRemoveOrgCommittee() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeCommittee((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgCommitteeResult = this.organisationServiceImp.removeOrgCommittee(123L);
        assertEquals("rem_cmt_200_OK", actualRemoveOrgCommitteeResult.getCode());
        assertEquals("success", actualRemoveOrgCommitteeResult.getMessage());
        verify(this.organisationInfoRepository).removeCommittee((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgCommittee2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeCommittee((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgCommittee(123L));
        verify(this.organisationInfoRepository).removeCommittee((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgDonationURL() throws Exception {
        when(this.organisationInfoRepository.addOrgDonationURL((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgDonationURL(new AddOrgDonationInfoRequest(123L, "Org Info")));
        verify(this.organisationInfoRepository).addOrgDonationURL((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgDonationURL2() throws Exception {
        when(this.organisationInfoRepository.addOrgDonationURL((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgDonationURLResult = this.organisationServiceImp
                .addOrgDonationURL(new AddOrgDonationInfoRequest(123L, "Org Info"));
        assertEquals("add_don_200_ok", actualAddOrgDonationURLResult.getCode());
        assertEquals("success", actualAddOrgDonationURLResult.getMessage());
        verify(this.organisationInfoRepository).addOrgDonationURL((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgDonationURL3() throws Exception {
        when(this.organisationInfoRepository.addOrgDonationURL((Long) any(), (String) any())).thenReturn(null);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgDonationURL(null));
    }

    @Test
    void testAddOrgDonationURL4() throws Exception {
        when(this.organisationInfoRepository.addOrgDonationURL((Long) any(), (String) any())).thenReturn(null);

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

        AddOrgDonationInfoRequest addOrgDonationInfoRequest = new AddOrgDonationInfoRequest(123L, "Org Info");
        addOrgDonationInfoRequest.setOrgInfo(null);
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgDonationURL(addOrgDonationInfoRequest));
    }

    @Test
    void testAddOrgDonationURL5() throws Exception {
        when(this.organisationInfoRepository.addOrgDonationURL((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgDonationURL(new AddOrgDonationInfoRequest(123L, "")));
    }

    @Test
    void testRemoveOrgDonationURL() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgDonationURL((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgDonationURLResult = this.organisationServiceImp
                .removeOrgDonationURL(123L);
        assertEquals("rem_don_200_ok", actualRemoveOrgDonationURLResult.getCode());
        assertEquals("success", actualRemoveOrgDonationURLResult.getMessage());
        verify(this.organisationInfoRepository).removeOrgDonationURL((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgDonationURL2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeOrgDonationURL((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgDonationURL(123L));
        verify(this.organisationInfoRepository).removeOrgDonationURL((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgDonationQRCode() throws Exception {
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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgDonationQRCode(new AddOrgQRCodeRequest(null,
                new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"))))));
    }

    @Test
    void testRemoveOrgDonationQRCode() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgDonationQRCode(null));
    }

    @Test
    void testAddOrgNGO() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(10);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGO(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        verify(this.organisationInfoRepository).addNGONumber((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGO2() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(1);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGO(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        verify(this.organisationInfoRepository).addNGONumber((Long) any(), (String) any());
        verify(this.organisationRepository, atLeast(1)).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGO3() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(null);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgNGO(null));
    }

    @Test
    void testAddOrgNGO4() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(10);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGO(new AddOrgNGORequest(123L, null, "2020-03-01")));
    }

    @Test
    void testAddOrgNGO5() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(10);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGO(new AddOrgNGORequest(123L, "", "2020-03-01")));
    }

    @Test
    void testAddOrgNGO6() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(10);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgNGO(new AddOrgNGORequest(123L, "42", null)));
    }

    @Test
    void testRemoveOrgNGO() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeNGONUmber((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertTrue(this.organisationServiceImp.removeOrgNGO(123L));
        verify(this.organisationInfoRepository).removeNGONUmber((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgNGO2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeNGONUmber((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgNGO(123L));
        verify(this.organisationInfoRepository).removeNGONUmber((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGODate() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGODate(new AddOrgNGORequest(123L, "42", "2020-03-01")));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGODate2() throws Exception {
        when(this.organisationInfoRepository.addNGODate((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGODate(new AddOrgNGORequest(123L, "42", "2020/03/01")));
        verify(this.organisationInfoRepository).addNGODate((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGODate3() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(10);
        when(this.organisationInfoRepository.addNGODate((Long) any(), (String) any())).thenReturn(1);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgNGODate(new AddOrgNGORequest(123L, "42", "2020/03/01")));
        verify(this.organisationInfoRepository).addNGODate((Long) any(), (String) any());
        verify(this.organisationInfoRepository).addNGONumber((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGODate4() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationInfoRepository.addNGODate((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgNGODateResult = this.organisationServiceImp
                .addOrgNGODate(new AddOrgNGORequest(123L, "42", "2020/03/01"));
        assertEquals("add_ngo_200_OK", actualAddOrgNGODateResult.getCode());
        assertEquals("success", actualAddOrgNGODateResult.getMessage());
        verify(this.organisationInfoRepository).addNGODate((Long) any(), (String) any());
        verify(this.organisationInfoRepository).addNGONumber((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgNGODate5() throws Exception {
        when(this.organisationInfoRepository.addNGONumber((Long) any(), (String) any())).thenReturn(null);
        when(this.organisationInfoRepository.addNGODate((Long) any(), (String) any())).thenReturn(1);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgNGODate(null));
    }

    @Test
    void testRemoveNGDate() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeNGODate((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveNGDateResult = this.organisationServiceImp.removeNGDate(123L);
        assertEquals("rem_est_200_OK", actualRemoveNGDateResult.getCode());
        assertEquals("success", actualRemoveNGDateResult.getMessage());
        verify(this.organisationInfoRepository).removeNGODate((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveNGDate2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeNGODate((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeNGDate(123L));
        verify(this.organisationInfoRepository).removeNGODate((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgEstDate() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgEstDate(new AddOrgEstDateRequest("2020-03-01", 123L)));
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgEstDate2() throws Exception {
        when(this.organisationInfoRepository.addEstDate((Long) any(), (String) any())).thenReturn(2);

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
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.addOrgEstDate(new AddOrgEstDateRequest("2020/03/01", 123L)));
        verify(this.organisationInfoRepository).addEstDate((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgEstDate3() throws Exception {
        when(this.organisationInfoRepository.addEstDate((Long) any(), (String) any())).thenReturn(1);

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
        generalOrganisationResponse actualAddOrgEstDateResult = this.organisationServiceImp
                .addOrgEstDate(new AddOrgEstDateRequest("2020/03/01", 123L));
        assertEquals("add_est_200_OK", actualAddOrgEstDateResult.getCode());
        assertEquals("success", actualAddOrgEstDateResult.getMessage());
        verify(this.organisationInfoRepository).addEstDate((Long) any(), (String) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgEstDate4() throws Exception {
        when(this.organisationInfoRepository.addEstDate((Long) any(), (String) any())).thenReturn(null);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgEstDate(null));
    }

    @Test
    void testRemoveOrgEstDate() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeEstDate((Long) any())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        generalOrganisationResponse actualRemoveOrgEstDateResult = this.organisationServiceImp.removeOrgEstDate(123L);
        assertEquals("rem_est_200_OK", actualRemoveOrgEstDateResult.getCode());
        assertEquals("success", actualRemoveOrgEstDateResult.getMessage());
        verify(this.organisationInfoRepository).removeEstDate((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testRemoveOrgEstDate2() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.removeEstDate((Long) any())).thenReturn(0);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgEstDate(123L));
        verify(this.organisationInfoRepository).removeEstDate((Long) any());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgImage() throws Exception {
        when(this.organisationPointsRepository.incrementImage((Long) any(), anyInt())).thenReturn(1);
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        generalOrganisationResponse actualAddOrgImageResult = this.organisationServiceImp
                .addOrgImage(new AddOrgImageMultipartRequest(123L, new ArrayList<MultipartFile>()));
        assertEquals("add_img_200_OK", actualAddOrgImageResult.getCode());
        assertEquals("success", actualAddOrgImageResult.getMessage());
        verify(this.organisationPointsRepository).getNumberOfImages((Long) any());
        verify(this.organisationPointsRepository).incrementImage((Long) any(), anyInt());
        verify(this.organisationRepository, atLeast(1)).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgImage2() throws Exception {
        when(this.organisationPointsRepository.incrementImage((Long) any(), anyInt())).thenReturn(0);
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .addOrgImage(new AddOrgImageMultipartRequest(123L, new ArrayList<MultipartFile>())));
        verify(this.organisationPointsRepository).getNumberOfImages((Long) any());
        verify(this.organisationPointsRepository).incrementImage((Long) any(), anyInt());
        verify(this.organisationRepository, atLeast(1)).selectOrganisationById((Long) any());
    }

    @Test
    void testAddOrgImage3() throws Exception {
        when(this.organisationPointsRepository.incrementImage((Long) any(), anyInt())).thenReturn(null);
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrgImage(null));
    }

    @Test
    void testRemoveOrgImage() throws Exception {
        OrganisationInfo organisationInfo = new OrganisationInfo();
        organisationInfo.setOrgId(123L);
        organisationInfo.setNGODate("2020-03-01");
        organisationInfo.setNumberOfReports(10);
        organisationInfo.setEstablishmentDate("2020-03-01");
        organisationInfo.setAddress("42 Main St");
        organisationInfo.setWebsite("Website");
        organisationInfo.setNumberOfImages(10);
        organisationInfo.setAuditorDetails("Auditor Details");
        organisationInfo.setInstagram("Instagram");
        organisationInfo.setDonationURL("https://example.org/example");
        organisationInfo.setTwitter("Twitter");
        organisationInfo.setAuditDocument("Audit Document");
        organisationInfo.setNGONumber("42");
        organisationInfo.setCommitteeDetails("Committee Details");
        organisationInfo.setFacebook("Facebook");
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.removeOrgImage(null, 10));
    }

    @Test
    void testConfirmValidity() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.confirmValidity(123L, 123L, "Type", true));
        verify(this.userRepository).isAdmin(anyLong());
    }

    @Test
    void testConfirmValidity2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.confirmValidity(null, 123L, "Type", true));
    }

    @Test
    void testConfirmValidity3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.confirmValidity(123L, null, "Type", true));
    }

    @Test
    void testConfirmValidity4() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints();
        organisationPoints.setOrgId(123L);
        organisationPoints.setAuditIsValid(true);
        organisationPoints.setCommitteeIsValid(true);
        organisationPoints.setWebsiteIsValid(true);
        organisationPoints.setEstDateIsValid(true);
        organisationPoints.setSocialMediaType("Social Media Type");
        organisationPoints.setNgoNoIsValid(true);
        organisationPoints.setTwitterIsValid(true);
        organisationPoints.setNumberOfImages(10);
        organisationPoints.setNgoDateIsValid(true);
        organisationPoints.setQrCodeIsValid(true);
        organisationPoints.setFacebookIsValid(true);
        organisationPoints.setInstagramIsValid(true);
        organisationPoints.setDonationURLIsValid(true);
        organisationPoints.setAddressIsValid(true);
        when(this.organisationPointsRepository.selectOrganisationPoints(anyLong())).thenReturn(organisationPoints);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.confirmValidity(123L, 123L, "address", true));
        verify(this.organisationPointsRepository).selectOrganisationPoints(anyLong());
        verify(this.userRepository).isAdmin(anyLong());
    }

    @Test
    void testConfirmValidity5() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints();
        organisationPoints.setOrgId(123L);
        organisationPoints.setAuditIsValid(true);
        organisationPoints.setCommitteeIsValid(true);
        organisationPoints.setWebsiteIsValid(true);
        organisationPoints.setEstDateIsValid(true);
        organisationPoints.setSocialMediaType("Social Media Type");
        organisationPoints.setNgoNoIsValid(true);
        organisationPoints.setTwitterIsValid(true);
        organisationPoints.setNumberOfImages(10);
        organisationPoints.setNgoDateIsValid(true);
        organisationPoints.setQrCodeIsValid(true);
        organisationPoints.setFacebookIsValid(true);
        organisationPoints.setInstagramIsValid(true);
        organisationPoints.setDonationURLIsValid(true);
        organisationPoints.setAddressIsValid(false);
        when(this.organisationPointsRepository.Address(anyLong(), anyBoolean())).thenReturn(1);
        when(this.organisationPointsRepository.selectOrganisationPoints(anyLong())).thenReturn(organisationPoints);

        Certificate certificate = new Certificate();
        certificate.setDateCreated("2020-03-01");
        certificate.setAdminRenewal(true);
        certificate.setPoints(1);
        certificate.setOrgId(1L);
        certificate.setDateExpiry("2020-03-01");
        certificate.setOrgRenewal(true);
        when(this.certificateRepository.selectPointsById((Long) any())).thenReturn(certificate);
        when(this.certificateRepository.updatePoints((Long) any(), anyInt())).thenReturn(1);
        when(this.certificateRepository.select_Points_ById((Long) any())).thenReturn(123);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        generalOrganisationResponse actualConfirmValidityResult = this.organisationServiceImp.confirmValidity(123L, 123L,
                "address", true);
        assertEquals("confirm_200_OK", actualConfirmValidityResult.getCode());
        assertEquals("success", actualConfirmValidityResult.getMessage());
        verify(this.organisationPointsRepository).Address(anyLong(), anyBoolean());
        verify(this.organisationPointsRepository).selectOrganisationPoints(anyLong());
        verify(this.certificateRepository).selectPointsById((Long) any());
        verify(this.certificateRepository, atLeast(1)).select_Points_ById((Long) any());
        verify(this.certificateRepository).updatePoints((Long) any(), anyInt());
        verify(this.userRepository).isAdmin(anyLong());
    }

    @Test
    void testConfirmValidity6() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints();
        organisationPoints.setOrgId(123L);
        organisationPoints.setAuditIsValid(true);
        organisationPoints.setCommitteeIsValid(true);
        organisationPoints.setWebsiteIsValid(true);
        organisationPoints.setEstDateIsValid(true);
        organisationPoints.setSocialMediaType("Social Media Type");
        organisationPoints.setNgoNoIsValid(true);
        organisationPoints.setTwitterIsValid(true);
        organisationPoints.setNumberOfImages(10);
        organisationPoints.setNgoDateIsValid(true);
        organisationPoints.setQrCodeIsValid(true);
        organisationPoints.setFacebookIsValid(true);
        organisationPoints.setInstagramIsValid(true);
        organisationPoints.setDonationURLIsValid(true);
        organisationPoints.setAddressIsValid(false);
        when(this.organisationPointsRepository.Address(anyLong(), anyBoolean())).thenReturn(0);
        when(this.organisationPointsRepository.selectOrganisationPoints(anyLong())).thenReturn(organisationPoints);

        Certificate certificate = new Certificate();
        certificate.setDateCreated("2020-03-01");
        certificate.setAdminRenewal(true);
        certificate.setPoints(1);
        certificate.setOrgId(1L);
        certificate.setDateExpiry("2020-03-01");
        certificate.setOrgRenewal(true);
        when(this.certificateRepository.selectPointsById((Long) any())).thenReturn(certificate);
        when(this.certificateRepository.updatePoints((Long) any(), anyInt())).thenReturn(1);
        when(this.certificateRepository.select_Points_ById((Long) any())).thenReturn(123);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.isAdmin(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.confirmValidity(123L, 123L, "address", true));
        verify(this.organisationPointsRepository).Address(anyLong(), anyBoolean());
        verify(this.organisationPointsRepository).selectOrganisationPoints(anyLong());
        verify(this.userRepository).isAdmin(anyLong());
    }

    @Test
    void testSelectOrganisationPoints() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints();
        organisationPoints.setOrgId(123L);
        organisationPoints.setAuditIsValid(true);
        organisationPoints.setCommitteeIsValid(true);
        organisationPoints.setWebsiteIsValid(true);
        organisationPoints.setEstDateIsValid(true);
        organisationPoints.setSocialMediaType("Social Media Type");
        organisationPoints.setNgoNoIsValid(true);
        organisationPoints.setTwitterIsValid(true);
        organisationPoints.setNumberOfImages(10);
        organisationPoints.setNgoDateIsValid(true);
        organisationPoints.setQrCodeIsValid(true);
        organisationPoints.setFacebookIsValid(true);
        organisationPoints.setInstagramIsValid(true);
        organisationPoints.setDonationURLIsValid(true);
        organisationPoints.setAddressIsValid(true);
        when(this.organisationPointsRepository.selectOrganisationPoints(anyLong())).thenReturn(organisationPoints);

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
        organisationPointsResponse actualSelectOrganisationPointsResult = this.organisationServiceImp
                .selectOrganisationPoints(123L);
        assertEquals("sel_pts_200_OK", actualSelectOrganisationPointsResult.getCode());
        assertSame(organisationPoints, actualSelectOrganisationPointsResult.getResponse());
        assertEquals("success", actualSelectOrganisationPointsResult.getMessage());
        verify(this.organisationPointsRepository).selectOrganisationPoints(anyLong());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testSelectOrganisationPoints2() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints();
        organisationPoints.setOrgId(123L);
        organisationPoints.setAuditIsValid(true);
        organisationPoints.setCommitteeIsValid(true);
        organisationPoints.setWebsiteIsValid(true);
        organisationPoints.setEstDateIsValid(true);
        organisationPoints.setSocialMediaType("Social Media Type");
        organisationPoints.setNgoNoIsValid(true);
        organisationPoints.setTwitterIsValid(true);
        organisationPoints.setNumberOfImages(10);
        organisationPoints.setNgoDateIsValid(true);
        organisationPoints.setQrCodeIsValid(true);
        organisationPoints.setFacebookIsValid(true);
        organisationPoints.setInstagramIsValid(true);
        organisationPoints.setDonationURLIsValid(true);
        organisationPoints.setAddressIsValid(true);
        when(this.organisationPointsRepository.selectOrganisationPoints(anyLong())).thenReturn(organisationPoints);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.selectOrganisationPoints(null));
    }

    @Test
    void testNumberOfImages() throws Exception {
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.numberOfImages(123L));
        verify(this.organisationPointsRepository).getNumberOfImages((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testNumberOfImages2() throws Exception {
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(1);

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
        numberOfImagesResponse actualNumberOfImagesResult = this.organisationServiceImp.numberOfImages(123L);
        assertEquals("num_img_200_OK", actualNumberOfImagesResult.getCode());
        assertEquals(1, actualNumberOfImagesResult.getNumber_of_images().intValue());
        assertEquals("success", actualNumberOfImagesResult.getMessage());
        verify(this.organisationPointsRepository).getNumberOfImages((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testNumberOfImages3() throws Exception {
        when(this.organisationPointsRepository.getNumberOfImages((Long) any())).thenReturn(10);

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
        assertThrows(Exception.class, () -> this.organisationServiceImp.numberOfImages(null));
    }

    @Test
    void testAddSector() throws Exception {
        Sectors sectors = new Sectors();
        sectors.setSector("Sector");
        sectors.setOrganisations(1);
        when(this.sectorsRepository.save((Sectors) any())).thenReturn(sectors);
        generalOrganisationResponse actualAddSectorResult = this.organisationServiceImp
                .addSector(new AddSectorRequest("Sector", "42"));
        assertEquals("add_sec_200_OK", actualAddSectorResult.getCode());
        assertEquals("success", actualAddSectorResult.getMessage());
        verify(this.sectorsRepository).save((Sectors) any());
    }

    @Test
    void testAddSector2() throws Exception {
        Sectors sectors = new Sectors();
        sectors.setSector("Sector");
        sectors.setOrganisations(1);
        when(this.sectorsRepository.save((Sectors) any())).thenReturn(sectors);
        assertThrows(Exception.class, () -> this.organisationServiceImp.addSector(new AddSectorRequest(null, "42")));
    }

    @Test
    void testAddSector3() throws Exception {
        Sectors sectors = new Sectors();
        sectors.setSector("Sector");
        sectors.setOrganisations(1);
        when(this.sectorsRepository.save((Sectors) any())).thenReturn(sectors);
        assertThrows(Exception.class, () -> this.organisationServiceImp.addSector(new AddSectorRequest("Sector", null)));
    }

    @Test
    void testAddSector4() throws Exception {
        Sectors sectors = new Sectors();
        sectors.setSector("Sector");
        sectors.setOrganisations(1);
        when(this.sectorsRepository.save((Sectors) any())).thenReturn(sectors);
        assertThrows(Exception.class, () -> this.organisationServiceImp.addSector(null));
    }

    @Test
    void testGetSectors() throws Exception {
        when(this.sectorsRepository.getSectors()).thenReturn(new ArrayList<String>());
        getSectorsResponse actualSectors = this.organisationServiceImp.getSectors();
        assertEquals("get_sec_200_OK", actualSectors.getCode());
        assertTrue(actualSectors.getSectors().isEmpty());
        assertEquals("success", actualSectors.getMessage());
        verify(this.sectorsRepository).getSectors();
    }

    @Test
    void testGetNumberOfOrganisations() throws Exception {
        when(this.organisationRepository.findAll()).thenReturn(new ArrayList<Organisations>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        getNumberOfOrganisationsResponse actualNumberOfOrganisations = this.organisationServiceImp
                .getNumberOfOrganisations(new GetOrganisationsRequest(123L));
        assertEquals("get_num_org_200_OK", actualNumberOfOrganisations.getCode());
        assertEquals(0, actualNumberOfOrganisations.getResponse());
        assertEquals("success", actualNumberOfOrganisations.getMessage());
        verify(this.organisationRepository).findAll();
        verify(this.userRepository).findUserById(anyLong());
    }

    @Test
    void testGetNumberOfOrganisations2() throws Exception {
        when(this.organisationRepository.findAll()).thenReturn(new ArrayList<Organisations>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        assertThrows(UserNotAuthorisedException.class,
                () -> this.organisationServiceImp.getNumberOfOrganisations(new GetOrganisationsRequest(123L)));
        verify(this.userRepository).findUserById(anyLong());
    }

    @Test
    void testGetNumberOfOrganisations3() throws Exception {
        when(this.organisationRepository.findAll()).thenReturn(new ArrayList<Organisations>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(null);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.organisationServiceImp.getNumberOfOrganisations(null));
    }

    @Test
    void testGetOrgCertLevel() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        getOrgCertLevelResponse actualOrgCertLevel = this.organisationServiceImp
                .getOrgCertLevel(new GetOrganisationCertificateLevelRequest(1L));
        assertEquals("get_org_cert_level", actualOrgCertLevel.getCode());
        assertEquals("success", actualOrgCertLevel.getMessage());
        assertEquals(1L, actualOrgCertLevel.getLevel());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testGetOrgCertLevel2() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.getOrgCertLevel(new GetOrganisationCertificateLevelRequest(1L)));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testGetOrgCertLevel3() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        getOrgCertLevelResponse actualOrgCertLevel = this.organisationServiceImp
                .getOrgCertLevel(new GetOrganisationCertificateLevelRequest(5L));
        assertEquals("get_org_cert_level", actualOrgCertLevel.getCode());
        assertEquals("success", actualOrgCertLevel.getMessage());
        assertEquals(1L, actualOrgCertLevel.getLevel());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testGetOrgCertLevel4() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp.getOrgCertLevel(null));
    }

    @Test
    void testGetNumPerMonth() throws Exception {
        when(this.organisationRepository.getAllOrganisations()).thenReturn(new ArrayList<Organisations>());
        responseJSON actualNumPerMonth = this.organisationServiceImp
                .getNumPerMonth(new getNumOrganisationPerMonthRequest("jane.doe@example.org"));
        assertEquals("get_num_orgs_per_month", actualNumPerMonth.getCode());
        Object object = actualNumPerMonth.getObject();
        assertTrue(object instanceof getNumOrganisationPerMonthResponse);
        assertEquals("success", actualNumPerMonth.getMessage());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getApr());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getSept());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getOct());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getNov());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getMay());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getMar());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJun());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJul());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJan());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getFeb());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getDec());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getAug());
        verify(this.organisationRepository).getAllOrganisations();
    }

    @Test
    void testGetNumPerMonth2() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("");
        organisations.setOrgSector("");
        organisations.setContactPerson("");
        organisations.setSlogan("");
        organisations.setOrgDescription("");
        organisations.setOrgName("");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations);
        when(this.organisationRepository.getAllOrganisations()).thenReturn(organisationsList);
        responseJSON actualNumPerMonth = this.organisationServiceImp
                .getNumPerMonth(new getNumOrganisationPerMonthRequest("jane.doe@example.org"));
        assertEquals("get_num_orgs_per_month", actualNumPerMonth.getCode());
        Object object = actualNumPerMonth.getObject();
        assertTrue(object instanceof getNumOrganisationPerMonthResponse);
        assertEquals("success", actualNumPerMonth.getMessage());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getApr());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getSept());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getOct());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getNov());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getMay());
        assertEquals(1L, ((getNumOrganisationPerMonthResponse) object).getMar());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJun());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJul());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJan());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getFeb());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getDec());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getAug());
        verify(this.organisationRepository).getAllOrganisations();
    }

    @Test
    void testGetNumPerMonth3() throws Exception {
        when(this.organisationRepository.getAllOrganisations()).thenReturn(new ArrayList<Organisations>());
        assertThrows(Exception.class, () -> this.organisationServiceImp.getNumPerMonth(null));
    }

    @Test
    void testGetNumPerMonth4() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("iloveyou");
        organisations.setContactNumber("42");
        organisations.setOrgEmail("jane.doe@example.org");
        organisations.setStatus("");
        organisations.setOrgSector("");
        organisations.setContactPerson("");
        organisations.setSlogan("");
        organisations.setOrgDescription("");
        organisations.setOrgName("");
        organisations.setDirectory("/tmp");
        organisations.setDateAdded("Date Added");

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("42");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("");
        organisations1.setOrgSector("");
        organisations1.setContactPerson("");
        organisations1.setSlogan("");
        organisations1.setOrgDescription("");
        organisations1.setOrgName("");
        organisations1.setDirectory("/tmp");
        organisations1.setDateAdded("2020-03-01");

        ArrayList<Organisations> organisationsList = new ArrayList<Organisations>();
        organisationsList.add(organisations1);
        organisationsList.add(organisations);
        when(this.organisationRepository.getAllOrganisations()).thenReturn(organisationsList);
        responseJSON actualNumPerMonth = this.organisationServiceImp
                .getNumPerMonth(new getNumOrganisationPerMonthRequest("jane.doe@example.org"));
        assertEquals("get_num_orgs_per_month", actualNumPerMonth.getCode());
        Object object = actualNumPerMonth.getObject();
        assertTrue(object instanceof getNumOrganisationPerMonthResponse);
        assertEquals("success", actualNumPerMonth.getMessage());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getApr());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getSept());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getOct());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getNov());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getMay());
        assertEquals(1L, ((getNumOrganisationPerMonthResponse) object).getMar());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJun());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJul());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getJan());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getFeb());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getDec());
        assertEquals(0L, ((getNumOrganisationPerMonthResponse) object).getAug());
        verify(this.organisationRepository).getAllOrganisations();
    }

    @Test
    void testUpdateOrganisationInfo() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "Type", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo10() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(0);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "contactPerson", "42")));
        verify(this.organisationRepository).existsById((Long) any());
        verify(this.organisationRepository).updatePerson((Long) any(), (String) any());
    }

    @Test
    void testUpdateOrganisationInfo11() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "", "42")));
    }

    @Test
    void testUpdateOrganisationInfo12() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "contactPerson", null)));
    }

    @Test
    void testUpdateOrganisationInfo13() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "contactPerson", "")));
    }

    @Test
    void testUpdateOrganisationInfo14() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp.updateOrganisationInfo(null));
    }

    @Test
    void testUpdateOrganisationInfo2() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "Type", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo3() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(null, "Type", "42")));
    }

    @Test
    void testUpdateOrganisationInfo4() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "description", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo5() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "contactNumber", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo6() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "email", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo7() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class, () -> this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "slogan", "42")));
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testUpdateOrganisationInfo8() throws Exception {
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        assertThrows(Exception.class,
                () -> this.organisationServiceImp.updateOrganisationInfo(new updateOrganisationInfoRequest(123L, null, "42")));
    }

    @Test
    void testUpdateOrganisationInfo9() throws Exception {
        when(this.organisationRepository.updatePerson((Long) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        generalOrganisationResponse actualUpdateOrganisationInfoResult = this.organisationServiceImp
                .updateOrganisationInfo(new updateOrganisationInfoRequest(123L, "contactPerson", "42"));
        assertEquals("update_person_200_OK", actualUpdateOrganisationInfoResult.getCode());
        assertEquals("success", actualUpdateOrganisationInfoResult.getMessage());
        verify(this.organisationRepository).existsById((Long) any());
        verify(this.organisationRepository).updatePerson((Long) any(), (String) any());
    }

    @Test
    void testGetMd5() {
        assertEquals("0e9c20d9b237aecc65de77a491061be5",
                this.organisationServiceImp.getMd5("27c7cf400229103e00c6d8830029e29b"));
    }

    @Test
    void testClearTabels() {
        doNothing().when(this.organisationInfoRepository).deleteAllInBatch();
        doNothing().when(this.organisationPointsRepository).deleteAllInBatch();
        doNothing().when(this.organisationRepository).deleteAllInBatch();
        doNothing().when(this.notificationRepository).deleteAllInBatch();
        this.organisationServiceImp.clearTabels();
        verify(this.organisationInfoRepository).deleteAllInBatch();
        verify(this.organisationPointsRepository).deleteAllInBatch();
        verify(this.organisationRepository).deleteAllInBatch();
        verify(this.notificationRepository).deleteAllInBatch();
    }

    @Test
    void testEmailExists() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertTrue(this.organisationServiceImp.emailExists(new emailExistsRequest("jane.doe@example.org")));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    void testEmailExists2() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.emailExists(new emailExistsRequest(null)));
    }

    @Test
    void testEmailExists3() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.emailExists(new emailExistsRequest("Email")));
    }

    @Test
    void testEmailExists4() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.emailExists(new emailExistsRequest("")));
    }

    @Test
    void testEmailExists5() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.organisationServiceImp.emailExists(null));
    }
}

