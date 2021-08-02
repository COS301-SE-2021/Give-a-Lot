package com.GiveaLot.givealot.Organisation.controller;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.rri.*;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static java.util.List.of;

@RequestMapping("v1/organisation")
@RestController
public class OrganisationController
{
    private OrganisationService service;
    private responseJSON response;

    @Autowired
    public OrganisationController(OrganisationService service, responseJSON response)
    {
        this.service = service;
        this.response = response;
    }

    /*
     * tested, works well
     */
    @PostMapping("/add/org")
    public responseJSON addOrganisation(@RequestBody @NonNull Organisation body)
    {
        try
        {
            if(service.addOrganisation(body))
            {
                response.setCode("org_add_ok_200");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_500");
                response.setMessage("unsuccessful");
                /* but why was the organisation not added??? */
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_add_err_501");
            response.setMessage("unsuccessful " + e.getMessage());
            return response;
        }
    }

    /*
    * tested, works well
    */
    @GetMapping("/points/{orgId}")
    public responseJSON selectOrganisationPoints(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /*
    * tested
    * */
    @GetMapping("/select/{orgId}")
    public responseJSON selectOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            Organisation res = service.selectOrganisation(orgId);
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


    /* tested - works */
    @GetMapping("/info/{orgId}")
    public responseJSON selectOrganisationInfo(@PathVariable("orgId")  @NonNull String orgId)
    {
        try
        {
            OrganisationInfo res = service.selectOrganisationInfo(orgId);
            if(res != null)
            {
                response.setCode("org_sel_ok_200");
                response.setMessage("success");
                response.setObject(res);
            }
            else
            {
                response.setCode("org_sel_bad_200");
                response.setMessage("unsuccessful");
                response.setObject(null);
            }
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful " + e.toString());
        }

        return response;
    }

    /* tested - works */
    @PutMapping("/activate/{orgId}")
    public responseJSON reactivateOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            boolean res = service.reactivateOrganisation(orgId);
            if(res)
            {
                response.setCode("org_act_ok_200");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_act_bad_200");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_act_bad_500");
            response.setMessage("unsuccessful " + e.toString());
            return response;
        }
    }

    /* tested - works */
    @PutMapping("/investigate/{orgId}")
    public responseJSON investigateOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            boolean res = service.investigateOrganisation(orgId);
            if(res)
            {
                response.setCode("org_inv_ok_203");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_inv_bad_203");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_inv_bad_500");
            response.setMessage("unsuccessful: " + e.toString());
            return response;
        }
    }

    /* tested - works */
    @PutMapping("/suspend/{orgId}")
    public responseJSON suspendOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            boolean res = service.suspendOrganisation(orgId);
            if(res)
            {
                response.setCode("org_sus_ok_204");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_sus_bad_204");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_sus_bad_500");
            response.setMessage("unsuccessful " + e.toString());
            return response;
        }
    }

    /* tested - works */
    @PutMapping("/add/website")
    public responseJSON addOrgWebsite(@RequestBody @NonNull AddOrgWebsiteRequest body)
    {
        try
        {
            if(service.addOrgWebsite(body))
            {
                response.setCode("add_ok_201");
                response.setMessage("success");
            }
            else
            {
                response.setCode("add_bad_201");
                response.setMessage("unsuccessful");
            }
            return response;
        }
        catch (Exception e)
        {
            response.setCode("add_bad_500");
            response.setMessage("unsuccessful " + e.getMessage());
            return response;
        }
    }


    /* tested - works - left comment for OrganisationDASTemp
       on the removeOrgAddress
    */
    @DeleteMapping("/delete/address/{orgId}")
    public responseJSON removeOrgAddress(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            boolean res = service.removeOrgAddress(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_205");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_205");
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

    /* tested - works */
    @DeleteMapping("/delete/images/{orgId}")
    public responseJSON removeOrgImage(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /* tested - works
    *  removeOrgTaxRef from OrganisationDASTemp always returns true
    *  even if an organisation id doesn't exist
    * */
    @DeleteMapping("/delete/taxref/{orgId}")
    public responseJSON removeOrgTaxRef(@PathVariable("orgId")@NonNull String orgId)
    {
        try
        {
            boolean res = service.removeOrgTaxRef(orgId);
            if(res)
            {
                response.setCode("org_rm_ok_207");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_207");
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

    /* tested - works
     *  removeOrgNGO from OrganisationDASTemp always returns true
     *  even if an organisation id doesn't exist
     * */
    @DeleteMapping("/delete/ngo/{orgId}")
    public responseJSON removeOrgNGO(@PathVariable("orgId") @NonNull String orgId)
    {
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


    /* tested - works
     *  removeOrgEstDate from OrganisationDASTemp always returns true
     *  even if an organisation id doesn't exist
     * */
    @DeleteMapping("/delete/estdate/{orgId}")
    public responseJSON removeOrgEstDate(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /* tested - works */
    @DeleteMapping("/delete/donationinfo/{orgId}")
    public responseJSON removeOrgDonationInfo(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /* tested - works
     *  removeOrgAuditDoc from OrganisationDASTemp always returns true
     *  even if an organisation id doesn't exist
     * */
    @DeleteMapping("/delete/audit/{orgId}")
    public responseJSON removeOrgAuditDoc(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /* tested - works
     *  removeOrgAuditor from OrganisationDASTemp always returns true
     *  even if an organisation id doesn't exist
     * */
    @DeleteMapping("/delete/auditor/{orgId}")
    public responseJSON removeOrgAuditor(@PathVariable("orgId") @NonNull String orgId)
    {
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

    /* tested - works
     *  removeOrgCommittee from OrganisationDASTemp always returns true
     *  even if an organisation id doesn't exist
     * */
    @DeleteMapping("/delete/committee/{orgId}")
    public responseJSON removeOrgCommittee(@PathVariable("orgId") @NonNull String orgId)
    {
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

    @DeleteMapping("/delete/socials/{orgId}")
    public responseJSON removeOrgSocials(@PathVariable("orgId") @NonNull String orgId,@PathVariable("type") @NonNull String type)
    {
        try
        {
            boolean res = service.removeOrgSocials(orgId,type);
            if(res)
            {
                response.setCode("org_rm_ok_215");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_rm_bad_215");
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

    @PostMapping("/add/taxref")
    public responseJSON addOrgTaxRef(@RequestBody AddOrgTaxRefRequest body)
    {
        try
        {
            boolean res = service.addOrgTaxRef(body);
            if(res)
            {
                response.setCode("org_add_ok_218");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_218");
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

    @GetMapping("/add/socials")
    public responseJSON addOrgSocials(@RequestBody AddSocialsRequest body)
    {
        try
        {
            boolean res = service.addOrgSocials(body);
            if(res)
            {
                response.setCode("org_add_ok_222");
                response.setMessage("success");
            }
            else
            {
                response.setCode("org_add_bad_222");
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

    @GetMapping("/add/ngo")
    public responseJSON addOrgNGO(@RequestBody AddOrgNGORequest body)
    {
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
    }
}
