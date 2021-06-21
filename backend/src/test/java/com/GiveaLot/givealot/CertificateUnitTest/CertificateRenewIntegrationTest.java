package com.GiveaLot.givealot.CertificateUnitTest;

import com.GiveaLot.givealot.Certificate.CertificateHelper;
import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.investigateOrganisationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class CertificateRenewIntegrationTest {

    @Test
    @Description("Checks all organisation certificates that they have not expired yet")
    void TEST_CHECK_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        helper.checkRenewal();
    }
    @Test
    @Description("Renews from the organisation side")
    void TEST_ORG_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        helper.orgRenew("4941d81fe9e50abfd6e18595b78a21cf");
    }
    @Test
    @Description("Renews and updates the expiry date from the admin side")
    void TEST_ADMIN_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        helper.adminRenew("4941d81fe9e50abfd6e18595b78a21cf");
    }

    @Test
    @Description("Runs the whole Certificate Renewal micro service")
    void TEST_INTEGRATION_CERTIFICATE() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        helper.checkRenewal();
        helper.orgRenew("2eaa331c8b7342c4ca71ae9b67ceed02");
        helper.adminRenew("2eaa331c8b7342c4ca71ae9b67ceed02");
    }

}
