package com.GiveaLot.givealot.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.GiveaLot.givealot.Events.dataclass.Calender;
import com.GiveaLot.givealot.Events.dataclass.Timeline;
import com.GiveaLot.givealot.Events.repository.TimelineRepository;
import com.GiveaLot.givealot.Events.repository.calenderRepository;
import com.GiveaLot.givealot.Events.requests.addCalenderEventRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.requests.editEventDateRequest;
import com.GiveaLot.givealot.Events.requests.editEventDescription;
import com.GiveaLot.givealot.Events.requests.editEventTitleRequest;
import com.GiveaLot.givealot.Events.requests.editTimeRequest;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Events.service.eventsServiceImp;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {eventsServiceImp.class})
@ExtendWith(SpringExtension.class)
class eventsServiceImpTest {
    @MockBean
    private calenderRepository calenderRepository;

    @Autowired
    private eventsServiceImp eventsServiceImp;

    @MockBean
    private OrganisationRepository organisationRepository;

    @MockBean
    private TimelineRepository timelineRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testAddCalenderEvent() throws Exception {
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
        when(this.organisationRepository.selectOrganisationByEmail((String) any())).thenReturn(organisations);
        assertThrows(Exception.class,
                () -> this.eventsServiceImp.addCalenderEvent(new addCalenderEventRequest("Dr", "Event Description",
                        "Event Start Time", "Event End Time", "2020-03-01", "2020-03-01", "jane.doe@example.org")));
        verify(this.userRepository, atLeast(1)).findUserByEmail((String) any());
        verify(this.organisationRepository).selectOrganisationByEmail((String) any());
    }

    @Test
    void testEditEventTitle() throws Exception {
        when(this.calenderRepository.editEventTitle((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventTitleResult = this.eventsServiceImp
                .editEventTitle(new editEventTitleRequest("jane.doe@example.org", 123L, "Dr"));
        assertEquals("adit_cal_event_200_OK", actualEditEventTitleResult.getCode());
        assertEquals("success", actualEditEventTitleResult.getMessage());
        verify(this.calenderRepository).editEventTitle((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventTitleFail() throws Exception {
        when(this.calenderRepository.editEventTitle((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.eventsServiceImp.editEventTitle(new editEventTitleRequest("jane.doe@example.org", 123L, "Dr")));
        verify(this.calenderRepository).editEventTitle((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventDescription() throws Exception {
        when(this.calenderRepository.editEventDescription((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventDescriptionResult = this.eventsServiceImp
                .editEventDescription(new editEventDescription("jane.doe@example.org", 123L, "New Description"));
        assertEquals("edit_cal_event_200_OK", actualEditEventDescriptionResult.getCode());
        assertEquals("success", actualEditEventDescriptionResult.getMessage());
        verify(this.calenderRepository).editEventDescription((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventDescriptionFail() throws Exception {
        when(this.calenderRepository.editEventDescription((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.eventsServiceImp
                .editEventDescription(new editEventDescription("jane.doe@example.org", 123L, "New Description")));
        verify(this.calenderRepository).editEventDescription((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventStartTime() throws Exception {
        when(this.calenderRepository.editEventStartTime((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventStartTimeResult = this.eventsServiceImp
                .editEventStartTime(new editTimeRequest("jane.doe@example.org", 123L, "New Time"));
        assertEquals("edit_cal_event_200_OK", actualEditEventStartTimeResult.getCode());
        assertEquals("success", actualEditEventStartTimeResult.getMessage());
        verify(this.calenderRepository).editEventStartTime((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventStartTimeFail() throws Exception {
        when(this.calenderRepository.editEventStartTime((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.eventsServiceImp.editEventStartTime(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        verify(this.calenderRepository).editEventStartTime((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventEndTime() throws Exception {
        when(this.calenderRepository.editEventEndTime((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventEndTimeResult = this.eventsServiceImp
                .editEventEndTime(new editTimeRequest("jane.doe@example.org", 123L, "New Time"));
        assertEquals("edit_cal_event_200_OK", actualEditEventEndTimeResult.getCode());
        assertEquals("success", actualEditEventEndTimeResult.getMessage());
        verify(this.calenderRepository).editEventEndTime((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventEndTimeFail() throws Exception {
        when(this.calenderRepository.editEventEndTime((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class,
                () -> this.eventsServiceImp.editEventEndTime(new editTimeRequest("jane.doe@example.org", 123L, "New Time")));
        verify(this.calenderRepository).editEventEndTime((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventStartDate() throws Exception {
        when(this.calenderRepository.editEventStartDate((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventStartDateResult = this.eventsServiceImp
                .editEventStartDate(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01"));
        assertEquals("edit_cal_event_200_OK", actualEditEventStartDateResult.getCode());
        assertEquals("success", actualEditEventStartDateResult.getMessage());
        verify(this.calenderRepository).editEventStartDate((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventStartDateFail() throws Exception {
        when(this.calenderRepository.editEventStartDate((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.eventsServiceImp
                .editEventStartDate(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        verify(this.calenderRepository).editEventStartDate((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventEndDate() throws Exception {
        when(this.calenderRepository.editEventEndDate((Long) any(), (String) any())).thenReturn(1);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        generalResponse actualEditEventEndDateResult = this.eventsServiceImp
                .editEventEndDate(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01"));
        assertEquals("edit_cal_event_200_OK", actualEditEventEndDateResult.getCode());
        assertEquals("success", actualEditEventEndDateResult.getMessage());
        verify(this.calenderRepository).editEventEndDate((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testEditEventEndDateFail() throws Exception {
        when(this.calenderRepository.editEventEndDate((Long) any(), (String) any())).thenReturn(0);
        when(this.calenderRepository.existsById((Long) any())).thenReturn(true);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setPassword("iloveyou");
        user.setActivateDate("2020-03-01");
        user.setAdmin(true);
        user.setFirstname("Jane");
        user.setLastname("Doe");
        when(this.userRepository.findUserByEmail((String) any())).thenReturn(user);
        assertThrows(Exception.class, () -> this.eventsServiceImp
                .editEventEndDate(new editEventDateRequest("jane.doe@example.org", 123L, "2020-03-01")));
        verify(this.calenderRepository).editEventEndDate((Long) any(), (String) any());
        verify(this.calenderRepository).existsById((Long) any());
        verify(this.userRepository).findUserByEmail((String) any());
    }

    @Test
    void testGetAllEventsForOrganisation() throws Exception {
        when(this.timelineRepository.getAllEvents((Long) any())).thenReturn(new ArrayList<Timeline>());
        when(this.organisationRepository.existsById((Long) any())).thenReturn(true);
        responseJSON actualAllEventsForOrganisation = this.eventsServiceImp.getAllEventsForOrganisation(123L);
        assertEquals("get_time_events_200_OK", actualAllEventsForOrganisation.getCode());
        assertTrue(((Collection<Object>) actualAllEventsForOrganisation.getObject()).isEmpty());
        assertEquals("success", actualAllEventsForOrganisation.getMessage());
        verify(this.timelineRepository).getAllEvents((Long) any());
        verify(this.organisationRepository).existsById((Long) any());
    }

    @Test
    void testGetAllEventsForOrganisationFail() throws Exception {
        when(this.timelineRepository.getAllEvents((Long) any())).thenReturn(new ArrayList<Timeline>());
        when(this.organisationRepository.existsById((Long) any())).thenReturn(false);
        assertThrows(Exception.class, () -> this.eventsServiceImp.getAllEventsForOrganisation(123L));
        verify(this.organisationRepository).existsById((Long) any());
    }

}

