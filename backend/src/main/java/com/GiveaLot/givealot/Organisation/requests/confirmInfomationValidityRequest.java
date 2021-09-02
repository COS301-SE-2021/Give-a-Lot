package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class confirmInfomationValidityRequest {

    private Long orgId;
    private Long adminId;
    private String type;
    private boolean isValid;

    public confirmInfomationValidityRequest(@JsonProperty("orgId") Long orgId,
                                            @JsonProperty("adminId") Long adminId,
                                            @JsonProperty("type") String type,
                                            @JsonProperty("isValid") boolean isValid) {
        this.orgId = orgId;
        this.adminId = adminId;
        this.type = type;
        this.isValid = isValid;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
