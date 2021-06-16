package com.GiveaLot.givealot.Report;


import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{

    @Override
    public createReportResponse createReport(createReportRequest request) throws Exception
    {
        System.out.println(request.getReportDescription());
        System.out.println(request.getReportType());
        System.out.println(request.getReporterUsername());
        System.out.println(request.getUserEmail());
        return null;
    }
}
