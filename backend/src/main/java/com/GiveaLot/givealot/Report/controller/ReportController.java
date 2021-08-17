package com.GiveaLot.givealot.Report.controller;

import com.GiveaLot.givealot.Report.requests.createReportRequest;
import com.GiveaLot.givealot.Report.service.ReportResponseJSON;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {


   @CrossOrigin
   @PostMapping("/organisation")
   public List<ReportResponseJSON> createReport(@RequestBody createReportRequest request)
   {
        return null;
   }
}