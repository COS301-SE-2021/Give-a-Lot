package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Browse.model.Browse;
import com.GiveaLot.givealot.Browse.repository.BrowseRecommenderRepository;
import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.service.CertificateService;
import com.GiveaLot.givealot.Events.requests.addTimeLineEventRequest;
import com.GiveaLot.givealot.Events.service.eventsServiceImp;
import com.GiveaLot.givealot.FaceRecognition.service.FaceRecognitionServiceImpl;
import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.repository.NotificationRepository;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import com.GiveaLot.givealot.Notification.service.notificationServiceImpl;
import com.GiveaLot.givealot.Organisation.model.*;
import com.GiveaLot.givealot.Organisation.repository.*;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.*;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.Server.ServerAccess;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Service
@Configurable
public class OrganisationServiceImp implements OrganisationService {
    @Autowired
    private OrganisationRepository organisationRepository;


    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    @Autowired
    private organisationPointsRepository organisationPointsRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CertificateService certificateService;

    @Autowired
    private final ServerAccess access = new ServerAccess();

    @Autowired
    private SendMailServiceImpl sendMailService;

    @Autowired
    private sectorsRepository sectorsRepository;

    @Autowired
    private BlockChainRepository blockChainRepository;

    @Autowired
    private BrowseRecommenderRepository browseRecommenderRepository;

    @Autowired
    private FaceRecognitionServiceImpl faceRecognitionService;

    @Autowired
    private OrganisationDataRepository organisationDataRepository;

    @Autowired
    private eventsServiceImp eventsService;

    @Autowired
    public void setOrganisationServiceImp(OrganisationRepository organisationRepository, OrganisationInfoRepository organisationInfoRepository, organisationPointsRepository organisationPointsRepository, CertificateRepository certificateRepository, UserRepository userRepository) {
        this.organisationRepository = organisationRepository;
        this.organisationInfoRepository = organisationInfoRepository;
        this.organisationPointsRepository = organisationPointsRepository;
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;
    }

    @Override /*tested all good - converted*/
    public getOrganisationsResponse getOrganisations(GetOrganisationsRequest request) throws Exception {
        if (request == null) {
            throw new Exception("Exception: request not set");
        }
        if (request.getAdminId() == null) {
            throw new Exception("Exception: admin user field not set");
        }

        User admin = userRepository.findUserById(request.getAdminId());

        if (admin == null)
            throw new Exception("Exception: user is not admin");

        if (!admin.getAdmin()) {
            throw new UserNotAuthorisedException("current user is not an admin");
        }


        List<Organisations> res = organisationRepository.findAll();
        if (res == null)
            throw new Exception("Exception: there are no organisations");

        return new getOrganisationsResponse("get_orgs_200_ok", "success", res);
    }

    @Override
    public responseJSON selectOrganisationAdmin(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Id provided is null");

        Organisations res_tmp = organisationRepository.selectOrganisationById(orgId);

        if (res_tmp == null)
            throw new Exception("organisation does not exist");

        else return new responseJSON("sel_org_200_ok", "success", res_tmp);
    }

    @Override
    public selectOrganisationResponse selectOrganisation(Long orgId, Long userId) throws Exception {

        if (orgId == null || userId == null)
            throw new Exception("Exception: Id provided is null");

        Organisations res_tmp = organisationRepository.selectOrganisationById(orgId);
        OrganisationResponseObject res = new OrganisationResponseObject(res_tmp.getOrgName(),
                res_tmp.getSlogan(),
                res_tmp.getOrgDescription(),
                res_tmp.getOrgSector(),
                null,
                null,
                null,
                null,
                organisationPointsRepository.getNumberOfImages(orgId),
                null);

        Blockchain blockchain_get_level = blockChainRepository.selectBlockchainOrgId(orgId);

        if (blockchain_get_level == null) {
            //remember to uncomment this
            //throw new Exception("fatal: level not available");
        } else res.setCertificateLevel(blockchain_get_level.getLevel());

        OrganisationInfo get_org_info = organisationInfoRepository.selectOrganisationInfo(orgId);
        OrganisationPoints organisationPoints = organisationPointsRepository.selectOrganisationPoints(orgId);


            if (get_org_info == null)
                throw new Exception("fatal: info not available");
            else
            {
                if(organisationPoints.isFacebookIsValid())
                    res.setFacebookUrl(get_org_info.getFacebook());

                if(organisationPoints.isInstagramIsValid())
                    res.setIstagramURl(get_org_info.getInstagram());

                if(organisationPoints.isTwitterIsValid())
                    res.setTwitterUrl(get_org_info.getTwitter());

                if(organisationPoints.isDonationURLIsValid())
                    res.setDonationLink(get_org_info.getDonationURL());
            }



        if (userId != -1) {
            User user = userRepository.findUserById(userId);

            if (user == null)
                throw new Exception("Exception: invalid user id");
        }


        if (res != null) {
            /*
             * interactions are used to learn and make decisions about
             * which organisations to recommend in the future for this user
             */

            Browse browse = browseRecommenderRepository.getRowByUserIdAndSector(userId, res.getOrgSector());
            if (browse == null) {
                browse = new Browse();
                browse.setUserId(userId);
                browse.setSector(res.getOrgSector());
                browse.setInteractions(1);
                browseRecommenderRepository.save(browse);
            } else {
                browseRecommenderRepository.updateInteractions(userId, browse.getInteractions() + 1, res.getOrgSector());
            }
            return new selectOrganisationResponse("sel_org_200_ok", "success", res);
        } else throw new Exception("Exception: id does not exist, check spelling");
    }

