package com.GiveaLot.givealot.Report.service;

import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.requests.createReportResponse;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    public createReportResponse createReportFile(Report report) throws Exception;


}
