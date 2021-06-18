package com.GiveaLot.givealot.Report.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class createReportRequest {
    String orgId;
    String orgName;
    String reportDescription;
    String reportType;
    String reporterEmail;
    Timestamp id;


    createReportRequest(@JsonProperty("organisation") String orgName,
                        @JsonProperty("description") String reportDescription,
                        @JsonProperty("type") String reportType,
                        @JsonProperty("email") String reporterEmail)
    {
        this.orgName = orgName;
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;
        this.id = new Timestamp(System.currentTimeMillis());

    }





    /** Getters **/

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

    public Timestamp getId() {
        return id;
    }



    /** Setters **/

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

    public void setId(Timestamp id) {
        this.id = id;
    }

    public String getOrgId() { return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
