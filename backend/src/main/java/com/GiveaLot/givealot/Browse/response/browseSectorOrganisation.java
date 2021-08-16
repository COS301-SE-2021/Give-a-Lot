package com.GiveaLot.givealot.Browse.response;

import com.fasterxml.jackson.annotation.JsonRootName;

/*
* browse organisation by sector response helper class
* */

public class browseSectorOrganisation {
    private Long orgId;
    private String orgName;
    private String dateAdded;
    private String imgUrl;

    public browseSectorOrganisation(Long orgId, String orgName, String dateAdded, String imgUrl) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.dateAdded = dateAdded;
        this.imgUrl = imgUrl;
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
