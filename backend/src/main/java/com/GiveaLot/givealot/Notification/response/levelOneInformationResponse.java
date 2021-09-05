package com.GiveaLot.givealot.Notification.response;

public class levelOneInformationResponse {

    String url;
    String ngoNumber;
    String ngoDate;
    Long level;
    String orgName;
    Long orgID;

    public levelOneInformationResponse(Long level,String url, String ngoNumber, String ngoDate,  String orgName, Long orgID) {
        this.url = url;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
        this.level = level;
        this.orgName = orgName;
        this.orgID = orgID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
