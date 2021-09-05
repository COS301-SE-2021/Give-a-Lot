package com.GiveaLot.givealot.Notification.response;

public class levelThreeInformationResponse {
    String establishmentDate;
    String donation_url;
    String qrCode_url;
    Long level;
    String orgName;
    Long orgID;

    public levelThreeInformationResponse(String establishmentDate, String donation_url, String qrCode_url, Long level, String orgName, Long orgID) {
        this.establishmentDate = establishmentDate;
        this.donation_url = donation_url;
        this.qrCode_url = qrCode_url;
        this.level = level;
        this.orgName = orgName;
        this.orgID = orgID;
    }

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getDonation_url() {
        return donation_url;
    }

    public void setDonation_url(String donation_url) {
        this.donation_url = donation_url;
    }

    public String getQrCode_url() {
        return qrCode_url;
    }

    public void setQrCode_url(String qrCode_url) {
        this.qrCode_url = qrCode_url;
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
