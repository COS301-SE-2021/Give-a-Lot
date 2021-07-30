package com.GiveaLot.givealot.Organisation.exceptions;

public class OrganisationException extends Exception{
    public OrganisationException(){}
    public OrganisationException(String message){ super(message);}
    public OrganisationException(String message,Throwable cause){super(message,cause);}
}
