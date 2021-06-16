package com.GiveaLot.givealot.Report.exceptions;

public class OngoingReportException extends Exception{

    public OngoingReportException(){}
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OngoingReportException(String message){
        super(message);
    }
    public OngoingReportException(String message,Throwable cause){super(message,cause);}
}
