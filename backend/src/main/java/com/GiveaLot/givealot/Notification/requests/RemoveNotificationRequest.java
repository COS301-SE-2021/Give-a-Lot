package com.GiveaLot.givealot.Notification.requests;

public class RemoveNotificationRequest {
    String  notification_id;

    public RemoveNotificationRequest(String notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }
}
