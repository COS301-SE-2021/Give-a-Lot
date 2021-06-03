package com.GiveaLot.givealot.Donation.rri;
import java.util.UUID;
public final class getInvoiceRequest{

    private final UUID invoiceID;

    public getInvoiceRequest( UUID invoiceID){
        if(invoiceID==null){
            String excMsg = "InvoiceID can not be null";
            throw new NullPointerException(excMsg);
        }
        this.invoiceID = invoiceID;
    }
    public UUID getInvoiceID() {
        return invoiceID;
    }

}