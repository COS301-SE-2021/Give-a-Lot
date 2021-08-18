package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgAuditorRequest {
    private Long orgId;
    private String auditor;

    public AddOrgAuditorRequest(@JsonProperty ("orgId") Long orgId,
                                @JsonProperty ("auditor") String auditor) {
        this.orgId = orgId;
        this.auditor = auditor;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}
