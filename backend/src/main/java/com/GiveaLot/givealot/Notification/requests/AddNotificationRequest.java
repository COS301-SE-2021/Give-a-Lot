package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AddNotificationRequest {
              String dateCreated ;
    String  notification_id;
              Long   org_id;
              boolean   isOpen;
              int  numberOfNotifications;
              String  description;
             String notificationType;

    public AddNotificationRequest(@JsonProperty("dateCreated") String dateCreated, @JsonProperty("notification_id") String notification_id,@JsonProperty("organisation_id") Long org_id,@JsonProperty("isOpen") boolean isOpen,@JsonProperty("numberOfNotifications") int numberOfNotifications,@JsonProperty("description") String description,@JsonProperty("notification_type") String notificationType) {
        this.dateCreated = dateCreated;
        this.notification_id = notification_id;
        this.org_id = org_id;
        this.isOpen = isOpen;
        this.numberOfNotifications = numberOfNotifications;
        this.description = description;
        this.notificationType = notificationType;
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

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
    @Override
    public String toString() {
        return "AddNotificationRequest{" +
                "notification_id='" + notification_id + '\'' +
                ", org_id='" + org_id + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", numberOfNotifications='" + numberOfNotifications + '\'' +
                ", description='" + description + '\'' +
                ", isOpen='" + isOpen + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }
}
