package com.GiveaLot.givealot.Report.exceptions;

public class OngoingReportException extends Exception{

    public OngoingReportException(){}

    public OngoingReportException(String message){
        super(message);
    }
    public OngoingReportException(String message,Throwable cause){
        super(message,cause);
    }
}
