package com.GiveaLot.givealot.Report.rri;

import com.GiveaLot.givealot.Report.ReportResponseJSON;

import java.io.File;
import java.util.List;

public class createReportResponse {
    private File reportFile;
    private List<ReportResponseJSON> ReportResponseJSON;

    public createReportResponse(){}

    public File getReportFile(){return reportFile;}

    public void setReportFile(File file){ this.reportFile = file; }

    public void setReportJSON(List<ReportResponseJSON> ok)
    {
        ReportResponseJSON = ok;
    }

    public List<ReportResponseJSON> getReportResponseJSON() {
        return ReportResponseJSON;
    }
}
