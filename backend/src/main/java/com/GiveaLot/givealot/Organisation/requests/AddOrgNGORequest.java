package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddOrgNGORequest
{
    private String orgId;
    private String ngoNumber;
    private Date ngoDate;

    public AddOrgNGORequest(@JsonProperty String orgId,
                            @JsonProperty String ngoNumber,
                            @JsonProperty Date ngoDate) {
        this.orgId = orgId;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getNgoNumber() {
        return ngoNumber;
    }

    public void setNgoNumber(String ngoNumber) {
        this.ngoNumber = ngoNumber;
    }

    public Date getNgoDate() {
        return ngoDate;
    }

    public void setNgoDate(Date ngoDate) {
        this.ngoDate = ngoDate;
    }
}
