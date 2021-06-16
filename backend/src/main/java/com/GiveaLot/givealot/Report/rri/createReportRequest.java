package com.GiveaLot.givealot.Report.rri;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class createReportRequest {
    String reportDescription;
    String reportType;
    String reporterEmail;
    DateTimeFormatter date;
    Timestamp id;


    createReportRequest(@JsonProperty("description") String reportDescription,
                        @JsonProperty("type") String reportType,
                        @JsonProperty("email") String reporterEmail)
    {
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;

    }

  public createReportRequest( String reportDescription,
                                String reportType,
                                String reporterEmail,
                                DateTimeFormatter date,
                                 Timestamp id){
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterEmail = reporterEmail;
        this.date = date;
        this.id = id;
    }



    /** Getters **/

    public String getReportDescription(){
        return reportDescription;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public Timestamp getId() {
        return id;
    }

    /** Setters **/

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public void setId(Timestamp id) {
        this.id = id;
    }
}
