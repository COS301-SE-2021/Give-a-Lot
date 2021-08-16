package com.GiveaLot.givealot.Report.service;

import com.GiveaLot.givealot.Report.dataclass.Report;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public interface ReportService {
    public boolean createReportFile(Report report) throws Exception;


}
