package com.GiveaLot.givealot.Events.service;


import com.GiveaLot.givealot.Events.dataclass.Calender;
import com.GiveaLot.givealot.Events.dataclass.Timeline;
import com.GiveaLot.givealot.Events.repository.TimelineRepository;
import com.GiveaLot.givealot.Events.repository.calenderRepository;
import com.GiveaLot.givealot.Events.requests.*;
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
        else if(request.getUserEmail() == null)
            throw new Exception("User email is null");

        System.out.println("requesting user > id " + request.getUserEmail());

        if(userRepository.findUserByEmail(request.getUserEmail().trim()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail().trim()) != null)
        {

        }

        else if(userRepository.findUserByEmail(request.getUserEmail().trim()) != null && organisationRepository.selectOrganisationByEmail(request.getUserEmail().trim()) == null)
        {
            if(!userRepository.findUserByEmail(request.getUserEmail().trim()).getAdmin())
                throw new Exception("only organisations and admins can use the calender at the moment");
        }
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
        calender.setUserEmail(request.getUserEmail());

        calenderRepository.save(calender);

        return new generalResponse("add_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventTitle(editEventTitleRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewTitle() == null)
            throw new Exception("the new title is null");
        else if(request.getNewTitle().isEmpty())
            throw new Exception("the new title is required");

        if(request.getNewTitle().length() > 35)
            throw new Exception("title too long");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventTitle(request.getEventId(), request.getNewTitle()) != 1)
            throw new Exception("title not changed");

        return new generalResponse("adit_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventDescription(editEventDescription request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewDescription() == null)
            throw new Exception("the new description is null");
        else if(request.getNewDescription().isEmpty())
            throw new Exception("the new description is required");


        if(request.getNewDescription().length() > 105)
            throw new Exception("description too long");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventDescription(request.getEventId(), request.getNewDescription()) != 1)
            throw new Exception("description not changed");

        return new generalResponse("edit_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventStartTime(editTimeRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewTime() == null)
            throw new Exception("time is null");
        else if(request.getNewTime().isEmpty())
            throw new Exception("time is required");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventStartTime(request.getEventId(), request.getNewTime()) != 1)
            throw new Exception("time not changed");

        return new generalResponse("edit_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventEndTime(editTimeRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewTime() == null)
            throw new Exception("time is null");
        else if(request.getNewTime().isEmpty())
            throw new Exception("time is required");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventEndTime(request.getEventId(), request.getNewTime()) != 1)
            throw new Exception("time not changed");

        return new generalResponse("edit_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventStartDate(editEventDateRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewDate() == null)
            throw new Exception("date is null");
        else if(request.getNewDate().isEmpty())
            throw new Exception("date is required");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventStartDate(request.getEventId(), request.getNewDate()) != 1)
            throw new Exception("date not changed");

        return new generalResponse("edit_cal_event_200_OK", "success");
    }

    @Override
    public generalResponse editEventEndDate(editEventDateRequest request) throws Exception {
        if(request == null)
            throw new Exception("edit event title request is null");
        if(request.getEventId() == null)
            throw new Exception("event id is null");
        else if(request.getUserEmail() == null)
            throw new Exception("user email is null");
        else if(request.getNewDate() == null)
            throw new Exception("date is null");
        else if(request.getNewDate().isEmpty())
            throw new Exception("date is required");

        else
        {
            if(userRepository.findUserByEmail(request.getUserEmail()) == null && organisationRepository.selectOrganisationByEmail(request.getUserEmail()) == null)
                throw new Exception("user not found");
            else if(!calenderRepository.existsById(request.getEventId()))
                throw new Exception("report cannot be identified");
        }

        if(calenderRepository.editEventEndDate(request.getEventId(), request.getNewDate()) != 1)
            throw new Exception("date not changed");

        return new generalResponse("edit_cal_event_200_OK", "success");
    }

    @Override
    public responseJSON getCalenderEvents(String userEmail) throws Exception
    {
        if(userEmail == null)
            throw new Exception("provided email is invalid");
        else if(userEmail.isEmpty())
            throw new Exception("user email address is required");
        else if(!userEmail.contains("@"))
            throw new Exception("invalid email address");
        else
        {
            if(userRepository.findUserByEmail(userEmail) == null)
            {
                if(organisationRepository.selectOrganisationByEmail(userEmail) == null)
                    throw new Exception("this email is not registered");
            }
        }

        List<Calender> res = calenderRepository.getCalenderEvents(userEmail);

        return new responseJSON("get_cal_events_200_OK", "success", res);
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
        timelineRepository.save(timeline);

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
