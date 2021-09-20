package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddOrgEstDateRequest {

    private String date;
    private Long orgId;

    public AddOrgEstDateRequest(@JsonProperty("date") String date,
                                @JsonProperty("orgId") Long orgId) {
        this.date = date;
        this.orgId = orgId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
