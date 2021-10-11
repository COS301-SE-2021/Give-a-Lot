package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetOrganisationCertificateLevelRequest {
    Long orgid;

    public GetOrganisationCertificateLevelRequest(@JsonProperty("orgid") Long orgid) {
        this.orgid = orgid;
    }


    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }
}
