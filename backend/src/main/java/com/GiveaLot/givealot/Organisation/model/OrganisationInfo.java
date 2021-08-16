package com.GiveaLot.givealot.Organisation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@Entity
@Table(name="organisation_info")
public class OrganisationInfo
{
    @Id
    @Column(name = "org_id", nullable = false, unique = true)
    public Long orgId;

    private String  address;
    private Integer numberOfImages;
    private Integer getNumberOfReports;
    private String  orgWebsite;
    private String  taxReference;
    private String  auditorDetails;
    private String  committeeDetails;
    private String  NGONumber;
    private String twitter;
    private String facebook;
    private String instagram;
    private String establishmentDate;

    public OrganisationInfo(Long orgId)
    {
        this.setOrgId(orgId);
    }
    public OrganisationInfo() {
        this.address = null;
        this.numberOfImages = null;
        this.getNumberOfReports = null;
        this.orgWebsite = null;
        this.taxReference = null;
        this.auditorDetails = null;
        this.committeeDetails = null;
        this.NGONumber = null;
        this.twitter = null;
        this.facebook = null;
        this.instagram = null;
        this.establishmentDate = null;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(Integer numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public Integer getGetNumberOfReports() {
        return getNumberOfReports;
    }

    public void setGetNumberOfReports(Integer getNumberOfReports) {
        this.getNumberOfReports = getNumberOfReports;
    }

    public String getOrgWebsite() {
        return orgWebsite;
    }

    public void setOrgWebsite(String orgWebsite) {
        this.orgWebsite = orgWebsite;
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

    public String getNGONumber() {
        return NGONumber;
    }

    public void setNGONumber(String NGONumber) {
        this.NGONumber = NGONumber;
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

    public String getEstablishmentDate() {
        return establishmentDate;
    }

    @Override
    public String toString() {
        return "organisationInfo{" +
                "orgId='" + orgId + '\'' +
                ", address='" + address + '\'' +
                ", numberOfImages=" + numberOfImages +
                ", getNumberOfReports=" + getNumberOfReports +
                ", orgWebsite='" + orgWebsite + '\'' +
                ", taxReference='" + taxReference + '\'' +
                ", auditorDetails='" + auditorDetails + '\'' +
                ", committeeDetails='" + committeeDetails + '\'' +
                ", NGONumber='" + NGONumber + '\'' +
                ", twitter='" + twitter + '\'' +
                ", facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", establishmentDate='" + establishmentDate + '\'' +
                '}';
    }

    public void setEstablishmentDate(String establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
}
