package com.GiveaLot.givealot.Donation;
import com.GiveaLot.givealot.Donation.rri.*;
import com.GiveaLot.givealot.Donation.repository.*;
import com.GiveaLot.givealot.Donation.exceptions.*;

import java.util.UUID;

public class DonationServiceImpl {
    private DonationRepository invoiceRepo;

    public DonationServiceImpl(DonationRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public getInvoiceResponse getInvoice(getInvoiceRequest getInvoiceRequest) throws InvalidRequestException {
        if (getInvoiceRequest == null) {
            throw new InvalidRequestException("Invoice Request object cannot be null");
        }
        final UUID InvoiceID = getInvoiceRequest.getInvoiceID(); //Invoice ID passed in
        Invoice invoice = null;
        if (!invoiceRepo.findById(InvoiceID).isPresent())
            throw new InvalidRequestException("Invoice associated with Invoice ID: " + InvoiceID + "could not be found!");
        invoice = invoiceRepo.findById(InvoiceID).get(); //Find the associated Invoice
        getInvoiceResponse response = new getInvoiceResponse(InvoiceID, invoice.getInvoicedDate(), invoice.getDetails());
        return response; //Return Invoice
    }
}
