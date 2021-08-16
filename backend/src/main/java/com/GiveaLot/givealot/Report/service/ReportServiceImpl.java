package com.GiveaLot.givealot.Report.service;

import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Server.ServerAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    public boolean createReportFile(Report report) throws Exception{

        try {

            /** Create file **/

            String reportName = "report" + report.getId();
            reportName = reportName.replaceAll("[^a-zA-Z0-9]", "");
            File file = new File("frontend/givealot/reports/organisationReport/" + reportName + ".txt");
            if (file.createNewFile()) {
            } else {
                throw new Exception("Exception: File already exists");
            }

            /** Write to file **/

            String id = report.getId().toString();
            String date = report.getDate().toString();
            String orgId = Long.toString(report.getOrgId());
            FileWriter writer = new FileWriter("frontend/givealot/reports/organisationReport/" + reportName + ".txt");

            writer.write("ID: ");
            writer.write(id);
            writer.write("\n");
            writer.write("Date: ");
            writer.write(date);
            writer.write("\n");
            writer.write("Reporter email: ");
            writer.write(report.getReporterEmail());
            writer.write("\n");
            writer.write("Organisation ID: ");
            writer.write(orgId);
            writer.write("\n");
            writer.write("Organisation Name: ");
            writer.write(report.getOrgName());
            writer.write("\n");
            writer.write("Type: ");
            writer.write(report.getReportType());
            writer.write("\n");
            writer.write("Description: ");
            writer.write(report.getReportDescription());
            writer.write("\n");

            writer.close();

            /** Update database **/

            try
            {
                int reports = organisationInfoRepository.selectOrganisationInfo(report.getOrgId()).getNumberOfReports();
                organisationInfoRepository.incrementReports(report.getOrgId(),reports+1);
            }
            catch (Exception e){
                throw new SQLException("Exception: ID is not present in the database");
            }
            System.out.println("Work");
            ServerAccess access = new ServerAccess();
            access.uploadReport(report.getOrgId(),file,date);
            return true;
        }
        catch (Exception e) {
            throw new Exception("Exception: " + e);
        }
    }

    public static void main(String[] args) throws Exception {
        ReportServiceImpl reportService = new ReportServiceImpl();

        Report report = new Report(45,"New Org","they stole my money","theft","reporterEmail");

        reportService.createReportFile(report);
    }
}
