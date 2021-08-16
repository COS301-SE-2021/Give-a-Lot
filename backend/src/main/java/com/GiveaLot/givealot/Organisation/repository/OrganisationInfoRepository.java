package com.GiveaLot.givealot.Organisation.repository;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/*
*  Todo:
*   1) select organisation info - done
*   2) create organisation points field for an organisation - done
*   3) add organisation website - done
*   4) remove organisation website - done
*   5) add org address - done
*   6) remove org address - done
*   7) add tax reference - done
*   8) remove tax reference - done
*   9) add twitter, facebook, instagram - done
*/

@Repository
public interface OrganisationInfoRepository extends JpaRepository<OrganisationInfo,Long>
{
    @Query("select i from OrganisationInfo i where i.orgId = ?1")
    OrganisationInfo selectOrganisationInfo(Long orgId);

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
    @Query("UPDATE OrganisationInfo i SET i.taxReference = ?2 WHERE i.orgId = ?1")
    Integer addOrgTaxRef(Long orgId, String taxRef);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.taxReference = null WHERE i.orgId = ?1")
    Integer removeOrgTaxRef(Long orgId);

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
    Integer addNGODate(Long orgId, Date NGODate);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.NGODate = null WHERE i.orgId = ?1")
    Integer removeNGODate(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationInfo i SET i.establishmentDate = ?2 WHERE i.orgId = ?1")
    Integer addEstDate(Long orgId, Date estDate);

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
    @Query("UPDATE OrganisationInfo i SET i.numberOfImages = ?2 WHERE i.orgId = ?1")
    Integer decrementImage(Long orgId, int imageCount);

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
