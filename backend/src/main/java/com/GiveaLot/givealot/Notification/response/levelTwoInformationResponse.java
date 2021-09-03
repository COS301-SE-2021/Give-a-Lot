package com.GiveaLot.givealot.Notification.response;

public class levelTwoInformationResponse {

    String website;
    String address;
    Long level;

    public levelTwoInformationResponse(Long level,String website, String address) {
        this.website = website;
        this.address = address;
        this.level = level;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
}
