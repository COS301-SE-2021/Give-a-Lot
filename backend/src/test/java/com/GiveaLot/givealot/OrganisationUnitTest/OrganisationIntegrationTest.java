package com.GiveaLot.givealot.OrganisationUnitTest;

import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.investigateOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.reactivateOrganisationRequest;
import com.GiveaLot.givealot.Organisation.rri.suspendOrganisationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrganisationIntegrationTest {

    @Test
    @Description("Adds an organisation to the Givealot system")
    void TEST_ADD() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        addOrganisationRequest request = new addOrganisationRequest("This Organisation", "Some Description", "Disease", "someemail@gmail.com", "password", "Mr. Somebody", "0823322000");

        service.addOrganisation(request);
    }
    @Test
    @Description("Investigates an organisation on the Givealot system")
    void TEST_ORG_INVESTIGATE() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        investigateOrganisationRequest request = new investigateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.investigateOrganisation(request);
    }
    @Test
    @Description("Suspends an organisation on the Givealot system")
    void TEST_ORG_SUSPEND() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        suspendOrganisationRequest request = new suspendOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.suspendOrganisation(request);
    }
    @Test
    @Description("Reactivates an organisation on the Givealot system")
    void TEST_ORG_REACTIVATE() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        reactivateOrganisationRequest request = new reactivateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.reactivateOrganisation(request);
    }

    @Test
    @Description("Runs the whole organisation micro service test")
    void TEST_INTEGRATION_ORGANISATION() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        //Initialization

        addOrganisationRequest request = new addOrganisationRequest("Integration Org", "Some Description", "Disease", "integration@gmail.com", "password", "Mr. Integration", "0823320000");

        investigateOrganisationRequest requestInv = new investigateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        suspendOrganisationRequest requestSus = new suspendOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        reactivateOrganisationRequest requestReact = new reactivateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");


        //StatusChanges

        service.addOrganisation(request);

        service.investigateOrganisation(requestInv);

        service.suspendOrganisation(requestSus);

        service.reactivateOrganisation(requestReact);


    }
}
