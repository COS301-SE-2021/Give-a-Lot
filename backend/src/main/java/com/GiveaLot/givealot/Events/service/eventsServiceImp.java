package com.GiveaLot.givealot.Events.service;


import com.GiveaLot.givealot.Events.dataclass.Calender;
import com.GiveaLot.givealot.Events.dataclass.Timeline;
import com.GiveaLot.givealot.Events.repository.TimelineRepository;
import com.GiveaLot.givealot.Events.repository.calenderRepository;
import com.GiveaLot.givealot.Events.requests.addCalenderEventRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.requests.editEventTitleRequest;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class eventsServiceImp implements eventsService{

    @Autowired
    calenderRepository calenderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    TimelineRepository timelineRepository;

    @Override
    public generalResponse addCalenderEvent(addCalenderEventRequest request) throws Exception {

        if(request == null)
            throw new Exception("request is null");
        else if(request.getEventDescription() == null) /*optional but still can't be null, rather an empty string*/
            throw new Exception("description is null");
        else if(request.getEventEndDate() == null || request.getEventEndDate().isEmpty())
            throw new Exception("end date is null or empty");
        else if(request.getEventStartDate() == null || request.getEventStartDate().isEmpty())
            throw new Exception("start date is null or empty");
        else if(request.getEventTitle() == null || request.getEventTitle().isEmpty())
            throw new Exception("event title is null or empty");
        else if(request.getEventStartTime() == null || request.getEventStartTime().isEmpty())
            throw new Exception("start time is null or empty");
        else if(request.getEventEndTime() == null || request.getEventEndTime().isEmpty())
            throw new Exception("description is null or empty");
        else if(request.getUserId() == null)
            throw new Exception("User id is null");

        if(userRepository.findUserById(request.getUserId()) == null && organisationRepository.selectOrganisationById(request.getUserId()) != null)
        { }

        else if(userRepository.findUserById(request.getUserId()) != null && organisationRepository.selectOrganisationById(request.getUserId()) == null)
        { }
        else
        {
            throw new Exception("user cannot be identified");
        }

        if(request.getEventDescription().length() > 105)
            throw new Exception("description too long");
        else if(request.getEventTitle().length() > 35)
            throw new Exception("title too long");

        Calender calender = new Calender();
        calender.setDescription(request.getEventDescription());
        calender.setEndDate(request.getEventEndDate());
        calender.setStartDate(request.getEventStartDate());
        calender.setEndTime(request.getEventEndTime());
        calender.setStartTime(request.getEventStartTime());
        calender.setTitle(request.getEventTitle());
        calender.setUserId(request.getUserId());

        calenderRepository.save(calender);

        return new generalResponse("add_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventTitle(editEventTitleRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserId() == null)
            throw new Exception("user id is null");
        else
        {
            if(userRepository.findUserById(request.getUserId()) == null && organisationRepository.selectOrganisationById(request.getEventId()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        calenderRepository.editEventTitle(request.getEventId(), request.getNewTitle());
        return new generalResponse("add_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse addTimelineEvent(addTimeLineEventRequest request) throws Exception {
        if(request == null)
            throw new Exception("request is null");
        else if(request.getEventDate() == null || request.getEventDate().isEmpty())
            throw new Exception("event date is either empty or null");
        else if(request.getEventShortDescription() == null || request.getEventShortDescription().isEmpty())
            throw new Exception("event description is either empty or null");
        else if(request.getEventTitle() == null || request.getEventTitle().isEmpty())
            throw new Exception("event title is either empty or null");
        else if(request.getOrgId() == null)
            throw new Exception("id is not set");

        if(!organisationRepository.existsById(request.getOrgId()))
            throw new Exception("id does not exist");

        Timeline timeline = new Timeline();
        timeline.setOrgId(request.getOrgId());
        timeline.setEventDate(request.getEventDate());
        timeline.setEventTitle(request.getEventShortDescription());

        return new generalResponse("add_time_event_200_OK","success");
    }

    @Override
    public responseJSON getAllEventsForOrganisation(Long orgId) throws Exception
    {
        if(orgId == null)
            throw new Exception("request ID is null");
        else if(!organisationRepository.existsById(orgId))
            throw new Exception("id does not exist");

        List<Timeline> events = timelineRepository.getAllEvents(orgId);

        return new responseJSON("get_time_events_200_OK","success",events);
    }
}
