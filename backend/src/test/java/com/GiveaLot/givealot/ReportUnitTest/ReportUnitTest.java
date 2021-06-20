package com.GiveaLot.givealot.ReportUnitTest;


import com.GiveaLot.givealot.Report.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Report.exceptions.ReportException;


import com.GiveaLot.givealot.Report.ReportHelper;
import com.GiveaLot.givealot.Report.ReportServiceImpl;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import java.util.Date;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ReportUnitTest {

    @InjectMocks

    createReportRequest request1;
    createReportRequest request2;
    createReportRequest request3;

    createReportResponse response1;

    ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
    ReportHelper reportHelper;

    Report report1;
    Report report2;
    Report report3;


    @BeforeEach
    void setUp() {

        reportHelper = new ReportHelper();


        request1 = null;


        request2 = new createReportRequest("24534643576546", "Some description", "Fraud", "reporter@gmail.com");


        report1 = new Report();
        report2 = new Report(request2.getOrgId(), request2.getReportDescription(), request2.getReportType(), request2.getReporterEmail());
        report3 = new Report(request2.getOrgId(), request2.getReportDescription(), request2.getReportType(), request2.getReporterEmail());



    }

    @Test
    @Description("Assumes that the createReport Request is null")
    void TEST_SHOULD_RETURN_INVALID_REQUEST_EXCEPTION() {
        Throwable throwError = assertThrows(InvalidRequestException.class, () -> reportServiceImpl.createReport(request1));
        assertEquals("Exception: Report could not be created because the request object is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Report object is default")
    void TEST_REPORT_IS_DEFAULT() {
        Throwable throwError = assertThrows(ReportException.class, () -> reportHelper.createReportFile(report1));
        assertEquals("Exception: Report data is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Organisation is already registered in the system")
    void TEST_ORG_ID_NONEXISTENT() {
        Throwable throwError = assertThrows(ReportException.class, () -> reportHelper.createReportFile(report3));
        assertEquals("Exception: ID is not present in the database", throwError.getMessage());
    }
}
