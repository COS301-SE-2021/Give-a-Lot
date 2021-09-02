package com.GiveaLot.givealot.Notification.service;


import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Notification.dataclass.Notification;
import com.GiveaLot.givealot.Notification.repository.NotificationRepository;
import com.GiveaLot.givealot.Notification.requests.AddNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.GetNotificationsRequest;
import com.GiveaLot.givealot.Notification.requests.RemoveNotificationRequest;
import com.GiveaLot.givealot.Notification.requests.UpdateNotificationRequest;
import com.GiveaLot.givealot.Notification.response.GetNotificationsResponse;
import com.GiveaLot.givealot.Notification.response.generalNotificationResponse;
import com.GiveaLot.givealot.Notification.response.getNumberOfNotificationsResponse;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class notificationServiceImpl implements notificationService{

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    BlockChainRepository blockChainRepository;

    @Override
    public GetNotificationsResponse getNotifications(GetNotificationsRequest request) throws Exception {
        boolean temporal_solution = true;

        if(!temporal_solution) {
            if (request == null) {
                throw new Exception("Exception: request not set");
            }
            if (request.getAdminUserEmail() == null) {
                throw new Exception("Exception: admin user field not set");
            } else if (request.getAdminUserEmail().isEmpty()) {
                throw new Exception("Exception: admin user field is empty");
            }

            User admin = userRepository.findUserByEmail(request.getAdminUserEmail());

            if (admin == null)
                throw new Exception("Exception: user is not admin");

            if (!admin.getAdmin()) {
                throw new UserNotAuthorisedException("current user is not an admin");
            }
        }

        List<Notification> res = notificationRepository.getAllNotifications();
        if(res == null)
            throw new Exception("Exception: there are no notifications");

        return new GetNotificationsResponse("get_notifications_200_ok","success",res);
    }

    @Override
    public generalNotificationResponse addNotifications(AddNotificationRequest request) throws Exception {
        if(request == null)
            throw new Exception("invalid notification object: null");

        if(request.getNotificationType() == null||
                request.getOrg_id() == null|| request.getDescription()== null
               )
            throw new Exception("invalid field provided: null");

        if(!request.getNotificationType().equals("update") || !request.getNotificationType().equals("report"))
        {
            throw new Exception("invalid field provided: null");

        }
        request.setOpen(false);

        if(notificationRepository.selectNotificationById(request.getNotification_id()) != null)
            throw new Exception("Notification already exists");

        Date dateCurrent = new Date();
        Date dateEx = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);

        request.setDateCreated(dateCreated);
        Notification notification = new Notification(request.getDateCreated(),request.getNotification_id(),request.getOrg_id(),request.isOpen(),request.getDescription(),request.getNotificationType());
        notificationRepository.save(notification);

        return new generalNotificationResponse("add_notification_200_ok", "success");    }

    @Override
    public generalNotificationResponse removeNotifications(Long id) throws Exception {

        if(id == null)
            throw new Exception("invalid notification object: null");

        if(notificationRepository.removeNotificationByNotification_id(id))
        return new generalNotificationResponse("remove_notification_200_ok", "success");
        else
        throw new Exception("An error has occured");

    }

    @Override
    public getNumberOfNotificationsResponse numberOfNotifications(GetNotificationsRequest request) throws Exception {
        return new getNumberOfNotificationsResponse("get_number_notifications_ok","success",getNotifications(request).getResponse().size());
    }

    @Override
    public generalNotificationResponse updateNotification(UpdateNotificationRequest request)throws Exception{
        if(request == null)
            throw new Exception("request is null");

        if(request.getOrg_id() == null)
            throw new Exception("request id is null");

        Organisations organisations = organisationRepository.getById(request.getOrg_id());
        if(organisations == null)
            throw new Exception("organisation does not exist");

        String description ="";
        String orgName = organisations.getOrgName();

        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(organisations.getOrgId());

        if(blockchain == null)
            throw new Exception("blockchain does not exist");


        if(blockchain.getLevel() ==0)
        {
            description = orgName+" requesting to upgrade to level 1";
        }
        else if(blockchain.getLevel() ==1)
        {
            description = orgName+" requesting to upgrade to level 2";
        }
        else if(blockchain.getLevel() ==2)
        {
            description = orgName+" requesting to upgrade to level 3";
        }
        else  if(blockchain.getLevel() ==3)
        {
            description = orgName+" requesting to upgrade to level 4";
        }
        else  if(blockchain.getLevel() ==4)
        {
            description = orgName+" requesting to upgrade to level 5";
        }

        Notification notification = new Notification();

        notification.setDescription(description);
        notification.setOrg_id(organisations.getOrgId());
        notification.setOpen(false);
        notification.setNotificationType("update");

        notificationRepository.save(notification);

//send email to organisation and admin

        return new generalNotificationResponse("update_notification_200_ok", "success");

    }
}
