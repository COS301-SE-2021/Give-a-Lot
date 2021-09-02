package com.GiveaLot.givealot.Notification.controller;

import com.GiveaLot.givealot.Notification.requests.AddNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.GetNotificationsRequest;
import com.GiveaLot.givealot.Notification.response.GetNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.generalNotificationResponse;
import com.GiveaLot.givealot.Notification.response.getNumberOfNotificationsResponse;
import com.GiveaLot.givealot.Notification.service.notificationServiceImpl;

import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/notifications")
@CrossOrigin("*")
@RestController
public class NotificationsController {
    private final notificationServiceImpl service;
    private final responseJSON response;

    @Autowired
    public NotificationsController(notificationServiceImpl service, responseJSON response)
    {
        this.service = service;
        this.response = response;
    }

    @PostMapping("/get/notifications")
    public ResponseEntity<GetNotificationsResponse> getNotifications(@RequestBody @NonNull GetNotificationsRequest body)
    {
        GetNotificationsResponse response;
        try
        {
            response = service.getNotifications(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new GetNotificationsResponse("get_notifications_500_bad","failed: " + e, null), HttpStatus.OK);
        }
    }

    @PostMapping("/add/notifications")
    public ResponseEntity<generalNotificationResponse> addOrganisation(@RequestBody @NonNull AddNotificationRequest body)
    {
        generalNotificationResponse response;
        try
        {
            response = service.addNotifications(new AddNotificationRequest(body.getOrg_id(),false,body.getDescription(),body.getNotificationType()));
            return new ResponseEntity<>(response,  HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalNotificationResponse("notification_add_err_501","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/get/num_notifications")
    public ResponseEntity<getNumberOfNotificationsResponse> getNumberOfNotifications(@RequestBody @NonNull GetNotificationsRequest body)
    {
        getNumberOfNotificationsResponse response;
        try
        {
            response = service.numberOfNotifications(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new getNumberOfNotificationsResponse("get_num_notifications_500_bad","failed: " + e, 0), HttpStatus.OK);
        }
    }

    @PutMapping("/remove/notification")
    public ResponseEntity<generalNotificationResponse> removeNotification(@PathVariable("notification_id") @NonNull String notification_id)
    {
        generalNotificationResponse response;
        try
        {
            response = service.removeNotifications(notification_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalNotificationResponse("notification_remove_err_501","failed: " + e), HttpStatus.OK);
        }
    }
}
