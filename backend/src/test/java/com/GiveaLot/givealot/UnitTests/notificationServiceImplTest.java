package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Notification.dataclass.Notification;
import com.GiveaLot.givealot.Notification.repository.NotificationRepository;
import com.GiveaLot.givealot.Notification.requests.AddNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.GetLevelRequest;
import com.GiveaLot.givealot.Notification.requests.GetNotificationsRequest;
import com.GiveaLot.givealot.Notification.requests.UpdateNotificationRequest;
import com.GiveaLot.givealot.Notification.response.GetLevelResponse;
import com.GiveaLot.givealot.Notification.response.GetNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.generalNotificationResponse;
import com.GiveaLot.givealot.Notification.response.getNumberOfNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.levelFiveInformationResponse;
import com.GiveaLot.givealot.Notification.response.levelOneInformationResponse;
import com.GiveaLot.givealot.Notification.response.levelThreeInformationResponse;
import com.GiveaLot.givealot.Notification.response.levelTwoInformationResponse;
import com.GiveaLot.givealot.Notification.service.notificationServiceImpl;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.repository.UserRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {notificationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class otificationServiceImplTest {
    @MockBean
    private BlockChainRepository blockChainRepository;

    @MockBean
    private NotificationRepository notificationRepository;

    @Autowired
    private notificationServiceImpl notificationServiceImpl;

    @MockBean
    private OrganisationInfoRepository organisationInfoRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testGetNotifications() throws Exception {
        when(this.notificationRepository.getAllNotifications()).thenReturn(new ArrayList<Notification>());
        GetNotificationsResponse actualNotifications = this.notificationServiceImpl
                .getNotifications(new GetNotificationsRequest("jane.doe@example.org"));
        assertEquals("get_notifications_200_ok", actualNotifications.getCode());
        assertTrue(actualNotifications.getResponse().isEmpty());
        assertEquals("success", actualNotifications.getMessage());
        verify(this.notificationRepository).getAllNotifications();
    }

    @Test
    void testAddNotifications() throws Exception {
        Notification notification = new Notification();
        notification.setDateCreated("2020-03-01");
        notification.setOrg_name("Org name");
        notification.setOpen(true);
        notification.setDescription("The characteristics of someone or something");
        notification.setNotificationType("Notification Type");
        notification.setNotification_id(1L);
        notification.setOrg_id(1L);
        when(this.notificationRepository.selectNotificationById((Long) any())).thenReturn(notification);
        assertThrows(Exception.class, () -> this.notificationServiceImpl.addNotifications(new AddNotificationRequest(1L,
                true, "The characteristics of someone or something", "Notification Type", "Name")));
        verify(this.notificationRepository).selectNotificationById((Long) any());
    }

    @Test
    void testAddNotificationsFail() throws Exception {
        Notification notification = new Notification();
        notification.setDateCreated("2020-03-01");
        notification.setOrg_name("Org name");
        notification.setOpen(true);
        notification.setDescription("The characteristics of someone or something");
        notification.setNotificationType("Notification Type");
        notification.setNotification_id(1L);
        notification.setOrg_id(1L);
        when(this.notificationRepository.selectNotificationById((Long) any())).thenReturn(notification);
        assertThrows(Exception.class, () -> this.notificationServiceImpl.addNotifications(new AddNotificationRequest(null,
                true, "The characteristics of someone or something", "Notification Type", "Name")));
    }

    @Test
    void testRemoveNotifications() throws Exception {
        when(this.notificationRepository.removeNotificationByNotification_id((Long) any())).thenReturn(true);
        generalNotificationResponse actualRemoveNotificationsResult = this.notificationServiceImpl
                .removeNotifications(123L);
        assertEquals("remove_notification_200_ok", actualRemoveNotificationsResult.getCode());
        assertEquals("success", actualRemoveNotificationsResult.getMessage());
        verify(this.notificationRepository).removeNotificationByNotification_id((Long) any());
    }

    @Test
    void testRemoveNotificationsFail() throws Exception {
        when(this.notificationRepository.removeNotificationByNotification_id((Long) any())).thenReturn(false);
        assertThrows(Exception.class, () -> this.notificationServiceImpl.removeNotifications(123L));
        verify(this.notificationRepository).removeNotificationByNotification_id((Long) any());
    }

    @Test
    void testNumberOfNotifications() throws Exception {
        when(this.notificationRepository.getAllNotifications()).thenReturn(new ArrayList<Notification>());
        getNumberOfNotificationsResponse actualNumberOfNotificationsResult = this.notificationServiceImpl
                .numberOfNotifications(new GetNotificationsRequest("jane.doe@example.org"));
        assertEquals("get_number_notifications_ok", actualNumberOfNotificationsResult.getCode());
        assertEquals(0, actualNumberOfNotificationsResult.getResponse());
        assertEquals("success", actualNumberOfNotificationsResult.getMessage());
        verify(this.notificationRepository).getAllNotifications();
    }

    @Test
    void testGetLevelInformation() throws Exception {
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
        responseJSON actualLevelInformation = this.notificationServiceImpl.getLevelInformation(1L);
        assertEquals("get_level_200_OK", actualLevelInformation.getCode());
        Object object = actualLevelInformation.getObject();
        assertTrue(object instanceof levelTwoInformationResponse);
        assertEquals("success", actualLevelInformation.getMessage());
        assertEquals("42 Main St", ((levelTwoInformationResponse) object).getAddress());
        assertEquals("Website", ((levelTwoInformationResponse) object).getWebsite());
        assertEquals("Org Name", ((levelTwoInformationResponse) object).getOrgName());
        assertEquals(1L, ((levelTwoInformationResponse) object).getOrgID().longValue());
        assertEquals(2L, ((levelTwoInformationResponse) object).getLevel().longValue());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testGetLevelInformationFail() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(0L);
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
        responseJSON actualLevelInformation = this.notificationServiceImpl.getLevelInformation(1L);
        assertEquals("get_level_200_OK", actualLevelInformation.getCode());
        Object object = actualLevelInformation.getObject();
        assertTrue(object instanceof levelOneInformationResponse);
        assertEquals("success", actualLevelInformation.getMessage());
        assertEquals(1L, ((levelOneInformationResponse) object).getLevel().longValue());
        assertEquals("localfiles/1/Gallery/logo.png", ((levelOneInformationResponse) object).getUrl());
        assertEquals("Org Name", ((levelOneInformationResponse) object).getOrgName());
        assertEquals(1L, ((levelOneInformationResponse) object).getOrgID().longValue());
        assertEquals("42", ((levelOneInformationResponse) object).getNgoNumber());
        assertEquals("2020-03-01", ((levelOneInformationResponse) object).getNgoDate());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testUpdateNotification() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

        Notification notification = new Notification();
        notification.setDateCreated("2020-03-01");
        notification.setOrg_name("Org name");
        notification.setOpen(true);
        notification.setDescription("The characteristics of someone or something");
        notification.setNotificationType("Notification Type");
        notification.setNotification_id(1L);
        notification.setOrg_id(1L);
        when(this.notificationRepository.save((Notification) any())).thenReturn(notification);

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
        when(this.organisationRepository.getById((Long) any())).thenReturn(organisations);
        generalNotificationResponse actualUpdateNotificationResult = this.notificationServiceImpl
                .updateNotification(new UpdateNotificationRequest(1L));
        assertEquals("update_notification_200_ok", actualUpdateNotificationResult.getCode());
        assertEquals("success", actualUpdateNotificationResult.getMessage());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.notificationRepository).save((Notification) any());
        verify(this.organisationRepository).getById((Long) any());
    }

    @Test
    void testUpdateNotificationFail() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(0L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

        Notification notification = new Notification();
        notification.setDateCreated("2020-03-01");
        notification.setOrg_name("Org name");
        notification.setOpen(true);
        notification.setDescription("The characteristics of someone or something");
        notification.setNotificationType("Notification Type");
        notification.setNotification_id(1L);
        notification.setOrg_id(1L);
        when(this.notificationRepository.save((Notification) any())).thenReturn(notification);

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
        when(this.organisationRepository.getById((Long) any())).thenReturn(organisations);
        generalNotificationResponse actualUpdateNotificationResult = this.notificationServiceImpl
                .updateNotification(new UpdateNotificationRequest(1L));
        assertEquals("update_notification_200_ok", actualUpdateNotificationResult.getCode());
        assertEquals("success", actualUpdateNotificationResult.getMessage());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.notificationRepository).save((Notification) any());
        verify(this.organisationRepository).getById((Long) any());
    }

    @Test
    void testGetLevel() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

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
        when(this.organisationRepository.getById((Long) any())).thenReturn(organisations);
        GetLevelResponse actualLevel = this.notificationServiceImpl.getLevel(new GetLevelRequest(1L));
        assertEquals("get_level_ok", actualLevel.getCode());
        assertEquals(1L, actualLevel.getResponse());
        assertEquals("success", actualLevel.getMessage());
        verify(this.blockChainRepository).selectBlockchainOrgId(anyLong());
        verify(this.organisationRepository).getById((Long) any());
    }

    @Test
    void testGetLevelFail() throws Exception {
        Blockchain blockchain = new Blockchain();
        blockchain.setTransactionHash("Transaction Hash");
        blockchain.setCertificateHash("Certificate Hash");
        blockchain.setIndex(1L);
        blockchain.setOrgId(123L);
        blockchain.setLevel(1L);
        when(this.blockChainRepository.selectBlockchainOrgId(anyLong())).thenReturn(blockchain);

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
        when(this.organisationRepository.getById((Long) any())).thenReturn(organisations);
        assertThrows(Exception.class, () -> this.notificationServiceImpl.getLevel(null));
    }
}

