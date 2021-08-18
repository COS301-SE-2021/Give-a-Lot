package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.service.CertificateService;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.organisationPointsRepository;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.generalOrganisationResponse;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationResponse;
import com.GiveaLot.givealot.Server.ServerAccess;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.exception.UserNotAuthorisedException;
import com.GiveaLot.givealot.User.repository.UserRepository;
import com.GiveaLot.givealot.User.requests.GetUsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Service
@Configurable
public class OrganisationServiceImp implements OrganisationService {


    @Autowired
    private OrganisationRepository organisationRepository;

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
    public void setOrganisationServiceImp(OrganisationRepository organisationRepository, OrganisationInfoRepository organisationInfoRepository, organisationPointsRepository organisationPointsRepository, CertificateRepository certificateRepository, UserRepository userRepository){
        this.organisationRepository = organisationRepository;
        this.organisationInfoRepository = organisationInfoRepository;
        this.organisationPointsRepository = organisationPointsRepository;
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;

    }

    @Override /*tested all good - converted*/
    public getOrganisationsResponse getOrganisations(GetOrganisationsRequest request) throws Exception
    {
        if(request == null)
        {
            throw new Exception("Exception: request not set");
        }
        if(request.getAdminUserEmail() == null)
        {
            throw new Exception("Exception: admin user field not set");
        }
        else if(request.getAdminUserEmail().isEmpty())
        {
            throw new Exception("Exception: admin user field is empty");
        }

        User admin = userRepository.findUserByEmail(request.getAdminUserEmail());

        if(admin == null)
            throw new Exception("Exception: user is not admin");


        if(!admin.getAdmin())
        {
            throw new UserNotAuthorisedException("current user is not an admin");
        }

        List<Organisations> res = organisationRepository.findAll();
        if(res == null)
            throw new Exception("Exception: there are no organisations");

        return new getOrganisationsResponse("get_orgs_200_ok","success",res);
    }

    @Override /*tested all good - converted*/
    public selectOrganisationResponse selectOrganisation(Long orgId) throws Exception {

        if(orgId == null)
            throw new Exception("Exception: Id provided is null");

        Organisations res = organisationRepository.selectOrganisationById(orgId);
        if (res != null)
            return new selectOrganisationResponse("sel_org_200_ok","success",res);
        else throw new Exception("Exception: id does not exist, check spelling");
    }

    @Override
    public OrganisationInfo selectOrganisationInfo(long orgId) throws Exception {
        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        OrganisationInfo organisationInfo = organisationInfoRepository.selectOrganisationInfo(orgId);

        if (organisationInfo == null) {
            organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(orgId);

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        } else return organisationInfo;
    }

