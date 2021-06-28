package com.GiveaLot.givealot.OrganisationUnitTest;



import com.GiveaLot.givealot.Organisation.OrganisationHelper;
import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.dataclass.Status;
import com.GiveaLot.givealot.Organisation.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationResponse;
//import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class OrganisationUnitTest {

    @InjectMocks

    addOrganisationRequest request1;
    addOrganisationRequest request2;
    addOrganisationRequest request3;
    addOrganisationRequest request4;
    addOrganisationRequest request5;

    addOrganisationResponse response1;

    OrganisationServiceImpl organisationServiceImpl = new OrganisationServiceImpl();
    OrganisationHelper organisationHelper;

    Organisation org1;
    Organisation org2;
    Organisation org3;
    Organisation org4;

    Organisation orgActive;
    Organisation orgInvestigated;
    Organisation orgSuspended;


    String organisation;

    @BeforeEach
    void setUp() throws Exception {

        organisationHelper = new OrganisationHelper();


        request1 = null;
        request4 = new addOrganisationRequest("","","","","","","");

        request5 = new addOrganisationRequest("The Organisation", "Some description", "Youth", "theorganisation","NewPassword","Mr. Org", "0823475690");




        request2= new addOrganisationRequest("The Organisation", "Some description", "Youth", "theorganisation@gmail.com","NewPassword","Mr. Org", "0823475690");

        //ORg is already in system
        request3= new addOrganisationRequest("The Organisation", "Some description", "Youth", "theorganisation12@gmail.com","NewPassword","Mr. Org", "0823475690");

        org1= new Organisation();
        org2= new Organisation(request2.getOrgName(),request2.getOrgDescription(),request2.getOrgSector(),request2.getOrgEmail(),request2.getPassword(),request2.getContactPerson(),request2.getContactNumber());
        org3= new Organisation(request2.getOrgName(),request2.getOrgDescription(),request2.getOrgSector(),request2.getOrgEmail(),request2.getPassword(),request2.getContactPerson(),request2.getContactNumber());
        //org4 = new Organisation("","","","","","","");

        orgActive = new Organisation(request2.getOrgEmail(),Status.Active);
        orgInvestigated = new Organisation(request2.getOrgEmail(), Status.UnderInvestigation);
        orgSuspended = new Organisation(request2.getOrgEmail(), Status.Suspended);


    }

    @Test
    @Description("Assumes that the addOrgRequest Request is null")
    void TEST_SHOULD_RETURN_INVALID_REQUEST_EXCEPTION(){
        Throwable throwError = assertThrows(InvalidRequestException.class, () -> organisationServiceImpl.addOrganisation(request1));
        assertEquals("Exception: Organisation could not be added because the request object is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Organisation object is default")
    void TEST_ORG_IS_DEFAULT(){
        Throwable throwError = assertThrows(OrgException.class, () -> organisationHelper.addOrg(org1));
        assertEquals("Exception: Organisation data is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the Organisation is already registered in the system")
    void TEST_ORG_IS_REGISTERED(){
        Throwable throwError = assertThrows(OrgException.class, () -> organisationServiceImpl.addOrganisation(request2));
        assertEquals("Exception: Organisation is already registered", throwError.getMessage());
    }

    @Test
    @Description("Assumes the Org is already Active when trying to reactivate")
    void TEST_IS_ACTIVE(){
        Throwable throwError = assertThrows(OrgException.class, () -> organisationHelper.reactivateOrg(orgActive));
        assertEquals("Exception: Organisation is already active", throwError.getMessage());
    }
    @Test
    @Description("Assumes the Org is already UnderInvestigation when trying to Investigate")
    void TEST_IS_UNDER_INVESTIGATION(){
        Throwable throwError = assertThrows(OrgException.class, () -> organisationHelper.investigateOrg(orgInvestigated));
        assertEquals("Exception: Organisation is already under investigation", throwError.getMessage());
    }
    @Test
    @Description("Assumes the Org is already Suspended when trying to suspend")
    void TEST_IS_SUSPENDED(){
        Throwable throwError = assertThrows(OrgException.class, () -> organisationHelper.suspendOrg(orgSuspended));
        assertEquals("Exception: Organisation is already suspended", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the data given are empty strings")
    void TEST_EMPTY_STRINGS() {
        Throwable throwError = assertThrows(OrgException.class, () -> organisationServiceImpl.addOrganisation(request4));
        assertEquals("Exception : Empty fields not allowed", throwError.getMessage());
    }
    @Test
    @Description("Assumes that the data given contains an incorrect email address")
    void TEST_WRONG_EMAIL() {
        Throwable throwError = assertThrows(OrgException.class, () -> organisationServiceImpl.addOrganisation(request5));
        assertEquals("Exception : invalid email", throwError.getMessage());
    }

}