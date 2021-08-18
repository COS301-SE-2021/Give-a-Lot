package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.generalOrganisationResponse;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrganisationService {
    selectOrganisationResponse selectOrganisation(Long orgId) throws Exception;
    OrganisationInfo selectOrganisationInfo(long orgId) throws Exception;
    OrganisationPoints selectOrganisationPoints(long orgId) throws Exception;
    generalOrganisationResponse addOrganisation(Organisations organisation) throws Exception;
    generalOrganisationResponse reactivateOrganisation(Long orgId) throws Exception;
    generalOrganisationResponse investigateOrganisation(Long orgId) throws Exception;
    generalOrganisationResponse suspendOrganisation(Long orgId) throws Exception;
    public getOrganisationsResponse getOrganisations(GetOrganisationsRequest request) throws Exception;
    //Additional classes
    generalOrganisationResponse addOrgWebsite(AddOrgWebsiteRequest request) throws Exception;
    generalOrganisationResponse removeOrgWebsite(Long orgId) throws Exception;
    generalOrganisationResponse addOrgAddress(AddOrgAddressRequest request) throws Exception;
    generalOrganisationResponse removeOrgAddress(Long orgId) throws Exception;
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
    generalOrganisationResponse addOrgSocials(AddSocialsRequest request) throws Exception;
    public generalOrganisationResponse removeOrgSocials(Long orgId, String type) throws Exception;
    boolean addOrgNGO(AddOrgNGORequest request) throws Exception;
    boolean removeOrgNGO(long orgId) throws Exception;
    boolean addOrgEstDate(AddOrgEstDateRequest request) throws Exception;
    boolean removeOrgEstDate(long orgId) throws Exception;

    /*
    * */


    boolean confirmValidity(Long orgId,Long adminId,String type,boolean confirmValidity) throws Exception;
    Integer numberOfImages(Long orgId) throws Exception;
}
