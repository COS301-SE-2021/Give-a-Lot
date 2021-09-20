package com.GiveaLot.givealot.Certificate.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetrieveCertificateRequest {
    Long orgId;
    String orgName;

    public RetrieveCertificateRequest(@JsonProperty("orgId") Long orgId, @JsonProperty("orgName") String orgName) {
        this.orgId = orgId;
        this.orgName = orgName;
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
}
