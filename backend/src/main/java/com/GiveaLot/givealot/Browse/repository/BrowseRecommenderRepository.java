package com.GiveaLot.givealot.Browse.repository;

import com.GiveaLot.givealot.Browse.model.Browse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrowseRecommenderRepository extends JpaRepository<Browse,Long>
{
    @Query("SELECT DISTINCT b.interactions from Browse AS b where b.orgId = ?1 AND b.sector = ?2")
    Integer getInteractionsFromSector(Long orgId, String sector);

}
