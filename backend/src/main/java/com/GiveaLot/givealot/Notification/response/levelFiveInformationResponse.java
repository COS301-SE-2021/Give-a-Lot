package com.GiveaLot.givealot.Notification.response;

public class levelFiveInformationResponse {
    private Long level;
    private String images;
    private String audit_document;
    String orgName;
    Long orgID;

    public levelFiveInformationResponse(Long level, String images, String audit_document, String orgName, Long orgID) {
        this.level = level;
        this.images = images;
        this.audit_document = audit_document;
        this.orgName = orgName;
        this.orgID = orgID;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAudit_document() {
        return audit_document;
    }

    public void setAudit_document(String audit_document) {
        this.audit_document = audit_document;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }
}
