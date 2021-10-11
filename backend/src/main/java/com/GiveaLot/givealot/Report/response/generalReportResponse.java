package com.GiveaLot.givealot.Report.response;

public class generalReportResponse
{
    String status;
    String message;

    public generalReportResponse(String status, String message)
    {
        this.message = message;
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
