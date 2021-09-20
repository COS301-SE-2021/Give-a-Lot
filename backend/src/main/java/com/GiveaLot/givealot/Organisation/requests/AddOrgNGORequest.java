package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddOrgNGORequest
{
    private long orgId;
    private String ngoNumber;
    private String ngoDate;

    public AddOrgNGORequest(@JsonProperty("orgId") long orgId,
                            @JsonProperty("ngoNumber") String ngoNumber,
                            @JsonProperty("ngoDate") String ngoDate) {
        this.orgId = orgId;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getNgoNumber() {
        return ngoNumber;
    }

    public void setNgoNumber(String ngoNumber) {
        this.ngoNumber = ngoNumber;
    }

    public String getNgoDate() {
        return ngoDate;
    }

    public void setNgoDate(String ngoDate) {
        this.ngoDate = ngoDate;
    }
}
