package com.GiveaLot.givealot.User.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import com.GiveaLot.givealot.User.requests.GetUserRequest;
import com.GiveaLot.givealot.User.requests.GetUsersRequest;
import com.GiveaLot.givealot.User.requests.RegisterUserRequest;
import com.GiveaLot.givealot.User.requests.ResetPasswordRequestRequest;
import com.GiveaLot.givealot.User.requests.SetAdminRequest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImp.class})
@ExtendWith(SpringExtension.class)
public class UserServiceImpTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.userServiceImp.Register(new RegisterUserRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    public void testRegister2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.userServiceImp.Register(new RegisterUserRequest("Jane", "Doe", null, "iloveyou")));
    }

    @Test
    public void testRegister3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.userServiceImp.Register(null));
    }

    @Test
    public void testRegister4() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        RegisterUserRequest registerUserRequest = mock(RegisterUserRequest.class);
        when(registerUserRequest.getEmail()).thenReturn("foo");
        assertThrows(Exception.class, () -> this.userServiceImp.Register(registerUserRequest));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(registerUserRequest, atLeast(1)).getEmail();
    }

    @Test
    public void testResetPasswordRequest() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertTrue(
                this.userServiceImp.ResetPasswordRequest(new ResetPasswordRequestRequest("jane.doe@example.org", "iloveyou")));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.userRepository).updatePassword((String) any(), (String) any());
    }

    @Test
    public void testResetPasswordRequest2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.userServiceImp.ResetPasswordRequest(null));
    }

    @Test
    public void testResetPasswordRequest3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        ResetPasswordRequestRequest resetPasswordRequestRequest = mock(ResetPasswordRequestRequest.class);
        when(resetPasswordRequestRequest.getNewPassword()).thenReturn("foo");
        when(resetPasswordRequestRequest.getEmail()).thenReturn("foo");
        assertTrue(this.userServiceImp.ResetPasswordRequest(resetPasswordRequestRequest));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.userRepository).updatePassword((String) any(), (String) any());
        verify(resetPasswordRequestRequest).getEmail();
        verify(resetPasswordRequestRequest).getNewPassword();
    }

    @Test
    public void testSetAdmin() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertTrue(this.userServiceImp.SetAdmin(new SetAdminRequest("jane.doe@example.org", "jane.doe@example.org")));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.userRepository).updateAdmin((String) any(), anyBoolean());
    }

    @Test
    public void testSetAdmin2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(0);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.userServiceImp.SetAdmin(new SetAdminRequest("jane.doe@example.org", "jane.doe@example.org")));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.userRepository).updateAdmin((String) any(), anyBoolean());
    }

    @Test
    public void testSetAdmin3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.userServiceImp.SetAdmin(new SetAdminRequest("jane.doe@example.org", "jane.doe@example.org")));
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    public void testSetAdmin4() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(null);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.userServiceImp.SetAdmin(null));
    }

    @Test
    public void testSetAdmin5() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        SetAdminRequest setAdminRequest = mock(SetAdminRequest.class);
        when(setAdminRequest.getGeneralUserEmail()).thenReturn("foo");
        when(setAdminRequest.getAdminEmail()).thenReturn("foo");
        assertTrue(this.userServiceImp.SetAdmin(setAdminRequest));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.userRepository).updateAdmin((String) any(), anyBoolean());
        verify(setAdminRequest, atLeast(1)).getAdminEmail();
        verify(setAdminRequest, atLeast(1)).getGeneralUserEmail();
    }

    @Test
    public void testSetAdmin6() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        SetAdminRequest setAdminRequest = mock(SetAdminRequest.class);
        when(setAdminRequest.getGeneralUserEmail()).thenReturn(null);
        when(setAdminRequest.getAdminEmail()).thenReturn("foo");
        assertThrows(Exception.class, () -> this.userServiceImp.SetAdmin(setAdminRequest));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(setAdminRequest, atLeast(1)).getAdminEmail();
        verify(setAdminRequest).getGeneralUserEmail();
    }

    @Test
    public void testSetAdmin7() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updateAdmin((String) any(), anyBoolean())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        SetAdminRequest setAdminRequest = mock(SetAdminRequest.class);
        when(setAdminRequest.getGeneralUserEmail()).thenReturn("foo");
        when(setAdminRequest.getAdminEmail()).thenReturn(null);
        assertThrows(Exception.class, () -> this.userServiceImp.SetAdmin(setAdminRequest));
        verify(setAdminRequest).getAdminEmail();
    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertSame(user, this.userServiceImp.getUser(new GetUserRequest("jane.doe@example.org", "Admin User")));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
    }

    @Test
    public void testGetUser2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(UserNotAuthorisedException.class,
                () -> this.userServiceImp.getUser(new GetUserRequest("jane.doe@example.org", "Admin User")));
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    public void testGetUser3() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(null);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.userServiceImp.getUser(null));
    }

    @Test
    public void testGetUser4() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        GetUserRequest getUserRequest = mock(GetUserRequest.class);
        when(getUserRequest.getGeneralUserEmail()).thenReturn("foo");
        when(getUserRequest.getAdminUser()).thenReturn("foo");
        assertSame(user, this.userServiceImp.getUser(getUserRequest));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
        verify(getUserRequest, atLeast(1)).getAdminUser();
        verify(getUserRequest, atLeast(1)).getGeneralUserEmail();
    }

    @Test
    public void testGetUser5() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        GetUserRequest getUserRequest = mock(GetUserRequest.class);
        when(getUserRequest.getGeneralUserEmail()).thenReturn(null);
        when(getUserRequest.getAdminUser()).thenReturn("foo");
        assertThrows(Exception.class, () -> this.userServiceImp.getUser(getUserRequest));
        verify(this.userRepository).findUserByEmail((String) any());
        verify(getUserRequest, atLeast(1)).getAdminUser();
        verify(getUserRequest).getGeneralUserEmail();
    }

    @Test
    public void testGetUser6() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        GetUserRequest getUserRequest = mock(GetUserRequest.class);
        when(getUserRequest.getGeneralUserEmail()).thenReturn("foo");
        when(getUserRequest.getAdminUser()).thenReturn(null);
        assertThrows(Exception.class, () -> this.userServiceImp.getUser(getUserRequest));
        verify(getUserRequest).getAdminUser();
    }

    @Test
    public void testGetUsers() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        ArrayList<User> userList = new ArrayList<User>();
        when(this.userRepository.findAll()).thenReturn(userList);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        List<User> actualGetUsersResult = this.userServiceImp.GetUsers(new GetUsersRequest("Admin User"));
        assertSame(userList, actualGetUsersResult);
        assertTrue(actualGetUsersResult.isEmpty());
        verify(this.userRepository).findAll();
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    public void testGetUsers2() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(false);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findAll()).thenReturn(new ArrayList<User>());
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(UserNotAuthorisedException.class,
                () -> this.userServiceImp.GetUsers(new GetUsersRequest("Admin User")));
        verify(this.userRepository).findUserByEmail((String) any());
    }
}

