package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Login.model.PasswordResetToken;
import com.GiveaLot.givealot.Login.repository.LoginRepository;
import com.GiveaLot.givealot.Login.repository.PasswordResetRepository;
import com.GiveaLot.givealot.Login.request.ChangePasswordRequest;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.request.TokenRequest;
import com.GiveaLot.givealot.Login.response.ForgotPasswordResponse;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Login.service.LoginServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LoginServiceImpTest {
    @MockBean
    private LoginRepository loginRepository;

    @Autowired
    private LoginServiceImp loginServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private PasswordResetRepository passwordResetRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testLogin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivateDate("2020-03-01");
        user1.setAdmin(true);
        user1.setFirstname("Jane");
        user1.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user1);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.login(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testLoginFail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("aac2ecb6661a94209898bcd6066ef479");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setPassword("iloveyou");
        user1.setActivateDate("2020-03-01");
        user1.setAdmin(true);
        user1.setFirstname("Jane");
        user1.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user1);
        LoginResponse actualLoginResult = this.loginServiceImp
                .login(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals("jane.doe@example.org", actualLoginResult.getCurr_user_email());
        assertTrue(actualLoginResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginResult.getMessage());
        assertEquals("admin", actualLoginResult.getJWTToken());
        assertNull(actualLoginResult.getId());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }


    @Test
    void testLoginGeneralUser() throws Exception {
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
    void testLoginGeneralUserFail() throws Exception {
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
        assertEquals("jane.doe@example.org", actualLoginGeneralUserResult.getCurr_user_email());
        assertTrue(actualLoginGeneralUserResult.isSuccess());
        assertEquals("User logged in successfully", actualLoginGeneralUserResult.getMessage());
        assertEquals("general", actualLoginGeneralUserResult.getJWTToken());
        assertNull(actualLoginGeneralUserResult.getId());
        verify(this.loginRepository).findUserByEmail((String) any());
    }

    @Test
    void testLoginOrganisation() throws Exception {
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
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    void testLoginOrganisationFail() throws Exception {
        Organisations organisations = new Organisations();
        organisations.setOrgId(123L);
        organisations.setPassword("aac2ecb6661a94209898bcd6066ef479");
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
        LoginResponse actualLoginOrganisationResult = this.loginServiceImp
                .loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals("jane.doe@example.org", actualLoginOrganisationResult.getCurr_user_email());
        assertTrue(actualLoginOrganisationResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginOrganisationResult.getMessage());
        assertEquals("organisation", actualLoginOrganisationResult.getJWTToken());
        assertEquals(123L, actualLoginOrganisationResult.getId().longValue());
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    void testLoginAdminUser() throws Exception {
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
    void testLoginAdminUserFail() throws Exception {
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
        assertEquals("jane.doe@example.org", actualLoginAdminUserResult.getCurr_user_email());
        assertTrue(actualLoginAdminUserResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginAdminUserResult.getMessage());
        assertEquals("admin", actualLoginAdminUserResult.getJWTToken());
        assertNull(actualLoginAdminUserResult.getId());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    void testForgotPassward() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUserEmail("jane.doe@example.org");
        passwordResetToken.setId(123L);
        passwordResetToken.setToken("ABC123");
        when(this.passwordResetRepository.save((PasswordResetToken) any())).thenReturn(passwordResetToken);

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
        assertThrows(Exception.class, () -> this.loginServiceImp.forgotPassward(null));
    }

    @Test
    void testCheckToken() throws Exception {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUserEmail("jane.doe@example.org");
        passwordResetToken.setId(123L);
        passwordResetToken.setToken("ABC123");
        when(this.passwordResetRepository.findToken((String) any())).thenReturn(passwordResetToken);
        ForgotPasswordResponse actualCheckTokenResult = this.loginServiceImp.checkToken(new TokenRequest("ABC123"));
        assertEquals("token matched", actualCheckTokenResult.getMessage());
        assertTrue(actualCheckTokenResult.isSuccess());
        verify(this.passwordResetRepository).findToken((String) any());
    }

    @Test
    void testCheckTokenFail() throws Exception {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUserEmail("jane.doe@example.org");
        passwordResetToken.setId(123L);
        passwordResetToken.setToken("ABC123");
        when(this.passwordResetRepository.findToken((String) any())).thenReturn(passwordResetToken);
        assertThrows(Exception.class, () -> this.loginServiceImp.checkToken(null));
    }

    @Test
    void testChangePassword() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

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
        when(this.organisationRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        ForgotPasswordResponse actualChangePasswordResult = this.loginServiceImp
                .changePassword(new ChangePasswordRequest("iloveyou", "jane.doe@example.org"));
        assertEquals("password reset successful", actualChangePasswordResult.getMessage());
        assertTrue(actualChangePasswordResult.isSuccess());
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
        verify(this.organisationRepository).updatePassword((String) any(), (String) any());
    }

    @Test
    void testChangePasswordFail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);

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
        when(this.organisationRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        ForgotPasswordResponse actualChangePasswordResult = this.loginServiceImp
                .changePassword(new ChangePasswordRequest("iloveyou", "MD5"));
        assertEquals("password reset successful", actualChangePasswordResult.getMessage());
        assertTrue(actualChangePasswordResult.isSuccess());
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
        verify(this.organisationRepository).updatePassword((String) any(), (String) any());
    }

    @Test
    void testGetMd5() {
        assertEquals("0e9c20d9b237aecc65de77a491061be5", this.loginServiceImp.getMd5("27c7cf400229103e00c6d8830029e29b"));
    }
}

