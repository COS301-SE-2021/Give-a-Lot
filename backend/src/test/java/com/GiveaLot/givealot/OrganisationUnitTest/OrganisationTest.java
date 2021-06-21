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

public class OrganisationTest {

    @Test
    void TEST_ADD() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        addOrganisationRequest request = new addOrganisationRequest("This Organisation", "Some Description", "Disease", "someemail@gmail.com", "password", "Mr. Somebody", "0823322000");

        service.addOrganisation(request);
    }
    @Test
    void TEST_ORG_INVESTIGATE() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        investigateOrganisationRequest request = new investigateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.investigateOrganisation(request);
    }
    @Test
    void TEST_ORG_SUSPEND() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        suspendOrganisationRequest request = new suspendOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.suspendOrganisation(request);
    }
    @Test
    void TEST_ORG_REACTIVATE() throws OrgException, SQLException, MessagingException, NoSuchAlgorithmException, IOException {
        OrganisationServiceImpl service = new OrganisationServiceImpl();

        reactivateOrganisationRequest request = new reactivateOrganisationRequest("8378a47a5f4a901d23222cef70df3203","");

        service.reactivateOrganisation(request);
    }
}
