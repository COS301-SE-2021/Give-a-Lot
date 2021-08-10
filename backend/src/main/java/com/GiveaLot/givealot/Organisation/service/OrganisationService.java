package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.dao.OrganisationDAOInterface;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.requests.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class OrganisationService {

    private final OrganisationDAOInterface organisationDAOInterface;

    @Autowired
    OrganisationService(@Qualifier("OrganisationTemp") OrganisationDAOInterface organisationDAOInterface)
    {
        this.organisationDAOInterface = organisationDAOInterface;
    }

    public Organisation selectOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.selectOrganisation(orgId);
    }

    public OrganisationInfo selectOrganisationInfo(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.selectOrganisationInfo(orgId);
    }


    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.selectOrganisationPoints(orgId);
    }


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


    public boolean reactivateOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.reactivateOrganisation(orgId);
    }

    public boolean investigateOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
       return organisationDAOInterface.investigateOrganisation(orgId);
    }

    public boolean suspendOrganisation(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
       return organisationDAOInterface.suspendOrganisation(orgId);
    }


    //Additional classes
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

    public boolean removeOrgWebsite(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgWebsite(orgId);
    }

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

    public boolean removeOrgAddress(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }

        return organisationDAOInterface.removeOrgAddress(orgId);
    }

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


    public boolean removeOrgImage(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId does not satisfy the database constraints");
        }
        return organisationDAOInterface.removeOrgImage(orgId);

    }


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


    public boolean removeOrgAuditDoc(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgAuditDoc(orgId);

    }

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

    public boolean removeOrgTaxRef(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgTaxRef(orgId);

    }

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


    public boolean removeOrgAuditor(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgAuditor(orgId);

    }

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

    public boolean removeOrgCommittee(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgCommittee(orgId);

    }

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

    public boolean removeOrgDonationInfo(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgDonationInfo(orgId);
    }

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

    public boolean removeOrgSocials(String orgId, String type) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgSocials(orgId, type);
    }

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

    public boolean removeOrgNGO(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgNGO(orgId);
    }

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

    public boolean removeOrgEstDate(String orgId) throws Exception {
        if (orgId.length()==0 || orgId.length()>50){
            throw new Exception("Exception: orgId is Invalid");
        }
        return organisationDAOInterface.removeOrgEstDate(orgId);

    }

}
