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
    @Column(name = "org_id",
            nullable = false,
            unique = true)
    public Long orgId;
    @Column(name = "address",
            nullable = true,
            unique = false)
    private String address;
    @Column(name = "number_of_images",
            nullable = true,
            unique = false)
    private Integer numberOfImages;
    @Column(name = "get_number_of_reports",
            nullable = true,
            unique = false)

    private Integer numberOfReports;
    @Column(name = "org_website",
            nullable = true,
            unique = false)

    private String website;
    @Column(name = "auditor_details",
            nullable = true,
            unique = false)

    private String auditorDetails;
    @Column(name = "committee_details",
            nullable = true,
            unique = false)

    private String committeeDetails;
    @Column(name = "tax_reference",
            nullable = true,
            unique = false)

    private String taxReference;
    @Column(name = "audit_document",
            nullable = true,
            unique = false)

    private String auditDocument;
    @Column(name = "ngonumber",
            nullable = true,
            unique = false)

    private String NGONumber;
    @Column(name = "ngo_date",
            nullable = true,
            unique = false)

    private Date NGODate;
    @Column(name = "twitter",
            nullable = true,
            unique = false)

    private String twitter;
    @Column(name = "facebook",
            nullable = true,
            unique = false)

    private String facebook;
    @Column(name = "instagram",
            nullable = true,
            unique = false)

    private String instagram;
    @Column(
            name = "establishment_date",
            nullable = true,
            unique = false)
    private String establishmentDate;

    public OrganisationInfo(Long orgId)
    {
        this.setOrgId(orgId);
    }
    public OrganisationInfo() {
        this.address = null;
        this.numberOfImages = null;
        this.numberOfReports = null;
        this.website = null;
        this.auditorDetails = null;
        this.committeeDetails = null;
        this.NGONumber = null;
        this.NGODate = null;
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
                ", numberOfReports=" + numberOfReports +
                ", website='" + website + '\'' +
                ", auditorDetails='" + auditorDetails + '\'' +
                ", committeeDetails='" + committeeDetails + '\'' +
                ", NGONumber='" + NGONumber + '\'' +
                ", NGODate='" + NGODate + '\'' +
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
