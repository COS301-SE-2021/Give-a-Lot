package com.GiveaLot.givealot.Organisation.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.dao.OrganisationDAOInterface;
import com.GiveaLot.givealot.Organisation.dao.OrganisationDASPostgre;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.rri.AddOrgAuditInfoRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgAuditorRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgCommitteeRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgDonationInfoRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgEstDateRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgImageRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgNGORequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgTaxRefRequest;
import com.GiveaLot.givealot.Organisation.rri.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.rri.AddSocialsRequest;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrganisationService.class})
@ExtendWith(SpringExtension.class)
public class OrganisationServiceTest {
    @MockBean(name = "temp")
    private OrganisationDAOInterface organisationDAOInterface;

    @Autowired
    private OrganisationService organisationService;

    @Test
    public void testConstructor() {
        new OrganisationService(new OrganisationDASPostgre());
    }

    @Test
    @Description("Tests that an organisation can be retrieved")
    public void testSelectOrganisation() throws Exception {
        Organisation organisation = new Organisation("42", "Org Name", "Slogan", "Org Description", "Org Sector",
                "jane.doe@example.org", "Status", "Contact Person", "Contact Number", "/tmp", "password");

        when(this.organisationDAOInterface.selectOrganisation(anyString())).thenReturn(organisation);
        assertSame(organisation, this.organisationService.selectOrganisation("42"));
        verify(this.organisationDAOInterface).selectOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation's information can be retrieved")
    public void testSelectOrganisationInfo() throws Exception {
        Date ngoDate = new Date();
        OrganisationInfo organisationInfo = new OrganisationInfo("42", "42 Main St", 0, 0, "Website", "Audit Document",
                "Tax Reference", "Auditor Details", "Committee Details", "Ngo Number", ngoDate, "Twitter", "Facebook",
                "Instagram", new Date());

        when(this.organisationDAOInterface.selectOrganisationInfo(anyString())).thenReturn(organisationInfo);
        assertSame(organisationInfo, this.organisationService.selectOrganisationInfo("42"));
        verify(this.organisationDAOInterface).selectOrganisationInfo(anyString());
    }

    @Test
    @Description("Tests that an organisation's certificate points can be retrieved")
    public void testSelectOrganisationPoints() throws Exception {
        OrganisationPoints organisationPoints = new OrganisationPoints("42", 1, true, true, true, true, true, true, true,
                true, "Social Media Type", true, 10);

        when(this.organisationDAOInterface.selectOrganisationPoints(anyString())).thenReturn(organisationPoints);
        assertSame(organisationPoints, this.organisationService.selectOrganisationPoints("42"));
        verify(this.organisationDAOInterface).selectOrganisationPoints(anyString());
    }

    @Test
    @Description("Tests that an organisation exists on the system")
    public void testOrganisationExistsTrue() {
        when(this.organisationDAOInterface.organisationExists((Organisation) any())).thenReturn(true);
        assertTrue(
                this.organisationService.organisationExists(new Organisation("42", "Org Name", "Slogan", "Org Description",
                        "Org Sector", "jane.doe@example.org", "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou")));
        verify(this.organisationDAOInterface).organisationExists((Organisation) any());
    }

    @Test
    @Description("Tests that an organisation does not exist on the system")
    public void testOrganisationExistsFalse() {
        when(this.organisationDAOInterface.organisationExists((Organisation) any())).thenReturn(false);
        assertFalse(
                this.organisationService.organisationExists(new Organisation("42", "Org Name", "Slogan", "Org Description",
                        "Org Sector", "jane.doe@example.org", "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou")));
        verify(this.organisationDAOInterface).organisationExists((Organisation) any());
    }

    @Test
    @Description("Tests that an organisation succeeds in being added to the system")
    public void testAddOrganisationTrue() throws Exception {
        when(this.organisationDAOInterface.addOrganisation((Organisation) any())).thenReturn(true);
        assertTrue(this.organisationService.addOrganisation(new Organisation("42", "Org Name", "Slogan", "Org Description",
                "Org Sector", "jane.doe@example.org", "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou")));
        verify(this.organisationDAOInterface).addOrganisation((Organisation) any());
    }

    @Test
    @Description("Tests that an organisation fails in being added to the system")
    public void testAddOrganisationFalse() throws Exception {
        when(this.organisationDAOInterface.addOrganisation((Organisation) any())).thenReturn(false);
        assertFalse(this.organisationService.addOrganisation(new Organisation("42", "Org Name", "Slogan", "Org Description",
                "Org Sector", "jane.doe@example.org", "Status", "Contact Person", "Contact Number", "/tmp", "iloveyou")));
        verify(this.organisationDAOInterface).addOrganisation((Organisation) any());
    }

    @Test
    @Description("Tests that an organisation reactivation succeeds on the system")
    public void testReactivateOrganisationTrue() throws Exception {
        when(this.organisationDAOInterface.reactivateOrganisation(anyString())).thenReturn(true);
        assertTrue(this.organisationService.reactivateOrganisation("42"));
        verify(this.organisationDAOInterface).reactivateOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation reactivation fails on the system")
    public void testReactivateOrganisationFalse() throws Exception {
        when(this.organisationDAOInterface.reactivateOrganisation(anyString())).thenReturn(false);
        assertFalse(this.organisationService.reactivateOrganisation("42"));
        verify(this.organisationDAOInterface).reactivateOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation investigation succeeds on the system")
    public void testInvestigateOrganisationTrue() throws Exception {
        when(this.organisationDAOInterface.investigateOrganisation(anyString())).thenReturn(true);
        assertTrue(this.organisationService.investigateOrganisation("42"));
        verify(this.organisationDAOInterface).investigateOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation investigation fails on the system")
    public void testInvestigateOrganisationFalse() throws Exception {
        when(this.organisationDAOInterface.investigateOrganisation(anyString())).thenReturn(false);
        assertFalse(this.organisationService.investigateOrganisation("42"));
        verify(this.organisationDAOInterface).investigateOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation suspension succeeds on the system")
    public void testSuspendOrganisationTrue() throws Exception {
        when(this.organisationDAOInterface.suspendOrganisation(anyString())).thenReturn(true);
        assertTrue(this.organisationService.suspendOrganisation("42"));
        verify(this.organisationDAOInterface).suspendOrganisation(anyString());
    }

    @Test
    @Description("Tests that an organisation suspension fails on the system")
    public void testSuspendOrganisationFalse() throws Exception {
        when(this.organisationDAOInterface.suspendOrganisation(anyString())).thenReturn(false);
        assertFalse(this.organisationService.suspendOrganisation("42"));
        verify(this.organisationDAOInterface).suspendOrganisation(anyString());
    }

    @Test
    public void testAddOrgWebsiteTrue() throws Exception {
        when(this.organisationDAOInterface.addOrgWebsite(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgWebsite(new AddOrgWebsiteRequest("42", "Website")));
        verify(this.organisationDAOInterface).addOrgWebsite(anyString(), anyString());
    }

    @Test
    public void testAddOrgWebsiteFalse() throws Exception {
        when(this.organisationDAOInterface.addOrgWebsite(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgWebsite(new AddOrgWebsiteRequest("42", "Website")));
        verify(this.organisationDAOInterface).addOrgWebsite(anyString(), anyString());
    }

    @Test
    public void testAddOrgWebsiteNull() throws Exception {
        when(this.organisationDAOInterface.addOrgWebsite(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgWebsite(null));
    }

    @Test
    public void testAddOrgWebsiteComplete() throws Exception {
        when(this.organisationDAOInterface.addOrgWebsite(anyString(), anyString())).thenReturn(true);
        AddOrgWebsiteRequest addOrgWebsiteRequest = mock(AddOrgWebsiteRequest.class);
        when(addOrgWebsiteRequest.getWebsite()).thenReturn("foo");
        when(addOrgWebsiteRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgWebsite(addOrgWebsiteRequest));
        verify(this.organisationDAOInterface).addOrgWebsite(anyString(), anyString());
        verify(addOrgWebsiteRequest).getOrgId();
        verify(addOrgWebsiteRequest).getWebsite();
    }

    @Test
    public void testRemoveOrgWebsiteTrue() throws Exception {
        when(this.organisationDAOInterface.removeOrgWebsite(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgWebsite("42"));
        verify(this.organisationDAOInterface).removeOrgWebsite(anyString());
    }

    @Test
    public void testRemoveOrgWebsiteFalse() throws Exception {
        when(this.organisationDAOInterface.removeOrgWebsite(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgWebsite("42"));
        verify(this.organisationDAOInterface).removeOrgWebsite(anyString());
    }

    @Test
    public void testAddOrgAddressTrue() {
        when(this.organisationDAOInterface.addOrgAddress(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgAddress("42", "42 Main St"));
        verify(this.organisationDAOInterface).addOrgAddress(anyString(), anyString());
    }

    @Test
    public void testAddOrgAddressFalse() {
        when(this.organisationDAOInterface.addOrgAddress(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgAddress("42", "42 Main St"));
        verify(this.organisationDAOInterface).addOrgAddress(anyString(), anyString());
    }

    @Test
    public void testRemoveOrgAddressTrue() throws Exception {
        when(this.organisationDAOInterface.removeOrgAddress(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgAddress("42"));
        verify(this.organisationDAOInterface).removeOrgAddress(anyString());
    }

    @Test
    public void testRemoveOrgAddressFalse() throws Exception {
        when(this.organisationDAOInterface.removeOrgAddress(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgAddress("42"));
        verify(this.organisationDAOInterface).removeOrgAddress(anyString());
    }

    @Test
    public void testAddOrgImageTrue() {
        when(this.organisationDAOInterface.addOrgImage(anyString(), (File) any())).thenReturn(true);
        assertTrue(this.organisationService.addOrgImage(
                new AddOrgImageRequest("42", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
        verify(this.organisationDAOInterface).addOrgImage(anyString(), (File) any());
    }

    @Test
    public void testAddOrgImageFalse() {
        when(this.organisationDAOInterface.addOrgImage(anyString(), (File) any())).thenReturn(false);
        assertFalse(this.organisationService.addOrgImage(
                new AddOrgImageRequest("42", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
        verify(this.organisationDAOInterface).addOrgImage(anyString(), (File) any());
    }

    @Test
    public void testAddOrgImageNull() {
        when(this.organisationDAOInterface.addOrgImage(anyString(), (java.io.File) any())).thenReturn(true);
        assertFalse(this.organisationService.addOrgImage(null));
    }

    @Test
    public void testAddOrgImageComplete() {
        when(this.organisationDAOInterface.addOrgImage(anyString(), (File) any())).thenReturn(true);
        AddOrgImageRequest addOrgImageRequest = mock(AddOrgImageRequest.class);
        when(addOrgImageRequest.getImage())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
        when(addOrgImageRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgImage(addOrgImageRequest));
        verify(this.organisationDAOInterface).addOrgImage(anyString(), (File) any());
        verify(addOrgImageRequest).getImage();
        verify(addOrgImageRequest).getOrgId();
    }

    @Test
    public void testRemoveOrgImageTrue() {
        when(this.organisationDAOInterface.removeOrgImage(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgImage("42"));
        verify(this.organisationDAOInterface).removeOrgImage(anyString());
    }

    @Test
    public void testRemoveOrgImageFalse() {
        when(this.organisationDAOInterface.removeOrgImage(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgImage("42"));
        verify(this.organisationDAOInterface).removeOrgImage(anyString());
    }

    @Test
    public void testAddOrgAuditDocTrue() {
        when(this.organisationDAOInterface.addOrgAuditDoc(anyString(), (File) any())).thenReturn(true);
        assertTrue(this.organisationService.addOrgAuditDoc(
                new AddOrgAuditInfoRequest("42", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
        verify(this.organisationDAOInterface).addOrgAuditDoc(anyString(), (File) any());
    }

    @Test
    public void testAddOrgAuditDocFalse() {
        when(this.organisationDAOInterface.addOrgAuditDoc(anyString(), (File) any())).thenReturn(false);
        assertFalse(this.organisationService.addOrgAuditDoc(
                new AddOrgAuditInfoRequest("42", Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
        verify(this.organisationDAOInterface).addOrgAuditDoc(anyString(), (File) any());
    }

    @Test
    public void testAddOrgAuditDocNull() {
        when(this.organisationDAOInterface.addOrgAuditDoc(anyString(), (java.io.File) any())).thenReturn(true);
        assertFalse(this.organisationService.addOrgAuditDoc(null));
    }

    @Test
    public void testAddOrgAuditDocComplete() {
        when(this.organisationDAOInterface.addOrgAuditDoc(anyString(), (File) any())).thenReturn(true);
        AddOrgAuditInfoRequest addOrgAuditInfoRequest = mock(AddOrgAuditInfoRequest.class);
        when(addOrgAuditInfoRequest.getAudit())
                .thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
        when(addOrgAuditInfoRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgAuditDoc(addOrgAuditInfoRequest));
        verify(this.organisationDAOInterface).addOrgAuditDoc(anyString(), (File) any());
        verify(addOrgAuditInfoRequest).getAudit();
        verify(addOrgAuditInfoRequest).getOrgId();
    }

    @Test
    public void testRemoveOrgAuditDocTrue() {
        when(this.organisationDAOInterface.removeOrgAuditDoc(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgAuditDoc("42"));
        verify(this.organisationDAOInterface).removeOrgAuditDoc(anyString());
    }

    @Test
    public void testRemoveOrgAuditDocFalse() {
        when(this.organisationDAOInterface.removeOrgAuditDoc(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgAuditDoc("42"));
        verify(this.organisationDAOInterface).removeOrgAuditDoc(anyString());
    }

    @Test
    public void testAddOrgTaxRefTrue() {
        when(this.organisationDAOInterface.addOrgTaxRef(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgTaxRef(new AddOrgTaxRefRequest("42", "Reference")));
        verify(this.organisationDAOInterface).addOrgTaxRef(anyString(), anyString());
    }

    @Test
    public void testAddOrgTaxRefFalse() {
        when(this.organisationDAOInterface.addOrgTaxRef(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgTaxRef(new AddOrgTaxRefRequest("42", "Reference")));
        verify(this.organisationDAOInterface).addOrgTaxRef(anyString(), anyString());
    }

    @Test
    public void testAddOrgTaxRefNull() {
        when(this.organisationDAOInterface.addOrgTaxRef(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgTaxRef(null));
    }

    @Test
    public void testAddOrgTaxRefComplete() {
        when(this.organisationDAOInterface.addOrgTaxRef(anyString(), anyString())).thenReturn(true);
        AddOrgTaxRefRequest addOrgTaxRefRequest = mock(AddOrgTaxRefRequest.class);
        when(addOrgTaxRefRequest.getReference()).thenReturn("foo");
        when(addOrgTaxRefRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgTaxRef(addOrgTaxRefRequest));
        verify(this.organisationDAOInterface).addOrgTaxRef(anyString(), anyString());
        verify(addOrgTaxRefRequest).getOrgId();
        verify(addOrgTaxRefRequest).getReference();
    }

    @Test
    public void testRemoveOrgTaxRefTrue() {
        when(this.organisationDAOInterface.removeOrgTaxRef(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgTaxRef("42"));
        verify(this.organisationDAOInterface).removeOrgTaxRef(anyString());
    }

    @Test
    public void testRemoveOrgTaxRefFalse() {
        when(this.organisationDAOInterface.removeOrgTaxRef(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgTaxRef("42"));
        verify(this.organisationDAOInterface).removeOrgTaxRef(anyString());
    }

    @Test
    public void testAddOrgAuditorTrue() {
        when(this.organisationDAOInterface.addOrgAuditor(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgAuditor(new AddOrgAuditorRequest("42", "Auditor")));
        verify(this.organisationDAOInterface).addOrgAuditor(anyString(), anyString());
    }

    @Test
    public void testAddOrgAuditorFalse() {
        when(this.organisationDAOInterface.addOrgAuditor(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgAuditor(new AddOrgAuditorRequest("42", "Auditor")));
        verify(this.organisationDAOInterface).addOrgAuditor(anyString(), anyString());
    }

    @Test
    public void testAddOrgAuditorNull() {
        when(this.organisationDAOInterface.addOrgAuditor(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgAuditor(null));
    }

    @Test
    public void testAddOrgAuditorComplete() {
        when(this.organisationDAOInterface.addOrgAuditor(anyString(), anyString())).thenReturn(true);
        AddOrgAuditorRequest addOrgAuditorRequest = mock(AddOrgAuditorRequest.class);
        when(addOrgAuditorRequest.getAuditor()).thenReturn("foo");
        when(addOrgAuditorRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgAuditor(addOrgAuditorRequest));
        verify(this.organisationDAOInterface).addOrgAuditor(anyString(), anyString());
        verify(addOrgAuditorRequest).getAuditor();
        verify(addOrgAuditorRequest).getOrgId();
    }

    @Test
    public void testRemoveOrgAuditorTrue() {
        when(this.organisationDAOInterface.removeOrgAuditor(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgAuditor("42"));
        verify(this.organisationDAOInterface).removeOrgAuditor(anyString());
    }

    @Test
    public void testRemoveOrgAuditorFalse() {
        when(this.organisationDAOInterface.removeOrgAuditor(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgAuditor("42"));
        verify(this.organisationDAOInterface).removeOrgAuditor(anyString());
    }

    @Test
    public void testAddOrgCommitteeTrue() {
        when(this.organisationDAOInterface.addOrgCommittee(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgCommittee(new AddOrgCommitteeRequest("42", "Committee")));
        verify(this.organisationDAOInterface).addOrgCommittee(anyString(), anyString());
    }

    @Test
    public void testAddOrgCommitteeFalse() {
        when(this.organisationDAOInterface.addOrgCommittee(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgCommittee(new AddOrgCommitteeRequest("42", "Committee")));
        verify(this.organisationDAOInterface).addOrgCommittee(anyString(), anyString());
    }

    @Test
    public void testAddOrgCommitteeNull() {
        when(this.organisationDAOInterface.addOrgCommittee(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgCommittee(null));
    }

    @Test
    public void testAddOrgCommitteeComplete() {
        when(this.organisationDAOInterface.addOrgCommittee(anyString(), anyString())).thenReturn(true);
        AddOrgCommitteeRequest addOrgCommitteeRequest = mock(AddOrgCommitteeRequest.class);
        when(addOrgCommitteeRequest.getCommittee()).thenReturn("foo");
        when(addOrgCommitteeRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgCommittee(addOrgCommitteeRequest));
        verify(this.organisationDAOInterface).addOrgCommittee(anyString(), anyString());
        verify(addOrgCommitteeRequest).getCommittee();
        verify(addOrgCommitteeRequest).getOrgId();
    }

    @Test
    public void testRemoveOrgCommitteeTrue() {
        when(this.organisationDAOInterface.removeOrgCommittee(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgCommittee("42"));
        verify(this.organisationDAOInterface).removeOrgCommittee(anyString());
    }

    @Test
    public void testRemoveOrgCommitteeFalse() {
        when(this.organisationDAOInterface.removeOrgCommittee(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgCommittee("42"));
        verify(this.organisationDAOInterface).removeOrgCommittee(anyString());
    }

    @Test
    public void testAddOrgDonationInfoTrue() {
        when(this.organisationDAOInterface.addOrgDonationInfo(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgDonationInfo(new AddOrgDonationInfoRequest("42", "Org Info")));
        verify(this.organisationDAOInterface).addOrgDonationInfo(anyString(), anyString());
    }

    @Test
    public void testAddOrgDonationInfoFalse() {
        when(this.organisationDAOInterface.addOrgDonationInfo(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgDonationInfo(new AddOrgDonationInfoRequest("42", "Org Info")));
        verify(this.organisationDAOInterface).addOrgDonationInfo(anyString(), anyString());
    }

    @Test
    public void testAddOrgDonationInfoNull() {
        when(this.organisationDAOInterface.addOrgDonationInfo(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgDonationInfo(null));
    }

    @Test
    public void testAddOrgDonationInfoComplete() {
        when(this.organisationDAOInterface.addOrgDonationInfo(anyString(), anyString())).thenReturn(true);
        AddOrgDonationInfoRequest addOrgDonationInfoRequest = mock(AddOrgDonationInfoRequest.class);
        when(addOrgDonationInfoRequest.getOrgInfo()).thenReturn("foo");
        when(addOrgDonationInfoRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgDonationInfo(addOrgDonationInfoRequest));
        verify(this.organisationDAOInterface).addOrgDonationInfo(anyString(), anyString());
        verify(addOrgDonationInfoRequest).getOrgId();
        verify(addOrgDonationInfoRequest).getOrgInfo();
    }

    @Test
    public void testRemoveOrgDonationInfoTrue() {
        when(this.organisationDAOInterface.removeOrgDonationInfo(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgDonationInfo("42"));
        verify(this.organisationDAOInterface).removeOrgDonationInfo(anyString());
    }

    @Test
    public void testRemoveOrgDonationInfoFalse() {
        when(this.organisationDAOInterface.removeOrgDonationInfo(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgDonationInfo("42"));
        verify(this.organisationDAOInterface).removeOrgDonationInfo(anyString());
    }

    @Test
    public void testAddOrgSocialsTrue() {
        when(this.organisationDAOInterface.addOrgSocials(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.addOrgSocials(new AddSocialsRequest( "Type", "42")));
        verify(this.organisationDAOInterface).addOrgSocials(anyString(), anyString());
    }

    @Test
    public void testAddOrgSocialsFalse() {
        when(this.organisationDAOInterface.addOrgSocials(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.addOrgSocials(new AddSocialsRequest( "Type", "42")));
        verify(this.organisationDAOInterface).addOrgSocials(anyString(), anyString());
    }

    @Test
    public void testAddOrgSocialsNull() {
        when(this.organisationDAOInterface.addOrgSocials(anyString(), anyString())).thenReturn(true);
        assertFalse(this.organisationService.addOrgSocials(null));
    }

    @Test
    public void testAddOrgSocialsComplete() {
        when(this.organisationDAOInterface.addOrgSocials(anyString(), anyString())).thenReturn(true);
        AddSocialsRequest addSocialsRequest = mock(AddSocialsRequest.class);
        when(addSocialsRequest.getType()).thenReturn("foo");
        when(addSocialsRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgSocials(addSocialsRequest));
        verify(this.organisationDAOInterface).addOrgSocials(anyString(), anyString());
        verify(addSocialsRequest).getOrgId();
        verify(addSocialsRequest).getType();
    }

    @Test
    public void testRemoveOrgSocials() {
        when(this.organisationDAOInterface.removeOrgSocials(anyString(), anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgSocials("42", "Type"));
        verify(this.organisationDAOInterface).removeOrgSocials(anyString(), anyString());
    }

    @Test
    public void testRemoveOrgSocials2() {
        when(this.organisationDAOInterface.removeOrgSocials(anyString(), anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgSocials("42", "Type"));
        verify(this.organisationDAOInterface).removeOrgSocials(anyString(), anyString());
    }

    @Test
    public void testAddOrgNGO() {
        when(this.organisationDAOInterface.addOrgNGO(anyString(), anyString(), (Date) any())).thenReturn(true);
        assertTrue(this.organisationService.addOrgNGO(new AddOrgNGORequest("42", "Ngo Number", new Date(1L))));
        verify(this.organisationDAOInterface).addOrgNGO(anyString(), anyString(), (Date) any());
    }

    @Test
    public void testAddOrgNGO2() {
        when(this.organisationDAOInterface.addOrgNGO(anyString(), anyString(), (Date) any())).thenReturn(false);
        assertFalse(this.organisationService.addOrgNGO(new AddOrgNGORequest("42", "Ngo Number", new Date(1L))));
        verify(this.organisationDAOInterface).addOrgNGO(anyString(), anyString(), (Date) any());
    }

    @Test
    public void testAddOrgNGO3() {
        when(this.organisationDAOInterface.addOrgNGO(anyString(), anyString(), (java.util.Date) any())).thenReturn(true);
        assertFalse(this.organisationService.addOrgNGO(null));
    }

    @Test
    public void testAddOrgNGO4() {
        when(this.organisationDAOInterface.addOrgNGO(anyString(), anyString(), (Date) any())).thenReturn(true);
        AddOrgNGORequest addOrgNGORequest = mock(AddOrgNGORequest.class);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(addOrgNGORequest.getNgoDate())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        when(addOrgNGORequest.getNgoNumber()).thenReturn("foo");
        when(addOrgNGORequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgNGO(addOrgNGORequest));
        verify(this.organisationDAOInterface).addOrgNGO(anyString(), anyString(), (Date) any());
        verify(addOrgNGORequest).getNgoDate();
        verify(addOrgNGORequest).getNgoNumber();
        verify(addOrgNGORequest).getOrgId();
    }

    @Test
    public void testRemoveOrgNGO() {
        when(this.organisationDAOInterface.removeOrgNGO(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgNGO("42"));
        verify(this.organisationDAOInterface).removeOrgNGO(anyString());
    }

    @Test
    public void testRemoveOrgNGO2() {
        when(this.organisationDAOInterface.removeOrgNGO(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgNGO("42"));
        verify(this.organisationDAOInterface).removeOrgNGO(anyString());
    }

    @Test
    public void testAddOrgEstDate() {
        when(this.organisationDAOInterface.addOrgEstDate(anyString(), (Date) any())).thenReturn(true);
        assertTrue(this.organisationService.addOrgEstDate(new AddOrgEstDateRequest(new Date(1L), "42")));
        verify(this.organisationDAOInterface).addOrgEstDate(anyString(), (Date) any());
    }

    @Test
    public void testAddOrgEstDate2() {
        when(this.organisationDAOInterface.addOrgEstDate(anyString(), (Date) any())).thenReturn(false);
        assertFalse(this.organisationService.addOrgEstDate(new AddOrgEstDateRequest(new Date(1L), "42")));
        verify(this.organisationDAOInterface).addOrgEstDate(anyString(), (Date) any());
    }

    @Test
    public void testAddOrgEstDate3() {
        when(this.organisationDAOInterface.addOrgEstDate(anyString(), (java.util.Date) any())).thenReturn(true);
        assertFalse(this.organisationService.addOrgEstDate(null));
    }

    @Test
    public void testAddOrgEstDate4() {
        when(this.organisationDAOInterface.addOrgEstDate(anyString(), (Date) any())).thenReturn(true);
        AddOrgEstDateRequest addOrgEstDateRequest = mock(AddOrgEstDateRequest.class);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(addOrgEstDateRequest.getDate())
                .thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        when(addOrgEstDateRequest.getOrgId()).thenReturn("foo");
        assertTrue(this.organisationService.addOrgEstDate(addOrgEstDateRequest));
        verify(this.organisationDAOInterface).addOrgEstDate(anyString(), (Date) any());
        verify(addOrgEstDateRequest).getDate();
        verify(addOrgEstDateRequest).getOrgId();
    }

    @Test
    public void testRemoveOrgEstDate() {
        when(this.organisationDAOInterface.removeOrgEstDate(anyString())).thenReturn(true);
        assertTrue(this.organisationService.removeOrgEstDate("42"));
        verify(this.organisationDAOInterface).removeOrgEstDate(anyString());
    }

    @Test
    public void testRemoveOrgEstDate2() {
        when(this.organisationDAOInterface.removeOrgEstDate(anyString())).thenReturn(false);
        assertFalse(this.organisationService.removeOrgEstDate("42"));
        verify(this.organisationDAOInterface).removeOrgEstDate(anyString());
    }
}

