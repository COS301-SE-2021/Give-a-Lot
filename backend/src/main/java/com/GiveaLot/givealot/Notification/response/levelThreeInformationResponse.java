package com.GiveaLot.givealot.Notification.response;

public class levelThreeInformationResponse {
    String establishmentDate;
    String donation_url;
    Long level;

    public levelThreeInformationResponse(Long level,String establishmentDate, String donation_url) {
        this.establishmentDate = establishmentDate;
        this.donation_url = donation_url;
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
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
}
