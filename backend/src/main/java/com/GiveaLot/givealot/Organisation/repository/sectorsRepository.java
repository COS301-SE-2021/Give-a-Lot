package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sectorsRepository extends JpaRepository<Sectors, String> {
    @Query("SELECT s.sector FROM Sectors AS s order by s.sector")
    List<String> getSectors();

    @Query("SELECT s.sector FROM Sectors AS s order by s.organisations desc")
    List<String> getSectorsDescendingByOrganisations();

    @Query("SELECT distinct s FROM Sectors AS s where s.sector = ?1")
    Sectors getSector(String sector);
}