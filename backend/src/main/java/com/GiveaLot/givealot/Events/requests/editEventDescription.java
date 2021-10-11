package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class editEventDescription {
    private String userEmail;
    private Long eventId;
    private String newDescription;


    public editEventDescription(@JsonProperty("userEmail") String userEmail,
                                 @JsonProperty("eventId") Long eventId,
                                 @JsonProperty("newDescription") String newDescription)
    {
        this.userEmail = userEmail;
        this.eventId = eventId ;
        this.newDescription = newDescription;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
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
