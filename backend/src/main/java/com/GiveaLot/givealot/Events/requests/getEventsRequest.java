package com.GiveaLot.givealot.Events.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getEventsRequest {
    private Long userId;

    public getEventsRequest(@JsonProperty("userId") Long userId) {
        this.userId = userId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
