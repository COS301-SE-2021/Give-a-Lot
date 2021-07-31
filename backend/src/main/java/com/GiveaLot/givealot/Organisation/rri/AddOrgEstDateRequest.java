package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddOrgEstDateRequest {

   private Date date;
    private String orgId;

    public AddOrgEstDateRequest(@JsonProperty Date date,
                                @JsonProperty String orgId)
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
