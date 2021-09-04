package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class editEventTitleRequest
{
    private Long userId;
    private Long eventId;
    private String newTitle;

    public editEventTitleRequest(@JsonProperty("userId") Long userId,
                            @JsonProperty("eventId") Long eventId,
                            @JsonProperty("newTitle") String newTitle)
    {
        this.userId = userId;
        this.eventId = eventId ;
        this.newTitle = newTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
