package com.GiveaLot.givealot.Events.repository;

import com.GiveaLot.givealot.Events.dataclass.Calender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface calenderRepository extends JpaRepository<Calender,Long>
{
    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.title = ?2 WHERE c.eventId = ?1")
    Integer editEventTitle(Long eventId, String newTitle);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.description = ?2 WHERE c.eventId = ?1")
    Integer editEventDescription(Long eventId, String newDescription);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.startTime = ?2 WHERE c.eventId = ?1")
    Integer editEventStartTime(Long eventId, String newStartTime);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.endTime = ?2 WHERE c.eventId = ?1")
    Integer editEventEndTime(Long eventId, String newEndTime);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.endDate = ?2 WHERE c.eventId = ?1")
    Integer editEventEndDate(Long eventId, String newEndDate);

    @Modifying
    @Transactional
    @Query("UPDATE Calender c SET c.startDate = ?2 WHERE c.eventId = ?1")
    Integer editEventStartDate(Long eventId, String newStartDate);

    @Query("SELECT c FROM Calender AS c where c.userEmail = ?1")
    List<Calender> getCalenderEvents(String userEmail);

    @Query("SELECT c FROM Calender AS c where c.userEmail = ?1 AND c.startTime = ?2 AND c.endTime = ?3 AND c.startDate = ?4 AND c.endDate = ?5")
    Calender checkDuplicate(String userEmail,String startTime, String endTime, String startDate, String endDate);
}
