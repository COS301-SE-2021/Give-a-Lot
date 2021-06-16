package com.GiveaLot.givealot.Report;

import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.ReportException;

import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReportHelper {

    //Create report

    public ReportHelper(){}
    public File createReportFile(Report report) throws Exception{
        try {

            String reportName = "report" + report.getId() + report.getReporterEmail();
            reportName = reportName.replaceAll("[^a-zA-Z0-9]", "");
            File file = new File(reportName + ".txt");
            if (file.createNewFile()) {
            } else {
                throw new ReportException("Exception: File already exists");
            }
            String id = report.getId().toString();
            String date = report.getDate().toString();
            FileWriter writer = new FileWriter(reportName + ".txt");

            writer.write("ID: ");
            writer.write(id);
            writer.write("\n");
            writer.write("Date: ");
            writer.write(date);
            writer.write("\n");
            writer.write("User email: ");
            writer.write(report.getReporterEmail());
            writer.write("\n");
            writer.write("Type: ");
            writer.write(report.getReportType());
            writer.write("\n");
            writer.write("Description: ");
            writer.write(report.getReportDescription());
            writer.write("\n");

            writer.close();

            return file;
        }
        catch (Exception e) {
            throw new ReportException("Exception: Problem creating Report");
        }
    }

    public static void main(String[] args) throws Exception {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Report report = new Report("They provided incorrect addresses and contact information", "Incorrect Profile Info", "CoolUser57", timestamp);
        ReportHelper help = new ReportHelper();
        File reportFile = help.createReportFile(report);
        System.out.println(reportFile);
        Scanner reader = new Scanner(reportFile);
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();

    }
}
