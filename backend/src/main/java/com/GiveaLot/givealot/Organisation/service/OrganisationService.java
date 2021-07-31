package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.dao.OrganisationDAOInterface;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.rri.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;

@Service
public class OrganisationService {

    private final OrganisationDAOInterface organisationDAOInterface;

    @Autowired
    OrganisationService(@Qualifier("temp") OrganisationDAOInterface organisationDAOInterface)
    {
        this.organisationDAOInterface = organisationDAOInterface;
    }

    public Organisation selectOrganisation(String orgId)
    {
        return organisationDAOInterface.selectOrganisation(orgId);
    }

    public OrganisationInfo selectOrganisationInfo(String orgId)
    {
        return organisationDAOInterface.selectOrganisationInfo(orgId);
    }


    public OrganisationPoints selectOrganisationPoints(String orgId)
    {
        return organisationDAOInterface.selectOrganisationPoints(orgId);
    }


    public boolean organisationExists(Organisation organisation)
    {
        return organisationDAOInterface.organisationExists(organisation);
    }


    public boolean addOrganisation(Organisation organisation)
    {
       return organisationDAOInterface.addOrganisation(organisation);
    }


    public boolean reactivateOrganisation(String orgId)
    {
        return organisationDAOInterface.reactivateOrganisation(orgId);
    }

    public boolean investigateOrganisation(String orgId){
       return organisationDAOInterface.investigateOrganisation(orgId);
    }

    public boolean suspendOrganisation(String orgId){

       return organisationDAOInterface.suspendOrganisation(orgId);
    }


    //Additional classes
    public boolean addOrgWebsite(AddOrgWebsiteRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String website = request.getWebsite();

            return organisationDAOInterface.addOrgWebsite(orgId, website);
        }
        return false;
    }

    public boolean removeOrgAddress(String orgId)
    {
        return organisationDAOInterface.removeOrgAddress(orgId);

    }

    public boolean addOrgImage(AddOrgImageRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            File image = request.getImage();

            return organisationDAOInterface.addOrgImage(orgId, image);
        }
        return false;
    }


    public boolean removeOrgImage(String orgId)
    {
        return organisationDAOInterface.removeOrgImage(orgId);

    }


    public boolean addOrgAuditDoc(AddOrgAuditInfoRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            File audit = request.getAudit();
            return organisationDAOInterface.addOrgAuditDoc(orgId, audit);
        }
        return false;
    }


    public boolean removeOrgAuditDoc(String orgId)
    {
        return organisationDAOInterface.removeOrgAuditDoc(orgId);

    }

    public boolean addOrgTaxRef(AddOrgTaxRefRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String reference = request.getReference();

            return organisationDAOInterface.addOrgTaxRef(orgId, reference);
        }
        return false;
    }

    public boolean removeOrgTaxRef(String orgId)
    {
        return organisationDAOInterface.removeOrgTaxRef(orgId);

    }

    public boolean addOrgAuditor(String orgId, String auditor)
    {
        return organisationDAOInterface.addOrgAuditor(orgId,auditor);

    }


    public boolean removeOrgAuditor(String orgId)
    {
        return organisationDAOInterface.removeOrgAuditor(orgId);

    }

    public boolean addOrgCommittee(AddOrgCommitteeRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String committee = request.getCommittee();
            return organisationDAOInterface.addOrgCommittee(orgId, committee);
        }
        return false;
    }

    public boolean removeOrgCommittee(String orgId)
    {
        return organisationDAOInterface.removeOrgCommittee(orgId);

    }

    public boolean addOrgDonationInfo(String orgId, String info)
    {
        return organisationDAOInterface.addOrgDonationInfo(orgId,info);

    }

    public boolean removeOrgDonationInfo(String orgId)
    {
        return organisationDAOInterface.removeOrgDonationInfo(orgId);

    }

    public boolean addOrgSocials(AddSocialsRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            String type = request.getType();
            String website = request.getWebsite();

            /*
                data not validated
            */

            return organisationDAOInterface.addOrgSocials(orgId,type,website);
        }
        /* maybe throw an exception indicating that an
             incorrect object state was used?
        */
        return false;
    }

    public boolean removeOrgSocials(String orgId, String type)
    {
        /*
        * not validated yet
        */
        return organisationDAOInterface.removeOrgSocials(orgId, type);
    }

    public boolean addOrgNGO(AddOrgNGORequest request)
    {
        if(request != null) {
            String orgId = request.getOrgId();
            String ngoNumber = request.getNgoNumber();
            Date ngoDate = request.getNgoDate();
            /*
             * not validated yet
             */
            return organisationDAOInterface.addOrgNGO(orgId, ngoNumber, ngoDate);
        }
        return false;
    }

    public boolean removeOrgNGO(String orgId)
    {
        return organisationDAOInterface.removeOrgNGO(orgId);
    }

    public boolean addOrgEstDate(AddOrgEstDateRequest request)
    {
        if(request != null)
        {
            String orgId = request.getOrgId();
            Date date = request.getDate();

            /*
             * not validated yet
             */
            return organisationDAOInterface.addOrgEstDate(orgId, date);
        }
        return false;
    }

    public boolean removeOrgEstDate(String orgId)
    {
        return organisationDAOInterface.removeOrgEstDate(orgId);

    }
}
