package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgAuditInfoRequest
{
    private String orgId;
    private File audit;

    public AddOrgAuditInfoRequest(@JsonProperty String orgId,
                                  @JsonProperty File audit) {
        this.orgId = orgId;
        this.audit = audit;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public File getAudit() {
        return audit;
    }

    public void setAudit(File audit) {
        this.audit = audit;
    }
}
