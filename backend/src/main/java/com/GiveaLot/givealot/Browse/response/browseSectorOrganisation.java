package com.GiveaLot.givealot.Browse.response;

/*
* browse organisation by sector response helper class
* */

public class browseSectorOrganisation {
    private Long orgId;
    private String orgName;
    private String dateAdded;
    private String imgUrl;
    private String orgDescription;
    private Integer certificate_level;


    public browseSectorOrganisation(Long orgId, String orgName, String dateAdded, String imgUrl, Integer certificate_level, String orgDescription) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.dateAdded = dateAdded;
        this.imgUrl = imgUrl;
        this.certificate_level = certificate_level;
        this.orgDescription = orgDescription;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public Integer getCertificate_level() {
        return certificate_level;
    }

    public void setCertificate_level(Integer certificate_level) {
        this.certificate_level = certificate_level;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
