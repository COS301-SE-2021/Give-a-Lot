package com.GiveaLot.givealot.Report;


import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Report.exceptions.ReportException;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

@Service
public class ReportServiceImpl implements ReportService{

    @Override
    public createReportResponse createReport(createReportRequest request) throws Exception
    {
        createReportResponse reportRes = null;
        if(request == null)
        {
            throw new InvalidRequestException("Exception: Report could not be created because the request object is null");
        }
        else
        {
            if(request.getOrgId().length() == 0 || request.getReportDescription().length() == 0 || request.getReportType().length() == 0 || request.getReporterEmail().length() == 0)
            {
                throw new ReportException("Report Exception: empty fields not allowed");
            }
            else if (!request.getReporterEmail().contains("@"))
            {
                throw new ReportException("Report Exception: invalid email provided");
            }

            try
            {
                reportRes = new createReportResponse();
                Report report = new Report(request.getOrgId(), request.getReportDescription(), request.getReportType(), request.getReporterEmail());

                ReportHelper createReport = new ReportHelper();
                reportRes.setReportJSON(List.of(new ReportResponseJSON(200,"ok",createReport.createReportFile(report))));
                return reportRes;
            }
            catch(Exception e)
            {
                throw new ReportException("Exception: Problem creating Report\n" + e.getMessage());
            }
        }
    }

/*    public static void main(String[] args) throws Exception {

        Report report = new Report("0b5d9a449f7d4c99ca9bd41def84b659","They provided incorrect addresses and contact information", "Incorrect Profile Info", "CoolUser57@gmail.com");

        ReportHelper help = new ReportHelper();
        File reportFile = help.createReportFile(report);
        System.out.println(reportFile);
        Scanner reader = new Scanner(reportFile);

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            System.out.println(data);
        }
        reader.close();
    }*/
}
