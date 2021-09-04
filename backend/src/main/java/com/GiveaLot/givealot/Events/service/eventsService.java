package com.GiveaLot.givealot.Events.service;

import com.GiveaLot.givealot.Events.requests.addCalenderEventRequest;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.requests.editEventTitleRequest;
import com.GiveaLot.givealot.Events.response.generalResponse;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;

public interface eventsService {

    generalResponse addCalenderEvent(addCalenderEventRequest request) throws Exception;
    generalResponse editEventTitle(editEventTitleRequest request) throws Exception;
    generalResponse addTimelineEvent(addTimeLineEventRequest request) throws Exception;
    responseJSON getAllEventsForOrganisation(Long orgId) throws Exception;
}
