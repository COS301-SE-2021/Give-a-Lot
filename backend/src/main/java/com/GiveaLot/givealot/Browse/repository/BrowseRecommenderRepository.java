package com.GiveaLot.givealot.Browse.repository;

import com.GiveaLot.givealot.Browse.model.Browse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrowseRecommenderRepository extends JpaRepository<Browse,Long>
{
    @Query("SELECT DISTINCT b.interactions from Browse AS b where b.userId = ?1 AND b.sector = ?2")
    Integer getInteractionsbySector(Long userId, String sector);

    @Query("SELECT DISTINCT b.sector from Browse AS b order by b.interactions")
    List<String> getInteractionsbySector();

}
