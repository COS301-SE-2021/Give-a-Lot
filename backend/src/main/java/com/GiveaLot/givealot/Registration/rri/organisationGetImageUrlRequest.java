package com.GiveaLot.givealot.Registration.rri;

public class organisationGetImageUrlRequest {
    private String organisationImageURL;
    private String organisastionKey;

    public organisationGetImageUrlRequest(String organisationImageURL, String organisastionKey) {
        this.organisationImageURL = organisationImageURL;
        this.organisastionKey = organisastionKey;
    }

    public String getOrganisationImageURL() {
        return organisationImageURL;
    }

    public void setOrganisationImageURL(String organisationImageURL) {
        this.organisationImageURL = organisationImageURL;
    }

    public void setOrganisastionKey(String organisastionKey) {
        this.organisastionKey = organisastionKey;
    }

    public String getOrganisastionKey() {
        return organisastionKey;
    }
}
