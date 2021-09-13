package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
* Todo:
*  1) Register organisation - done
*  2) Select AddOrganisationRequest - done
*  3) suspend AddOrganisationRequest - done
*  4) activate AddOrganisationRequest - done
*  5) investigate AddOrganisationRequest - done
*/

@Repository
public interface OrganisationRepository extends JpaRepository<Organisations,Long>
{
    @Query("SELECT distinct o FROM Organisations AS o")
    List<Organisations> getAllOrganisations();

    @Query("select o from Organisations o where o.orgId = ?1 AND NOT o.status = 'suspended' ")
    Organisations selectOrganisationById(Long orgId);

    @Query("select o from Organisations o where o.orgEmail = ?1")
    Organisations selectOrganisationByEmail(String orgEmail);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.status = ?2 WHERE o.orgId = ?1")
    Integer updateStatus(Long orgId, String status);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.directory = ?2 WHERE o.orgId = ?1")
    Integer updateRepo(Long orgId, String dir);

    @Query("SELECT DISTINCT o.orgId FROM Organisations AS o WHERE o.orgEmail = ?1")
    long getOrgId(String orgEmail);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.orgDescription = ?2 WHERE o.orgId = ?1")
    int updateDescription(Long orgId, String newValue);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.orgName = ?2 WHERE o.orgId = ?1")
    int updateOrgName(Long orgId, String newValue);
    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.contactNumber = ?2 WHERE o.orgId = ?1")
    int updateContactNumber(Long orgId, String newValue);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.slogan = ?2 WHERE o.orgId = ?1")
    int updateSlogan(Long orgId, String newValue);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.orgEmail = ?2 WHERE o.orgId = ?1")
    int updateEmail(Long orgId, String newValue);

    @Modifying
    @Transactional
    @Query("UPDATE Organisations o SET o.contactPerson = ?2 WHERE o.orgId = ?1")
    int updatePerson(Long orgId, String newValue);
}
