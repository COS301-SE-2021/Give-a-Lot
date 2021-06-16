package com.GiveaLot.givealot.Report.dataclass;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {
    String reportDescription;
    String reportType;
    String reporterUsername;
    String date;
    String id;

    public Report(String reportDescription, String reportType, String reporterUsername, Timestamp id){
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterUsername = reporterUsername;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.date = date.format(dateTime);

        this.id = id.toString().replaceAll("[^a-zA-Z0-9]", "");;
    }

    /** Getters **/

    public String getReportDescription(){
        return reportDescription;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReporterUsername() {
        return reporterUsername;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    /** Setters **/

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setReporterUsername(String reporterUsername) {
        this.reporterUsername = reporterUsername;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Timestamp id) {
        this.id = id.toString().replaceAll("[^a-zA-Z0-9]", "");
    }
}
