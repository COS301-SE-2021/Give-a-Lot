package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class editEventTitleRequest
{
    private String userEmail;
    private Long eventId;
    private String newTitle;


    public editEventTitleRequest(@JsonProperty("userEmail") String userEmail,
                            @JsonProperty("eventId") Long eventId,
                            @JsonProperty("newTitle") String newTitle)
    {
        this.userEmail = userEmail;
        this.eventId = eventId ;
        this.newTitle = newTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
