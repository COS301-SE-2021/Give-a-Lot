package com.GiveaLot.givealot.Events.repository;

import com.GiveaLot.givealot.Events.dataclass.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimelineRepository extends JpaRepository<Timeline,Long> {
    @Query("SELECT t FROM Timeline as t where t.orgId = ?1 ORDER BY t.eventDate")
    List<Timeline> getAllEvents(Long orgId);
}

