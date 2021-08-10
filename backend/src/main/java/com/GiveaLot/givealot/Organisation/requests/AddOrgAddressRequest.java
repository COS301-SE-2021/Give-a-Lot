package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgAddressRequest {


    private String orgId;
    private String address;

    public AddOrgAddressRequest(@JsonProperty String orgId,@JsonProperty String address) {
        this.orgId = orgId;
        this.address = address;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public String getAddress() {
        return this.address;
    }
}
