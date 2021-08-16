package com.GiveaLot.givealot.Report.controller;
import com.GiveaLot.givealot.Report.ReportResponseJSON;
import com.GiveaLot.givealot.Report.service.*;
import com.GiveaLot.givealot.Report.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
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