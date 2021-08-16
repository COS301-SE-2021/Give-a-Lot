package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddOrgEstDateRequest {

   private Date date;
    private long orgId;

    public AddOrgEstDateRequest(@JsonProperty Date date,
                                @JsonProperty long orgId)
    {
        this.date = date;
        this.orgId = orgId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }
}
