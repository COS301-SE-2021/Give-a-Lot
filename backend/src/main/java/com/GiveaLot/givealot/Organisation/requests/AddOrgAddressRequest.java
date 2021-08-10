package com.GiveaLot.givealot.Organisation.requests;

public class AddOrgAddressRequest {


    private String orgId;
    private String address;

    public AddOrgAddressRequest(String orgId, String address) {
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
