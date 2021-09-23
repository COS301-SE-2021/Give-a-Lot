package com.GiveaLot.givealot.Report.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getReportRequest {
    private Long adminId;


    public getReportRequest(@JsonProperty("orgId") Long adminId) {
        this.adminId = adminId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
