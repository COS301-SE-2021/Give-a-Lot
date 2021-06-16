package com.GiveaLot.givealot.Report;

import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.ReportException;

import java.io.File;
import java.io.FileWriter;

public class ReportHelper {

    //Create report

    public ReportHelper(){}
    public File createReportFile(Report report) throws Exception{
        try {

            String reportName = "report" + report.getId().toString();
            File file = new File(reportName + ".txt");
            if (file.createNewFile()) {
            } else {
                throw new ReportException("Exception: File already exists");
            }
            String id = report.getId().toString();
            String date = report.getDate().toString();
            FileWriter writer = new FileWriter(reportName + ".txt");

            writer.write(id);
            writer.write(date);
            writer.write(report.getReporterUsername());
            writer.write(report.getReportDescription());

            writer.close();

            return file;
        }
        catch (Exception e) {
            throw new ReportException("Exception: Problem creating Report");
        }
    }
}
