package com.GiveaLot.givealot.Certificate.exceptions;

public class InvalidRequestException extends CertificateException
{
    public InvalidRequestException(){}
    public InvalidRequestException(String message){super(message);}
    public InvalidRequestException(String message,Throwable cause){super(message,cause);}
}
