package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganisationService {
    Organisations selectOrganisation(Long orgId) throws Exception;
    OrganisationInfo selectOrganisationInfo(long orgId) throws Exception;
    OrganisationPoints selectOrganisationPoints(long orgId) throws Exception;
    boolean addOrganisation(Organisations organisation) throws Exception;
    boolean reactivateOrganisation(long orgId) throws Exception;
    boolean investigateOrganisation(long orgId) throws Exception;
    boolean suspendOrganisation(long orgId) throws Exception;
    public getOrganisationsResponse getOrganisations(GetOrganisationsRequest request) throws Exception;
    //Additional classes
    boolean addOrgWebsite(AddOrgWebsiteRequest request) throws Exception;
    boolean removeOrgWebsite(long orgId) throws Exception;
    boolean addOrgAddress(AddOrgAddressRequest request) throws Exception;
    boolean removeOrgAddress(long orgId) throws Exception;
    boolean addOrgImage(AddOrgImageRequest request) throws Exception;
    boolean removeOrgImage(long orgId) throws Exception;
    boolean addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception;
    boolean removeOrgAuditDoc(long orgId) throws Exception;
    boolean addOrgTaxRef(AddOrgTaxRefRequest request) throws Exception;
    boolean removeOrgTaxRef(long orgId) throws Exception;
    boolean addOrgAuditor(AddOrgAuditorRequest request) throws Exception;
    boolean removeOrgAuditor(long orgId) throws Exception;
    boolean addOrgCommittee(AddOrgCommitteeRequest request) throws Exception;
    boolean removeOrgCommittee(long orgId) throws Exception ;
    boolean addOrgDonationInfo(AddOrgDonationInfoRequest request) throws Exception;
    boolean removeOrgDonationInfo(long orgId) throws Exception;
    boolean addOrgSocials(AddSocialsRequest request) throws Exception;
    boolean removeOrgSocials(long orgId, String type) throws Exception;
    boolean addOrgNGO(AddOrgNGORequest request) throws Exception;
    boolean removeOrgNGO(long orgId) throws Exception;
    boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception;
    boolean removeOrgEstDate(long orgId) throws Exception;

    /*
    * */


    boolean confirmValidity(Long orgId,Long adminId,String type,boolean confirmValidity) throws Exception;
    Integer numberOfImages(Long orgId) throws Exception;
}
