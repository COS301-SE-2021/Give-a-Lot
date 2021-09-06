package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class editTimeRequest {
    private String userEmail;
    private Long eventId;
    private String newTime;

    public editTimeRequest(@JsonProperty("userEmail") String userEmail,
                                @JsonProperty("eventId") Long eventId,
                                @JsonProperty("newTime") String newTime)
    {
        this.userEmail = userEmail;
        this.eventId = eventId ;
        this.newTime = newTime;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
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
