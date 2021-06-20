package com.GiveaLot.givealot.Report;


import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Report.exceptions.ReportException;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ReportServiceImpl implements ReportService{

    @Override
    public createReportResponse createReport(createReportRequest request) throws Exception
    {
        createReportResponse reportRes = null;
        if (request == null){
            throw new InvalidRequestException("Exception: Report could not be created because the request object is null");
        }
        Report report = null;
        try
        {
            report = new Report("","","","");
        }
        catch (Exception e)
        {
            throw new ReportException("Problem creating Report");
        }
        
        report = new Report(request.getOrgId(),request.getReportDescription(),request.getReportType(),request.getReporterEmail());
        reportRes = new createReportResponse();
        ReportHelper createReport = new ReportHelper();
        try {
            reportRes.setReportFile(createReport.createReportFile(report));
        }catch (Exception e){
            throw new ReportException("Exception: Problem creating Report");
        }
        return reportRes;
    }

}
