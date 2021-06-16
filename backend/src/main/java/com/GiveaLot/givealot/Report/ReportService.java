package com.GiveaLot.givealot.Report;

import com.GiveaLot.givealot.Report.exceptions.ReportException;
import com.GiveaLot.givealot.Report.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Report.exceptions.NotAuthorizedException;
import com.GiveaLot.givealot.Report.exceptions.TypeException;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Search.exceptions.InvalidInputException;
import com.GiveaLot.givealot.Search.exceptions.ResultNotFoundException;
import com.GiveaLot.givealot.Search.rri.searchOrganisationRequest;
import com.GiveaLot.givealot.Search.rri.searchOrganisationResponse;

public interface ReportService {

    /**
     * Generates a new Report .
     * @param request:createReportRequest Object
     * @return createReportResponse object that holds the created report
     * @throws NotAuthorizedException if user is not an admin that is trying to generate report
     * @throws ReportException if Report could not be generated for some reason
     * @throws InvalidRequestException if the request object is not correct
     * @throws TypeException if the type provided is not valid []
     */

    createReportResponse createReport(createReportRequest request) throws Exception;
}


