package com.GiveaLot.givealot.Report.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class appealReportRequest {
    private Long orgId;
    private Long adminId;

    public appealReportRequest(@JsonProperty("orgId") Long orgId,@JsonProperty("reportId") Long adminId) {
        this.orgId = orgId;
        this.adminId = adminId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}