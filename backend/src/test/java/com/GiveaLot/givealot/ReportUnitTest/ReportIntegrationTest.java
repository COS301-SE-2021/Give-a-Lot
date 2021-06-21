package com.GiveaLot.givealot.ReportUnitTest;

import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Report.ReportHelper;
import com.GiveaLot.givealot.Report.ReportServiceImpl;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class ReportIntegrationTest {

    @Test
    @Description("Creates, files and displays the report created by a user")
    void TEST_REPORT() throws Exception {
        ReportServiceImpl service = new ReportServiceImpl();
        ReportHelper help = new ReportHelper();

        Report request = new Report("4941d81fe9e50abfd6e18595b78a21cf", "Some description", "Fraud", "reporter@gmail.com");

        createReportResponse  response = new createReportResponse();
        response.setReportFile(help.createReportFile(request));

        File report = response.getReportFile();
        //System.out.println(report);
        Scanner reader = new Scanner(report);

        while (reader.hasNextLine())
        {
            String data = reader.nextLine();
            System.out.println(data);
        }
        //reader.close();

    }


    @Test
    @Description("Runs the whole Report micro service")
    void TEST_INTEGRATION_REPORT() throws Exception {
        ReportServiceImpl service = new ReportServiceImpl();
        ReportHelper help = new ReportHelper();

        createReportRequest request = new createReportRequest("4941d81fe9e50abfd6e18595b78a21cf", "Some description", "Fraud", "reporter@gmail.com");

        service.createReport(request);

    }
}