    @Override /* tested works well except - certificate throws a null pointer exception.*/
    public generalOrganisationResponse addOrganisation(Organisations organisation) throws Exception
    {
        if(organisation == null)
            throw new Exception("invalid organisation object: null");

        if(organisation.getOrgName() == null || organisation.getOrgDescription() == null||
                organisation.getPassword() == null|| organisation.getOrgSector() == null ||
                organisation.getOrgEmail() == null|| organisation.getContactNumber() == null||
                organisation.getContactPerson() == null|| organisation.getSlogan() == null)
            throw new Exception("invalid field provided: null");

        organisation.setDirectory("/home/ubuntu/Organisations/");
        organisation.setStatus("active");

        if(organisationRepository.selectOrganisationByEmail(organisation.getOrgEmail()) != null)
            throw new Exception("Email already exists");

        else if (organisation.getOrgName().isEmpty() || organisation.getOrgName().length()>255)
            throw new Exception("Exception: orgName does not satisfy the database constraints");

        else if (organisation.getOrgDescription().isEmpty() || organisation.getOrgDescription().length()>65535)
            throw new Exception("Exception: orgDescription does not satisfy the database constraints");

        else if (organisation.getPassword().isEmpty() || organisation.getPassword().length()>255)
            throw new Exception("Exception: password does not satisfy the database constraints");

        else if (organisation.getOrgSector().isEmpty() || organisation.getOrgSector().length()>255)
            throw new Exception("Exception: orgSector does not satisfy the database constraints");

        else if (organisation.getStatus().isEmpty() || organisation.getStatus().length()>255)
            throw new Exception("Exception: status does not satisfy the database constraints");

        else if (organisation.getOrgEmail().isEmpty() || organisation.getOrgEmail().length()>255)
            throw new Exception("Exception: orgEmail does not satisfy the database constraints");

        else if (organisation.getDirectory().isEmpty() || organisation.getDirectory().length()>255)
            throw new Exception("Exception: directory does not satisfy the database constraints");

        else if (organisation.getContactNumber().isEmpty() || organisation.getContactNumber().length()>255)
            throw new Exception("Exception: contactNumber does not satisfy the database constraints");

        else if (organisation.getContactPerson().isEmpty() || organisation.getContactPerson().length()>255)
            throw new Exception("Exception: contactPerson does not satisfy the database constraints");

        else if (organisation.getSlogan().isEmpty() || organisation.getSlogan().length()>255)
            throw new Exception("Exception: orgSlogan does not satisfy the database constraints");

        // salts and hashes of passwords
        String salt = getMd5(organisation.getOrgEmail());
        String salted = getMd5(organisation.getPassword() + salt);
        organisation.setPassword(salted);
        organisationRepository.save(organisation);

        long id = organisationRepository.selectOrganisationByEmail(organisation.getOrgEmail()).getOrgId();
        String directory = "/home/ubuntu/Organisations/" + id;
        organisationRepository.updateRepo(id,directory);

        organisationInfoRepository.save(new OrganisationInfo((long) id));
        organisationPointsRepository.save(new OrganisationPoints((long) id));

        LocalDate date = LocalDate.now(); // registration date

        //organisation is saved at this point

        // save dates
        Date dateCurrent = new Date();
        Date dateEx = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateCreated = format.format(dateCurrent);

        int year = dateCurrent.getYear();
        dateEx.setYear(year+1);
        String dateExpiry = format.format(dateEx);

        /** Create tables and directory **/

        Certificate certificate;
        try
        {
            ServerAccess access = new ServerAccess();
            certificate = new Certificate(id,dateCreated,dateExpiry,0);
            access.createOrganisationDirectory(id, organisation.getOrgName());
        }
        catch (Exception e)
        {
            throw new Exception("Exception : cert || server access -> " + e);
        }

        certificateRepository.save(certificate);
        certificateService.addCertificate(id,certificate);
        return new generalOrganisationResponse("add_org_200_ok", "success");
    }

