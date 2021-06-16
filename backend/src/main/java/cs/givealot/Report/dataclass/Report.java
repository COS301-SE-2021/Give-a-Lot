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
        t

    }
}
