package com.GiveaLot.givealot.Donation;
import java.time.LocalDateTime;
import java.util.UUID;
public class Invoice {

    private UUID InvoiceID;
    private LocalDateTime invoicedDate;
    private String details;
    private double totalPrice;

    public Invoice(UUID invoiceID, LocalDateTime INVOICED_DATE, String DETAILS, double TOTAL_PRICE) {
        InvoiceID = invoiceID;
        invoicedDate = INVOICED_DATE;
        details = DETAILS;
        totalPrice = TOTAL_PRICE;

    }

    public Invoice() {

    }
    /** Getters and Setters */
    public LocalDateTime getInvoicedDate() {
        return invoicedDate;
    }

    public void setInvoicedDate(LocalDateTime invoicedDate) {
        this.invoicedDate = invoicedDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public UUID getInvoiceID() {
        return InvoiceID;
    }

    public void setInvoiceID(UUID invoiceID) {
        InvoiceID = invoiceID;
    }

}
