package com.GiveaLot.givealot.Events.service;

import com.GiveaLot.givealot.Events.requests.*;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;

public interface eventsService {
    generalResponse addCalenderEvent(addCalenderEventRequest request) throws Exception;
    generalResponse editEventTitle(editEventTitleRequest request) throws Exception;
    generalResponse addTimelineEvent(addTimeLineEventRequest request) throws Exception;
    responseJSON getAllEventsForOrganisation(Long orgId) throws Exception;
    generalResponse editEventDescription(editEventDescription request) throws Exception;
    generalResponse editEventStartTime(editTimeRequest request) throws Exception;
    generalResponse editEventEndTime(editTimeRequest request) throws Exception;
    generalResponse editEventStartDate(editEventDateRequest request) throws Exception;
    generalResponse editEventEndDate(editEventDateRequest request) throws Exception;
    responseJSON getCalenderEvents(String userEmail) throws Exception;

}
