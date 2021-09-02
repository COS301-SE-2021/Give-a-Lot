package com.GiveaLot.givealot.Report.controller;

import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.requests.createReportRequest;
import com.GiveaLot.givealot.Report.requests.createReportResponse;
import com.GiveaLot.givealot.Report.service.ReportResponseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.response.getUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {


   @CrossOrigin
   @PostMapping("/organisation")
   public ResponseEntity<createReportResponse> createReport(@RequestBody createReportRequest request)
   {
      createReportResponse createReportResponse;
      try {
         Report report = new Report(request.getOrgId(), request.getReportDescription(),request.getOrgName() ,request.getReportType(),request.getReporterEmail());
         if(request != null)
         {
             createReportResponse = new createReportResponse("rep_org_succ","report successful",report);
             return new ResponseEntity<>(createReportResponse,HttpStatus.OK);
         }
         return new ResponseEntity<>(new createReportResponse("rep_org_usucc","report unsuccessful",null),HttpStatus.OK);

      }
      catch (Exception e)
      {
         return new ResponseEntity<>(new createReportResponse("rep_org_usucc","report unsuccessful",null),HttpStatus.OK);

      }
   }

}