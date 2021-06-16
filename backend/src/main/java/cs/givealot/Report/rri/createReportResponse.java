package main.java.cs.givealot.Report.rri;

import java.io.File;

public class createReportResponse {
    private File reportFile;

    public createReportResponse(){}
    public File getReportFile(){return reportFile; }
    public void setReportFile(File file){ this.reportFile = file; }
}
