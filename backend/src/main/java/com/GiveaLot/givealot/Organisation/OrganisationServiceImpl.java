package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.dataclass.Status;
import com.GiveaLot.givealot.Organisation.rri.*;
import com.GiveaLot.givealot.Organisation.exceptions.*;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.*;


public class OrganisationServiceImpl {
    enum Status{
        Active,
        UnderInvestigation,
        Suspended
    }
    Status status;

    OrganisationHelper help = new OrganisationHelper();

    addOrganisationResponse addOrganisation(addOrganisationRequest request) throws InvalidRequestException, NoSuchAlgorithmException, SQLException {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be added because the request object is null");
        }

        Organisation org = new Organisation(request.getOrgName(),request.getOrgDescription(),request.getOrgSector(),request.getOrgEmail(),request.getPassword(),request.getContactPerson(),request.getContactNumber());

        help.addOrg(org);


        return null;
    }

    reactivateOrganisationResponse reactivateOrganisation(reactivateOrganisationRequest request) throws OrgException, NoSuchAlgorithmException, SQLException {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        try {
            Organisation org = new Organisation(request.getOrgEmail(), request.getStatus());

            if (!(org.getStatus() == com.GiveaLot.givealot.Organisation.dataclass.Status.Active)){
                help.reactivateOrg(org);
            }
            else{
                throw new OrgException("Exception: Organisation is already Active");
            }
        }
        catch (Exception e){
            throw new OrgException("Exception: Organisation could not be reactivated");
        }


        return null;
    }

    investigateOrganisationResponse investigateOrganisation(investigateOrganisationRequest request) throws OrgException {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        try {
            Organisation org = new Organisation(request.getOrgEmail(), request.getStatus());

            if (!(org.getStatus() == com.GiveaLot.givealot.Organisation.dataclass.Status.UnderInvestigation)){
                help.investigateOrg(org);
            }
            else{
                throw new OrgException("Exception: Organisation is already UnderInvestigation");
            }
        }
        catch (Exception e){
            throw new OrgException("Exception: Organisation could not be set to UnderInvestagtion");
        }


        return null;
    }

    suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest request) throws OrgException
    {
        if (request == null){
            throw new InvalidRequestException("Exception: Organisation could not be updated because the request object is null");
        }
        try {
            Organisation org = new Organisation(request.getOrgEmail(), request.getStatus());

            if (!(org.getStatus() == com.GiveaLot.givealot.Organisation.dataclass.Status.Suspended)){
                help.suspendOrg(org);
            }
            else{
                throw new OrgException("Exception: Organisation is already Suspended");
            }
        }
        catch (Exception e){
            throw new OrgException("Exception: Organisation could not be suspended");
        }


        return null;
    }


}
