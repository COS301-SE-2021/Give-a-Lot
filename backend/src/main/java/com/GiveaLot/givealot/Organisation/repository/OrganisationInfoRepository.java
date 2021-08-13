package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.dataclass.organisationInfo;
import com.GiveaLot.givealot.Organisation.requests.AddOrgAddressRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
*  Todo:
*   1) select organisation info - done
*   2) create organisation points field for an organisation - done
*   3) add organisation website - done
*   4) remove organisation website - done
*   5)
* */
@Repository
public interface OrganisationInfoRepository extends JpaRepository<organisationInfo,String>
{
    @Query("select i from organisationInfo i where i.orgId = ?1")
    organisationInfo selectOrganisationInfo(String orgId);

    @Modifying
    @Transactional
    @Query("UPDATE organisationInfo i SET i.orgWebsite = ?2 WHERE i.orgId = ?1")
    Integer addOrgWebsite(String orgId, String url);

    @Modifying
    @Transactional
    @Query("UPDATE organisationInfo i SET i.orgWebsite = null WHERE i.orgId = ?1")
    Integer removeOrgWebsite(String orgId);

    @Modifying
    @Transactional
    @Query("UPDATE organisationInfo i SET i.address = ?2 WHERE i.orgId = ?1")
    Integer addOrgAddress(String orgId, String address);


    @Modifying
    @Transactional
    @Query("UPDATE organisationInfo i SET i.address = null WHERE i.orgId = ?1")
    Integer removeOrgAddress(String orgId);
}
