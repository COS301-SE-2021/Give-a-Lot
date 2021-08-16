package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.repository.organisationPointsRepository;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Server.ServerAccess;
import com.GiveaLot.givealot.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Service
public class OrganisationServiceImp implements OrganisationService {


    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private OrganisationInfoRepository organisationInfoRepository;

    @Autowired
    organisationPointsRepository organisationPointsRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Organisations selectOrganisation(String orgId) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: Organisation Id is null");
        else if (orgId.isEmpty() || orgId.length() > 50) {
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }

        Organisations res = organisationRepository.selectOrganisationById(Long.parseLong(orgId));
        if (res != null)
            return res;
        else throw new Exception("Exception: id does not exist, check spelling");
    }

    @Override
    public OrganisationInfo selectOrganisationInfo(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        OrganisationInfo organisationInfo = organisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId));

        if (organisationInfo == null) {
            organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        } else return organisationInfo;
    }

    @Override
    public boolean addOrganisation(Organisations organisation) throws Exception
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

        /** Setup **/

        ServerAccess access = new ServerAccess();
        long tmp_id = organisationRepository.getOrgId(organisation.getOrgEmail());

        /** Setup dates **/

        java.util.Date dateCurrent = new Date();
        java.util.Date dateEx = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateCreated = format.format(dateCurrent);

        int year = dateCurrent.getYear();
        dateEx.setYear(year+1);
        String dateExpiry = format.format(dateEx);

        /** Salts and hashes password **/

        String salt = getMd5(organisation.getOrgEmail());

        String salted = getMd5(organisation.getPassword() + salt);

        organisation.setPassword(salted);

        /** Create tables and directory **/

        Certificate certificate = new Certificate(dateCreated,dateExpiry,0);

        access.createOrganisationDirectory(organisation.getOrgId(), organisation.getOrgName());
        organisation.setDirectory("/home/ubuntu/Organisations/" + tmp_id);

        //create certificate tuple

        //create certificate



        LocalDate date = LocalDate.now(); /* registration date */


        organisationRepository.save(organisation);
        organisationInfoRepository.save(new OrganisationInfo((long) tmp_id));
        organisationPointsRepository.save(new OrganisationPoints((long) tmp_id));
        certificateRepository.save(certificate);
        return true;
    }

    @Override
    public boolean suspendOrganisation(String orgId) throws Exception {

        if (orgId == null)
            throw new Exception("String object is null");
        else if (orgId.isEmpty())
            throw new Exception("invalid id length");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(Long.parseLong(orgId), "suspended".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean reactivateOrganisation(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("String object is null");
        else if (orgId.isEmpty())
            throw new Exception("invalid id length");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(Long.parseLong(orgId), "active".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean investigateOrganisation(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("String object is null");
        else if (orgId.isEmpty())
            throw new Exception("invalid id");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else {
            if (organisationRepository.updateStatus(Long.parseLong(orgId), "investigating".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if (request.getWebsite() == null)
            throw new Exception("Exception: website not set");
        else if (request.getWebsite().isEmpty())
            throw new Exception("Exception: invalid website length");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        /*
         *  Todo:
         *   validate the website
         *     1) send a request to the website
         *        1.2) scrape the web and search for signs of ownership
         *
         * */

        if (organisationInfoRepository.addOrgWebsite(Long.parseLong(request.getOrgId()), request.getWebsite()) != 1)
            throw new Exception("Exception: website field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgWebsite(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgWebsite(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: website field not updated");

        return true;
    }

    @Override
    public boolean addOrgAddress(AddOrgAddressRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if (request.getAddress() == null)
            throw new Exception("Exception: address not set");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgAddress(Long.parseLong(request.getOrgId()), request.getAddress()) != 1)
            throw new Exception("Exception: address field not updated");

        return true;
    }

    @Override
    public boolean removeOrgAddress(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgAddress(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: address field not updated");

        return true;
    }

    @Override
    public boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request not set");
        else if (request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if (request.getReference() == null)
            throw new Exception("Exception: tax reference not set");
        else if (request.getReference().isEmpty())
            throw new Exception("Exception: tax field is empty");
        else if (request.getOrgId().isEmpty())
            throw new Exception("Exception: org ID is empty");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.addOrgTaxRef(Long.parseLong(request.getOrgId()), request.getReference()) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) throws Exception {
        if (orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if (orgId.isEmpty())
            throw new Exception("Exception: ID is empty");
        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if (organisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null) {
            /*
             * Because organisation already exists, set the field
             * */
            OrganisationInfo organisationInfo = new OrganisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            organisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if (organisationInfoRepository.removeOrgTaxRef(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean addOrgSocials(AddSocialsRequest request) throws Exception {
        if (request == null)
            throw new Exception("Exception: request is not set");

        else if (request.getOrgId() == null)
            throw new Exception("Exception: request id not set");

        else if (request.getType() == null)
            throw new Exception("Exception: request type is not set");

        else if (request.getUrl().isEmpty())
            throw new Exception("Exception: url is empty");

        else if (request.getOrgId().isEmpty())
            throw new Exception("Exception: ID is empty");

        else if (organisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: request id does not exist");

        if (request.getType().trim().equalsIgnoreCase("twitter")) {
            if (organisationInfoRepository.addTwitter(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else if (request.getType().trim().equalsIgnoreCase("instagram")) {
            if (organisationInfoRepository.addInstagram(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else if (request.getType().trim().equalsIgnoreCase("facebook")) {
            if (organisationInfoRepository.addFacebook(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        } else throw new Exception("Exception: social not identified");

        return true;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) throws Exception {

        if (orgId == null)
            throw new Exception("Exception: request id not set");

        else if (type == null)
            throw new Exception("Exception: request type is not set");

        else if (type.isEmpty())
            throw new Exception("Exception: type is empty");

        else if (orgId.isEmpty())
            throw new Exception("Exception: ID is empty");

        else if (organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: request id does not exist");

        if (type.trim().equalsIgnoreCase("twitter")) {
            if (organisationInfoRepository.removeTwitter(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        } else if (type.trim().equalsIgnoreCase("instagram")) {
            if (organisationInfoRepository.removeInstagram(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        } else if (type.trim().equalsIgnoreCase("facebook")) {
            if (organisationInfoRepository.removeFacebook(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        } else throw new Exception("Exception: social not identified");

        return true;
    }

    @Override
    public boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgAuditor(AddOrgAuditorRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgAuditor(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgCommittee(AddOrgCommitteeRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgCommittee(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgDonationInfo(AddOrgDonationInfoRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgDonationInfo(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgNGO(AddOrgNGORequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgNGO(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgEstDate(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgImage(AddOrgImageRequest request) throws Exception {

        return false;
    }

    @Override
    public boolean removeOrgImage(String orgId) throws Exception {

        return false;
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
    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: id is not set");

        else if(organisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
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
