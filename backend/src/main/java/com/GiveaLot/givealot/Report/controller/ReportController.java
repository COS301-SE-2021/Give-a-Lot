package com.GiveaLot.givealot.Report.controller;
import com.GiveaLot.givealot.Report.ReportService;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

   @PostMapping("/organisation")
   public List<String> createReport(@RequestBody createReportRequest request)
   {
        List<String> res = new LinkedList<>();
        try
        {
            reportService.createReport(request);
            res.add("200");
            return res;
        }
        catch(Exception e)
        {
            return List.of(e.getMessage());
        }
   }
}
