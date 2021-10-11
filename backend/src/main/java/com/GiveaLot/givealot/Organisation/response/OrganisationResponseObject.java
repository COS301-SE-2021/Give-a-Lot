package com.GiveaLot.givealot.Organisation.response;

public class OrganisationResponseObject {

    private String orgName;
    private String slogan;
    private String orgDescription;
    private String orgSector;
    private Long certificateLevel;
    private String facebookUrl;
    private String twitterUrl;
    private String istagramURl;
    private String donationLink;
    private Integer numberOfImages;


    public OrganisationResponseObject(String orgName,
                                      String slogan,
                                      String orgDescription,
                                      String orgSector,
                                      Long certificateLevel,
                                      String facebookUrl,
                                      String twitterUrl,
                                      String istagramURl,
                                      Integer numberOfImages,
                                      String donationLink) {
        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.certificateLevel = certificateLevel;
        this.facebookUrl = facebookUrl;
        this.twitterUrl = twitterUrl;
        this.istagramURl = istagramURl;
        this.numberOfImages = numberOfImages;
        this.donationLink = donationLink;
    }

    public String getDonationLink() {
        return donationLink;
    }

    public void setDonationLink(String donationLink) {
        this.donationLink = donationLink;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgSector() {
        return orgSector;
    }

    public void setOrgSector(String orgSector) {
        this.orgSector = orgSector;
    }

    public Long getCertificateLevel() {
        return certificateLevel;
    }

    public void setCertificateLevel(Long certificateLevel) {
        this.certificateLevel = certificateLevel;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getIstagramURl() {
        return istagramURl;
    }

    public void setIstagramURl(String istagramURl) {
        this.istagramURl = istagramURl;
    }

    public Integer getNumberOfImages() {
        return numberOfImages;
    }

    public void setNumberOfImages(Integer numberOfImages) {
        this.numberOfImages = numberOfImages;
    }
}
