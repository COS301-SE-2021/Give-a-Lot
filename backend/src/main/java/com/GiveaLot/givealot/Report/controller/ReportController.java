package com.GiveaLot.givealot.Report.controller;
import com.GiveaLot.givealot.Report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;



   public List<String> createReport(@RequestBody String reportDescription, String reportType, String reporterUsername)
   {
       List<String> res = new LinkedList<>();

       res.add("status: 200");
       res.add("status: 200");
       return res;
   }

}