    @Override
    public selectOrganisationInfoResponse selectOrganisationInfo(Long orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: Provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        OrganisationInfo organisationInfo = organisationInfoRepository.selectOrganisationInfo(orgId);

        if (organisationInfo == null) {
            organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        } else return new selectOrganisationInfoResponse("sel_org_200_OK", "success", organisationInfo);
    }

    @Override /* tested works well except - certificate throws a null pointer exception.*/
    public generalOrganisationResponse addOrganisation(AddOrganisationRequest organisation) throws Exception {
        if (organisation == null)
            throw new Exception("invalid organisation object: null");

        if (organisation.getOrgName() == null || organisation.getOrgDescription() == null ||
                organisation.getPassword() == null || organisation.getOrgSector() == null ||
                organisation.getOrgEmail() == null || organisation.getContactNumber() == null ||
                organisation.getContactPerson() == null || organisation.getSlogan() == null)
            throw new Exception("invalid field provided: null");

        organisation.setDirectory("/home/ubuntu/Organisations/");
        organisation.setStatus("active");

        if (organisationRepository.selectOrganisationByEmail(organisation.getOrgEmail()) != null)
            throw new Exception("Email already exists");

        else if (organisation.getOrgName().isEmpty() || organisation.getOrgName().length() > 255)
            throw new Exception("Exception: orgName does not satisfy the database constraints");

        else if(organisationRepository.selectOrganisationByName(organisation.getOrgName()) != null)
            throw new Exception("Exception: organisation name already exists");

        else if (organisation.getOrgDescription().isEmpty() || organisation.getOrgDescription().length() > 65535)
            throw new Exception("Exception: orgDescription does not satisfy the database constraints");

        else if (organisation.getPassword().isEmpty() || organisation.getPassword().length() > 255)
            throw new Exception("Exception: password does not satisfy the database constraints");

        else if (organisation.getOrgSector().isEmpty() || organisation.getOrgSector().length() > 255)
            throw new Exception("Exception: orgSector does not satisfy the database constraints");

        else if (organisation.getStatus().isEmpty() || organisation.getStatus().length() > 255)
            throw new Exception("Exception: status does not satisfy the database constraints");

        else if (organisation.getOrgEmail().isEmpty() || organisation.getOrgEmail().length() > 255)
            throw new Exception("Exception: orgEmail does not satisfy the database constraints");

        else if (organisation.getDirectory().isEmpty() || organisation.getDirectory().length() > 255)
            throw new Exception("Exception: directory does not satisfy the database constraints");

        else if (organisation.getContactNumber().isEmpty() || organisation.getContactNumber().length() > 255)
            throw new Exception("Exception: contactNumber does not satisfy the database constraints");

        else if (organisation.getContactPerson().isEmpty() || organisation.getContactPerson().length() > 255)
            throw new Exception("Exception: contactPerson does not satisfy the database constraints");

        else if (organisation.getSlogan().isEmpty() || organisation.getSlogan().length() > 255)
            throw new Exception("Exception: orgSlogan does not satisfy the database constraints");

        if (userRepository.findUserByEmail(organisation.getOrgEmail()) != null) {
            throw new Exception("This email already exists");
        }
        List<String> get_current_sectors = sectorsRepository.getSectors();

        /* this block updates the sectors table - start */
        if (get_current_sectors == null) {
            throw new Exception("technical error: organisation cannot be classified");
        } else {
            boolean found = false;
            for (String s : get_current_sectors) {
                if (s.equalsIgnoreCase(organisation.getOrgSector())) {
                    Sectors temp = sectorsRepository.getSector(s);
                    temp.setOrganisations(temp.getOrganisations() + 1);
                    sectorsRepository.save(temp);
                    found = true;
                }
            }
            if (!found)
                throw new Exception("Sector not identified: select from the preset list or 'other' if yours is not showing");
        }
        /* this block updates the sectors table - end */

        /* this block deals with password hashing - start */

        String salt = getMd5(organisation.getOrgEmail());
        String salted = getMd5(organisation.getPassword() + salt);
        organisation.setPassword(salted);

        /* this block deals with password hashing - end */

        Date dateCurrent = new Date();
        Date dateEx = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);

        organisation.setDateCreated(dateCreated);

        Organisations save_org = new Organisations(
                organisation.getOrgName(),
                organisation.getSlogan(),
                organisation.getOrgDescription(),
                organisation.getOrgSector(),
                organisation.getOrgEmail(),
                organisation.getOrgId(),
                organisation.getStatus(),
                organisation.getContactPerson(),
                organisation.getContactNumber(),
                organisation.getDirectory(),
                organisation.getPassword(),
                organisation.getDateCreated(),
                organisation.getImage().getBytes()
        );
        organisationRepository.save(save_org);
        /* save the organisation in the database */

        long id = organisationRepository.selectOrganisationByEmail(organisation.getOrgEmail()).getOrgId();
        String directory = "/home/ubuntu/Organisations/" + id;
        organisationRepository.updateRepo(id, directory);

        String orgIdString = String.valueOf(id);
        String localStorage = "src/main/resources/localFiles/" + orgIdString;
        String localImageStorage = "src/main/resources/localFiles/" + orgIdString + "/gallery";
        String localImageStorage2 = "src/main/resources/localFiles/" + orgIdString + "/gallery/backup";
        String localCertificateStorage = "src/main/resources/localFiles/" + orgIdString + "/certificate";
        System.out.println(localCertificateStorage);

        File directoryLocal = new File(localStorage);
        File directoryImageLocal = new File(localImageStorage);
        File directoryImageLocal2 = new File(localImageStorage2);
        File directoryCertLocal = new File(localCertificateStorage);

        directoryLocal.mkdir();
        directoryImageLocal.mkdir();
        directoryImageLocal2.mkdir();
        directoryCertLocal.mkdir();

