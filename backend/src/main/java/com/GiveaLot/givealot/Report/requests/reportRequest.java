package com.GiveaLot.givealot.Report.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class reportRequest {

    private Long orgId;
    private Long userId;
    private String reportType;
    private String description;


    public reportRequest(@JsonProperty("orgId") Long orgId,
                         @JsonProperty("userId") Long userId,
                         @JsonProperty("reportType") String reportType,
                         @JsonProperty("description") String description)
    {
        this.orgId = orgId;
        this.userId = userId;
        this.reportType = reportType;
        this.description = description;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
