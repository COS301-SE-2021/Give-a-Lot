package com.GiveaLot.givealot.Report.controller;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.dataclass.Reports;
import com.GiveaLot.givealot.Report.requests.*;
import com.GiveaLot.givealot.Report.response.generalReportResponse;
import com.GiveaLot.givealot.Report.service.ReportResponseJSON;
import com.GiveaLot.givealot.Report.service.ReportServiceImpl;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.response.UserResponse;
import com.GiveaLot.givealot.User.response.getUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/report")
public class ReportController {

   @Autowired
   ReportServiceImpl service;


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

   @CrossOrigin
   @PostMapping("/org/")
   public ResponseEntity<generalReportResponse> reportOrganisation(@RequestBody @NonNull reportRequest request)
   {
      try
      {
         return new ResponseEntity<>(service.reportOrganisation(request),HttpStatus.OK);
      }
      catch(Exception e)
      {
         return new ResponseEntity<>(new generalReportResponse("rep_org_failed","report unsuccessful " + e),HttpStatus.BAD_REQUEST);
      }
   }

   @CrossOrigin
   @PostMapping("/get/all")
   public ResponseEntity<responseJSON> getAllReports(@RequestBody @NonNull getReportRequest request)
   {
      try
      {
         return new ResponseEntity<>(service.getAllReports(request.getAdminId()),HttpStatus.OK);
      }
      catch(Exception e)
      {
         return new ResponseEntity<>(new responseJSON("rep_get_failed","report unsuccessful", null),HttpStatus.BAD_REQUEST);
      }
   }

   @CrossOrigin
   @PostMapping("/appeal/")
   public ResponseEntity<generalReportResponse> appealReport(@RequestBody @NonNull appealReportRequest request)
   {
      try
      {
         return new ResponseEntity<>(service.appealReport(request.getOrgId(),request.getAdminId()),HttpStatus.OK);
      }
      catch(Exception e)
      {
         return new ResponseEntity<>(new generalReportResponse("rep_appeal_failed","report unsuccessful"),HttpStatus.BAD_REQUEST);
      }
   }

   @CrossOrigin
   @PostMapping("/get/appealed")
   public ResponseEntity<responseJSON> getAppealedReports(@RequestBody @NonNull getReportRequest request)
   {
      try
      {
         return new ResponseEntity<>(service.getAppealedReports(request.getAdminId()),HttpStatus.OK);
      }
      catch(Exception e)
      {
         return new ResponseEntity<>(new responseJSON("get_appeal_failed","report unsuccessful",null),HttpStatus.BAD_REQUEST);
      }
   }
}