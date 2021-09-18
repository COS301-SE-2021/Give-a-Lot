package com.GiveaLot.givealot.Notification.controller;

import com.GiveaLot.givealot.Notification.requests.*;
import com.GiveaLot.givealot.Notification.response.GetLevelResponse;
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
    public ResponseEntity<generalNotificationResponse> addNotification(@RequestBody @NonNull AddNotificationRequest body)
    {
        generalNotificationResponse response;
        try
        {
            response = service.addNotifications(new AddNotificationRequest(body.getOrg_id(),false,body.getDescription(),body.getNotificationType(),body.getName()));
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

    @PutMapping("/remove/notification/{notification_id}")
    public ResponseEntity<generalNotificationResponse> removeNotification(@PathVariable("notification_id") @NonNull Long notification_id)
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

    @PostMapping("/update/notifications")
    public ResponseEntity<generalNotificationResponse> updateRequestNotification(@RequestBody @NonNull UpdateNotificationRequest body)
    {
        generalNotificationResponse response;
        try
        {
            response = service.updateNotification(body);
            return new ResponseEntity<>(response,  HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalNotificationResponse("notification_update_request_err_501","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/get/level_information")
    public ResponseEntity<responseJSON> getNumberOfNotificationsResponse(@RequestBody @NonNull levelsRequest body)
    {
        responseJSON response;
        try
        {
            response = service.getLevelInformation(body.getOrgId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new responseJSON("get_notifications_500_bad","failed: " + e, null), HttpStatus.OK);
        }
    }
    @PostMapping("/get/level")
    public ResponseEntity<GetLevelResponse> getNumberOfNotificationsResponse(@RequestBody @NonNull GetLevelRequest body)
    {
        GetLevelResponse response;
        try
        {
            response = service.getLevel(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new GetLevelResponse("get_notifications_500_bad","failed: " + e, 0), HttpStatus.OK);
        }
    }
}
