package com.GiveaLot.givealot.Organisation.exceptions;

public class InvalidRequestException extends OrgException{
    public InvalidRequestException(){}
    public InvalidRequestException(String message){super(message);}
    public InvalidRequestException(String message,Throwable cause){super(message,cause);}
}
