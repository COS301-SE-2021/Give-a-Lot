package com.GiveaLot.givealot.Notification.dataclass;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@Table(
        name = "notification"
)
public class Notification {

    @Column(
                name = "date_created",
                updatable = true,
                nullable = false
                )
        String dateCreated;

        @Id
        @Column(
                name = "notification_id",
                updatable = false,
                nullable = false
        )
        String notification_id;

    @Column(
            name = "org_id",
            updatable = false,
            nullable = false
    )
    long org_id;
        @Column(
                name = "isOpen",
                updatable = true,
                nullable = false
        )
        boolean isOpen;


    @Column(
            name = "Description",
            updatable = true,
            nullable = false
    )
    String Description;

    @Column(
            name = "notificationType",
            updatable = true,
            nullable = false
    )
    String notificationType;

    public Notification( long org_id, boolean isOpen, String description, String notificationType) {
        this.notification_id = notification_id;
        this.org_id = org_id;
        this.isOpen = isOpen;
        Description = description;
        this.notificationType = notificationType;
    }
    public Notification(String dateCreated, String notification_id, long org_id, boolean open, String description, String notificationType) {
        this.dateCreated = dateCreated;
        this.notification_id = notification_id;
        this.org_id = org_id;
        this.isOpen = open;
        Description = description;
        this.notificationType = notificationType;
    }

    public Notification() {

    }


    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    public long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(long org_id) {
        this.org_id = org_id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
