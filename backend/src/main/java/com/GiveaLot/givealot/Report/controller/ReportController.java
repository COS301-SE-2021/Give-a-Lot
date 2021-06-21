package com.GiveaLot.givealot.Report.controller;
import com.GiveaLot.givealot.Report.ReportResponseJSON;
import com.GiveaLot.givealot.Report.ReportService;
import com.GiveaLot.givealot.Report.ReportServiceImpl;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportServiceImpl ReportServiceImpl;

    @Autowired
    public ReportController(ReportServiceImpl ReportServiceImpl) {
        this.ReportServiceImpl = ReportServiceImpl;
    }

   @CrossOrigin
   @PostMapping("/organisation")
   public List<ReportResponseJSON> createReport(@RequestBody createReportRequest request)
   {
        try
        {
            createReportResponse createReportResponse = ReportServiceImpl.createReport(request);
            return createReportResponse.getReportResponseJSON();
        }
        catch(Exception e)
        {
            return List.of(new ReportResponseJSON(402, e.getMessage(), null));
        }
   }
}