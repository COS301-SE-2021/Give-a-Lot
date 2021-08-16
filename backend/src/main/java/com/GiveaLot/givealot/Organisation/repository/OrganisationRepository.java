package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    @Query("select o from Organisations o where o.orgId = ?1")
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

/*
    adminValidateWebsite
    String query1 = "update public.\"OrganisationPoints\" set \"websiteIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = '" + orgid + "';";

    adminValidateAdress
    String query1 = "update public.\"OrganisationPoints\" set \"addressIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = '" + orgid + "';";

    adminValidateNoOfImages
    String query1 = "update public.\"OrganisationPoints\" set \"addressIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = '" + orgid + "';";

    adminValidateAuditDoc
    String query1 = "update public.\"OrganisationPoints\" set \"auditIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 15 where \"orgId\" = '" + orgid + "';";

    adminValidateOrgTaxRef
    String query1 = "update public.\"OrganisationPoints\" set \"taxRefIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = '" + orgid + "';";

    adminValidateAuditor
    String query1 = "update public.\"OrganisationPoints\" set \"auditorIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = '" + orgid + "';";

    adminValidateOrgCommittee
    String query1 = "update public.\"OrganisationPoints\" set \"committeeIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = '" + orgid + "';";

    adminValidatOrgSocials
    //WORKS THE SAME WAY FOR FACEBOOK AND INSTAGRAM
    String query = "update public.\"OrganisationPoints\" set \"points\" = points+5 where \"orgId\" = '" + orgid + "';";
    String query1 = "update public.\"OrganisationPoints\" set \"twitterIsValid\" = true where \"orgId\" = '" + orgid + "';";

    adminValidateOrgNGO
    String query1 = "update public.\"OrganisationPoints\" set \"ngoNoIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query3 = "update public.\"OrganisationPoints\" set \"points\" = points + 15 where \"orgId\" = '" + orgid + "';";

    adminValidateOrgEstDate
    String query1 = "update public.\"OrganisationPoints\" set \"estDateIsValid\" = true where \"orgId\" = '" + orgid + "';";
    String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = '" + orgid + "';";

    */

}
