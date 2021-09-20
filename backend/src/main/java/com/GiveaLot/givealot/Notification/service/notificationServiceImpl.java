package com.GiveaLot.givealot.Notification.service;


import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Notification.dataclass.Notification;
import com.GiveaLot.givealot.Notification.repository.NotificationRepository;
import com.GiveaLot.givealot.Notification.requests.*;
import com.GiveaLot.givealot.Notification.response.*;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
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
public class notificationServiceImpl implements notificationService {

    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    BlockChainRepository blockChainRepository;

    @Autowired
    OrganisationInfoRepository organisationInfoRepository;

    @Override
    public GetNotificationsResponse getNotifications(GetNotificationsRequest request) throws Exception {
        boolean temporal_solution = true;

        if (!temporal_solution) {
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
        if (res == null)
            throw new Exception("Exception: there are no notifications");

        return new GetNotificationsResponse("get_notifications_200_ok", "success", res);
    }

    @Override
    public generalNotificationResponse addNotifications(AddNotificationRequest request) throws Exception {
        if (request == null)
            throw new Exception("invalid request object: null");

        if (request.getNotificationType() == null ||
                request.getOrg_id() == null || request.getDescription() == null
        )
            throw new Exception("null type provided: null");


        request.setOpen(false);

        if (notificationRepository.selectNotificationById(request.getNotification_id()) != null)
            throw new Exception("Notification already exists");

        Date dateCurrent = new Date();
        Date dateEx = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);

        request.setDateCreated(dateCreated);
        Notification notification = new Notification(request.getDateCreated(), request.getNotification_id(), request.getOrg_id(), request.isOpen(), request.getDescription(), request.getNotificationType(),request.getName());
        notificationRepository.save(notification);

        return new generalNotificationResponse("add_notification_200_ok", "success");
    }

    @Override
    public generalNotificationResponse removeNotifications(Long id) throws Exception {

        if (id == null)
            throw new Exception("invalid notification object: null");

        if (notificationRepository.removeNotificationByNotification_id(id))
            return new generalNotificationResponse("remove_notification_200_ok", "success");
        else
            throw new Exception("An error has occured");
    }

    @Override
    public getNumberOfNotificationsResponse numberOfNotifications(GetNotificationsRequest request) throws Exception {
        return new getNumberOfNotificationsResponse("get_number_notifications_ok", "success", getNotifications(request).getResponse().size());
    }

    @Override
    public responseJSON getLevelInformation(Long orgid) throws Exception {
        if (orgid == null)
            throw new Exception("organisation id is null");

        Organisations organisations = organisationRepository.selectOrganisationById(orgid);

        if (organisations == null) {
            throw new Exception("organisation does not exist");
        }
        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(orgid);
        if (blockchain == null) {
            throw new Exception("organisation does not exist");
        }
        long level = blockchain.getLevel();
        OrganisationInfo organisationInfo = organisationInfoRepository.selectOrganisationInfo(orgid);
        if (organisationInfo == null) {
            throw new Exception("organisation information does not exist");
        }
        if (level == 0) {
            String logoUrl = "localfiles/" + orgid + "/Gallery/logo.png";

            String ngoNumber = organisationInfo.getNGONumber();
            String ngoRegistrationDate = organisationInfo.getNGODate();
            return new responseJSON("get_level_200_OK", "success", new levelOneInformationResponse(1L,logoUrl, ngoNumber, ngoRegistrationDate,organisations.getOrgName(),orgid));
        } else if (level == 1) {
            String websiteUrl = organisationInfo.getWebsite();
            String address = organisationInfo.getAddress();
            return new responseJSON("get_level_200_OK", "success", new levelTwoInformationResponse(websiteUrl,address,2L,organisations.getOrgName(),orgid));
        } else if (level == 2) {
            String establishementDate = organisationInfo.getEstablishmentDate();
            String donation_url = organisationInfo.getDonationURL();
            String qrCodeUrl = "localfiles/" + orgid + "/Gallery/QRCode.png";

            return new responseJSON("get_level_200_OK", "success", new levelThreeInformationResponse(establishementDate, donation_url,qrCodeUrl,3L,organisations.getOrgName(),orgid));

        } else if (level == 3) {
            String committee_details = organisationInfo.getCommitteeDetails();
            String twitter = organisationInfo.getTwitter();
            String facebook = organisationInfo.getFacebook();
            String instagram = organisationInfo.getInstagram();


            return new responseJSON("get_level_200_OK", "success", new levelFourInformationResponse(4L,committee_details, facebook, instagram,twitter ,organisations.getOrgName(),orgid));


        } else if (level == 4) {
            String image1 = "localfiles/" + orgid + "/Gallery/image0";
            String auditdoc = "localfiles/" + orgid + "/Gallery/AuditDoc.pdf";

            return new responseJSON("get_level_200_OK", "success", new levelFiveInformationResponse(5L,auditdoc, image1,organisations.getOrgName(),orgid));

        } else
            return null;
    }

    @Override
    public generalNotificationResponse updateNotification(UpdateNotificationRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");

        if (request.getOrg_id() == null)
            throw new Exception("request id is null");

        Organisations organisations = organisationRepository.getById(request.getOrg_id());
        if (organisations == null)
            throw new Exception("organisation does not exist");

        String description = "";
        String orgName = organisations.getOrgName();

        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(organisations.getOrgId());

        if (blockchain == null)
            throw new Exception("blockchain does not exist");


        if (blockchain.getLevel() == 0) {
            description = orgName + " requesting to upgrade to level 1";
        } else if (blockchain.getLevel() == 1) {
            description = orgName + " requesting to upgrade to level 2";
        } else if (blockchain.getLevel() == 2) {
            description = orgName + " requesting to upgrade to level 3";
        } else if (blockchain.getLevel() == 3) {
            description = orgName + " requesting to upgrade to level 4";
        } else if (blockchain.getLevel() == 4) {
            description = orgName + " requesting to upgrade to level 5";
        }

        Notification notification = new Notification();

        notification.setDescription(description);
        notification.setOrg_id(organisations.getOrgId());

        notification.setOpen(false);
        notification.setOrg_name(orgName);
        notification.setNotificationType("update");

        Date dateCurrent = new Date();
        Date dateEx = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);
        notification.setDateCreated(dateCreated);

        notificationRepository.save(notification);

//send email to organisation and admin

        return new generalNotificationResponse("update_notification_200_ok", "success");

    }

    @Override
    public GetLevelResponse getLevel(GetLevelRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");
        if (organisationRepository.getById(request.getOrgid()) == null) {
            throw new Exception("organisation does not exist");
        }
        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(request.getOrgid());

        return new GetLevelResponse("get_level_ok", "success", blockchain.getLevel());

    }
}
