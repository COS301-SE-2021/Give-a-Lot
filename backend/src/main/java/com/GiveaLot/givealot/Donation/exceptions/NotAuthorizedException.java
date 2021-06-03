package com.GiveaLot.givealot.Donation.exceptions;

public class NotAuthorizedException extends DonationException {
    public NotAuthorizedException(String message) {
        super(message);
    }
}