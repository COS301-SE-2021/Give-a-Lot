package com.GiveaLot.givealot.Notification.repository;

import com.GiveaLot.givealot.Notification.dataclass.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    @Query("SELECT o FROM Notification AS o WHERE o.isOpen = false ")
    List<Notification> getAllNotifications();
    @Modifying
    @Transactional
    @Query("UPDATE Notification o SET o.org_name = ?2 WHERE o.org_id = ?1")
    int updateOrgName(Long orgId, String newValue);
    @Query("SELECT o from Notification as o where o.notification_id=?1")
    Notification selectNotificationById(Long notificationID);

    @Modifying
    @Transactional
    @Query("UPDATE Notification o set o.isOpen=true where o.notification_id=?1")
    boolean removeNotificationByNotification_id(Long notification_id);

    @Modifying
    @Transactional
    @Query("UPDATE Notification o set o.isOpen=true where o.org_id=?1 AND o.Description = ?2")
    void removeNotification(Long orgId, String query_);
}
