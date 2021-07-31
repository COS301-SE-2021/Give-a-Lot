package com.GiveaLot.givealot.Organisation.controller;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.rri.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;
import org.springframework.web.bind.annotation.*;

import java.io.File;
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
            response.setMessage(e.getMessage());
            return response;
        }
    }

    @GetMapping("/points/{orgId}")
    public responseJSON selectOrganisationPoints(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            Object res = service.selectOrganisationPoints(orgId);
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
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }

    @GetMapping("/select/{orgId}")
    public responseJSON selectOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            Object res = service.selectOrganisation(orgId);
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
            return response;
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful");
            return response;
        }
    }


    @GetMapping("/info/{orgId}")
    public List<Object> selectOrganisationInfo(@PathVariable("orgId")  @NonNull String orgId)
    {
        OrganisationInfo res = service.selectOrganisationInfo(orgId);
        try
        {
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
        }
        catch (Exception e)
        {
            response.setCode("org_sel_bad_500");
            response.setMessage("unsuccessful");
        }

        assert res != null;
        return List.of(response,res);
    }

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
            response.setMessage("unsuccessful");
            return response;
        }
    }

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
            response.setMessage("unsuccessful");
            return response;
        }
    }

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
            response.setMessage("unsuccessful");
            return response;
        }
    }

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

    @DeleteMapping("/delete/taxref/{orgId}")
    public void removeOrgTaxRef(@PathVariable("orgId")@NonNull String orgId)
    {
        Object response = service.removeOrgTaxRef(orgId);
    }

    @DeleteMapping("/delete/ngo/{orgId}")
    public void removeOrgNGO(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgNGO(orgId);
    }

    @DeleteMapping("/delete/estdate/{orgId}")
    public void removeOrgEstDate(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgEstDate(orgId);
    }

    @DeleteMapping("/delete/donationinfo/{orgId}")
    public void removeOrgDonationInfo(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgDonationInfo(orgId);
    }

    @DeleteMapping("/delete/audit/{orgId}")
    public void removeOrgAuditDoc(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgAuditDoc(orgId);
    }

    @DeleteMapping("/delete/auditor/{orgId}")
    public void removeOrgAuditor(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgAuditor(orgId);
    }

    @DeleteMapping("/delete/committee/{orgId}")
    public void removeOrgCommittee(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgCommittee(orgId);
    }

    @DeleteMapping("/delete/socials/{orgId}")
    public void removeOrgSocials(@PathVariable("orgId") @NonNull String orgId,@PathVariable("type") @NonNull String type)
    {
        Object response = service.removeOrgSocials(orgId,type);
    }


    /*
    * backend
    * */
    public void organisationExists(Organisation organisation)
    {

    }

    public void addOrgEstDate(@PathVariable("orgId") String orgId,@PathVariable("date") Date date)
    {
        Object response = service.removeOrgEstDate(orgId);
    }



    public void addOrgImage(String orgId, File image)
    {

    }

    public void addOrgAuditDoc(String orgId, File audit)
    {

    }

    public void addOrgTaxRef(@PathVariable("orgId") String orgId, String reference)
    {

    }

    public void addOrgAuditor(@PathVariable("orgId") String orgId, String auditor)
    {

    }

    public void addOrgCommittee(@PathVariable("orgId") String orgId, @PathVariable("committee")  String committee)
    {
        System.out.println(orgId);
    }

    @GetMapping()
    public void addOrgDonationInfo(@PathVariable("orgId") String orgId,@PathVariable("info") String info)
    {

    }

    @GetMapping("/{orgId}/{type}/{website}")
    public void addOrgSocials(@PathVariable("orgId")  String orgId,
                              @PathVariable("type")String type,
                              @PathVariable("website") String website)
    {
        System.out.println(orgId + "\n " + type + " \n " );
    }

    public void addOrgNGO(String orgId, String ngoNumber, Date ngoDate)
    {
        System.out.println(orgId);
        System.out.println(ngoNumber);
        System.out.println(ngoDate);
    }
}
