package com.GiveaLot.givealot.Report.exception;

public class InvalidRequestException extends ReportException
{
    public InvalidRequestException(){}
    public InvalidRequestException(String message){super(message);}
    public InvalidRequestException(String message,Throwable cause){super(message,cause);}
}