package com.GiveaLot.givealot.Notification.response;

public class levelOneInformationResponse {

    String url;
    String ngoNumber;
    String ngoDate;
    Long level;

    public levelOneInformationResponse( Long level, String url, String ngoNumber, String ngoDate) {
        this.url = url;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
        this.level = level;
    }

    public levelOneInformationResponse(String url, String ngoNumber, String ngoDate) {
        this.url = url;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
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
}
