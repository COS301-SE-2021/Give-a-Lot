package com.GiveaLot.givealot.Organisation.controller;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.response.generalOrganisationResponse;
import com.GiveaLot.givealot.Organisation.response.getOrganisationsResponse;
import com.GiveaLot.givealot.Organisation.response.selectOrganisationResponse;
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
     @GetMapping("/sel/organisation/{orgId}") /*tested all good*/
    public ResponseEntity<selectOrganisationResponse> selectOrganisation(@PathVariable("orgId") @NonNull Long orgId)
    {
        selectOrganisationResponse response;
        try
        {
            response = service.selectOrganisation(orgId);
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

    @PostMapping("/add/org") /*tested all good*/
    public ResponseEntity<generalOrganisationResponse> addOrganisation(@RequestBody @NonNull AddOrganisationRequest body)
    {
        generalOrganisationResponse response;
        try
        {
            response = service.addOrganisation(new Organisations(body.getOrgName(),
                    body.getSlogan(),body.getOrgDescription(),body.getOrgSector(),
                    body.getOrgEmail(),null,body.getStatus(),body.getContactPerson(),
                    body.getContactNumber(), "givealot/organisations/", body.getPassword()));
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

    /* tested - works *//*
    @GetMapping("/info/{orgId}")
    public responseJSON selectOrganisationInfo(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            OrganisationInfo res = service.selectOrganisationInfo(orgId);
            if(res != null)
            {
                response.setCode("org_sel_ok_200");
                response.setMessage("success");
                response.setObject(res);
            }
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful " + e);
        }
        return response;
    }

    *//* tested - works *//*
    @PostMapping("/add/website")
    public responseJSON addOrgWebsite(@RequestBody @NonNull AddOrgWebsiteRequest body)
    {
        response.setObject(null);
        try
        {
            if(service.addOrgWebsite(body))
            {
                response.setCode("add_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("add_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    *//* tested - works *//*
    @DeleteMapping("/delete/website/{orgId}")
    public responseJSON removeOrgWebsite(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            if(service.removeOrgWebsite(orgId))
            {
                response.setCode("rem_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("rem_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    *//* tested - works *//*
    @PutMapping("/add/address")
    public responseJSON addOrgAddress(@RequestBody @NonNull AddOrgAddressRequest body)
    {
        response.setObject(null);
        try
        {
            if(service.addOrgAddress(body))
            {
                response.setCode("we_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("add_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    *//* tested - works *//*
    @DeleteMapping("/delete/address/{orgId}")
    public responseJSON removeOrgAddress(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            if(service.removeOrgAddress(orgId))
            {
                response.setCode("rem_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("rem_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
        }
        return response;
    }

    *//* tested - works *//*
    @PostMapping("/add/taxref")
    public responseJSON addOrgTaxRef(@RequestBody AddOrgTaxRefRequest body)
    {
        response.setObject(null);
        try
        {
            if(service.addOrgTaxRef(body))
            {
                response.setCode("org_add_ok_200");
                response.setMessage("success");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful " + e);
            return response;
        }
    }

    *//* tested - works *//*
    @DeleteMapping("/delete/taxref/{orgId}")
    public responseJSON removeOrgTaxRef(@PathVariable("orgId")@NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgTaxRef(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful " + e);
        }
        return response;
    }

    *//* tested - works *//*


    *//* tested - works *//*


    *//* tested - works *//*


    *//* tested - works *//*
    @PostMapping("/add/socials")
    public responseJSON addOrgSocials(@RequestBody  @NonNull AddSocialsRequest body)
    {
        response.setObject(null);
        try
        {
            boolean res = service.addOrgSocials(body);
            if(res)
            {
                response.setCode("org_add_ok_222");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful " + e);
        }
        return response;
    }

    *//* tested - works *//*
    @DeleteMapping("/delete/socials/{orgId}/{type}")
    public responseJSON removeOrgSocials(@PathVariable("orgId") @NonNull long orgId,@PathVariable("type") @NonNull String type)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgSocials(orgId,type);
            if(res)
            {
                response.setCode("org_rm_ok_200");
                response.setMessage("success");
            }
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful " + e);
        }
        return response;
    }

    @GetMapping("/points/{orgId}")
    public responseJSON selectOrganisationPoints(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            OrganisationPoints res = service.selectOrganisationPoints(orgId);
            if(res != null)
            {
                response.setCode("org_sel_ok_200");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_sel_bad_200");
                response.setMessage("unsuccessful");
            }
            response.setObject(res);
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful " + e.toString());
        }
        return response;
    }

    @DeleteMapping("/delete/images/{orgId}")
    public responseJSON removeOrgImage(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgImage(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_206");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_206");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/ngo/{orgId}")
    public responseJSON removeOrgNGO(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        System.out.println(orgId);
        try
        {
            boolean res = service.removeOrgNGO(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_208");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_208");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/estdate/{orgId}")
    public responseJSON removeOrgEstDate(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgEstDate(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_209");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_209");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/donationinfo/{orgId}")
    public responseJSON removeOrgDonationInfo(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        System.out.println(orgId);
        try
        {
            boolean res = service.removeOrgDonationInfo(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_210");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_210");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/audit/{orgId}")
    public responseJSON removeOrgAuditDoc(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgAuditDoc(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_211");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_211");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/auditor/{orgId}")
    public responseJSON removeOrgAuditor(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgAuditor(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_212");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_212");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @DeleteMapping("/delete/committee/{orgId}")
    public responseJSON removeOrgCommittee(@PathVariable("orgId") @NonNull long orgId)
    {
        response.setObject(null);
        try
        {
            boolean res = service.removeOrgCommittee(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_213");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_213");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_rm_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/estdate")
    public responseJSON addOrgEstDate(@RequestBody @NonNull AddOrgEstDateRequest body)
    {
        response.setObject(null);
        //System.out.println(body.getDate().toString());
        try
        {
            boolean res = service.addOrgEstDate(body);
            if(res)
            {
                response.setCode("org_add_ok_216");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_216");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/image")
    public responseJSON addOrgImage(@RequestBody @NonNull AddOrgImageRequest body)
    {
        response.setObject(null);
        try
        {
            boolean res = service.addOrgImage(body);
            if(res)
            {
                response.setCode("org_add_ok_217");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_217");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/audit")
    public responseJSON addOrgAuditDoc(AddOrgAuditInfoRequest body)
    {
        response.setObject(null);
        try
        {
            boolean res = service.addOrgAuditDoc(body);
            if(res)
            {
                response.setCode("org_add_ok_217");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_217");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/auditor")
    public responseJSON addOrgAuditor(@RequestBody @NonNull AddOrgAuditorRequest body)
    {
        response.setObject(null);
        System.out.println(body.getAuditor() + " " + body.getOrgId());
        try
        {
            boolean res = service.addOrgAuditor(body);
            if(res)
            {
                response.setCode("org_add_ok_219");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_219");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/committee")
    public responseJSON addOrgCommittee(@RequestBody @NonNull AddOrgCommitteeRequest body)
    {
        response.setObject(null);
        System.out.println(body.getCommittee() + " " + body.getOrgId());
        try
        {
            boolean res = service.addOrgCommittee(body);
            if(res)
            {
                response.setCode("org_add_ok_220");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_220");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/donation/info")
    public responseJSON addOrgDonationInfo(@RequestBody @NonNull AddOrgDonationInfoRequest body)
    {
        response.setObject(null);
        System.out.println(body.getOrgInfo() + " " + body.getOrgId());
        try
        {
            boolean res = service.addOrgDonationInfo(body);
            if(res)
            {
                response.setCode("org_add_ok_221");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_221");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @PostMapping("/add/ngo")
    public responseJSON addOrgNGO(@RequestBody AddOrgNGORequest body)
    {
        response.setObject(null);
        try
        {
            boolean res = service.addOrgNGO(body);
            if(res)
            {
                response.setCode("org_add_ok_223");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_223");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }*/
}
