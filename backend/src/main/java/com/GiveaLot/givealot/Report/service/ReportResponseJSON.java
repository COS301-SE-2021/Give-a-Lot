package com.GiveaLot.givealot.Report.service;

import java.io.File;

public class ReportResponseJSON
{
    int code;
    String status;
    private File reportFile;

    public ReportResponseJSON(int http_code, String status, File reportFile)
    {
        this.code = http_code;
        this.status = status;
        this.reportFile = reportFile;
    }

    public File getReportFile() {
        return reportFile;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
