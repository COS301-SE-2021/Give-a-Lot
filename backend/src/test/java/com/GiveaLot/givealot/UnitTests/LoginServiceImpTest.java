package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Login.repository.LoginRepository;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Login.service.LoginServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LoginServiceImp.class})
@ExtendWith(SpringExtension.class)
public class LoginServiceImpTest {
    @MockBean
    private LoginRepository loginRepository;

    @Autowired
    private LoginServiceImp loginServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testLoginAdmin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivateDate("2020-03-01");
        user1.setAdmin(true);
        user1.setFirstname("Jane");
        user1.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user1);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.login(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginNotAdmin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivateDate("2020-03-01");
        user1.setAdmin(true);
        user1.setFirstname("Jane");
        user1.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user1);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.login(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.loginRepository).findUserByEmail((String) any());
    }

    @Test
    public void testLoginNull() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(null);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivateDate("2020-03-01");
        user1.setAdmin(true);
        user1.setFirstname("Jane");
        user1.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user1);
        assertThrows(Exception.class, () -> this.loginServiceImp.login(null));
    }

    @Test
    public void testLoginGeneralUser() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository).findUserByEmail((String) any());
    }

    @Test
    public void testLoginGeneralUserCorrectToken() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("aac2ecb6661a94209898bcd6066ef479");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        LoginResponse actualLoginGeneralUserResult = this.loginServiceImp
                .loginGeneralUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertNull(actualLoginGeneralUserResult.getId());
        assertTrue(actualLoginGeneralUserResult.isSuccess());
        assertEquals("User logged in successfully", actualLoginGeneralUserResult.getMessage());
        assertEquals("general", actualLoginGeneralUserResult.getJWTToken());
        verify(this.loginRepository).findUserByEmail((String) any());
    }

    @Test
    public void testLoginGeneralUserWrongEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("MD5", "iloveyou", "Role")));
        verify(this.loginRepository).findUserByEmail((String) any());
    }

    @Test
    public void testLoginGeneralUserNoEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest(null, "iloveyou", "Role")));
    }

    @Test
    public void testLoginGeneralUserEmptyEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("", "iloveyou", "Role")));
    }

    @Test
    public void testLoginGeneralUserNullPassword() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("jane.doe@example.org", null, "Role")));
    }

    @Test
    public void testLoginGeneralUserEmptyPassword() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("jane.doe@example.org", "", "Role")));
    }

    @Test
    public void testLoginOrganisation() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    public void testLoginOrganisationCorrectToken() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("aac2ecb6661a94209898bcd6066ef479");
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
        LoginResponse actualLoginOrganisationResult = this.loginServiceImp
                .loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals(123L, actualLoginOrganisationResult.getId().longValue());
        assertTrue(actualLoginOrganisationResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginOrganisationResult.getMessage());
        assertEquals("organisation", actualLoginOrganisationResult.getJWTToken());
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    public void testLoginOrganisationWrongEmail() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest("MD5", "iloveyou", "Role")));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    public void testLoginOrganisationNullEmail() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest(null, "iloveyou", "Role")));
    }

    @Test
    public void testLoginOrganisationEmptyEmail() throws Exception {
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
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest("", "iloveyou", "Role")));
    }

    @Test
    public void testLoginAdminUser() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginAdminUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginAdminUserCorrectToken() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("aac2ecb6661a94209898bcd6066ef479");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        LoginResponse actualLoginAdminUserResult = this.loginServiceImp
                .loginAdminUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertNull(actualLoginAdminUserResult.getId());
        assertTrue(actualLoginAdminUserResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginAdminUserResult.getMessage());
        assertEquals("admin", actualLoginAdminUserResult.getJWTToken());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginAdminUserNotAdmin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginAdminUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginAdminUserWrongEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginAdminUser(new LoginRequest("MD5", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginAdminUserNullEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginAdminUser(new LoginRequest(null, "iloveyou", "Role")));
    }

    @Test
    public void testLoginAdminUserEmptyEmail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.loginServiceImp.loginAdminUser(new LoginRequest("", "iloveyou", "Role")));
    }

    @Test
    public void testGetMd5() {
        assertEquals("0e9c20d9b237aecc65de77a491061be5", this.loginServiceImp.getMd5("27c7cf400229103e00c6d8830029e29b"));
    }
}

