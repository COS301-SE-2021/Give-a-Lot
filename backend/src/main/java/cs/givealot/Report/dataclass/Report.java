package main.java.cs.givealot.Report.dataclass;

import java.security.Timestamp;
import java.time.format.DateTimeFormatter;

public class Report {
    String reportDescription;
    String reportType;
    String reporterUsername;
    DateTimeFormatter date;
    Timestamp id;

    public Report(String reportDescription, String reportType, String reporterUsername, DateTimeFormatter date, Timestamp id){
        this.reportDescription = reportDescription;
        this.reportType = reportType;
        this.reporterUsername = reporterUsername;
        this.date = date;
        this.id = id;
    }

    public String getReportDescription(){
        return reportDescription;
    }

    public String getReportType() {
        return reportType;
    }

    public String getReporterUsername() {
        return reporterUsername;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public Timestamp getId() {
        return id;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setReporterUsername(String reporterUsername) {
        this.reporterUsername = reporterUsername;
    }
}
