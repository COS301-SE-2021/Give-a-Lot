package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class editEventDateRequest {
    private String userEmail;
    private Long eventId;
    private String newDate;

    public editEventDateRequest(@JsonProperty("userEmail") String userEmail,
                           @JsonProperty("eventId") Long eventId,
                           @JsonProperty("newDate") String newDate)
    {
        this.userEmail = userEmail;
        this.eventId = eventId ;
        this.newDate = newDate;
    }

    public String getNewDate() {
        return newDate;
    }

    public void setNewDate(String newDate) {
        this.newDate = newDate;
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
