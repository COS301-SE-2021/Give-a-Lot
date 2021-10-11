package com.GiveaLot.givealot.Browse.repository;

import com.GiveaLot.givealot.Browse.model.Browse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BrowseRecommenderRepository extends JpaRepository<Browse,Long>
{
    @Query("SELECT s.sector FROM Browse AS s where s.userId = ?1 order by s.interactions desc")
    List<String> getInteractionsbySectorUser (Long userId);

    @Query("SELECT s.sector FROM Browse AS s order by s.interactions desc")
    List<String> getInteractionsbySectorGeneral();

    @Query("SELECT s FROM Browse AS s where s.userId = ?1 AND s.sector = ?2")
    Browse getRowByUserIdAndSector(Long userId,String sector);


    @Query("SELECT s FROM Browse AS s where s.userId = ?1")
    List<Browse> getInteractionsForUser(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Browse b SET b.interactions = ?2 WHERE b.userId = ?1 AND b.sector = ?3")
    int updateInteractions(Long userId, int interactions, String sector);

}
