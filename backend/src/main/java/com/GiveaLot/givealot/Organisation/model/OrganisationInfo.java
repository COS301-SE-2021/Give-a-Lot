package com.GiveaLot.givealot.Organisation.model;

import java.util.Date;

public class OrganisationInfo {
    private String orgId;
    private String address;
    private int numberOfImages;
    private int numberOfReports;
    private String website;
    private String auditDocument;
    private String taxReference;
    private String auditorDetails;
    private String committeeDetails;
    private String ngoNumber;
    private Date ngoDate;
    private String twitter;
    private String facebook;
    private String instagram;
    private Date establishmentDate;

    public OrganisationInfo(String orgId, String address, int numberOfImages, int numberOfReports, String website, String auditDocument, String taxReference, String auditorDetails, String committeeDetails, String ngoNumber, Date ngoDate, String twitter, String facebook, String instagram, Date establishmentDate) {
        this.orgId = orgId;
        this.address = address;
        this.numberOfImages = numberOfImages;
        this.numberOfReports = numberOfReports;
        this.website = website;
        this.auditDocument = auditDocument;
        this.taxReference = taxReference;
        this.auditorDetails = auditorDetails;
        this.committeeDetails = committeeDetails;
        this.ngoNumber = ngoNumber;
        this.ngoDate = ngoDate;
        this.twitter = twitter;
        this.facebook = facebook;
        this.instagram = instagram;
        this.establishmentDate = establishmentDate;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAuditDocument() {
        return auditDocument;
    }

    public void setAuditDocument(String auditDocument) {
        this.auditDocument = auditDocument;
    }

    public String getTaxReference() {
        return taxReference;
    }

    public void setTaxReference(String taxReference) {
        this.taxReference = taxReference;
    }

    public String getAuditorDetails() {
        return auditorDetails;
    }

    public void setAuditorDetails(String auditorDetails) {
        this.auditorDetails = auditorDetails;
    }

    public String getCommitteeDetails() {
        return committeeDetails;
    }

    public void setCommitteeDetails(String committeeDetails) {
        this.committeeDetails = committeeDetails;
    }

    public String getNgoNumber() {
        return ngoNumber;
    }

    public void setNgoNumber(String ngoNumber) {
        this.ngoNumber = ngoNumber;
    }

    public Date getNgoDate() {
        return ngoDate;
    }

    public void setNgoDate(Date ngoDate) {
        this.ngoDate = ngoDate;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }


}
