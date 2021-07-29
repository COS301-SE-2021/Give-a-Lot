package com.giveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.Organisation.model.Organisation;
import java.io.File;
import java.util.Date;

public interface OrganisationDAOInterface {

    public Organisation selectOrganisation(String orgId);

    public Organisation selectOrganisationInfo(String orgId);

    public Organisation selectOrganisationPoints(String orgId);


    public boolean organisationExists(Organisation organisation);

    public boolean addOrganisation(Organisation organisation);

    public boolean reactivateOrganisation(String orgId);

    public boolean investigateOrganisation(String orgId);

    public boolean suspendOrganisation(String orgId);


    /** Additional functions **/


    public boolean addOrgWebsite(String orgId,String website);

    public boolean removeOrgAddress(String orgId);

    public boolean addOrgImage(String orgId, File image);

    public boolean removeOrgImage(String orgId);

    public boolean addOrgAuditDoc(String orgId, File audit);

    public boolean removeOrgAuditDoc(String orgId);

    public boolean addOrgTaxRef(String orgId, String reference);

    public boolean removeOrgTaxRef(String orgId);

    public boolean addOrgAuditor(String orgId, String auditor);

    public boolean removeOrgAuditor(String orgId);

    public boolean addOrgCommittee(String orgId, String committee);

    public boolean removeOrgCommittee(String orgId);

    public boolean addOrgDonationInfo(String orgId, String info);

    public boolean removeOrgDonationInfo(String orgId);

    public boolean addOrgSocials(String orgId, String type, String website);

    public boolean removeOrgSocials(String orgId, String type);

    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate);

    public boolean removeOrgNGO(String orgId);

    public boolean addOrgEstDate(String orgId, Date date);

    public boolean removeOrgEstDate(String orgId);

}
