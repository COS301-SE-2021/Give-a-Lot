package com.GiveaLot.givealot.Report.exceptions;



public class NotAuthorizedException extends ReportException {
    public NotAuthorizedException(){}
    public NotAuthorizedException(String message){super(message);}
    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

}