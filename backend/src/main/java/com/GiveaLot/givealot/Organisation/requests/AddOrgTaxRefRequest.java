package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgTaxRefRequest {
    private Long orgId;
    private File reference;

    public AddOrgTaxRefRequest(@JsonProperty ("orgId") Long orgId,
                               @JsonProperty ("reference") File reference) {
        this.orgId = orgId;
        this.reference = reference;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public File getReference() {
        return reference;
    }

    public void setReference(File reference) {
        this.reference = reference;
    }
}
