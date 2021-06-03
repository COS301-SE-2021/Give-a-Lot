package com.GiveaLot.givealot.Donation.rri;
import java.time.LocalDateTime;
import java.util.UUID;

public final class getInvoiceResponse {
    private  UUID invoiceID;
    private  LocalDateTime invoicedDate;
    private  String message;

    public getInvoiceResponse(UUID invoiceID, LocalDateTime invoicedDate, String message) {
        this.invoiceID = invoiceID;
        this.invoicedDate = invoicedDate;
        this.message = message;
    }

    public getInvoiceResponse() {
    }
}