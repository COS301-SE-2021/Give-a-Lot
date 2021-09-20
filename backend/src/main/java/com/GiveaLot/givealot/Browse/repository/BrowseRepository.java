package com.GiveaLot.givealot.Browse.repository;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrowseRepository extends JpaRepository<Organisations,Long> {

    /*
    *  helper function for get getOrgs
    */
    @Query("SELECT distinct o.orgSector FROM Organisations AS o")
    List<String> getAllSectors();

    @Query("SELECT distinct o FROM Organisations AS o where o.orgSector = ?1 AND o.status NOT IN('suspended')")
    List<Organisations> getOrganisationsBySector(String sector);







}
