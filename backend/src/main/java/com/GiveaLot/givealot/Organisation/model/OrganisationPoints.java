package com.GiveaLot.givealot.Organisation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Entity
@Table(name="organisation_points")
public class OrganisationPoints {

    @Id
    private Long orgId;
    private int points;
    private boolean addressIsValid;
    private boolean websiteIsValid;
    private boolean auditIsValid;
    private boolean taxRefIsValid;
    private boolean auditorIsValid;
    private boolean committeeIsValid;
    private boolean ngoNoIsValid;
    private boolean ngoDateIsValid;
    private boolean twitterIsValid;
    private boolean facebookIsValid;
    private boolean instagramIsValid;
    private boolean estDateIsValid;
    private boolean donationUrlIsValid;
    private int numberOfImages;
    private String socialMediaType;
    private boolean qr_code_is_valid;

    public OrganisationPoints()
    {

    }

    public boolean isQr_code_is_valid() {
        return qr_code_is_valid;
    }

    public void setQr_code_is_valid(boolean qr_code_is_valid) {
        this.qr_code_is_valid = qr_code_is_valid;
    }

    public boolean isDonationUrlIsValid() {
        return donationUrlIsValid;
    }

    public void setDonationUrlIsValid(boolean donationUrlIsValid) {
        this.donationUrlIsValid = donationUrlIsValid;
    }

    public OrganisationPoints(long org_id) {
        this.orgId = org_id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isAddressIsValid() {
        return addressIsValid;
    }

    public void setAddressIsValid(boolean addressIsValid) {
        this.addressIsValid = addressIsValid;
    }

    public boolean isWebsiteIsValid() {
        return websiteIsValid;
    }

    public void setWebsiteIsValid(boolean websiteIsValid) {
        this.websiteIsValid = websiteIsValid;
    }

    public boolean isAuditIsValid() {
        return auditIsValid;
    }

    public void setAuditIsValid(boolean auditIsValid) {
        this.auditIsValid = auditIsValid;
    }

    public boolean isTaxRefIsValid() {
        return taxRefIsValid;
    }

    public void setTaxRefIsValid(boolean taxRefIsValid) {
        this.taxRefIsValid = taxRefIsValid;
    }

    public boolean isAuditorIsValid() {
        return auditorIsValid;
    }

    public void setAuditorIsValid(boolean auditorIsValid) {
        this.auditorIsValid = auditorIsValid;
    }

    public boolean isCommitteeIsValid() {
        return committeeIsValid;
    }

    public void setCommitteeIsValid(boolean committeeIsValid) {
        this.committeeIsValid = committeeIsValid;
    }

    public boolean isNgoNoIsValid() {
        return ngoNoIsValid;
    }

    public void setNgoNoIsValid(boolean ngoNoIsValid) {
        this.ngoNoIsValid = ngoNoIsValid;
    }

    public boolean isNgoDateIsValid() {
        return ngoDateIsValid;
    }

    public void setNgoDateIsValid(boolean ngoDateIsValid) {
        this.ngoDateIsValid = ngoDateIsValid;
    }

    public boolean isTwitterIsValid() {
        return twitterIsValid;
    }

    public void setTwitterIsValid(boolean twitterIsValid) {
        this.twitterIsValid = twitterIsValid;
    }

    public boolean isFacebookIsValid() {
        return facebookIsValid;
    }

    public void setFacebookIsValid(boolean facebookIsValid) {
        this.facebookIsValid = facebookIsValid;
    }

    public boolean isInstagramIsValid() {
        return instagramIsValid;
    }

    public void setInstagramIsValid(boolean instagramIsValid) {
        this.instagramIsValid = instagramIsValid;
    }

    public boolean isEstDateIsValid() {
        return estDateIsValid;
    }

    public void setEstDateIsValid(boolean estDateIsValid) {
        this.estDateIsValid = estDateIsValid;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(int numberOfImages) {
        this.numberOfImages = numberOfImages;
    }

    public String getSocialMediaType() {
        return socialMediaType;
    }

    public void setSocialMediaType(String socialMediaType) {
        this.socialMediaType = socialMediaType;
    }
}
