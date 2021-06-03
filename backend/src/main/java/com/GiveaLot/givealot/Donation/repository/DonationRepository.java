package com.GiveaLot.givealot.Donation.repository;

import com.GiveaLot.givealot.Donation.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonationRepository extends JpaRepository<Invoice, UUID> {
}