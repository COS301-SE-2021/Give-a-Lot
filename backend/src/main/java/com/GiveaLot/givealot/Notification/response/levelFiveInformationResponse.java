package com.GiveaLot.givealot.Notification.response;

public class levelFiveInformationResponse {
    String images;
    String audit_document;

    public levelFiveInformationResponse(String images, String audit_document) {
        this.images = images;
        this.audit_document = audit_document;
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
}
