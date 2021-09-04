package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class updateOrganisationInfoRequest {

    private Long orgId;
    private String type;
    private String newValue;

    public updateOrganisationInfoRequest(@JsonProperty("orgId") Long orgId, @JsonProperty("type") String type, @JsonProperty("newValue") String newValue) {
        this.orgId = orgId;
        this.type = type;
        this.newValue = newValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
}
