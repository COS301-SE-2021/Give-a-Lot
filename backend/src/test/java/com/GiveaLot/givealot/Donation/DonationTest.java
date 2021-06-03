package com.GiveaLot.givealot.Donation;
import java.time.LocalDateTime;

import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Donation.repository.DonationRepository;
import com.GiveaLot.givealot.Donation.rri.getInvoiceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DonationTest {
    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private DonationServiceImpl donationService;

    UUID invID = UUID.randomUUID();
    Invoice inv1;
    void setUp() {
        inv1 = new Invoice(invID,LocalDateTime.now(),"Test1",0.00);
    }


    @Test
    @DisplayName("When invoice does not exist")
    void GetInvoiceRequestNoInvoiceFound() {
        getInvoiceRequest testReq = new getInvoiceRequest(UUID.randomUUID());
        when(donationRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Throwable thrown = assertThrows(InvalidRequestException.class, ()-> DonationService.getInvoice(testReq));
        assertEquals("Invoice associated with Invoice ID: " + testReq.getInvoiceID() + "could not be found!", thrown.getMessage());
    }
    @Test
    @DisplayName("GetInvoiceRequestObject - No Constructor for null Invoice ID")
    void GetInvoiceRequestNullInvoiceID() {
        Throwable thrown = assertThrows(NullPointerException.class, ()-> new getInvoiceRequest(null));
        assertEquals("InvoiceID can not be null", thrown.getMessage());
    }
}
