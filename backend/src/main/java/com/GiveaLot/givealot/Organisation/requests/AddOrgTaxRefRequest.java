package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddOrgTaxRefRequest {
    private String orgId;
    private String reference;

    public AddOrgTaxRefRequest(@JsonProperty String orgId,
                               @JsonProperty String reference) {
        this.orgId = orgId;
        this.reference = reference;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
