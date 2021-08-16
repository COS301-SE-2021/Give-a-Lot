package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgAuditorRequest {
    private long orgId;
    private String auditor;

    public AddOrgAuditorRequest(@JsonProperty long orgId,
                                @JsonProperty String auditor) {
        this.orgId = orgId;
        this.auditor = auditor;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}