    @Override
    public boolean suspendOrganisation(long orgId) throws Exception {

        /*if()
        {

        }*/

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(orgId, "suspended".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean reactivateOrganisation(long orgId) throws Exception {

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(orgId, "active".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean investigateOrganisation(long orgId) throws Exception {

        if (organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(orgId, "investigating".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getWebsite() == null)
            throw new Exception("Exception: value not set");
        else if (request.getWebsite().isEmpty())
            throw new Exception("Exception: invalid value length");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgWebsite(request.getOrgId(), request.getWebsite()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgWebsite(long orgId) throws Exception {
        if (organisationRepository.selectOrganisationById(orgId) == null)
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

        return true;
    }

    @Override
    public boolean addOrgAddress(AddOrgAddressRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getAddress() == null)
            throw new Exception("Exception: value not set");
        else if (request.getAddress().isEmpty())
            throw new Exception("Exception: invalid value length");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgAddress(request.getOrgId(), request.getAddress()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgAddress(long orgId) throws Exception {

        if (organisationRepository.selectOrganisationById(orgId) == null)
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

        if (organisationInfoRepository.removeOrgAddress(orgId) != 1)
            throw new Exception("Exception: value field not updated");

        return true;
    }

    @Override
    public boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getReference() == null)
            throw new Exception("Exception: tax reference not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        String name = organisationRepository.selectOrganisationById(request.getOrgId()).getOrgName();

        access.uploadTaxReference(request.getOrgId(),name,request.getReference());

        if (organisationInfoRepository.addOrgTaxRef(request.getOrgId(), "provided") != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgTaxRef(long orgId) throws Exception {

        if (organisationRepository.selectOrganisationById(orgId) == null)
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

        if (organisationInfoRepository.removeOrgTaxRef(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean addOrgSocials(AddSocialsRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is not set");

        else if (request.getType() == null)
            throw new Exception("Exception: request type is not set");

        else if (request.getUrl().isEmpty())
            throw new Exception("Exception: url is empty");

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

        return true;
    }

    @Override
    public boolean removeOrgSocials(long orgId, String type) throws Exception {

        if (type == null)
            throw new Exception("Exception: request type is not set");

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

        return true;
    }

    @Override
    public boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getAudit() == null)
            throw new Exception("Exception: tax reference not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        String name = organisationRepository.selectOrganisationById(request.getOrgId()).getOrgName();

        access.uploadAuditDocument(request.getOrgId(),name,request.getAudit());

        if (organisationInfoRepository.addAuditDoc(request.getOrgId(), "provided") != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgAuditDoc(long orgId) throws Exception {
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

        return true;
    }

    @Override
    public boolean addOrgAuditor(AddOrgAuditorRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getAuditor() == null)
            throw new Exception("Exception: value not set");
        else if (request.getAuditor().isEmpty())
            throw new Exception("Exception: invalid value length");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addAuditor(request.getOrgId(), request.getAuditor()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgAuditor(long orgId) throws Exception {
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

        if (organisationInfoRepository.removeAuditor(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean addOrgCommittee(AddOrgCommitteeRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getCommittee() == null)
            throw new Exception("Exception: value not set");
        else if (request.getCommittee().isEmpty())
            throw new Exception("Exception: invalid value length");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addCommittee(request.getOrgId(), request.getCommittee()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgCommittee(long orgId) throws Exception {
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

        return true;
    }

    @Override
    public boolean addOrgDonationInfo(AddOrgDonationInfoRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgDonationInfo(long orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgNGO(AddOrgNGORequest request) throws Exception {
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
        if (organisationInfoRepository.addNGODate(request.getOrgId(), request.getNgoDate()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
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
    public boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getDate() == null)
            throw new Exception("Exception: value not set");
        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addEstDate(request.getOrgId(), request.getDate()) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgEstDate(long orgId) throws Exception {
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

        if (organisationInfoRepository.removeEstDate(orgId) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean addOrgImage(AddOrgImageRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");

        else if (request.getImage() == null)
            throw new Exception("Exception: tax reference not set");

        else if (organisationRepository.selectOrganisationById(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        String name = organisationRepository.selectOrganisationById(request.getOrgId()).getOrgName();

        access.uploadImageJPG(request.getOrgId(),name,request.getImage());

        int numImages = organisationInfoRepository.selectOrganisationInfo(request.getOrgId()).getNumberOfImages();

        if (organisationInfoRepository.incrementImage(request.getOrgId(), numImages + 1) != 1)
            throw new Exception("Exception: value field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgImage(long orgId) throws Exception {

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

        int numImages = organisationInfoRepository.selectOrganisationInfo(orgId).getNumberOfImages();

        if (organisationInfoRepository.decrementImage(orgId, numImages - 1) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

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
    /*
    * points
    * points
    * points
    * */

    @Override
    public boolean confirmValidity(Long orgId,Long adminId,String type,boolean confirmValidity) throws Exception
    {
        if(orgId == null)
            throw new Exception("Exception: organisation id is not set");
        else if(adminId == null)
            throw new Exception("Exception: admin id is not set");
        else if(type == null)
            throw new Exception("Exception: type is not set");
        else if(type.isEmpty())
            throw new Exception("Exception: type is empty");
        else if(userRepository.isAdmin(adminId) == null)
            throw new Exception("Exception: user unauthorized");
        /*
        * check if ID belongs to user
        */

        /*
        * true: for valid
        * false: invalid
        * */
        if(type.equalsIgnoreCase("address"))
        {
            Integer dps = 0, currentPoints = 0;
            int res = confirmValidity ? organisationPointsRepository.Address(orgId,true) : organisationPointsRepository.Address(orgId,false);
            if(res != 1)
                throw new Exception("Exception: address validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Address(orgId,false) : organisationPointsRepository.Address(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
            else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Address(orgId,false) : organisationPointsRepository.Address(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }

        }
        else if(type.equalsIgnoreCase("audit"))
        {
            Integer currentPoints = 0, dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Audit(orgId,true) : organisationPointsRepository.Audit(orgId,false);
            if(res != -1)
                throw new Exception("Exception: audit validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Audit(orgId,false) : organisationPointsRepository.Audit(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
            else currentPoints = certificate_tmp.getPoints();

                    res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Audit(orgId,false) : organisationPointsRepository.Audit(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("auditor"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Auditor(orgId,true) : organisationPointsRepository.Auditor(orgId,false);
            if(res != -1)
                throw new Exception("Exception: auditor validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Auditor(orgId,false) : organisationPointsRepository.Auditor(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Auditor(orgId,false) : organisationPointsRepository.Auditor(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("committee"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Committee(orgId,true) : organisationPointsRepository.Committee(orgId,false);
            if(res != -1)
                throw new Exception("Exception: committee validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Committee(orgId,false) : organisationPointsRepository.Committee(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Committee(orgId,false) : organisationPointsRepository.Committee(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("establishment_date"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.EstablishmentDate(orgId,true) : organisationPointsRepository.EstablishmentDate(orgId,false);
            if(res != -1)
                throw new Exception("Exception: establishment date validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.EstablishmentDate(orgId,false) : organisationPointsRepository.EstablishmentDate(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.EstablishmentDate(orgId,false) : organisationPointsRepository.EstablishmentDate(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("facebook"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Facebook(orgId,true) : organisationPointsRepository.Facebook(orgId,false);
            if(res != -1)
                throw new Exception("Exception: facebook validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Facebook(orgId,false) : organisationPointsRepository.Facebook(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Facebook(orgId,false) : organisationPointsRepository.Facebook(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("instagram"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Instagram(orgId,true) : organisationPointsRepository.Instagram(orgId,false);
            if(res != -1)
                throw new Exception("Exception: instagram validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Instagram(orgId,false) : organisationPointsRepository.Instagram(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
            else currentPoints = certificate_tmp.getPoints();
            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Instagram(orgId,false) : organisationPointsRepository.Instagram(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("twitter"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Twitter(orgId,true) : organisationPointsRepository.Twitter(orgId,false);
            if(res != -1)
                throw new Exception("Exception: twitter validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Twitter(orgId,false) : organisationPointsRepository.Twitter(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Twitter(orgId,false) : organisationPointsRepository.Twitter(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("ngo_date"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.NGO_Date(orgId,true) : organisationPointsRepository.NGO_Date(orgId,false);
            if(res != -1)
                throw new Exception("Exception: NGO date validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.NGO_Date(orgId,false) : organisationPointsRepository.NGO_Date(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.NGO_Date(orgId,false) : organisationPointsRepository.NGO_Date(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("ngo_number"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.NGO_Number(orgId,true) : organisationPointsRepository.NGO_Number(orgId,false);
            if(res != -1)
                throw new Exception("Exception: NGO number validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.NGO_Number(orgId,false) : organisationPointsRepository.NGO_Number(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.NGO_Number(orgId,false) : organisationPointsRepository.NGO_Number(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("tax_raf"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.taxRaf(orgId,true) : organisationPointsRepository.taxRaf(orgId,false);
            if(res != -1)
                throw new Exception("Exception: tax raf validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.taxRaf(orgId,false) : organisationPointsRepository.taxRaf(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.taxRaf(orgId,false) : organisationPointsRepository.taxRaf(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else if(type.equalsIgnoreCase("website"))
        {
            Integer currentPoints = 0,dps = 0;
            Integer res = confirmValidity ? organisationPointsRepository.Website(orgId,true) : organisationPointsRepository.Website(orgId,false);
            if(res != -1)
                throw new Exception("Exception: address validity not confirmed");

            Certificate certificate_tmp = certificateRepository.selectPointsById(orgId);
            if(certificate_tmp == null) /*perform rollback*/
            {
                res = confirmValidity ? organisationPointsRepository.Website(orgId,false) : organisationPointsRepository.Website(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }else currentPoints = certificate_tmp.getPoints();

            res = confirmValidity ? certificateRepository.updatePoints(orgId,currentPoints + dps) : certificateRepository.updatePoints(orgId,currentPoints - dps);

            if(res != 1)
            {
                res = confirmValidity ? organisationPointsRepository.Website(orgId,false) : organisationPointsRepository.Website(orgId,true);
                if(res == 1)
                    throw new Exception("Exception: error occurred, rollback action performed successfully");
                else throw new Exception("Exception: error occurred, rollback action failed");
            }
        }
        else throw new Exception("Exception: type is incorrect");
        return false;
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(long orgId) throws Exception {

        if(organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: id does not exist");
        return null;
    }

    @Override
    public Integer numberOfImages(Long orgId) throws Exception
    {
        if(orgId == null)
            throw new Exception("Exception: id is not set");

        else if(organisationRepository.selectOrganisationById(orgId) == null)
            throw new Exception("Exception: id does not exist");

        Integer res = organisationPointsRepository.getNumberOfEmages(orgId);
        if(res != 1)
            throw new Exception("Exception: id does not exist");

        return res;
    }


}
