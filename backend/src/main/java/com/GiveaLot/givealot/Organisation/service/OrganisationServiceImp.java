package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.model.organisationInfo;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Server.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class OrganisationServiceImp implements OrganisationService {

    @Autowired
    private OrganisationRepository OrganisationRepository;

    @Autowired
    private OrganisationInfoRepository OrganisationInfoRepository;

    @Override
    public Organisations selectOrganisation(String orgId) throws Exception {

        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest Id is null");
        else if (orgId.isEmpty() || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }

        Organisations res = OrganisationRepository.selectOrganisationById(Long.parseLong(orgId));
        if(res != null)
            return res;
        else throw new Exception("Exception: id does not exist, check spelling");
    }

    @Override
    public organisationInfo selectOrganisationInfo(String orgId) throws Exception
    {
        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest ID is not set");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        organisationInfo organisationInfo = OrganisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId));

        if(organisationInfo == null)
        {
            /*
            * Because organisation already exists, set the field
            * */
            organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            OrganisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }
        else return organisationInfo;
    }

    @Override
    public boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception {
        if(request == null)
            throw new Exception("Exception: request not set");
        else if(request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if(request.getWebsite() == null)
            throw new Exception("Exception: website not set");
        else if(request.getWebsite().isEmpty())
            throw new Exception("Exception: invalid website length");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        /*
        *  Todo:
        *   validate the website
        *     1) send a request to the website
        *        1.2) scrape the web and search for signs of ownership
        *
        * */

        if(OrganisationInfoRepository.addOrgWebsite(Long.parseLong(request.getOrgId()),request.getWebsite()) != 1)
            throw new Exception("Exception: website field failed to update");

        return true;
    }

    @Override
    public boolean removeOrgWebsite(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest ID is not set");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        if(OrganisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null)
        {
            /*
             * Because organisation already exists, set the field
             * */
            organisationInfo organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            OrganisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if(OrganisationInfoRepository.removeOrgWebsite(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: website field not updated");

        return true;
    }

    @Override
    public boolean addOrgAddress(AddOrgAddressRequest request) throws Exception {
        if(request == null)
            throw new Exception("Exception: request not set");
        else if(request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if(request.getAddress() == null)
            throw new Exception("Exception: address not set");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        if(OrganisationInfoRepository.addOrgAddress(Long.parseLong(request.getOrgId()),request.getAddress()) != 1)
            throw new Exception("Exception: address field not updated");

        return true;
    }

    @Override
    public boolean removeOrgAddress(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest ID is not set");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        if(OrganisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null)
        {
            /*
             * Because organisation already exists, set the field
             * */
            organisationInfo organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            OrganisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if(OrganisationInfoRepository.removeOrgAddress(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: address field not updated");

        return true;
    }

    @Override
    public boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception {
        if(request == null)
            throw new Exception("Exception: request not set");
        else if(request.getOrgId() == null)
            throw new Exception("Exception: ID not set");
        else if(request.getReference() == null)
            throw new Exception("Exception: tax reference not set");
        else if(request.getReference().isEmpty())
            throw new Exception("Exception: tax field is empty");
        else if(request.getOrgId().isEmpty())
            throw new Exception("Exception: org ID is empty");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        if(OrganisationInfoRepository.addOrgTaxRef(Long.parseLong(request.getOrgId()),request.getReference()) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest ID is not set");
        else if(orgId.isEmpty())
            throw new Exception("Exception: ID is empty");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        if(OrganisationInfoRepository.selectOrganisationInfo(Long.parseLong(orgId)) == null)
        {
            /*
             * Because organisation already exists, set the field
             * */
            organisationInfo organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(Long.parseLong(orgId));

            OrganisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if(OrganisationInfoRepository.removeOrgTaxRef(Long.parseLong(orgId)) != 1)
            throw new Exception("Exception: tax reference field not updated");

        return true;
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

        if(OrganisationRepository.selectOrganisationByEmail(organisation.getOrgEmail()) != null)
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

        OrganisationRepository.save(organisation);

        /*
        get the id of the newly saved organisation and
        concatenate it with the root directory
        * */
        int tmp_id = OrganisationRepository.getOrgId(organisation.getOrgEmail());
        OrganisationRepository.updateRepo((long) tmp_id, "/home/ubuntu/Organisations/" + tmp_id);

        LocalDate date = LocalDate.now(); /* registration date */
        OrganisationInfoRepository.save(new organisationInfo((long) tmp_id));

        try
        {
            //create certificate tuple
            //create certificate
            ServerAccess access = new ServerAccess();
            access.createOrganisationDirectory(tmp_id,organisation.getOrgName());
        }
        catch(Exception e)
        {
            throw new Exception("server access error from add organisation. message: " + e);
        }

        return true;
    }

    @Override
    public boolean suspendOrganisation(String orgId) throws Exception {

        if(orgId == null)
            throw new Exception("String object is null");
        else if(orgId.isEmpty())
            throw new Exception("invalid id length");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(Long.parseLong(orgId),"suspended".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean reactivateOrganisation(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("String object is null");
        else if(orgId.isEmpty())
            throw new Exception("invalid id length");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(Long.parseLong(orgId),"active".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean investigateOrganisation(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("String object is null");
        else if(orgId.isEmpty())
            throw new Exception("invalid id");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(Long.parseLong(orgId),"investigating".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean addOrgSocials(AddSocialsRequest request) throws Exception {
        if(request == null)
        throw new Exception("Exception: request is not set");

        else if(request.getOrgId() == null)
            throw new Exception("Exception: request id not set");

        else if(request.getType() == null)
            throw new Exception("Exception: request type is not set");

        else if(request.getUrl().isEmpty())
            throw new Exception("Exception: url is empty");

        else if(request.getOrgId().isEmpty())
            throw new Exception("Exception: ID is empty");

        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: request id does not exist");

        if(request.getType().trim().equalsIgnoreCase("twitter"))
        {
            if(OrganisationInfoRepository.addTwitter(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        }
        else if(request.getType().trim().equalsIgnoreCase("instagram"))
        {
            if(OrganisationInfoRepository.addInstagram(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        }
        else if(request.getType().trim().equalsIgnoreCase("facebook"))
        {
            if(OrganisationInfoRepository.addFacebook(Long.parseLong(request.getOrgId()), request.getUrl()) != 1)
                throw new Exception("Exception: social not added");
        }
        else throw new Exception("Exception: social not identified");

        return true;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) throws Exception {

         if(orgId == null)
            throw new Exception("Exception: request id not set");

        else if(type == null)
            throw new Exception("Exception: request type is not set");

        else if(type.isEmpty())
            throw new Exception("Exception: type is empty");

        else if(orgId.isEmpty())
            throw new Exception("Exception: ID is empty");

        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: request id does not exist");

        if(type.trim().equalsIgnoreCase("twitter"))
        {
            if(OrganisationInfoRepository.removeTwitter(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        }
        else if(type.trim().equalsIgnoreCase("instagram"))
        {
            if(OrganisationInfoRepository.removeInstagram(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        }
        else if(type.trim().equalsIgnoreCase("facebook"))
        {
            if(OrganisationInfoRepository.removeFacebook(Long.parseLong(orgId)) != 1)
                throw new Exception("Exception: social not removed");
        }
        else throw new Exception("Exception: social not identified");

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

        if(request == null)
            throw new Exception("Exception: request is not set");
        else if(request.getOrgId() == null)
            throw new Exception("Exception: request id not set");
        else if(request.getImage() == null)
            throw new Exception("Exception: request img url not set");
        else if(request.getOrgId().isEmpty())
            throw new Exception("Exception: request id is invalid");
        else if(request.getImage().isEmpty())
            throw new Exception("Exception: request img url is invalid");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(request.getOrgId())) == null)
            throw new Exception("Exception: request id does not exist/invalid");

        return false;
    }

    @Override
    public boolean removeOrgImage(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: AddOrganisationRequest ID is not set");
        else if(OrganisationRepository.selectOrganisationById(Long.parseLong(orgId)) == null)
            throw new Exception("Exception: AddOrganisationRequest ID does not exist");

        return false;
    }
    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        return null;
    }
}
