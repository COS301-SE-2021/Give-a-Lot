package com.GiveaLot.givealot.Events.repository;

import com.GiveaLot.givealot.Events.dataclass.Calender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface calenderRepository extends JpaRepository<Calender,Long>
{
    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.title = null WHERE c.eventId = ?1")
    Integer editEventTitle(Long eventId, String newTitle);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.description = null WHERE c.eventId = ?1")
    Integer editEventDescription(Long eventId, String newDescription);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.startTime = null WHERE c.eventId = ?1")
    Integer editEventStartTime(Long eventId, String newStartTime);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.endTime = null WHERE c.eventId = ?1")
    Integer editEventEndTime(Long eventId, String newEndTime);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.endDate = null WHERE c.eventId = ?1")
    Integer editEventEndDate(Long eventId, String newEndDate);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.startDate = null WHERE c.eventId = ?1")
    Integer editEventStartDate(Long eventId, String newStartDate);
}
