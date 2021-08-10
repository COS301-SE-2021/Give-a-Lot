package com.GiveaLot.givealot.Browse.service;

import java.util.List;

public class OrganisationData
{
    private String OrgId; /* order tree by */
    private String OrgName;
    private String OrgDescription;
    private String OrgSector;
    private String OrgEmail;
    private boolean OrgStatus;
    private String OrgAddress;
    private List<String> images;
    private String OrgWebsite;
    private String OrgTwitter;
    private String OrgFacebook;
    private String OrgInstagram;
    private String OrgEstablishment;

    public void reset_object() {
        OrgId = null; /* order tree by */
        OrgName = null;
        OrgDescription = null;
        OrgSector = null;
        OrgEmail = null;
        OrgStatus = false;
        OrgAddress = null;
        images = null;
        OrgWebsite = null;
        OrgTwitter = null;
        OrgFacebook = null;
        OrgInstagram = null;
        OrgEstablishment = null;
    }

    public OrganisationData() {
        reset_object();
    }

    public List<String> getImages() {
        return this.images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getOrgAddress() {
        return this.OrgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.OrgAddress = orgAddress;
    }

    public String getOrgDescription() {
        return this.OrgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.OrgDescription = orgDescription;
    }

    public String getOrgEmail() {
        return this.OrgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.OrgEmail = orgEmail;
    }

    public String getOrgEstablishment() {
        return this.OrgEstablishment;
    }

    public void setOrgEstablishment(String orgEstablishment) {
        this.OrgEstablishment = orgEstablishment;
    }

    public String getOrgFacebook() {
        return this.OrgFacebook;
    }

    public void setOrgFacebook(String orgFacebook) {
        this.OrgFacebook = orgFacebook;
    }

    public String getOrgId() {
        return this.OrgId;
    }

    public void setOrgId(String orgId) {
        this.OrgId = orgId;
    }

    public String getOrgInstagram() {
        return this.OrgInstagram;
    }

    public void setOrgInstagram(String orgInstagram) {
        this.OrgInstagram = orgInstagram;
    }

    public String getOrgName() {
        return this.OrgName;
    }

    public void setOrgName(String orgName) {
        this.OrgName = orgName;
    }

    public String getOrgSector() {
        return this.OrgSector;
    }

    public void setOrgSector(String orgSector) {
        this.OrgSector = orgSector;
    }

    public String getOrgTwitter() {
        return this.OrgTwitter;
    }

    public void setOrgTwitter(String orgTwitter) {
        this.OrgTwitter = orgTwitter;
    }

    public void setOrgStatus(boolean orgStatus) {
        this.OrgStatus = orgStatus;
    }

    public boolean getOrgStatus() {
        return this.OrgStatus;
    }

    public String getOrgWebsite() {
        return this.OrgWebsite;
    }

    public void setOrgWebsite(String orgWebsite) {
        this.OrgWebsite = orgWebsite;
    }
}
