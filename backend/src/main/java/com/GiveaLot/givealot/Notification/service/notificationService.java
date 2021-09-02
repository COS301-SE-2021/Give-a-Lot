package com.GiveaLot.givealot.Notification.service;

import com.GiveaLot.givealot.Notification.requests.AddNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.GetNotificationsRequest;
import com.GiveaLot.givealot.Notification.requests.RemoveNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.UpdateNotificationRequest;
import com.GiveaLot.givealot.Notification.response.GetNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.generalNotificationResponse;
import com.GiveaLot.givealot.Notification.response.getNumberOfNotificationsResponse;
import com.GiveaLot.givealot.Organisation.requests.GetOrganisationsRequest;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import org.springframework.stereotype.Service;

@Service
public interface notificationService {

    GetNotificationsResponse getNotifications(GetNotificationsRequest request) throws Exception;
    generalNotificationResponse addNotifications(AddNotificationRequest request)throws Exception;
    generalNotificationResponse  removeNotifications(Long id)throws Exception;
    getNumberOfNotificationsResponse numberOfNotifications(GetNotificationsRequest request)throws Exception;

    generalNotificationResponse updateNotification(UpdateNotificationRequest request)throws Exception;

}
