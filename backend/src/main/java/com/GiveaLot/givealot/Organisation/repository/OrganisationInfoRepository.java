package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.dataclass.organisationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationInfoRepository extends JpaRepository<organisationInfo,String>
{
    @Query("select i from organisationInfo i where i.orgId = ?1")
    organisationInfo selectOrganisationInfo(String orgId);
}
