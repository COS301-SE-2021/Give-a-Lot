package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.*;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.requests.GetUsersRequest;
import com.GiveaLot.givealot.User.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/organisation")
@CrossOrigin("*")
@RestController
public class OrganisationController
{
    private final OrganisationServiceImp service;
    private final responseJSON response;

    @Autowired
    public OrganisationController(OrganisationServiceImp service, responseJSON response)
    {
        this.service = service;
        this.response = response;
    }

    /* tested - works */
     @GetMapping("/sel/organisation/{orgId}/{userId}") /*tested all good*/
    public ResponseEntity<selectOrganisationResponse> selectOrganisation(@PathVariable("orgId") @NonNull Long orgId,@PathVariable("userId") @NonNull Long userId)
    {
        selectOrganisationResponse response;
        try
        {
            response = service.selectOrganisation(orgId,userId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new selectOrganisationResponse("sel_org_500_bad","failed: " + e, null), HttpStatus.OK);
        }
    }

    @PostMapping("/get/organisations") /*tested all good*/
    public ResponseEntity<getOrganisationsResponse> getOrganisations(@RequestBody @NonNull GetOrganisationsRequest body)
    {
        getOrganisationsResponse response;
        try
        {
            response = service.getOrganisations(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new getOrganisationsResponse("get_orgs_500_bad","failed: " + e, null), HttpStatus.OK);
        }
    }

    /*this function is meant to be removed in production */
    @GetMapping("/get/organisations/temporal") /*tested all good*/
    public ResponseEntity<getOrganisationsResponse> getOrganisationsTemporal()
    {
        getOrganisationsResponse response;
        try
        {
            response = service.getOrganisations(null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new getOrganisationsResponse("get_orgs_500_bad","failed: " + e, null), HttpStatus.OK);
        }
    }

