package com.GiveaLot.givealot.Login.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Login.repository.LoginRepository;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.User.dataclass.User;
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

    @Test
    public void testLoginGeneralUser() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        LoginResponse actualLoginGeneralUserResult = this.loginServiceImp
                .loginGeneralUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals("1", actualLoginGeneralUserResult.getJWTToken());
        assertTrue(actualLoginGeneralUserResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginGeneralUserResult.getMessage());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginGeneralUser2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("User logged in succesfully");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginGeneralUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginGeneralUser3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword(null);
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.loginServiceImp.loginGeneralUser(null));

    }

    @Test
    public void testLoginGeneralUser4() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword(null);
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getPassword()).thenReturn("foo");
        when(loginRequest.getEmail()).thenReturn(null);
        assertThrows(Exception.class, () -> this.loginServiceImp.loginGeneralUser(loginRequest));
        verify(loginRequest).getEmail();
    }

    @Test
    public void testLoginOrganisation() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findOrganisationByEmail((String) any())).thenReturn(user);
        LoginResponse actualLoginOrganisationResult = this.loginServiceImp
                .loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals("1", actualLoginOrganisationResult.getJWTToken());
        assertTrue(actualLoginOrganisationResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginOrganisationResult.getMessage());
        verify(this.loginRepository, atLeast(1)).findOrganisationByEmail((String) any());
    }

    @Test
    public void testLoginOrganisation2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("User logged in succesfully");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findOrganisationByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.loginServiceImp.loginOrganisation(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        verify(this.loginRepository, atLeast(1)).findOrganisationByEmail((String) any());
    }

    @Test
    public void testLoginOrganisation3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword(null);
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findOrganisationByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.loginServiceImp.loginOrganisation(null));
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
        LoginResponse actualLoginAdminUserResult = this.loginServiceImp
                .loginAdminUser(new LoginRequest("jane.doe@example.org", "iloveyou", "Role"));
        assertEquals("1", actualLoginAdminUserResult.getJWTToken());
        assertTrue(actualLoginAdminUserResult.isSuccess());
        assertEquals("User logged in succesfully", actualLoginAdminUserResult.getMessage());
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testLoginAdminUser2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("User logged in succesfully");
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
    public void testLoginAdminUser3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword(null);
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.loginServiceImp.loginAdminUser(null));
    }

    @Test
    public void testLoginAdminUser4() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword(null);
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.loginRepository.findUserByEmail((String) any())).thenReturn(user);
        LoginRequest loginRequest = mock(LoginRequest.class);
        when(loginRequest.getPassword()).thenReturn("foo");
        when(loginRequest.getEmail()).thenReturn("foo");
        assertThrows(Exception.class, () -> this.loginServiceImp.loginAdminUser(loginRequest));
        verify(this.loginRepository, atLeast(1)).findUserByEmail((String) any());
        verify(loginRequest, atLeast(1)).getEmail();
    }
}

