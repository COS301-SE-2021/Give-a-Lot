package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgAuditInfoRequest
{
    private Long orgId;
    private File audit;

    public AddOrgAuditInfoRequest(@JsonProperty Long orgId,
                                  @JsonProperty File audit) {
        this.orgId = orgId;
        this.audit = audit;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public File getAudit() {
        return audit;
    }

    public void setAudit(File audit) {
        this.audit = audit;
    }
}
