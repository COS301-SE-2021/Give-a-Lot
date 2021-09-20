package com.GiveaLot.givealot.Report.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class createReportRequest {
    long orgId;
    String reportDescription;
    String reportType;
    String reporterEmail;
    String orgName;


    public createReportRequest(@JsonProperty("orgId") long orgId,
                               @JsonProperty("orgName") String orgName,
                               @JsonProperty("description") String reportDescription,
                               @JsonProperty("type") String reportType,
                               @JsonProperty("email") String reporterEmail
                              )
    {
        this.orgId = orgId;
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;
    }




    /** Getters **/

    public long getOrgId() {
        return orgId;
    }

    public String getReportDescription(){
        return reportDescription;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getOrgName() {
        return orgName;
    }



    /** Setters **/

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
