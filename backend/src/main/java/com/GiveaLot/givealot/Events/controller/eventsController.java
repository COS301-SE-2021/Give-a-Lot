package com.GiveaLot.givealot.Events.controller;

import com.GiveaLot.givealot.Events.requests.*;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Events.service.eventsServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class eventsController {

    @Autowired
    eventsServiceImp service;

    @PostMapping("/calender/add")
    ResponseEntity<generalResponse> addCalenderEvent(@RequestBody @NonNull addCalenderEventRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.addCalenderEvent(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("add_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/title")
    ResponseEntity<generalResponse> editEventTitle(@RequestBody @NonNull editEventTitleRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventTitle(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/description")
    ResponseEntity<generalResponse> editEventDescription(@RequestBody @NonNull editEventDescription body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventDescription(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/time/start")
    ResponseEntity<generalResponse> editEventStartTime(@RequestBody @NonNull editTimeRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventStartTime(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/time/end")
    ResponseEntity<generalResponse> editEventEndTime(@RequestBody @NonNull editTimeRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventEndTime(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/date/start")
    ResponseEntity<generalResponse> editEventStartDate(@RequestBody @NonNull editEventDateRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventStartDate(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/calender/edit/date/end")
    ResponseEntity<generalResponse> editEventEndDate(@RequestBody @NonNull editEventDateRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.editEventEndDate(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("edit_calender_event_bad", "failed " + e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/timeline/{orgId}") /*timeline*/
    ResponseEntity<responseJSON> getAllEventsForOrganisation(@PathVariable("orgId") Long orgId)
    {
        try
        {
            return new ResponseEntity<>(service.getAllEventsForOrganisation(orgId), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new responseJSON("get_time_events_bad", "failed", null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/calender/{email}") /*timeline*/
    ResponseEntity<responseJSON> getCalenderEvents(@PathVariable("email") String emailAddress)
    {
        try
        {
            return new ResponseEntity<>(service.getCalenderEvents(emailAddress), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new responseJSON("get_cal_events_bad", "failed", null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add/timeline/") /*timeline*/
    ResponseEntity<generalResponse> addTimelineEvent(@RequestBody addTimeLineEventRequest body)
    {
        try
        {
            return new ResponseEntity<>(service.addTimelineEvent(body), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalResponse("add_time_events_bad", "failed"), HttpStatus.BAD_REQUEST);
        }
    }
}
