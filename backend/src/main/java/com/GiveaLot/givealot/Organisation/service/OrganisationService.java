package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.requests.*;
import org.springframework.stereotype.Service;

@Service
public interface OrganisationService {
    Organisations selectOrganisation(String orgId) throws Exception;
    OrganisationInfo selectOrganisationInfo(String orgId) throws Exception;
    OrganisationPoints selectOrganisationPoints(String orgId) throws Exception;
    boolean addOrganisation(Organisations organisation) throws Exception;
    boolean reactivateOrganisation(String orgId) throws Exception;
    boolean investigateOrganisation(String orgId) throws Exception;
    boolean suspendOrganisation(String orgId) throws Exception;

    //Additional classes
    boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception;
    boolean removeOrgWebsite(String orgId) throws Exception;
    boolean addOrgAddress(AddOrgAddressRequest request) throws Exception;
    boolean removeOrgAddress(String orgId) throws Exception;
    boolean addOrgImage(AddOrgImageRequest request) throws Exception;
    boolean removeOrgImage(String orgId) throws Exception;
    boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception;
    boolean removeOrgAuditDoc(String orgId) throws Exception;
    boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception;
    boolean removeOrgTaxRef(String orgId) throws Exception;
    boolean addOrgAuditor(AddOrgAuditorRequest request) throws Exception;
    boolean removeOrgAuditor(String orgId) throws Exception;
    boolean addOrgCommittee(AddOrgCommitteeRequest request) throws Exception;
    boolean removeOrgCommittee(String orgId) throws Exception ;
    boolean addOrgDonationInfo(AddOrgDonationInfoRequest request) throws Exception;
    boolean removeOrgDonationInfo(String orgId) throws Exception;
    boolean addOrgSocials(AddSocialsRequest request) throws Exception;
    boolean removeOrgSocials(String orgId, String type) throws Exception;
    boolean addOrgNGO(AddOrgNGORequest request) throws Exception;
    boolean removeOrgNGO(String orgId) throws Exception;
    boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception;
    boolean removeOrgEstDate(String orgId) throws Exception;
}
