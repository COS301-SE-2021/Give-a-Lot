package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.dao.OrganisationDAOInterface;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.Optional;

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
    public boolean addOrgWebsite(String orgId,String website)
    {
        return organisationDAOInterface.addOrgWebsite(orgId,website);
    }

    public boolean removeOrgAddress(String orgId)
    {
        return organisationDAOInterface.removeOrgAddress(orgId);

    }

    public boolean addOrgImage(String orgId, File image)
    {
        return organisationDAOInterface.addOrgImage(orgId,image);

    }


    public boolean removeOrgImage(String orgId)
    {
        return organisationDAOInterface.removeOrgImage(orgId);

    }


    public boolean addOrgAuditDoc(String orgId, File audit)
    {
        return organisationDAOInterface.addOrgAuditDoc(orgId,audit);

    }


    public boolean removeOrgAuditDoc(String orgId)
    {
        return organisationDAOInterface.removeOrgAuditDoc(orgId);

    }

    public boolean addOrgTaxRef(String orgId, String reference)
    {
        return organisationDAOInterface.addOrgTaxRef(orgId,reference);

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

    public boolean addOrgCommittee(String orgId, String committee)
    {
        return organisationDAOInterface.addOrgCommittee(orgId,committee);

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


    public boolean addOrgSocials(String orgId, String type, String website)
    {
        return organisationDAOInterface.addOrgSocials(orgId,type,website);

    }

    public boolean removeOrgSocials(String orgId, String type)
    {
        return organisationDAOInterface.removeOrgSocials(orgId,type);

    }

    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate)
    {
        return organisationDAOInterface.addOrgNGO(orgId,ngoNumber,ngoDate);

    }

    public boolean removeOrgNGO(String orgId)
    {
        return organisationDAOInterface.removeOrgNGO(orgId);

    }


    public boolean addOrgEstDate(String orgId, Date date)
    {
        return organisationDAOInterface.addOrgEstDate(orgId,date);

    }


    public boolean removeOrgEstDate(String orgId)
    {
        return organisationDAOInterface.removeOrgEstDate(orgId);

    }




}
