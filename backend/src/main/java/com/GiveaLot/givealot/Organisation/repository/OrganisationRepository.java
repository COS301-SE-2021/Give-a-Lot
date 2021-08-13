package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.dataclass.OrganisationRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/*
* Todo:
*  1) Register organisation - done
*  2) Select Organisation - done
*  3) suspend Organisation - done
*  4) activate Organisation - done
*  5) investigate Organisation - done
*
*
* */
public interface OrganisationRepository extends JpaRepository<OrganisationRepo,String> {

    @Query("select o from OrganisationRepo o where o.orgId = ?1")
    OrganisationRepo selectOrganisation(String orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationRepo o SET o.status = ?2 WHERE o.orgId = ?1")
    Integer updateStatus(String orgId, String status);

}
