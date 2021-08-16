package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgAddressRequest {


    private long orgId;
    private String address;

    public AddOrgAddressRequest(@JsonProperty("orgId") long orgId,@JsonProperty("address") String address) {
        this.orgId = orgId;
        this.address = address;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getOrgId() {
        return this.orgId;
    }

    public String getAddress() {
        return this.address;
    }
}
