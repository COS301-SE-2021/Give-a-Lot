package com.GiveaLot.givealot.Report.service;

import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationResponse;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.dataclass.Reports;
import com.GiveaLot.givealot.Report.repository.reportRepository;
import com.GiveaLot.givealot.Report.requests.createReportResponse;
import com.GiveaLot.givealot.Report.requests.reportRequest;
import com.GiveaLot.givealot.Report.response.generalReportResponse;
import com.GiveaLot.givealot.Server.ServerAccess;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private reportRepository reportRepository;

    @Autowired
    private final ServerAccess access = new ServerAccess();

    @Override
    public createReportResponse createReportFile(Report report) throws Exception {
        try {

            /** Create file **/

            String reportName = "report" + report.getId();
            reportName = reportName.replaceAll("[^a-zA-Z0-9]", "");
            File file = new File("frontend/givealot/reports/organisationReport/" + reportName + ".txt");

            if (!file.createNewFile()) {
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

            updateNumberOfReports(report.getOrgId());
            access.uploadReport(report.getOrgId(), file, date);
            return new createReportResponse("report_org_200_ok", "success", report);
        } catch (Exception e) {
            throw new Exception("Exception: " + e);
        }
    }

    @Override
    public boolean updateNumberOfReports(long orgId) throws Exception {
        try {
            int reports = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfReports();
            organisationInfoRepository.incrementReports(orgId, reports + 1);
            return true;
        } catch (Exception e) {
            throw new Exception("Exception: ID is not present in the database" + e);
        }
    }

    @Override
    public generalReportResponse reportOrganisation(reportRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");
        else if (request.getDescription() == null || request.getDescription().isEmpty())
            throw new Exception("Invalid description, null or empty provided");
        else if (request.getReportType() == null || request.getReportType().isEmpty())
            throw new Exception("Invalid report type, null or empty provided");
        else if (request.getOrgId() == null || request.getUserId() == null)
            throw new Exception("Invalid id, null provided");
        else if (userRepository.findUserById(request.getUserId()) == null)
            throw new Exception("user id does not exist");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("org id does not exist");

        Reports reports = new Reports();
        reports.setReportType(request.getReportType());
        reports.setOrgId(request.getOrgId());
        reports.setUserId(request.getUserId());

        Date dateCurrent = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);

        reports.setAppealed(false);
        reports.setDate(dateCreated);
        reports.setDescription(request.getDescription());
        reportRepository.save(reports);

        return new generalReportResponse("report_200_OK", "success");
    }

    @Override
    public responseJSON getAllReports(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("id does not exist");

        List<Reports> res = reportRepository.getAllReports(orgId);
        return new responseJSON("get_reports_200_OK", "success", res);
    }

    @Override
    public generalReportResponse appealReport(Long orgId, Long reportId) throws Exception {
        if (orgId == null)
            throw new Exception("provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("id does not exist");

        if (reportRepository.getReportById(reportId) == null)
            throw new Exception("report does not exist");

        reportRepository.appealReport(reportId);

        return new generalReportResponse("appeal_reports_200_OK", "success");
    }

    @Override
    public responseJSON getAppealedReports(Long adminId) throws Exception {
        if (adminId == null)
            throw new Exception("id is null");
        else if (userRepository.findUserById(adminId) == null)
            throw new Exception("user not found");
        else if (!userRepository.findUserById(adminId).getAdmin())
            throw new Exception("not authorized");

        return new responseJSON("get_app_reports_OK", "success", reportRepository.getAppealedReports());
    }


    public static void main(String[] args) throws Exception {
        ReportServiceImpl reportService = new ReportServiceImpl();

        Report report = new Report(45, "New Org", "they stole my money", "theft", "reporterEmail");

        reportService.createReportFile(report);
    }
}
