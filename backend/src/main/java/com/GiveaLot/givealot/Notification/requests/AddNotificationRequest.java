package com.GiveaLot.givealot.Notification.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNotificationRequest {
    private    String dateCreated ;
    private    Long  notification_id;
    private    Long   org_id;
    private   boolean   isOpen;
    private    int  numberOfNotifications;
    private    String  description;
    private   String notificationType;
    private   String name;


    public AddNotificationRequest(@JsonProperty("organisation_id") Long org_id,@JsonProperty("isOpen") boolean isOpen,@JsonProperty("description") String description,@JsonProperty("notification_type") String notificationType,@JsonProperty("name") String name) {

        this.org_id = org_id;
        this.isOpen = isOpen;
        this.description = description;
        this.notificationType = notificationType;
        this.name = name;
    }

    public int getNumberOfNotifications() {
        return numberOfNotifications;
    }

    public void setNumberOfNotifications(int numberOfNotifications) {
        this.numberOfNotifications = numberOfNotifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Long getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(Long notification_id) {
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
