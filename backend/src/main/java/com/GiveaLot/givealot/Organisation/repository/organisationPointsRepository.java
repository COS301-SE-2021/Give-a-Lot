package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface organisationPointsRepository extends JpaRepository<OrganisationPoints,Long> {

    @Query("select op from OrganisationPoints op where op.orgId = ?1")
    OrganisationPoints selectOrganisationPoints(long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.addressIsValid = ?2 WHERE op.orgId = ?1")
    int Address(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.auditIsValid = ?2 WHERE op.orgId = ?1")
    int Audit(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.auditorIsValid = ?2 WHERE op.orgId = ?1")
    int Auditor(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.committeeIsValid = ?2 WHERE op.orgId = ?1")
    int Committee(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.estDateIsValid = ?2 WHERE op.orgId = ?1")
    int EstablishmentDate(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.facebookIsValid = ?2 WHERE op.orgId = ?1")
    int Facebook(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.instagramIsValid = ?2 WHERE op.orgId = ?1")
    int Instagram(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.twitterIsValid = ?2 WHERE op.orgId = ?1")
    int Twitter(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.ngoDateIsValid = ?2 WHERE op.orgId = ?1")
    int NGO_Date(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.ngoNoIsValid = ?2 WHERE op.orgId = ?1")
    int NGO_Number(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.taxRefIsValid = ?2 WHERE op.orgId = ?1")
    int taxRaf(long orgId, boolean value);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationPoints op SET op.websiteIsValid = ?2 WHERE op.orgId = ?1")
    int Website(long orgId, boolean value);
}
