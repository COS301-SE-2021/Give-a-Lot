package com.GiveaLot.givealot.Notification.response;

public class levelTwoInformationResponse {

    String website;
    String address;
    Long level;
    String orgName;
    Long orgID;

    public levelTwoInformationResponse(String website, String address, Long level, String orgName, Long orgID) {
        this.website = website;
        this.address = address;
        this.level = level;
        this.orgName = orgName;
        this.orgID = orgID;
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }
}
