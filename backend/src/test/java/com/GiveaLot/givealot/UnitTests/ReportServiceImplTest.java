package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.dataclass.Reports;
import com.GiveaLot.givealot.Report.repository.reportRepository;
import com.GiveaLot.givealot.Report.requests.reportRequest;
import com.GiveaLot.givealot.Report.response.generalReportResponse;
import com.GiveaLot.givealot.Report.service.ReportServiceImpl;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ReportServiceImplTest {
    @MockBean
    private OrganisationInfoRepository organisationInfoRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private reportRepository reportRepository;

    @Autowired
    private ReportServiceImpl reportServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testCreateReportFile() throws Exception {
        assertThrows(Exception.class, () -> this.reportServiceImpl
                .createReportFile(new Report(123L, "Org Name", "Report Description", "Report Type", "jane.doe@example.org")));
        assertThrows(Exception.class, () -> this.reportServiceImpl.createReportFile(null));
    }

    @Test
    void testUpdateNumberOfReports() throws Exception {
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
        when(this.organisationInfoRepository.incrementReports((Long) any(), anyInt())).thenReturn(1);
        when(this.organisationInfoRepository.selectOrganisationInfo((Long) any())).thenReturn(organisationInfo);
        assertTrue(this.reportServiceImpl.updateNumberOfReports(123L));
        verify(this.organisationInfoRepository).incrementReports((Long) any(), anyInt());
        verify(this.organisationInfoRepository).selectOrganisationInfo((Long) any());
    }

    @Test
    void testReportOrganisation() throws Exception {
        Reports reports = new Reports();
        reports.setOrgId(123L);
        reports.setAppealed(true);
        reports.setReportType("Report Type");
        reports.setReportId(123L);
        reports.setUserId(123L);
        reports.setDescription("The characteristics of someone or something");
        reports.setDate("2020-03-01");
        when(this.reportRepository.save((Reports) any())).thenReturn(reports);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

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
        generalReportResponse actualReportOrganisationResult = this.reportServiceImpl.reportOrganisation(
                new reportRequest(123L, 123L, "Report Type", "The characteristics of someone or something"));
        assertEquals("success", actualReportOrganisationResult.getMessage());
        assertEquals("report_200_OK", actualReportOrganisationResult.getStatus());
        verify(this.reportRepository).save((Reports) any());
        verify(this.userRepository).findUserById(anyLong());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testReportOrganisationFail() throws Exception {
        Reports reports = new Reports();
        reports.setOrgId(123L);
        reports.setAppealed(true);
        reports.setReportType("Report Type");
        reports.setReportId(123L);
        reports.setUserId(123L);
        reports.setDescription("The characteristics of someone or something");
        reports.setDate("2020-03-01");
        when(this.reportRepository.save((Reports) any())).thenReturn(reports);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);

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
        assertThrows(Exception.class, () -> this.reportServiceImpl.reportOrganisation(
                new reportRequest(null, 123L, "Report Type", "The characteristics of someone or something")));
    }

    @Test
    void testGetAllReports() throws Exception {
        when(this.reportRepository.getAllReports((Long) any())).thenReturn(new ArrayList<Reports>());

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
        responseJSON actualAllReports = this.reportServiceImpl.getAllReports(123L);
        assertEquals("get_reports_200_OK", actualAllReports.getCode());
        assertTrue(((Collection<Object>) actualAllReports.getObject()).isEmpty());
        assertEquals("success", actualAllReports.getMessage());
        verify(this.reportRepository).getAllReports((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testGetAllReportsFail() throws Exception {
        when(this.reportRepository.getAllReports((Long) any())).thenReturn(new ArrayList<Reports>());

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
        assertThrows(Exception.class, () -> this.reportServiceImpl.getAllReports(null));
    }

    @Test
    void testAppealReport() throws Exception {
        Reports reports = new Reports();
        reports.setOrgId(123L);
        reports.setAppealed(true);
        reports.setReportType("Report Type");
        reports.setReportId(123L);
        reports.setUserId(123L);
        reports.setDescription("The characteristics of someone or something");
        reports.setDate("2020-03-01");
        when(this.reportRepository.appealReport((Long) any())).thenReturn(8080);
        when(this.reportRepository.getReportById((Long) any())).thenReturn(reports);

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
        generalReportResponse actualAppealReportResult = this.reportServiceImpl.appealReport(123L, 123L);
        assertEquals("success", actualAppealReportResult.getMessage());
        assertEquals("appeal_reports_200_OK", actualAppealReportResult.getStatus());
        verify(this.reportRepository).appealReport((Long) any());
        verify(this.reportRepository).getReportById((Long) any());
        verify(this.organisationRepository).selectOrganisationById((Long) any());
    }

    @Test
    void testAppealReportFail() throws Exception {
        Reports reports = new Reports();
        reports.setOrgId(123L);
        reports.setAppealed(true);
        reports.setReportType("Report Type");
        reports.setReportId(123L);
        reports.setUserId(123L);
        reports.setDescription("The characteristics of someone or something");
        reports.setDate("2020-03-01");
        when(this.reportRepository.appealReport((Long) any())).thenReturn(8080);
        when(this.reportRepository.getReportById((Long) any())).thenReturn(reports);

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
        assertThrows(Exception.class, () -> this.reportServiceImpl.appealReport(null, 123L));
    }

    @Test
    void testGetAppealedReports() throws Exception {
        when(this.reportRepository.getAppealedReports()).thenReturn(new ArrayList<Reports>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        responseJSON actualAppealedReports = this.reportServiceImpl.getAppealedReports(123L);
        assertEquals("get_app_reports_OK", actualAppealedReports.getCode());
        assertTrue(((Collection<Object>) actualAppealedReports.getObject()).isEmpty());
        assertEquals("success", actualAppealedReports.getMessage());
        verify(this.reportRepository).getAppealedReports();
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
    }

    @Test
    void testGetAppealedReportsFail() throws Exception {
        when(this.reportRepository.getAppealedReports()).thenReturn(new ArrayList<Reports>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserById(anyLong())).thenReturn(user);
        assertThrows(Exception.class, () -> this.reportServiceImpl.getAppealedReports(123L));
        verify(this.userRepository, atLeast(1)).findUserById(anyLong());
    }
}

