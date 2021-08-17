package com.GiveaLot.givealot.Report.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class createReportRequest {
    String orgId;
    String orgName;
    String reportDescription;
    String reportType;
    String reporterEmail;


    public createReportRequest(@JsonProperty("orgId") String orgId,
                               @JsonProperty("orgName") String orgName,
                               @JsonProperty("description") String reportDescription,
                               @JsonProperty("type") String reportType,
                               @JsonProperty("email") String reporterEmail)
    {
        this.orgId = orgId;
        this.orgName = orgName;
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;

    }





    /** Getters **/

    public String getOrgId() {
        return orgId;
    }

    public String getOrgName() {
        return orgName;
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




    /** Setters **/

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

}
