package com.GiveaLot.givealot.IntegrationTests;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.controller.UserController;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.requests.GetUserRequest;
import com.GiveaLot.givealot.User.requests.GetUsersRequest;
import com.GiveaLot.givealot.User.requests.RegisterUserRequest;
import com.GiveaLot.givealot.User.requests.ResetPasswordRequestRequest;
import com.GiveaLot.givealot.User.requests.SetAdminRequest;
import com.GiveaLot.givealot.User.requests.getNumUserPerMonthRequest;
import com.GiveaLot.givealot.User.response.getNumberofUsersResponse;
import com.GiveaLot.givealot.User.response.userResponseGeneral;
import com.GiveaLot.givealot.User.service.UserServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @MockBean
    private responseJSON responseJSON;

    @Autowired
    private UserController userController;

    @MockBean
    private UserServiceImp userServiceImp;

    @Test
    void testAddUser() throws Exception {
        when(this.userServiceImp.Register((RegisterUserRequest) any()))
                .thenReturn(new userResponseGeneral("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/register/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new RegisterUserRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddUserFail() throws Exception {
        when(this.userServiceImp.Register((RegisterUserRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/register/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new RegisterUserRequest("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"add_usr_bad_500\",\"message\":\"failed :java.lang.Exception: An error occurred\"}"));
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
        when(this.userServiceImp.getUser((GetUserRequest) any())).thenReturn(user);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUserRequest("jane.doe@example.org", "Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"successful\",\"success\":true,\"response\":{\"id\":null,\"firstname\":\"Jane\",\"lastname\":\"Doe\","
                                        + "\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\",\"activateDate\":\"2020-03-01\",\"admin\":true},"
                                        + "\"jwttoken\":\"1\"}"));
    }

    @Test
    void testGetUserFail() throws Exception {
        when(this.userServiceImp.getUser((GetUserRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUserRequest("jane.doe@example.org", "Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"response\":null,\"jwttoken\":null}"));
    }

    @Test
    void testGetNumOrganisationsPerMonth() throws Exception {
        when(this.userServiceImp.getNumPerMonth((getNumUserPerMonthRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/num_users/per_month")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new getNumUserPerMonthRequest("jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"get_num_user_per_month_500_bad\",\"message\":\"failed: java.lang.Exception: An error occurred\","
                                        + "\"object\":null}"));
    }

    @Test
    void testGetNumberOfUsers() throws Exception {
        when(this.userServiceImp.getNumberOfUser((GetUsersRequest) any()))
                .thenReturn(new getNumberofUsersResponse(true, "Not all who wander are lost", 1));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/num_user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUsersRequest("Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"Not all who wander are lost\",\"success\":true,\"response\":1}"));
    }

    @Test
    void testGetNumberOfUsersFail() throws Exception {
        when(this.userServiceImp.getNumberOfUser((GetUsersRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/num_user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUsersRequest("Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"get_num_notifications_500_bad\",\"success\":false,\"response\":0}"));
    }

    @Test
    void testGetUsers() throws Exception {
        when(this.userServiceImp.GetUsers((GetUsersRequest) any())).thenReturn(new ArrayList<User>());
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/users")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUsersRequest("Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"successful\",\"success\":true,\"response\":[],\"jwttoken\":\"1\"}"));
    }

    @Test
    void testGetUsersFail() throws Exception {
        when(this.userServiceImp.GetUsers((GetUsersRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/get/users")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new GetUsersRequest("Admin User")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"response\":null,\"jwttoken\":null}"));
    }

    @Test
    void testResetPassword() throws Exception {
        when(this.userServiceImp.ResetPasswordRequest((ResetPasswordRequestRequest) any()))
                .thenReturn(new userResponseGeneral("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/resetPassword/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ResetPasswordRequestRequest("jane.doe@example.org", "iloveyou")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testResetPasswordFail() throws Exception {
        when(this.userServiceImp.ResetPasswordRequest((ResetPasswordRequestRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/resetPassword/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ResetPasswordRequestRequest("jane.doe@example.org", "iloveyou")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"res_pass_bad_500\",\"message\":\"failed: java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testSetAdmin() throws Exception {
        when(this.userServiceImp.SetAdmin((SetAdminRequest) any()))
                .thenReturn(new userResponseGeneral("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/setadmin/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new SetAdminRequest("jane.doe@example.org", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testSetAdminFail() throws Exception {
        when(this.userServiceImp.SetAdmin((SetAdminRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/user/setadmin/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new SetAdminRequest("jane.doe@example.org", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"code\":\"set_ad_500_bad\",\"message\":\"Failed: java.lang.Exception: An error occurred\"}"));
    }
}

