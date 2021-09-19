package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class addTimeLineEventRequest
{
    private Long orgId;
    private String eventDate;
    private String eventTitle;
    private String eventShortDescription;

    public addTimeLineEventRequest(@JsonProperty("orgId") Long orgId,
                                   @JsonProperty("eventDate") String eventDate,
                                   @JsonProperty("eventTitle") String eventTitle,
                                   @JsonProperty("eventShortDescription") String eventShortDescription)
    {
        this.orgId = orgId;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
        this.eventShortDescription = eventShortDescription;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventShortDescription() {
        return eventShortDescription;
    }

    public void setEventShortDescription(String eventShortDescription) {
        this.eventShortDescription = eventShortDescription;
    }
}