    @PostMapping("/add/org") /*tested all good*/
    public ResponseEntity<generalOrganisationResponse> addOrganisation(@RequestBody @NonNull AddOrganisationRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrganisation(new Organisations(body.getOrgName(),
                    body.getSlogan(),body.getOrgDescription(),body.getOrgSector(),
                    body.getOrgEmail(),null,body.getStatus(),body.getContactPerson(),
                    body.getContactNumber(), "givealot/organisations/", body.getPassword(),null));
            return new ResponseEntity<>(response,  HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("org_add_err_501","failed: " + e), HttpStatus.OK);
        }
    }

    @PutMapping("/suspend/{orgId}") /* tested all good */
    public ResponseEntity<generalOrganisationResponse> suspendOrganisation(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.suspendOrganisation(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("org_sus_err_501","failed: " + e), HttpStatus.OK);
        }
    }

    @PutMapping("/activate/{orgId}") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> reactivateOrganisation(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.reactivateOrganisation(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("org_rea_err_500","failed: " + e), HttpStatus.OK);
        }
    }

    @PutMapping("/investigate/{orgId}") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> investigateOrganisation(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.investigateOrganisation(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("org_inv_err_500","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/website") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> addOrgWebsite(@RequestBody @NonNull AddOrgWebsiteRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgWebsite(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("org_web_err_500","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/website/{orgId}") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> removeOrgWebsite(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgWebsite(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_web_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/address") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> addOrgAddress(@RequestBody @NonNull AddOrgAddressRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgAddress(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_addr_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/address/{orgId}") /* tested - works */
    public ResponseEntity<generalOrganisationResponse>  removeOrgAddress(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgAddress(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_addr_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/socials") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> addOrgSocials(@RequestBody  @NonNull AddSocialsRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgSocials(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_soc_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/socials/{orgId}/{type}") /* tested - works */
    public ResponseEntity<generalOrganisationResponse> removeOrgSocials(@PathVariable("orgId") @NonNull Long orgId,@PathVariable("type") @NonNull String type)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgSocials(orgId,type);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_soc_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/taxref") /* not tested */
    public ResponseEntity<generalOrganisationResponse> addOrgTaxRef(@RequestBody AddOrgTaxRefRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgTaxRef(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_tax_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/taxref/{orgId}") /* not tested */
    public ResponseEntity<generalOrganisationResponse> removeOrgTaxRef(@PathVariable("orgId")@NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgTaxRef(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_tax_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/audit") /* not tested */
    public ResponseEntity<generalOrganisationResponse> addOrgAuditDoc(@RequestBody @NonNull AddOrgAuditInfoRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgAuditDoc(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_audoc_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/audit/{orgId}") /* not tested */
    public ResponseEntity<generalOrganisationResponse> removeOrgAuditDoc(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgAuditDoc(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_audoc_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/auditor") /* not tested */
    public ResponseEntity<generalOrganisationResponse> addOrgAuditor(@RequestBody @NonNull AddOrgAuditorRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgAuditor(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_audr_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/auditor/{orgId}") /* not tested */
    public ResponseEntity<generalOrganisationResponse> removeOrgAuditor(@PathVariable("orgId") @NonNull long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgAuditor(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_audr_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/committee") /* not tested */
    public ResponseEntity<generalOrganisationResponse>  addOrgCommittee(@RequestBody @NonNull AddOrgCommitteeRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgCommittee(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_cmt_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/committee/{orgId}")
    public ResponseEntity<generalOrganisationResponse> removeOrgCommittee(@PathVariable("orgId") @NonNull long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgCommittee(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_cmt_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/donation/info") /* not tested */
    public ResponseEntity<generalOrganisationResponse> addOrgDonationInfo(@RequestBody @NonNull AddOrgDonationInfoRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgDonationInfo(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_don_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/donationinfo/{orgId}") /* not tested */
    public ResponseEntity<generalOrganisationResponse> removeOrgDonationInfo(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgDonationInfo(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_don_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/estdate") /* tested - works */
    public  ResponseEntity<generalOrganisationResponse> addOrgEstDate(@RequestBody @NonNull AddOrgEstDateRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgEstDate(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_est_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/estdate/{orgId}") /*tested - works */
    public ResponseEntity<generalOrganisationResponse> removeOrgEstDate(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgEstDate(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_est_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PutMapping("/delete/validity/confirm/{orgId}/{adminId}/{type}/{confirm}") /*tested - works */
    public ResponseEntity<generalOrganisationResponse> confirmValidity(@PathVariable("orgId") @NonNull Long orgId,
                                                                       @PathVariable("adminId") @NonNull Long adminId,
                                                                       @PathVariable("type") @NonNull String type,
                                                                       @PathVariable("confirm") @NonNull Boolean confirm)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.confirmValidity(orgId,adminId,type,confirm);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_est_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @PostMapping("/add/image") /* all good - correctness not tested yet */
    public ResponseEntity<generalOrganisationResponse> addOrgImage(@RequestBody @NonNull AddOrgImageRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrgImage(body);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_est_500_err","failed: " + e), HttpStatus.OK);
        }
    }


    @DeleteMapping("/delete/images/{orgId}")
    public ResponseEntity<generalOrganisationResponse> removeOrgImage(@PathVariable("orgId") @NonNull Long orgId)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.removeOrgImage(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("rem_img_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/images/count/{orgId}") /* tested - all good */
    public ResponseEntity<numberOfImagesResponse> numberOfImages(@PathVariable("orgId") @NonNull Long orgId)
    {
        numberOfImagesResponse response;
        try
        {
            response = service.numberOfImages(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new numberOfImagesResponse("num_img_500_err","failed: " + e, null), HttpStatus.OK);
        }
    }

    @GetMapping("/points/{orgId}") /* all good - correctness not tested yet */
    public ResponseEntity<organisationPointsResponse> selectOrganisationPoints(@PathVariable("orgId") @NonNull long orgId)
    {
        organisationPointsResponse response;
        try
        {
            response = service.selectOrganisationPoints(orgId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new organisationPointsResponse("num_img_500_err","failed: " + e, null), HttpStatus.OK);
        }
    }

    @PostMapping("/add/sector")
    ResponseEntity<generalOrganisationResponse> addSector(@RequestBody  @NonNull AddSectorRequest request)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addSector(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new generalOrganisationResponse("add_sec_500_err","failed: " + e), HttpStatus.OK);
        }
    }

    @GetMapping("/get/sectors")
    ResponseEntity<getSectorsResponse> getSectors()
    {
        getSectorsResponse response;
        try
        {
            response = service.getSectors();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new getSectorsResponse("get_sec_500_err","failed: " + e, null), HttpStatus.OK);
        }
    }
}
