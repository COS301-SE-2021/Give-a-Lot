package main.java.cs.givealot.Report;

import main.java.cs.givealot.Report.exceptions.ReportException;
import main.java.cs.givealot.Report.exceptions.InvalidRequestException;
import main.java.cs.givealot.Report.exceptions.NotAuthorizedException;
import main.java.cs.givealot.Report.exceptions.TypeException;
import main.java.cs.givealot.Report.rri.createReportResponse;
import main.java.cs.givealot.Report.rri.createReportRequest;

public interface ReportService {

    /**
     * Generates a new Report .
     * @param request:createReportRequest Object
     * @return createReportResponse object that holds the created report
     * @throws NotAuthorizedException if user is not an admin that is trying to generate report
     * @throws ReportException if Report could not be generated for some reason
     * @throws InvalidRequestException if the request object is not correct
     * @throws TypeException if the type provided is not valid
     */

    createReportResponse createReport(createReportRequest request) throws Exception;
}
