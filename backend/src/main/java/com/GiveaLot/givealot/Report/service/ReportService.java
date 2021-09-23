package com.GiveaLot.givealot.Report.service;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.requests.createReportResponse;
import com.GiveaLot.givealot.Report.requests.reportRequest;
import com.GiveaLot.givealot.Report.response.generalReportResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    createReportResponse createReportFile(Report report) throws Exception;
    boolean updateNumberOfReports(long orgId) throws Exception;
    responseJSON getAllReports(Long orgId) throws Exception;
    generalReportResponse appealReport(Long orgId, Long reportId) throws Exception;
    generalReportResponse reportOrganisation(reportRequest request) throws Exception;
    responseJSON getAppealedReports(Long adminId) throws Exception;
}
