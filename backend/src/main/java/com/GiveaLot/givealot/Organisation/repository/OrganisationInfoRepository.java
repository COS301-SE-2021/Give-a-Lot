package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface OrganisationInfoRepository extends JpaRepository<OrganisationInfo, Long> {
    @Query("select i from OrganisationInfo i where i.orgId = ?1")
    OrganisationInfo selectOrganisationInfo(Long orgId);

    @Query(value = "SELECT min(orgId) FROM OrganisationInfo")
    Long getOrgBottom();

    @Query(value = "SELECT max(orgId) FROM OrganisationInfo")
    Long getOrgTop();

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.website = ?2 WHERE i.orgId = ?1")
    Integer addOrgWebsite(Long orgId, String url);


    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.website = null WHERE i.orgId = ?1")
    Integer removeOrgWebsite(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.address = ?2 WHERE i.orgId = ?1")
    Integer addOrgAddress(Long orgId, String address);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.address = null WHERE i.orgId = ?1")
    Integer removeOrgAddress(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.donationURL = ?2 WHERE i.orgId = ?1")
    Integer addOrgDonationURL(Long orgId, String taxRef);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.donationURL = null WHERE i.orgId = ?1")
    Integer removeOrgDonationURL(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.auditDocument = ?2 WHERE i.orgId = ?1")
    Integer addAuditDoc(Long orgId, String auditDoc);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.auditDocument = null WHERE i.orgId = ?1")
    Integer removeAuditDoc(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.auditorDetails = ?2 WHERE i.orgId = ?1")
    Integer addAuditor(Long orgId, String auditor);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.auditorDetails = null WHERE i.orgId = ?1")
    Integer removeAuditor(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.committeeDetails = ?2 WHERE i.orgId = ?1")
    Integer addCommittee(Long orgId, String committee);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.committeeDetails = null WHERE i.orgId = ?1")
    Integer removeCommittee(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.NGONumber = ?2 WHERE i.orgId = ?1")
    Integer addNGONumber(Long orgId, String NgoNumber);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.NGONumber = null WHERE i.orgId = ?1")
    Integer removeNGONUmber(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.NGODate = ?2 WHERE i.orgId = ?1")
    Integer addNGODate(Long orgId, String NGODate);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.NGODate = null WHERE i.orgId = ?1")
    Integer removeNGODate(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.establishmentDate = ?2 WHERE i.orgId = ?1")
    Integer addEstDate(Long orgId, String estDate);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.establishmentDate = null WHERE i.orgId = ?1")
    Integer removeEstDate(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.numberOfImages = ?2 WHERE i.orgId = ?1")
    Integer incrementImage(Long orgId, int imageCount);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.numberOfImages = i.numberOfImages+1 WHERE i.orgId = ?1")
    Integer incrementNumImagesd(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.numberOfImages = ?2 WHERE i.orgId = ?1")
    Integer decrementImage(Long orgId, int imageCount);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.numberOfReports = ?2 WHERE i.orgId = ?1")
    Integer incrementReports(Long orgId, int reportCount);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.numberOfReports = ?2 WHERE i.orgId = ?1")
    Integer decrementReports(Long orgId, int reportCount);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.twitter = ?2 WHERE i.orgId = ?1")
    Integer addTwitter(Long orgId, String handle);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.instagram = ?2 WHERE i.orgId = ?1")
    Integer addInstagram(Long orgId, String handle);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.facebook = ?2 WHERE i.orgId = ?1")
    Integer addFacebook(Long orgId, String handle);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.twitter = null WHERE i.orgId = ?1")
    Integer removeTwitter(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.instagram = null WHERE i.orgId = ?1")
    Integer removeInstagram(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.facebook = null WHERE i.orgId = ?1")
    Integer removeFacebook(Long orgId);


}
