package com.GiveaLot.givealot.Notification.response;

public class levelTwoInformationResponse {

    String website;
    String address;

    public levelTwoInformationResponse(String website, String address) {
        this.website = website;
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
