package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class AddOrgAuditInfoRequest
{
    private Long orgId;
    private MultipartFile audit;

    public AddOrgAuditInfoRequest(@JsonProperty Long orgId,
                                  @JsonProperty("audit") MultipartFile audit) {
        this.orgId = orgId;
        this.audit = audit;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public MultipartFile getAudit() {
        return audit;
    }

    public void setAudit(MultipartFile audit) {
        this.audit = audit;
    }
}
