package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class AddOrgTaxRefRequest {
    private long orgId;
    private File reference;

    public AddOrgTaxRefRequest(@JsonProperty ("orgId") long orgId,
                               @JsonProperty ("reference") File reference) {
        this.orgId = orgId;
        this.reference = reference;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public File getReference() {
        return reference;
    }

    public void setReference(File reference) {
        this.reference = reference;
    }
}
