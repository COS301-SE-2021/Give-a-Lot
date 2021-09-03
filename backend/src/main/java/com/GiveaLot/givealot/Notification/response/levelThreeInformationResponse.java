package com.GiveaLot.givealot.Notification.response;

public class levelThreeInformationResponse {
    String establishmentDate;
    String donation_url;

    public levelThreeInformationResponse(String establishmentDate, String donation_url) {
        this.establishmentDate = establishmentDate;
        this.donation_url = donation_url;
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