        organisationInfoRepository.save(new OrganisationInfo((long) id));
        organisationPointsRepository.save(new OrganisationPoints((long) id));

        //organisation is saved at this point
        /* ideally we should revert the above changes on the
         * database if the following systems fail*/

        /** Create tables and directory **/

        Certificate certificate;
        int year = dateCurrent.getYear();
        dateEx.setYear(year + 1);
        String dateExpiry = format.format(dateEx);
        try {
            System.out.println("==========server access enter==========");
            ServerAccess access = new ServerAccess();
            System.out.println("==========server access constructed==========");
            certificate = new Certificate(id, dateCreated, dateExpiry, 0);
            System.out.println("==========server access certificate object==========");
            access.createOrganisationDirectory(id, organisation.getOrgName());
            System.out.println("==========server access directory created==========");
        } catch (Exception e) {
            throw new Exception("Exception : cert || server access -> " + e);
        }

        System.out.println("===========organisation data create================");
        OrganisationData organisationData = new OrganisationData();
        organisationData.setOrgId(id);
        organisationDataRepository.save(organisationData);
        System.out.println("===========organisation data saved================");


        System.out.println("===========organisation certificate create================");
        certificateRepository.save(certificate);
        System.out.println("===========organisation certificate saved================");

        System.out.println("===========organisation certificate pdf create================");
        certificateService.addCertificate(id, certificate);
        System.out.println("===========organisation certificate pdf created================");


        System.out.println("=========saving logo==========");
        this.addOrgLogo(new AddOrgLogoRequest(id, organisation.getImage()));
        System.out.println("=========saving logo complete==========");

        /**Sending a verification email**/
        System.out.println("Sending Email...");

        Mail mail = new Mail(organisation.getOrgEmail(), "Givealot SignUp Verification", "Congratulations your organisation has successfully signed up to the Give A Lot platform." + "\n" +
                "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                "\n" +
                "\n" +
                "Kind Regards \n" +
                "Give A Lot Team");

        sendMailService.sendMail(mail);
        System.out.println("Email sent successfully");
        System.out.println(organisation.getOrgName().replaceAll("\\s+", "") + "Certificate.pdf");
        if (new File(organisation.getOrgName().replaceAll("\\s+", "") + "Certificate.pdf").delete()) {
            System.out.println("#######################################################################################");
            System.out.println("Deleted");
            System.out.println("#######################################################################################");
        } else {
            System.out.println("#######################################################################################");
            System.out.println("Failed");
            System.out.println("#######################################################################################");
        }

