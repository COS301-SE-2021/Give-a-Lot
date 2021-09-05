package com.GiveaLot.givealot.Events.controller;

import com.GiveaLot.givealot.Events.requests.addCalenderEventRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
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
            return new ResponseEntity<>(new generalResponse("add_calender_event_bad", "failed"), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/get/timeline/{orgId}")
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

    @PostMapping("/add/timeline/")
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
