package com.GiveaLot.givealot.Organisation.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgAuditorRequest {
    private String orgId;
    private String auditor;

    public AddOrgAuditorRequest(@JsonProperty String orgId,
                                @JsonProperty String auditor) {
        this.orgId = orgId;
        this.auditor = auditor;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}
