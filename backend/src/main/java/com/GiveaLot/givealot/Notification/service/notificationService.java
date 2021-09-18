package com.GiveaLot.givealot.Notification.service;

import com.GiveaLot.givealot.Notification.requests.*;
import com.GiveaLot.givealot.Notification.response.GetLevelResponse;
import com.GiveaLot.givealot.Notification.response.GetNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.generalNotificationResponse;
import com.GiveaLot.givealot.Notification.response.getNumberOfNotificationsResponse;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.stereotype.Service;

@Service
public interface notificationService {

    //gets all notifications
    GetNotificationsResponse getNotifications(GetNotificationsRequest request) throws Exception;
    //adds a new notification
    generalNotificationResponse addNotifications(AddNotificationRequest request)throws Exception;
    //removes an already existing notification
    generalNotificationResponse  removeNotifications(Long id)throws Exception;
    //gets number of notifications available
    getNumberOfNotificationsResponse numberOfNotifications(GetNotificationsRequest request)throws Exception;
    responseJSON getLevelInformation(Long orgid)throws Exception;
    generalNotificationResponse updateNotification(UpdateNotificationRequest request)throws Exception;
    GetLevelResponse getLevel(GetLevelRequest request)throws Exception;
}
