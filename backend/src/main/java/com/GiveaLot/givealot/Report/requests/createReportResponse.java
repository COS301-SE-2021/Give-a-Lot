package com.GiveaLot.givealot.Report.requests;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.service.ReportResponseJSON;

import java.io.File;
import java.util.List;

public class createReportResponse {
    private String code;
    private String message;
    private Report response;

    public createReportResponse(String code, String message, Report response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Report getResponse() {
        return response;
    }

    public void setResponse(Report response) {
        this.response = response;
    }
}
