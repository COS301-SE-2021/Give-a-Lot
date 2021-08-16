package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgAuditInfoRequest
{
    private long orgId;
    private File audit;

    public AddOrgAuditInfoRequest(@JsonProperty long orgId,
                                  @JsonProperty File audit) {
        this.orgId = orgId;
        this.audit = audit;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public File getAudit() {
        return audit;
    }

    public void setAudit(File audit) {
        this.audit = audit;
    }
}
