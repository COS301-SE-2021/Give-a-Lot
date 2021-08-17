package com.GiveaLot.givealot.Organisation.service.response;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.requests.*;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganisationServiceMockup {
    @Autowired
    private final OrganisationService organisationService;

    public OrganisationServiceMockup(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    Organisations selectOrganisation(long orgId) throws Exception{
        return organisationService.selectOrganisation(orgId);
    }

}
