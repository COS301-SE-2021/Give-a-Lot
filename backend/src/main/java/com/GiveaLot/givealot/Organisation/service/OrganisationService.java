package com.GiveaLot.givealot.Organisation.service;

import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.*;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.stereotype.Service;

@Service
public interface OrganisationService {

    selectOrganisationResponse selectOrganisation(Long orgId, Long userId) throws Exception;
    selectOrganisationInfoResponse selectOrganisationInfo(Long orgId) throws Exception;
    organisationPointsResponse selectOrganisationPoints(Long orgId) throws Exception;
    generalOrganisationResponse addOrganisation(AddOrganisationRequest organisation) throws Exception;
    generalOrganisationResponse reactivateOrganisation(ActivateRequest request) throws Exception;
    generalOrganisationResponse investigateOrganisation(InvestigateRequest request) throws Exception;
    generalOrganisationResponse suspendOrganisation(SuspendRequest request) throws Exception;
    getOrganisationsResponse getOrganisations(GetOrganisationsRequest request) throws Exception;
    //Additional classes
    generalOrganisationResponse addOrgWebsite(AddOrgWebsiteRequest request) throws Exception;
    generalOrganisationResponse removeOrgWebsite(Long orgId) throws Exception;
    generalOrganisationResponse addOrgAddress(AddOrgAddressRequest request) throws Exception;
    generalOrganisationResponse removeOrgAddress(Long orgId) throws Exception;
    generalOrganisationResponse addOrgLogo(AddOrgLogoRequest request) throws Exception;
    generalOrganisationResponse removeOrgLogo(Long orgId) throws Exception;
    generalOrganisationResponse addOrgImage(AddOrgImageMultipartRequest request) throws Exception ;
    generalOrganisationResponse removeOrgImage(Long orgId, int number) throws Exception;
    generalOrganisationResponse addOrgAuditDoc(AddOrgAuditInfoRequest request) throws Exception;
    generalOrganisationResponse removeOrgAuditDoc(Long orgId) throws Exception;
    generalOrganisationResponse addOrgCommittee(AddOrgCommitteeRequest request) throws Exception;
    generalOrganisationResponse removeOrgCommittee(Long orgId) throws Exception ;
    generalOrganisationResponse addOrgDonationURL(AddOrgDonationInfoRequest request) throws Exception;
    generalOrganisationResponse removeOrgDonationURL(Long orgId) throws Exception;
    generalOrganisationResponse addOrgDonationQRCode(AddOrgQRCodeRequest request) throws Exception;
    generalOrganisationResponse removeOrgDonationQRCode(Long orgId) throws Exception;
    generalOrganisationResponse addOrgSocials(AddSocialsRequest request) throws Exception;
    generalOrganisationResponse removeOrgSocials(Long orgId, String type) throws Exception;
    generalOrganisationResponse addOrgNGO(AddOrgNGORequest request) throws Exception;
    boolean removeOrgNGO(long orgId) throws Exception;
    generalOrganisationResponse addOrgNGODate(AddOrgNGORequest request) throws Exception;
    generalOrganisationResponse removeNGDate(Long orgId) throws Exception;
    generalOrganisationResponse addOrgEstDate(AddOrgEstDateRequest request) throws Exception;
    generalOrganisationResponse removeOrgEstDate(Long orgId) throws Exception;
    generalOrganisationResponse confirmValidity(Long orgId,Long adminId,String type,boolean confirmValidity) throws Exception;
    numberOfImagesResponse numberOfImages(Long orgId) throws Exception;
    generalOrganisationResponse addSector(AddSectorRequest request) throws Exception;
    getSectorsResponse getSectors() throws Exception;
    getNumberOfOrganisationsResponse getNumberOfOrganisations(GetOrganisationsRequest request)throws Exception;
    getOrgCertLevelResponse getOrgCertLevel(GetOrganisationCertificateLevelRequest request)throws Exception;
    responseJSON getNumPerMonth(getNumOrganisationPerMonthRequest request)throws Exception;
    generalOrganisationResponse updateOrganisationInfo(updateOrganisationInfoRequest request) throws Exception;
    void clearTabels();
    boolean emailExists(emailExistsRequest request) throws Exception;
    responseJSON selectOrganisationAdmin(Long orgId) throws Exception;
    byte [] getOrganisationLogo(Long orgId) throws Exception;
    Long getOrgBottom();
    Long getOrgTop();

}
