package com.GiveaLot.givealot.Organisation.exceptions;

public class OrgException extends Exception{
    public OrgException(){}
    public OrgException(String message){ super(message);}
    public OrgException(String message,Throwable cause){super(message,cause);}
}