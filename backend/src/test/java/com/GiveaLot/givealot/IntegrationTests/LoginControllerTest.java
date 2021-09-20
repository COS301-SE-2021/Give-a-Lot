package com.GiveaLot.givealot.IntegrationTests;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Login.controller.LoginController;
import com.GiveaLot.givealot.Login.request.ChangePasswordRequest;
import com.GiveaLot.givealot.Login.request.ForgotPasswordRequest;
import com.GiveaLot.givealot.Login.request.LoginRequest;
import com.GiveaLot.givealot.Login.request.TokenRequest;
import com.GiveaLot.givealot.Login.response.ForgotPasswordResponse;
import com.GiveaLot.givealot.Login.response.LoginResponse;
import com.GiveaLot.givealot.Login.service.LoginServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@ContextConfiguration(classes = {LoginController.class})
@ExtendWith(SpringExtension.class)
class LoginControllerTest {
    @Autowired
    private LoginController loginController;

    @MockBean
    private LoginServiceImp loginServiceImp;

    @Test
    void testLogin() throws Exception {
        when(this.loginServiceImp.login((LoginRequest) any()))
                .thenReturn(new LoginResponse("jane.doe@example.org", true, "Not all who wander are lost", "ABC123", 123L));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/determine")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"Not all who wander are lost\",\"success\":true,\"curr_user_email\":\"jane.doe@example.org\",\"id"
                                        + "\":123,\"jwttoken\":\"ABC123\"}"));
    }

    @Test
    void testLoginFail() throws Exception {
        when(this.loginServiceImp.login((LoginRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/determine")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(401))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"curr_user_email\":\"\",\"id\":null,"
                                        + "\"jwttoken\":null}"));
    }

    @Test
    void testLoginGeneralUser() throws Exception {
        when(this.loginServiceImp.loginGeneralUser((LoginRequest) any()))
                .thenReturn(new LoginResponse("jane.doe@example.org", true, "Not all who wander are lost", "ABC123", 123L));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/general")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"Not all who wander are lost\",\"success\":true,\"curr_user_email\":\"jane.doe@example.org\",\"id"
                                        + "\":123,\"jwttoken\":\"ABC123\"}"));
    }

    @Test
    void testLoginGeneralUserFail() throws Exception {
        when(this.loginServiceImp.loginGeneralUser((LoginRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/general")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"curr_user_email\":\"\",\"id\":null,"
                                        + "\"jwttoken\":null}"));
    }

    @Test
    void testCheckToken() throws Exception {
        when(this.loginServiceImp.checkToken((TokenRequest) any()))
                .thenReturn(new ForgotPasswordResponse(true, "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/check_token")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new TokenRequest("ABC123")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"message\":\"Not all who wander are lost\",\"success\":true}"));
    }

    @Test
    void testCheckTokenFail() throws Exception {
        when(this.loginServiceImp.checkToken((TokenRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/check_token")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new TokenRequest("ABC123")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"tokens do not match\",\"success\":false}"));
    }

    @Test
    void testLoginOrganisation() throws Exception {
        when(this.loginServiceImp.loginOrganisation((LoginRequest) any()))
                .thenReturn(new LoginResponse("jane.doe@example.org", true, "Not all who wander are lost", "ABC123", 123L));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/login_org")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"Not all who wander are lost\",\"success\":true,\"curr_user_email\":\"jane.doe@example.org\",\"id"
                                        + "\":123,\"jwttoken\":\"ABC123\"}"));
    }

    @Test
    void testLoginOrganisationFail() throws Exception {
        when(this.loginServiceImp.loginOrganisation((LoginRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/login_org")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"curr_user_email\":\"\",\"id\":null,"
                                        + "\"jwttoken\":null}"));
    }

    @Test
    void testLoginAdminUser() throws Exception {
        when(this.loginServiceImp.loginAdminUser((LoginRequest) any()))
                .thenReturn(new LoginResponse("jane.doe@example.org", true, "Not all who wander are lost", "ABC123", 123L));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/admin")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"Not all who wander are lost\",\"success\":true,\"curr_user_email\":\"jane.doe@example.org\",\"id"
                                        + "\":123,\"jwttoken\":\"ABC123\"}"));
    }

    @Test
    void testLoginAdminUserFail() throws Exception {
        when(this.loginServiceImp.loginAdminUser((LoginRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/admin")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new LoginRequest("jane.doe@example.org", "iloveyou", "Role")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"message\":\"java.lang.Exception: An error occurred\",\"success\":false,\"curr_user_email\":\"\",\"id\":null,"
                                        + "\"jwttoken\":null}"));
    }

    @Test
    void testForgotPassowrd() throws Exception {
        when(this.loginServiceImp.forgotPassward((ForgotPasswordRequest) any()))
                .thenReturn(new ForgotPasswordResponse(true, "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/forgot_password")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ForgotPasswordRequest("jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"message\":\"Not all who wander are lost\",\"success\":true}"));
    }

    @Test
    void testForgotPassowrdFail() throws Exception {
        when(this.loginServiceImp.forgotPassward((ForgotPasswordRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/forgot_password")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ForgotPasswordRequest("jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"message\":\"token not sent java.lang.Exception: An error occurred\",\"success\":false}"));
    }

    @Test
    void testUpdatePassword() throws Exception {
        when(this.loginServiceImp.changePassword((ChangePasswordRequest) any()))
                .thenReturn(new ForgotPasswordResponse(true, "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/update_password")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ChangePasswordRequest("iloveyou", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"message\":\"Not all who wander are lost\",\"success\":true}"));
    }

    @Test
    void testUpdatePasswordFail() throws Exception {
        when(this.loginServiceImp.changePassword((ChangePasswordRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/login/user/update_password")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new ChangePasswordRequest("iloveyou", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.loginController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"password reset failed\",\"success\":false}"));
    }
}

