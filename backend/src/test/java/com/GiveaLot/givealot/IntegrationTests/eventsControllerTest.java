package com.GiveaLot.givealot.IntegrationTests;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Events.controller.eventsController;
import com.GiveaLot.givealot.Events.requests.addCalenderEventRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.requests.editEventDateRequest;
import com.GiveaLot.givealot.Events.requests.editEventDescription;
import com.GiveaLot.givealot.Events.requests.editEventTitleRequest;
import com.GiveaLot.givealot.Events.requests.editTimeRequest;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Events.service.eventsServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
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

@ContextConfiguration(classes = {eventsController.class})
@ExtendWith(SpringExtension.class)
class eventsControllerTest {
    @MockBean
    private responseJSON responseJSON;

    @Autowired
    private eventsController eventsController;

    @MockBean
    private eventsServiceImp eventsServiceImp;

    @Test
    void testAddCalenderEvent() throws Exception {
        when(this.eventsServiceImp.addCalenderEvent((addCalenderEventRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/add")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new addCalenderEventRequest("Dr", "Event Description",
                        "Event Start Time", "Event End Time", "2020-03-01", "2020-03-01", "jane.doe@example.org")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddCalenderEventFail() throws Exception {
        when(this.eventsServiceImp.addCalenderEvent((addCalenderEventRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/add")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new addCalenderEventRequest("Dr", "Event Description",
                        "Event Start Time", "Event End Time", "2020-03-01", "2020-03-01", "jane.doe@example.org")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"add_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventTitle() throws Exception {
        when(this.eventsServiceImp.editEventTitle((editEventTitleRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/title")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventTitleRequest("jane.doe@example.org", 123L, "Dr")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventTitleFail() throws Exception {
        when(this.eventsServiceImp.editEventTitle((editEventTitleRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/title")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventTitleRequest("jane.doe@example.org", 123L, "Dr")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventDescription() throws Exception {
        when(this.eventsServiceImp.editEventDescription((editEventDescription) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/description")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new editEventDescription("jane.doe@example.org", 123L, "New Description")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventDescriptionFail() throws Exception {
        when(this.eventsServiceImp.editEventDescription((editEventDescription) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/description")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(
                objectMapper.writeValueAsString(new editEventDescription("jane.doe@example.org", 123L, "New Description")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventStartTime() throws Exception {
        when(this.eventsServiceImp.editEventStartTime((editTimeRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/time/start")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventStartTimeFail() throws Exception {
        when(this.eventsServiceImp.editEventStartTime((editTimeRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/time/start")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventEndTime() throws Exception {
        when(this.eventsServiceImp.editEventEndTime((editTimeRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/time/end")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventEndTimeFail() throws Exception {
        when(this.eventsServiceImp.editEventEndTime((editTimeRequest) any())).thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/time/end")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventStartDate() throws Exception {
        when(this.eventsServiceImp.editEventStartDate((editEventDateRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/date/start")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventStartDateFail() throws Exception {
        when(this.eventsServiceImp.editEventStartDate((editEventDateRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/date/start")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testEditEventEndDate() throws Exception {
        when(this.eventsServiceImp.editEventEndDate((editEventDateRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/date/end")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testEditEventEndDateFail() throws Exception {
        when(this.eventsServiceImp.editEventEndDate((editEventDateRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/calender/edit/date/end")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content(objectMapper.writeValueAsString(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"code\":\"edit_calender_event_bad\",\"message\":\"failed java.lang.Exception: An error occurred\"}"));
    }

    @Test
    void testAddTimelineEvent() throws Exception {
        when(this.eventsServiceImp.addTimelineEvent((addTimeLineEventRequest) any()))
                .thenReturn(new generalResponse("Code", "Not all who wander are lost"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/add/timeline/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new addTimeLineEventRequest(123L, "2020-03-01", "Dr", "Event Short Description")));
        MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"code\":\"Code\",\"message\":\"Not all who wander are lost\"}"));
    }

    @Test
    void testAddTimelineEventFail() throws Exception {
        when(this.eventsServiceImp.addTimelineEvent((addTimeLineEventRequest) any()))
                .thenThrow(new Exception("An error occurred"));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/event/add/timeline/")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new addTimeLineEventRequest(123L, "2020-03-01", "Dr", "Event Short Description")));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.eventsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"code\":\"add_time_events_bad\",\"message\":\"failed\"}"));
    }
}

