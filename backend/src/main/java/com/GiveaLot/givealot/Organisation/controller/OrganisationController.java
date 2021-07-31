package com.GiveaLot.givealot.Organisation.controller;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Organisation.service.response.responseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;
import java.util.List;

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
                response.setMessage("added");
            }
            else
            {
                response.setCode("org_add_bad_500");
                response.setMessage("organisation not added"); /* why was it not added??? */
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
    public void selectOrganisationPoints(@PathVariable("orgId") @NonNull String orgId)
    {
        try
        {
            Object res = service.selectOrganisationPoints(orgId);
            if(res != null)
            {
                response.setCode("org_sel_ok_200");
                //return List.of();
            }
            else
            {

            }
        }
        catch (Exception e)
        {

        }


    }

    @GetMapping("/select/{orgId}")
    public void selectOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.selectOrganisation(orgId);
    }


    @GetMapping("/info/{orgId}")
    public void selectOrganisationInfo(@PathVariable("orgId")  @NonNull String orgId)
    {
        Object response = service.selectOrganisationInfo(orgId);
    }

    @PutMapping("/activate/{orgId}")
    public void reactivateOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.reactivateOrganisation(orgId);
    }

    @PutMapping("/investigate/{orgId}")
    public void investigateOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.investigateOrganisation(orgId);
    }

    @PutMapping("/suspend/{orgId}")
    public void suspendOrganisation(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.suspendOrganisation(orgId);
    }

    @PutMapping("/website/{orgId}/{website}")
    public void addOrgWebsite(@PathVariable("orgId") @NonNull String orgId,
                              @PathVariable("website") @NonNull String website)
    {
        Object response = service.addOrgWebsite(orgId,website);
    }

    @DeleteMapping("/delete/address/{orgId}")
    public void removeOrgAddress(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgAddress(orgId);
    }

    @DeleteMapping("/delete/images/{orgId}")
    public void removeOrgImage(@PathVariable("orgId") @NonNull String orgId)
    {
        Object response = service.removeOrgImage(orgId);
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
