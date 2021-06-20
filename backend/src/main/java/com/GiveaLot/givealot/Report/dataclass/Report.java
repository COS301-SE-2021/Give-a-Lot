package com.GiveaLot.givealot.Report.dataclass;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    String orgId;
    String orgName;
    String reportDescription;
    String reportType;
    String reporterEmail;
    String date;
    String id;

    public Report(){

    }

    public Report(String orgId, String reportDescription, String reportType, String reporterEmail){
        this.orgId = orgId;
        this.orgName = orgName;
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = date.format(dateTime);

        Timestamp id = new Timestamp(System.currentTimeMillis());

        this.id = id.toString().replaceAll("[^a-zA-Z0-9]", "");;
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

    public String getDate() {
        return date;
    }

    public String getId() {
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Timestamp id) {
        this.id = id.toString().replaceAll("[^a-zA-Z0-9]", "");
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
