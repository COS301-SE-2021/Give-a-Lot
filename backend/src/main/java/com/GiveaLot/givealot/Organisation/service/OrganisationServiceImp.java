package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.dataclass.organisationInfo;
import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.dataclass.OrganisationRepo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.requests.*;
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
    public OrganisationRepo selectOrganisation(String orgId) throws Exception {

        if(orgId == null)
            throw new Exception("Exception: Organisation Id is null");
        else if (orgId.isEmpty() || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }

        return OrganisationRepository.selectOrganisation(orgId);
    }

    @Override
    public organisationInfo selectOrganisationInfo(String orgId) throws Exception
    {
        if(orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if(OrganisationRepository.selectOrganisation(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        organisationInfo organisationInfo = OrganisationInfoRepository.selectOrganisationInfo(orgId);

        if(organisationInfo == null)
        {
            /*
            * Because organisation already exists, set the field
            * */
            organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(orgId);

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
        else if(OrganisationRepository.selectOrganisation(request.getOrgId()) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        /*
        *  Todo:
        *   validate the website
        * */

        if(OrganisationInfoRepository.addOrgWebsite(request.getOrgId(),request.getWebsite()) != 1)
            throw new Exception("Exception: website field not updated");

        return true;
    }

    @Override
    public boolean removeOrgWebsite(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("Exception: Organisation ID is not set");
        else if(OrganisationRepository.selectOrganisation(orgId) == null)
            throw new Exception("Exception: Organisation ID does not exist");

        if(OrganisationInfoRepository.selectOrganisationInfo(orgId) == null)
        {
            /*
             * Because organisation already exists, set the field
             * */
            organisationInfo organisationInfo = new organisationInfo();
            organisationInfo.setOrgId(orgId);

            OrganisationInfoRepository.save(organisationInfo);
            throw new Exception("Exception: system level error, organisation info did not exist, rerun " +
                    "the contract");
        }

        if(OrganisationInfoRepository.removeOrgWebsite(orgId) != 1)
            throw new Exception("Exception: website field not updated");

        return true;
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        return null;
    }

    @Override
    public boolean addOrganisation(OrganisationRepo organisation) throws Exception
    {
        if(organisation == null)
            throw new Exception("invalid organisation object: null");

        else if(organisation.getOrgId() == null || organisation.getOrgName() == null || organisation.getOrgDescription() == null|| organisation.getPassword() == null|| organisation.getOrgSector() == null|| organisation.getStatus() == null|| organisation.getOrgEmail() == null|| organisation.getDirectory() == null|| organisation.getContactNumber() == null|| organisation.getContactPerson() == null|| organisation.getSlogan() == null)
            throw new Exception("invalid field provided: null");

        else if(OrganisationRepository.selectOrganisation(organisation.getOrgId()) != null)
            throw new Exception("This organisation already exists");

        else if (organisation.getOrgId().isEmpty() || organisation.getOrgId().length() > 50)
            throw new Exception("Exception: orgId does not satisfy the database constraints");

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

        organisationInfo organisationInfo = new organisationInfo();

        OrganisationRepository.save(organisation);
        organisationInfo.setOrgId(organisation.getOrgId());
        LocalDate date = LocalDate.now(); /* registration date */
        OrganisationInfoRepository.save(organisationInfo);
        return true;
    }

    @Override
    public boolean suspendOrganisation(String orgId) throws Exception {

        if(orgId == null)
            throw new Exception("String object is null");
        else if(orgId.isEmpty())
            throw new Exception("invalid id length");
        else if(OrganisationRepository.selectOrganisation(orgId) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(orgId,"suspended".toLowerCase()) != 1)
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
        else if(OrganisationRepository.selectOrganisation(orgId) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(orgId,"active".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean investigateOrganisation(String orgId) throws Exception {
        if(orgId == null)
            throw new Exception("String object is null");
        else if(orgId.isEmpty())
            throw new Exception("invalid id length");
        else if(OrganisationRepository.selectOrganisation(orgId) == null)
            throw new Exception("ID doesn't exist");
        else
        {
            if(OrganisationRepository.updateStatus(orgId,"investigating".toLowerCase()) != 1)
                throw new Exception("status not updated");
            else return true;
        }
    }

    @Override
    public boolean addOrgAddress(AddOrgAddressRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgAddress(String orgId) throws Exception {
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

    @Override
    public boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) throws Exception {
        return false;
    }

    @Override
    public boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) throws Exception {
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
    public boolean addOrgSocials(AddSocialsRequest request) throws Exception {
        return false;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) throws Exception {
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

/*    @Override
    public OrganisationInfo selectOrganisationInfo(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.selectOrganisationInfo(orgId);
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.selectOrganisationPoints(orgId);
    }

    @Override
    public boolean organisationExists(Organisation organisation) throws Exception {
        if (organisation.getOrgId().toString().length()==0 || organisation.getOrgId().toString().length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        if (organisation.getOrgName().length()==0 || organisation.getOrgName().length()>255){
            throw new Exception("Exception: orgName does not satisfy the database constraints");
        }
        if (organisation.getOrgDescription().length()==0 || organisation.getOrgDescription().length()>65535){
            throw new Exception("Exception: orgDescription does not satisfy the database constraints");
        }
        if (organisation.getPassword().length()==0 || organisation.getPassword().length()>255){
            throw new Exception("Exception: password does not satisfy the database constraints");
        }
        if (organisation.getOrgSector().length()==0 || organisation.getOrgSector().length()>255){
            throw new Exception("Exception: orgSector does not satisfy the database constraints");
        }
        if (organisation.getStatus().length()==0 || organisation.getStatus().length()>255){
            throw new Exception("Exception: status does not satisfy the database constraints");
        }
        if (organisation.getOrgEmail().length()==0 || organisation.getOrgEmail().length()>255){
            throw new Exception("Exception: orgEmail does not satisfy the database constraints");
        }
        if (organisation.getDirectory().length()==0 || organisation.getDirectory().length()>255){
            throw new Exception("Exception: directory does not satisfy the database constraints");
        }
        if (organisation.getContactNumber().length()==0 || organisation.getContactNumber().length()>255){
            throw new Exception("Exception: contactNumber does not satisfy the database constraints");
        }
        if (organisation.getContactPerson().length()==0 || organisation.getContactPerson().length()>255){
            throw new Exception("Exception: contactPerson does not satisfy the database constraints");
        }
        if (organisation.getSlogan().length()==0 || organisation.getSlogan().length()>255){
            throw new Exception("Exception: orgSlogan does not satisfy the database constraints");
        }
        return organisationDAOInterface.organisationExists(organisation);
    }

    @Override
    public boolean addOrganisation(Organisation organisation) throws Exception {
        if (organisation.getOrgId().toString().length() ==0 || organisation.getOrgId().toString().length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        if (organisation.getOrgName().length()==0 || organisation.getOrgName().length()>255){
            throw new Exception("Exception: orgName does not satisfy the database constraints");
        }
        if (organisation.getOrgDescription().length()==0 || organisation.getOrgDescription().length()>65535){
            throw new Exception("Exception: orgDescription does not satisfy the database constraints");
        }
        if (organisation.getPassword().length()==0 || organisation.getPassword().length()>255){
            throw new Exception("Exception: password does not satisfy the database constraints");
        }
        if (organisation.getOrgSector().length()==0 || organisation.getOrgSector().length()>255){
            throw new Exception("Exception: orgSector does not satisfy the database constraints");
        }
        if (organisation.getStatus().length()==0 || organisation.getStatus().length()>255){
            throw new Exception("Exception: status does not satisfy the database constraints");
        }
        if (organisation.getOrgEmail().length()==0 || organisation.getOrgEmail().length()>255){
            throw new Exception("Exception: orgEmail does not satisfy the database constraints");
        }
        if (organisation.getDirectory().length()==0 || organisation.getDirectory().length()>255){
            throw new Exception("Exception: directory does not satisfy the database constraints");
        }
        if (organisation.getContactNumber().length()==0 || organisation.getContactNumber().length()>255){
            throw new Exception("Exception: contactNumber does not satisfy the database constraints");
        }
        if (organisation.getContactPerson().length()==0 || organisation.getContactPerson().length()>255){
            throw new Exception("Exception: contactPerson does not satisfy the database constraints");
        }
        if (organisation.getSlogan().length()==0 || organisation.getSlogan().length()>255){
            throw new Exception("Exception: orgSlogan does not satisfy the database constraints");
        }
        return organisationDAOInterface.addOrganisation(organisation);
    }

    @Override
    public boolean reactivateOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.reactivateOrganisation(orgId);
    }

    @Override
    public boolean investigateOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.investigateOrganisation(orgId);
    }

    @Override
    public boolean suspendOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.suspendOrganisation(orgId);
    }


    //Additional classes
    @Override
    public boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String website = request.getWebsite();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (website.length()==0 || website.length()>255){
                throw new Exception("Exception: website does not satisfy the database constraints");
            }

            return organisationDAOInterface.addOrgWebsite(orgId, website);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgWebsite(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgWebsite(orgId);
    }

    @Override
    public boolean addOrgAddress(AddOrgAddressRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String address = request.getAddress();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (address.length()==0 || address.length()>255){
                throw new Exception("Exception: address does not satisfy the database constraints");
            }

            return organisationDAOInterface.addOrgAddress(orgId,address);
        }
        throw new Exception("Exception: request object is null");

    }

    @Override
    public boolean removeOrgAddress(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }

        return organisationDAOInterface.removeOrgAddress(orgId);
    }

    @Override
    public boolean addOrgImage(AddOrgImageRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            File image = request.getImage();

            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (image.isFile()){
                throw new Exception("Exception: image cannot be uploaded to the server");
            }
            return organisationDAOInterface.addOrgImage(orgId, image);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgImage(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.removeOrgImage(orgId);

    }

    @Override
    public boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            File audit = request.getAudit();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (audit.isFile()){
                throw new Exception("Exception: audit cannot be uploaded to the server");
            }
            return organisationDAOInterface.addOrgAuditDoc(orgId, audit);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgAuditDoc(orgId);

    }

    @Override
    public boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String reference = request.getReference();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (reference.length()==0 || reference.length()>255){
                throw new Exception("Exception: reference does not satisfy the database constraints");
            }

            return organisationDAOInterface.addOrgTaxRef(orgId, reference);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgTaxRef(orgId);

    }

    @Override
    public boolean addOrgAuditor(AddOrgAuditorRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String auditor = request.getAuditor();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (auditor.length()==0 || auditor.length()>255){
                throw new Exception("Exception: auditor does not satisfy the database constraints");
            }
            return organisationDAOInterface.addOrgAuditor(orgId, auditor);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgAuditor(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgAuditor(orgId);

    }

    @Override
    public boolean addOrgCommittee(AddOrgCommitteeRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String committee = request.getCommittee();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (committee.length()==0 || committee.length()>255){
                throw new Exception("Exception: committee does not satisfy the database constraints");
            }
            return organisationDAOInterface.addOrgCommittee(orgId, committee);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgCommittee(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgCommittee(orgId);

    }

    @Override
    public boolean addOrgDonationInfo(AddOrgDonationInfoRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String info = request.getOrgInfo();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (info.length()==0 || info.length()>255){
                throw new Exception("Exception: info does not satisfy the database constraints");
            }
            return organisationDAOInterface.addOrgDonationInfo(orgId, info);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgDonationInfo(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgDonationInfo(orgId);
    }

    @Override
    public boolean addOrgSocials(AddSocialsRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String type = request.getType();
            String url = request.getUrl();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (type.length()==0 || type.length()>255){
                throw new Exception("Exception: type is Invalid");
            }
            if (url.length()==0 || url.length()>255){
                throw new Exception("Exception: url does not satisfy the database constraints");
            }

            return organisationDAOInterface.addOrgSocials(orgId,type,url);
        }

        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgSocials(orgId, type);
    }

    @Override
    public boolean addOrgNGO(AddOrgNGORequest request) throws Exception {
        if(request != null) {
            String orgId = request.getOrgId();
            String ngoNumber = request.getNgoNumber();
            Date ngoDate = request.getNgoDate();

            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }
            if (ngoNumber.length()==0 || ngoNumber.length()>255){
                throw new Exception("Exception: nogNumber does not satisfy the database constraints");
            }


            return organisationDAOInterface.addOrgNGO(orgId, ngoNumber, ngoDate);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgNGO(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgNGO(orgId);
    }

    @Override
    public boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception {
        if(request != null)
        {
            String orgId = request.getOrgId();
            Date date = request.getDate();
            if (orgId.length()==0 || orgId.length()>50){
                throw new Exception("Exception: orgId does not satisfy the database constraints");
            }

            return organisationDAOInterface.addOrgEstDate(orgId, date);
        }
        throw new Exception("Exception: request object is null");
    }

    @Override
    public boolean removeOrgEstDate(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgEstDate(orgId);

    }*/

}
