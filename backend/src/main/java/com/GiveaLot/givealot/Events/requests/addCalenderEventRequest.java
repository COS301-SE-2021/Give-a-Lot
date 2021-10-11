package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class addCalenderEventRequest
{
    private String eventTitle;
    private String eventDescription;
    private String eventStartTime;
    private String eventEndTime;
    private String eventStartDate;
    private String eventEndDate;
    private String userEmail;


    public addCalenderEventRequest(@JsonProperty("eventTitle") String eventTitle,
                                   @JsonProperty("eventDescription") String eventDescription,
                                   @JsonProperty("eventStartTime") String eventStartTime,
                                   @JsonProperty("eventEndTime") String eventEndTime,
                                   @JsonProperty("eventStartDate") String eventStartDate,
                                   @JsonProperty("eventEndDate") String eventEndDate,
                                   @JsonProperty("userEmail") String userEmail
                                   )
    {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
}
