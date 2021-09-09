/*
package com.GiveaLot.givealot.Organisation.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.organisationPointsRepository;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrganisationServiceImpTest {
    @MockBean
    private CertificateRepository certificateRepository;

    @MockBean
    private OrganisationInfoRepository organisationInfoRepository;

    @MockBean
    private organisationPointsRepository organisationPointsRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationServiceImp organisationServiceImp;

    @MockBean
    private UserRepository userRepository;

*/
/*    @Test
    public void testAddOrganisation() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }*//*


    @Test
    public void testAddOrganisation2() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword(null);
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation3() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber(null);
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation4() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail(null);
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation5() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector(null);
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation6() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson(null);
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation7() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan(null);
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation8() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription(null);
        organisations1.setOrgName("Org Name");
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }

    @Test
    public void testAddOrganisation9() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);

        Organisations organisations1 = new Organisations();
        organisations1.setOrgId(123L);
        organisations1.setPassword("iloveyou");
        organisations1.setContactNumber("Contact Number");
        organisations1.setOrgEmail("jane.doe@example.org");
        organisations1.setStatus("Status");
        organisations1.setOrgSector("Org Sector");
        organisations1.setContactPerson("Contact Person");
        organisations1.setSlogan("Slogan");
        organisations1.setOrgDescription("Org Description");
        organisations1.setOrgName(null);
        organisations1.setDirectory("/tmp");
        assertThrows(Exception.class, () -> this.organisationServiceImp.addOrganisation(organisations1));
    }
}

*/
