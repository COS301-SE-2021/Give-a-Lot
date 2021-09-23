package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.sectorsRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import com.GiveaLot.givealot.User.requests.GetUserRequest;
import com.GiveaLot.givealot.User.requests.GetUsersRequest;
import com.GiveaLot.givealot.User.requests.RegisterUserRequest;
import com.GiveaLot.givealot.User.requests.ResetPasswordRequestRequest;
import com.GiveaLot.givealot.User.requests.SetAdminRequest;
import com.GiveaLot.givealot.User.requests.getNumUserPerMonthRequest;
import com.GiveaLot.givealot.User.response.getNumUsersPerMonthResponse;
import com.GiveaLot.givealot.User.response.getNumberofUsersResponse;
import com.GiveaLot.givealot.User.response.userResponseGeneral;

import java.util.ArrayList;
import java.util.List;

import com.GiveaLot.givealot.User.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceImpTest {
    @MockBean
    private BrowseRecommenderRepository browseRecommenderRepository;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private sectorsRepository sectorsRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    void testRegister() throws Exception {
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
    void testRegisterFail() throws Exception {
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
    void testResetPasswordRequest() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        userResponseGeneral actualResetPasswordRequestResult = this.userServiceImp
                .ResetPasswordRequest(new ResetPasswordRequestRequest("jane.doe@example.org", "iloveyou"));
        assertEquals("res_pass_200_ok", actualResetPasswordRequestResult.getCode());
        assertEquals("success", actualResetPasswordRequestResult.getMessage());
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.userRepository).updatePassword((String) any(), (String) any());
    }

    @Test
    void testResetPasswordRequestFail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.updatePassword((String) any(), (String) any())).thenReturn(1);
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        userResponseGeneral actualResetPasswordRequestResult = this.userServiceImp
                .ResetPasswordRequest(new ResetPasswordRequestRequest("MD5", "iloveyou"));
        assertEquals("res_pass_200_ok", actualResetPasswordRequestResult.getCode());
        assertEquals("success", actualResetPasswordRequestResult.getMessage());
        verify(this.userRepository).findUserByEmail((String) any());
        verify(this.userRepository).updatePassword((String) any(), (String) any());
    }

    @Test
    void testSetAdmin() throws Exception {
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
    void testSetAdminFail() throws Exception {
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
    void testGetUser() throws Exception {
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
    void testGetUserFail() throws Exception {
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
    void testGetUsers() throws Exception {
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
    void testGetUsersFail() throws Exception {
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

    @Test
    void testGetNumberOfUser() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findAll()).thenReturn(new ArrayList<User>());
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        getNumberofUsersResponse actualNumberOfUser = this.userServiceImp
                .getNumberOfUser(new GetUsersRequest("Admin User"));
        assertEquals("success", actualNumberOfUser.getMessage());
        assertTrue(actualNumberOfUser.isSuccess());
        assertEquals(0, actualNumberOfUser.getResponse());
        verify(this.userRepository).findAll();
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testGetNumberOfUserFail() throws Exception {
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
                () -> this.userServiceImp.getNumberOfUser(new GetUsersRequest("Admin User")));
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testGetNumPerMonth() throws Exception {
        when(this.userRepository.findAll()).thenReturn(new ArrayList<User>());
        responseJSON actualNumPerMonth = this.userServiceImp
                .getNumPerMonth(new getNumUserPerMonthRequest("jane.doe@example.org"));
        assertEquals("get_num_orgs_per_month", actualNumPerMonth.getCode());
        Object object = actualNumPerMonth.getObject();
        assertTrue(object instanceof getNumUsersPerMonthResponse);
        assertEquals("success", actualNumPerMonth.getMessage());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getApr());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getSept());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getOct());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getNov());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getMay());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getMar());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJun());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJul());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJan());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getFeb());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getDec());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getAug());
        verify(this.userRepository).findAll();
    }

    @Test
    void testGetNumPerMonthFail() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user);
        when(this.userRepository.findAll()).thenReturn(userList);
        responseJSON actualNumPerMonth = this.userServiceImp
                .getNumPerMonth(new getNumUserPerMonthRequest("jane.doe@example.org"));
        assertEquals("get_num_orgs_per_month", actualNumPerMonth.getCode());
        Object object = actualNumPerMonth.getObject();
        assertTrue(object instanceof getNumUsersPerMonthResponse);
        assertEquals("success", actualNumPerMonth.getMessage());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getApr());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getSept());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getOct());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getNov());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getMay());
        assertEquals(1L, ((getNumUsersPerMonthResponse) object).getMar());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJun());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJul());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getJan());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getFeb());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getDec());
        assertEquals(0L, ((getNumUsersPerMonthResponse) object).getAug());
        verify(this.userRepository).findAll();
    }

    @Test
    void testGetMd5() {
        assertEquals("0e9c20d9b237aecc65de77a491061be5", this.userServiceImp.getMd5("27c7cf400229103e00c6d8830029e29b"));
    }
}