        eventsService.addTimelineEvent(new addTimeLineEventRequest(id, dateCreated, "joined give a lot", "we welcome you to the give a lot community"));
        return new generalOrganisationResponse("add_org_200_ok", "success-" + id);
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse suspendOrganisation(SuspendRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");
        if (request.getOrgID() == null)
            throw new Exception("Exception: provided id is null");

        else if (organisationRepository.selectOrganisationById(request.getOrgID()) == null)
            throw new Exception("Exception: ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(request.getOrgID(), "suspended".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else {
                /**Sending Status change email**/
                System.out.println("Sending Email...");

                Mail mail = new Mail(organisationRepository.selectOrganisationById(request.getOrgID()).getOrgEmail(), "Givealot Status Change", "Dear User " + "\n \n Your organisation has been placed under investigation due to numerous reports." +
                        "\n The reports will be reviewed by Give A Lot and if they are found to be false, we will reactivate your organization." + "\n" +
                        "\n All of your organisation's images in the gallery have been censored for privacy and safety. \n" +
                        "\n We apologise for the inconvenience this may cause" +
                        "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                        "\n" +
                        "\n" +
                        "Kind Regards \n" +
                        "Give A Lot Team");

                sendMailService.sendMail(mail);
                System.out.println("Email sent successfully");

                int images = organisationInfoRepository.selectOrganisationInfo(request.getOrgID()).getNumberOfImages();
                FaceRecognitionServiceImpl faceRecognitionService = new FaceRecognitionServiceImpl();
                try {
                    for (int i = 0; i < images; i++) {
                        faceRecognitionService.FaceBlurSuspend(request.getOrgID(), i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new generalOrganisationResponse("sus_org_200_ok", "success");
            }
        }
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse reactivateOrganisation(ActivateRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");
        if (request.getOrgID() == null)
            throw new Exception("Exception: ID is null");
        if (organisationRepository.selectOrganisationById(request.getOrgID()) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(request.getOrgID(), "active".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else {
                System.out.println("Sending Email...");

                Mail mail = new Mail(organisationRepository.selectOrganisationById(request.getOrgID()).getOrgEmail(), "Givealot Status Change", "It is with great confidence to inform you that tour account has been reactivated" +
                        "\n We apologise for the inconvenience this may have caused" +
                        "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                        "\n" +
                        "\n" +
                        "Kind Regards \n" +
                        "Givealot Team");

                sendMailService.sendMail(mail);
                System.out.println("Email sent successfully");
                return new generalOrganisationResponse("rea_org_200_ok", "success");
            }
        }
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse investigateOrganisation(InvestigateRequest request) throws Exception {

        if (request == null)
            throw new Exception("request is null");
        if (organisationRepository.selectOrganisationById(request.getOrgID()) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(request.getOrgID(), "investigating".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else {
                int numberOfImages = organisationPointsRepository.getNumberOfImages(request.getOrgID());

                for (int i = 0; i < numberOfImages; i++) {
                    System.out.println("bluring image" + i);
                    faceRecognitionService.FaceBlurSuspend(request.getOrgID(), i);
                }

                /**Sending Status change email**/
                System.out.println("Sending Email...");

                Mail mail = new Mail(organisationRepository.selectOrganisationById(request.getOrgID()).getOrgEmail(), "Givealot Status Change", "It is with great regret to inform you that your organisation due to numerous reports against it is under investigation" +
                        "\n these reports will be reviewed by team and if found to be false we will reactivate your organization." +
                        "\n We apologise for the inconvienace this may cause" +
                        "\n We are please to be working with you to provide a safe space were user's can donate to authentic organisations" +
                        "\n" +
                        "\n" +
                        "Kind Regards \n" +
                        "Givealot Team");

                sendMailService.sendMail(mail);
                System.out.println("Email sent successfully");
                return new generalOrganisationResponse("inv_org_200_ok", "success");
            }
        }
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse addOrgWebsite(AddOrgWebsiteRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getWebsite() == null)
            throw new Exception("Exception: value not set");

        else if (request.getWebsite().isEmpty())
            throw new Exception("Exception: invalid value length");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID is null");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgWebsite(request.getOrgId(), request.getWebsite()) != 1)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_web_200_ok", "success");
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse removeOrgWebsite(Long orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgWebsite(orgId) != 1)
            throw new Exception("Exception: value field not updated");

        return new generalOrganisationResponse("rem_web_200_ok", "success");
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse addOrgAddress(AddOrgAddressRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID is null");

        else if (request.getAddress() == null)
            throw new Exception("Exception: value not set");

        else if (request.getAddress().isEmpty())
            throw new Exception("Exception: invalid value length");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgAddress(request.getOrgId(), request.getAddress()) != 1)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_addr_200_ok", "success");
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse removeOrgAddress(Long orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        else if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgAddress(orgId) != 1)
            throw new Exception("Exception: value field not updated");

        return new generalOrganisationResponse("rem_addr_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse addOrgLogo(AddOrgLogoRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Provided ID is null");

        else if (request.getImage() == null)
            throw new Exception("Exception: image reference not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        Organisations organisation_tmp = organisationRepository.selectOrganisationById(request.getOrgId());

        if (organisation_tmp == null)
            throw new Exception("Exception: add image function did not finish, organisation does not exist");


        organisationRepository.addLogo(request.getOrgId(), request.getImage().getBytes());

        String name = organisation_tmp.getOrgName();

        access.uploadImageLogo(request.getOrgId(), request.getImage());

        return new generalOrganisationResponse("add_logo_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse removeOrgLogo(Long orgId) throws Exception {
        return null;
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse addOrgSocials(AddSocialsRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is not set");

        else if (request.getType() == null)
            throw new Exception("Exception: request type is not set");

        else if (request.getUrl().isEmpty())
            throw new Exception("Exception: url is empty");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: request id does not exist");

        if (request.getType().trim().equalsIgnoreCase("twitter")) {
            if (organisationInfoRepository.addTwitter(request.getOrgId(), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else if (request.getType().trim().equalsIgnoreCase("instagram")) {
            if (organisationInfoRepository.addInstagram(request.getOrgId(), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else if (request.getType().trim().equalsIgnoreCase("facebook")) {
            if (organisationInfoRepository.addFacebook(request.getOrgId(), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else throw new Exception("Exception: social not identified");

        return new generalOrganisationResponse("add_soc_200_OK", "success");
    }

    @Override /*tested all good - converted*/
    public generalOrganisationResponse removeOrgSocials(Long orgId, String type) throws Exception {

        if (type == null)
            throw new Exception("Exception: request type is not set");

        else if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (type.isEmpty())
            throw new Exception("Exception: type is empty");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: request id does not exist");

        if (type.trim().equalsIgnoreCase("twitter")) {
            if (organisationInfoRepository.removeTwitter(orgId) != 1)
                throw new Exception("Exception: social not removed");
        } else if (type.trim().equalsIgnoreCase("instagram")) {
            if (organisationInfoRepository.removeInstagram(orgId) != 1)
                throw new Exception("Exception: social not removed");

        } else if (type.trim().equalsIgnoreCase("facebook")) {
            if (organisationInfoRepository.removeFacebook(orgId) != 1)
                throw new Exception("Exception: social not removed");
        } else throw new Exception("Exception: social not identified");

        return new generalOrganisationResponse("rem_soc_200_OK", "success");
    }

    @Override /*not fully integration tested, all good - converted*/
    public generalOrganisationResponse addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        if (request.getOrgId() == null)
            throw new Exception("Exception: provided ID is null");

     /*   else if (request.getAudit() == null)
            throw new Exception("Exception: tax reference not set");*/

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        Organisations organisation_tmp = organisationRepository.selectOrganisationById(request.getOrgId());

        if (organisation_tmp == null)
            throw new Exception("Exception: failed to finish - add audit doc");

        String name = organisation_tmp.getOrgName();

        access.uploadAuditDocument(request.getOrgId(), name, request.getAudit());

        if (organisationInfoRepository.addAuditDoc(request.getOrgId(), "provided") != 1)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_audoc_200_OK", "success");
    }

    @Override /*not fully integration tested, all good - converted*/
    public generalOrganisationResponse removeOrgAuditDoc(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        if (organisationInfoRepository.removeAuditDoc(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return new generalOrganisationResponse("rem_audoc_200_OK", "success");
    }

    @Override /*not fully integration tested, all good - converted*/
    public generalOrganisationResponse addOrgCommittee(AddOrgCommitteeRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: provided ID is null");

        else if (request.getCommittee() == null)
            throw new Exception("Exception: value not set");

        else if (request.getCommittee().isEmpty())
            throw new Exception("Exception: invalid value length");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addCommittee(request.getOrgId(), request.getCommittee()) != 1)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_cmt_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse removeOrgCommittee(Long orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        if (organisationInfoRepository.removeCommittee(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return new generalOrganisationResponse("rem_cmt_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse addOrgDonationURL(AddOrgDonationInfoRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID is null");

        else if (request.getOrgInfo() == null)
            throw new Exception("Exception: value not set");

        else if (request.getOrgInfo().isEmpty())
            throw new Exception("Exception: invalid value length");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgDonationURL(request.getOrgId(), request.getOrgInfo()) != 1)
            throw new Exception("Exception: value field failed to update");


        return new generalOrganisationResponse("add_don_200_ok", "success");
    }

    @Override
    public generalOrganisationResponse removeOrgDonationURL(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgDonationURL(orgId) != 1)
            throw new Exception("Exception: value field not updated");

        return new generalOrganisationResponse("rem_don_200_ok", "success");
    }

    @Override
    public generalOrganisationResponse addOrgDonationQRCode(AddOrgQRCodeRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Provided ID is null");

        else if (request.getImage() == null)
            throw new Exception("Exception: tax reference not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        Organisations organisation_tmp = organisationRepository.selectOrganisationById(request.getOrgId());

        if (organisation_tmp == null)
            throw new Exception("Exception: add image function did not finish, organisation does not exist");

        String name = organisation_tmp.getOrgName();

        OrganisationData organisationData = organisationDataRepository.selectOrganisationDataById(organisation_tmp.getOrgId());

        /*for existing organisation's without a field on the table*/
        if(organisationData == null)
        {
            organisationData = new OrganisationData();
            organisationData.setOrgId(request.getOrgId());
            organisationData.setQrCode(request.getImage().getBytes());
            organisationDataRepository.save(organisationData);
        }
        else
        {
            /*otherwise update the existing field*/
            organisationDataRepository.updateQRCode(request.getOrgId(),request.getImage().getBytes());
        }

        access.uploadImageQRCode(request.getOrgId(), request.getImage());
        return new generalOrganisationResponse("add_qr_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse removeOrgDonationQRCode(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);
            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        OrganisationInfo organisation_tmp = organisationInfoRepository.selectOrganisationInfo(orgId);

        access.deleteQR(orgId);

        if (organisation_tmp == null)
            throw new Exception("Exception: rare error occured, image not fully removed");

        return new generalOrganisationResponse("rem_qr_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse addOrgNGO(AddOrgNGORequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getNgoNumber() == null)
            throw new Exception("Exception: value not set");
        else if (request.getNgoNumber().isEmpty())
            throw new Exception("Exception: invalid value length");
        else if (request.getNgoDate() == null)
            throw new Exception("Exception: value not set");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addNGONumber(request.getOrgId(), request.getNgoNumber()) != 1)
            throw new Exception("Exception: value field failed to update");
        if (addOrgNGODate(request) == null)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_ngo_200_OK", "success");
    }

    @Override
    public boolean removeOrgNGO(long orgId) throws Exception {
        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        if (organisationInfoRepository.removeNGONUmber(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public generalOrganisationResponse addOrgNGODate(AddOrgNGORequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getNgoDate() == null)
            throw new Exception("Exception: value not set");

        else if (request.getNgoDate().isEmpty())
            throw new Exception("Exception: date field is empty");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        String Str[] = (request.getNgoDate()).split("/");

        String tmp_date = "";

        if (Str.length == 3) {
            tmp_date = Str[2] + "-" + Str[1] + "-" + Str[0];
        } else throw new Exception("Exception: Invalid date provided");

        if (organisationInfoRepository.addNGODate(request.getOrgId(), tmp_date) != 1)
            throw new Exception("Exception: value field failed to update");

        if (organisationInfoRepository.addNGONumber(request.getOrgId(), request.getNgoNumber()) != 1)
            throw new Exception("Exception: ngo number not added");

        return new generalOrganisationResponse("add_ngo_200_OK", "success");
    }

    @Override
    public generalOrganisationResponse removeNGDate(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        if (organisationInfoRepository.removeNGODate(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return new generalOrganisationResponse("rem_est_200_OK", "success");
    }

    @Override /*tested - works well */
    public generalOrganisationResponse addOrgEstDate(AddOrgEstDateRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getDate() == null)
            throw new Exception("Exception: value not set");

        else if (request.getDate().isEmpty())
            throw new Exception("Exception: date field is empty");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        String Str[] = (request.getDate()).split("/");

        String tmp_date = "";

        if (Str.length == 3) {
            tmp_date = Str[2] + "-" + Str[1] + "-" + Str[0];
        } else throw new Exception("Exception: Invalid date provided");

        if (organisationInfoRepository.addEstDate(request.getOrgId(), tmp_date) != 1)
            throw new Exception("Exception: value field failed to update");

        return new generalOrganisationResponse("add_est_200_OK", "success");
    }

    @Override /*tested - works well */
    public generalOrganisationResponse removeOrgEstDate(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        if (organisationInfoRepository.removeEstDate(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return new generalOrganisationResponse("rem_est_200_OK", "success");
    }


    @Override
    public generalOrganisationResponse addOrgImage(AddOrgImageMultipartRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getOrgId() == null)
            throw new Exception("Provided ID is null");

        else if (request.getImages() == null)
            throw new Exception("Exception: images are not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        Organisations organisation_tmp = organisationRepository.selectOrganisationById(request.getOrgId());

        if (organisation_tmp == null)
            throw new Exception("Exception: add image function did not finish, organisation does not exist");

        int numImages = organisationPointsRepository.getNumberOfImages(request.getOrgId());
        int i = 0;

        access.uploadImageJPG(request.getOrgId(), request.getImages(), numImages);
            numImages++;


        if (organisationPointsRepository.incrementImage(request.getOrgId(), numImages) != 1)
            throw new Exception("Exception: value field failed to update");


        return new generalOrganisationResponse("add_img_200_OK", "success");
    }

    @Override /* all good, correctness not tested yet */
    public generalOrganisationResponse removeOrgImage(Long orgId, int number) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: provided ID is null");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(orgId) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun the contract");
        }

        OrganisationInfo organisation_tmp = organisationInfoRepository.selectOrganisationInfo(orgId);

        if (organisation_tmp == null)
            throw new Exception("Exception: rare error occured, image not fully removed");

        access.deleteImage(orgId, number);

        int numImages = organisation_tmp.getNumberOfImages();

        if (organisationInfoRepository.decrementImage(orgId, numImages - 1) != 1)
            throw new Exception("Exception: tax reference field not updated");
        return new generalOrganisationResponse("rem_img_200_OK", "success");
    }

    /*
     * points
     */

    @Override /*tested - works well */
    public generalOrganisationResponse confirmValidity(Long orgId, Long adminId, String type, boolean confirmValidity) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: organisation id is not set");
        else if (adminId == null)
            throw new Exception("Exception: admin id is not set");
        else if (type == null)
            throw new Exception("Exception: type is not set");
        else if (type.isEmpty())
            throw new Exception("Exception: type is empty");
        else if (userRepository.isAdmin(adminId) == null)
            throw new Exception("Exception: user unauthorized");
        /*
         * check if ID belongs to user
         */

        /*
         * true: for valid
         * false: invalid
         * */
        if (type.equalsIgnoreCase("address")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isAddressIsValid() == confirmValidity) {
                throw new Exception("ngo address is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer dps = 10, currentPoints;
            int res = confirmValidity ? organisationPointsRepository.Address(orgId, true) : organisationPointsRepository.Address(orgId, false);
            if (res != 1)
                throw new Exception("Exception: address validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Address(orgId, false) : organisationPointsRepository.Address(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("website")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isWebsiteIsValid() == confirmValidity) {
                throw new Exception("ngo website is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 10;
            Integer res = confirmValidity ? organisationPointsRepository.Website(orgId, true) : organisationPointsRepository.Website(orgId, false);

            if (res != 1)
                throw new Exception("Exception: website validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Website(orgId, false) : organisationPointsRepository.Website(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("establishment_date")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isEstDateIsValid() == confirmValidity) {
                throw new Exception("ngo establishment date is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 10;
            Integer res = confirmValidity ? organisationPointsRepository.EstablishmentDate(orgId, true) : organisationPointsRepository.EstablishmentDate(orgId, false);
            if (res != 1)
                throw new Exception("Exception: establishment date validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.EstablishmentDate(orgId, false) : organisationPointsRepository.EstablishmentDate(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("qr_code")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isQrCodeIsValid() == confirmValidity) {
                throw new Exception("ngo qr code is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.DonationQR(orgId, true) : organisationPointsRepository.DonationQR(orgId, false);
            if (res != 1)
                throw new Exception("Exception: establishment date validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.DonationQR(orgId, false) : organisationPointsRepository.DonationQR(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("donation_link")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isDonationURLIsValid() == confirmValidity) {
                throw new Exception("ngo donation link is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.DonationURL(orgId, true) : organisationPointsRepository.DonationURL(orgId, false);
            if (res != 1)
                throw new Exception("Exception: establishment date validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.DonationURL(orgId, false) : organisationPointsRepository.DonationURL(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("committee")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isCommitteeIsValid() == confirmValidity) {
                throw new Exception("commitee is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.Committee(orgId, true) : organisationPointsRepository.Committee(orgId, false);
            if (res != 1)
                throw new Exception("Exception: committee validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Committee(orgId, false) : organisationPointsRepository.Committee(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("twitter")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isTwitterIsValid() == confirmValidity) {
                throw new Exception("twitter is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.Twitter(orgId, true) : organisationPointsRepository.Twitter(orgId, false);
            if (res != 1)
                throw new Exception("Exception: twitter validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Twitter(orgId, false) : organisationPointsRepository.Twitter(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("facebook")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isFacebookIsValid() == confirmValidity) {
                throw new Exception("facebook is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.Facebook(orgId, true) : organisationPointsRepository.Facebook(orgId, false);
            if (res != 1)
                throw new Exception("Exception: facebook validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Facebook(orgId, false) : organisationPointsRepository.Facebook(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("instagram")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isInstagramIsValid() == confirmValidity) {
                throw new Exception("instagram is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 5;
            Integer res = confirmValidity ? organisationPointsRepository.Instagram(orgId, true) : organisationPointsRepository.Instagram(orgId, false);
            if (res != 1)
                throw new Exception("Exception: instagram validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Instagram(orgId, false) : organisationPointsRepository.Instagram(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("ngo_date")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isNgoDateIsValid() == confirmValidity) {
                throw new Exception("ngo date is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 10;
            Integer res = confirmValidity ? organisationPointsRepository.NGO_Date(orgId, true) : organisationPointsRepository.NGO_Date(orgId, false);
            if (res != 1)
                throw new Exception("Exception: NGO date validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);
            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.NGO_Date(orgId, false) : organisationPointsRepository.NGO_Date(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("ngo_number")) {
            OrganisationPoints organisationPoints_current_status = organisationPointsRepository.selectOrganisationPoints(orgId);

            if (organisationPoints_current_status != null && organisationPoints_current_status.isNgoNoIsValid() == confirmValidity) {
                throw new Exception("ngo number is already updated");
            } else if (organisationPoints_current_status == null) {
                throw new Exception("points not allocated for this organisation");
            }

            Integer currentPoints = 0, dps = 10;
            Integer res = confirmValidity ? organisationPointsRepository.NGO_Number(orgId, true) : organisationPointsRepository.NGO_Number(orgId, false);
            if (res != 1)
                throw new Exception("Exception: NGO number validity not confirmed");

            currentPoints = certificateRepository.select_Points_ById(orgId);

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            currentPoints = certificateRepository.select_Points_ById(orgId);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.NGO_Number(orgId, false) : organisationPointsRepository.NGO_Number(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else if (type.equalsIgnoreCase("audit")) {
            Integer currentPoints = 0, dps = 15;
            Integer res = confirmValidity ? organisationPointsRepository.Audit(orgId, true) : organisationPointsRepository.Audit(orgId, false);
            if (res != 1)
                throw new Exception("Exception: audit validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if (certificate_tmp == null) /*perform rollback*/ {
                res = confirmValidity ? organisationPointsRepository.Audit(orgId, false) : organisationPointsRepository.Audit(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            } else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId, currentPoints + dps) : certificateRepository.updatePoints(orgId, currentPoints - dps);

            if (res != 1) {
                res = confirmValidity ? organisationPointsRepository.Audit(orgId, false) : organisationPointsRepository.Audit(orgId, true);
                if (res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        } else throw new Exception("Exception: type is incorrect");

        if (confirmValidity) {
            try {
                Integer CURRENT_PTS = certificateRepository.selectPointsById(orgId).getPoints();
                if (CURRENT_PTS == 20) {
                    String query_ = organisationRepository.selectOrganisationById(orgId).getOrgName() + " requesting to upgrade to level 1";
                    notificationRepository.removeNotification(orgId, query_);
                    certificateService.updateCertificate(orgId);
                } else if (CURRENT_PTS == 40) {
                    String query_ = organisationRepository.selectOrganisationById(orgId).getOrgName() + " requesting to upgrade to level 2";
                    notificationRepository.removeNotification(orgId, query_);
                    certificateService.updateCertificate(orgId);
                } else if (CURRENT_PTS == 60) {
                    String query_ = organisationRepository.selectOrganisationById(orgId).getOrgName() + " requesting to upgrade to level 3";
                    notificationRepository.removeNotification(orgId, query_);
                    certificateService.updateCertificate(orgId);
                } else if (CURRENT_PTS == 80) {
                    String query_ = organisationRepository.selectOrganisationById(orgId).getOrgName() + " requesting to upgrade to level 4";
                    notificationRepository.removeNotification(orgId, query_);
                    certificateService.updateCertificate(orgId);
                } else if (CURRENT_PTS == 100) {
                    String query_ = organisationRepository.selectOrganisationById(orgId).getOrgName() + " requesting to upgrade to level 5";
                    notificationRepository.removeNotification(orgId, query_);
                    certificateService.updateCertificate(orgId);
                }
            } catch (Exception e) {
                System.out.println("Certificate not upgraded yet\n" +
                        "possible reasons: \n" +
                        "minimum points required are not satisfied\n" + e
                );
            }
        }
        return new generalOrganisationResponse("confirm_200_OK", "success");
    }

    @Override
    public organisationPointsResponse selectOrganisationPoints(Long orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: Provided ID is null");

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        OrganisationPoints organisationPoints = organisationPointsRepository.selectOrganisationPoints(orgId);

        if (organisationPoints == null) {
            organisationPoints = new OrganisationPoints();
            organisationPoints.setOrgId(orgId);

            organisationPointsRepository.save(organisationPoints);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        } else return new organisationPointsResponse("sel_pts_200_OK", "success", organisationPoints);
    }

    @Override /* tested - all good */
    public numberOfImagesResponse numberOfImages(Long orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: id is not set");

        else if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: id does not exist");

        Integer res = organisationPointsRepository.getNumberOfImages(orgId);
        if (res != 1)
            throw new Exception("Exception: id does not exist");

        return new numberOfImagesResponse("num_img_200_OK", "success", res);
    }

    @Override
    public generalOrganisationResponse addSector(AddSectorRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is null");
        else if (request.getSector() == null)
            throw new Exception("Exception: sector field is null");
        else if (request.getAdminId() == null)
            throw new Exception("Exception: id field is null");
        else {
            Sectors sector = new Sectors();
            sector.setSector(request.getSector().toLowerCase().trim());
            sector.setOrganisations(0);
            sectorsRepository.save(sector);
            return new generalOrganisationResponse("add_sec_200_OK", "success");
        }
    }

    @Override
    public getSectorsResponse getSectors() throws Exception {
        List<String> sectors = sectorsRepository.getSectors();
        if (sectors != null) {
            return new getSectorsResponse("get_sec_200_OK", "success", sectors);
        }
        throw new Exception("Exception: no sectors found!");
    }

    @Override
    public getNumberOfOrganisationsResponse getNumberOfOrganisations(GetOrganisationsRequest request) throws Exception {
        return new getNumberOfOrganisationsResponse("get_num_org_200_OK", "success", getOrganisations(request).getResponse().size());
    }

    @Override
    public getOrgCertLevelResponse getOrgCertLevel(GetOrganisationCertificateLevelRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is null");

        if (!organisationRepository.existsById(request.getOrgid())) {
            throw new Exception("organisation does not exist");
        }
        Blockchain blockchain = blockChainRepository.selectBlockchainOrgId(request.getOrgid());
        if (blockchain == null)
            throw new Exception("error with the blockchain");

        return new getOrgCertLevelResponse("get_org_cert_level", "success", blockchain.getLevel());
    }

    @Override
    public responseJSON getNumPerMonth(getNumOrganisationPerMonthRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is null");
        String month = "";
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int jun = 0;
        int jul = 0;
        int aug = 0;
        int sept = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;
        int i = 0;
        List<Organisations> organisations = organisationRepository.getAllOrganisations();
        while (i < organisations.size()) {
            month = organisations.get(i).getDateAdded().substring(5, 7);
            if (month.equals("01")) {
                jan++;
            } else if (month.equals("02")) {
                feb++;
            } else if (month.equals("03")) {
                mar++;
            } else if (month.equals("04")) {
                apr++;
            } else if (month.equals("05")) {
                may++;
            } else if (month.equals("06")) {
                jun++;
            } else if (month.equals("07")) {
                jul++;
            } else if (month.equals("08")) {
                aug++;
            } else if (month.equals("09")) {
                sept++;
            } else if (month.equals("10")) {
                oct++;
            } else if (month.equals("11")) {
                nov++;
            } else if (month.equals("12")) {
                dec++;
            }
            i++;
        }


        return new responseJSON("get_num_orgs_per_month", "success", new getNumOrganisationPerMonthResponse(jan, feb, mar, apr, may, jun, jul, aug, sept, oct, nov, dec));
    }

    @Override
    public byte [] getOrganisationLogo(Long orgId) throws Exception
    {
        if(orgId == null)
            throw new Exception("organisation id is null");
        else if(!organisationRepository.existsById(orgId))
            throw new Exception("organisation does not exist");

        byte [] image = organisationRepository.getOrganisationLogo(orgId);
        return image;
    }

    @Override
    public generalOrganisationResponse updateOrganisationInfo(updateOrganisationInfoRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is null");
        else if (request.getOrgId() == null)
            throw new Exception(("request id is null"));
        else if (request.getNewValue() == null)
            throw new Exception("request id is null");
        else if (request.getType() == null)
            throw new Exception("request type is null");
        else if (request.getType().isEmpty())
            throw new Exception("type field is required");
        else if (request.getNewValue().isEmpty())
            throw new Exception("new value is required");

        if (!organisationRepository.existsById(request.getOrgId()))
            throw new Exception("the organisation you are attempting to modify does not exist");

        if (request.getType().equalsIgnoreCase("description")) {
            if (request.getNewValue().length() > 65535 || request.getNewValue().length() < 100) {
                throw new Exception("Exception: Description does not satisfy the database constraints");
            }
            if (organisationRepository.updateDescription(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update description");

            return new generalOrganisationResponse("update_description_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("contactNumber")) {
            if (!request.getNewValue().matches("[0-9]+")) {
                throw new Exception("This number is invalid, 0XXXXXXXXX where X is 0-9");
            } else if (request.getNewValue().length() != 10) {
                throw new Exception("The length of this function is not correct");
            }

            if (organisationRepository.updateContactNumber(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update contact number");

            return new generalOrganisationResponse("update_number_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("email")) {
            if (!request.getNewValue().contains("@")) {
                throw new Exception("The email provided is invalid");
            } else {
                Organisations organisations = organisationRepository.selectOrganisationByEmail(request.getNewValue());
                if (organisations != null && !organisations.getOrgId().equals(request.getOrgId()))
                    throw new Exception("email already taken");
            }
            if (organisationRepository.updateEmail(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update email");

            return new generalOrganisationResponse("update_email_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("slogan")) {
            if (request.getNewValue().length() < 3) {
                throw new Exception("This slogan is too short");
            }
            if (organisationRepository.updateSlogan(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update slogan");

            return new generalOrganisationResponse("update_slogan_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("contactPerson")) {
            if (request.getNewValue().length() < 2) {
                throw new Exception("This name is too short to be a person name");
            } else if (request.getNewValue().length() > 50) {
                throw new Exception("This name is too long, apologies if it is your real name");
            }

            if (organisationRepository.updatePerson(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update contact person");

            return new generalOrganisationResponse("update_person_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("orgName")) {
            if (request.getNewValue().length() < 2) {
                throw new Exception("This name is too short to be a organisation name");
            } else if (request.getNewValue().length() > 50) {
                throw new Exception("This name is too long, apologies if it is your organisation name");
            }

            if (organisationRepository.updateOrgName(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update organisation Name");

            notificationRepository.updateOrgName(request.getOrgId(), request.getNewValue());
            return new generalOrganisationResponse("update_org_name_200_OK", "success");
        } else if (request.getType().equalsIgnoreCase("address")) {
            if (request.getNewValue().length() < 2) {
                throw new Exception("This address is too short to be a organisation address");
            } else if (request.getNewValue().length() > 250) {
                throw new Exception("This address is too long, apologies if it is your organisation address");
            }

            if (organisationInfoRepository.addOrgAddress(request.getOrgId(), request.getNewValue()) != 1)
                throw new Exception("failed to update organisation address");

            return new generalOrganisationResponse("update_org_address_200_OK", "success");
        }
        else if (request.getType().equalsIgnoreCase("password"))
        {
            String salt = getMd5(organisationRepository.selectOrganisationById(request.getOrgId()).getOrgEmail());
            String salted = getMd5(request.getNewValue() + salt);
            organisationRepository.updatePasswordById(request.getOrgId(),salted);
            return new generalOrganisationResponse("update_org_pass_200_OK", "success");
        }
        throw new Exception("the type is incorrect");
    }


    /*helper*/
    public String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clearTabels() {
        organisationInfoRepository.deleteAllInBatch();
        organisationRepository.deleteAllInBatch();
        notificationRepository.deleteAllInBatch();
        organisationPointsRepository.deleteAllInBatch();
    }


    @Override
    public boolean emailExists(emailExistsRequest request) throws Exception {
        if (request == null)
            throw new Exception("request is NULL");
        else if (request.getEmail() == null)
            throw new Exception("email is null");
        else if (request.getEmail().isEmpty() || !request.getEmail().contains("@"))
            throw new Exception("email is invalid");

        if (organisationRepository.selectOrganisationByEmail(request.getEmail()) == null) {
            return userRepository.findUserByEmail(request.getEmail()) != null;
        }
        return true;
    }
}
