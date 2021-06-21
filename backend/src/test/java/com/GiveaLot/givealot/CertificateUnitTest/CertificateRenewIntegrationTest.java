package com.GiveaLot.givealot.CertificateUnitTest;

import com.GiveaLot.givealot.Certificate.CertificateHelper;
import com.GiveaLot.givealot.Organisation.OrganisationServiceImpl;
import com.GiveaLot.givealot.Organisation.exceptions.OrgException;
import com.GiveaLot.givealot.Organisation.rri.investigateOrganisationRequest;
import org.junit.jupiter.api.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class CertificateRenewIntegrationTest {

    @Test
    void TEST_CHECK_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        helper.checkRenewal();
    }
    @Test
    void TEST_ORG_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        //helper.orgRenew();
    }
    @Test
    void TEST_ADMIN_RENEWAL() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

       // helper.adminRenew();
    }

    @Test
    void TEST_INTEGRATION_CERTIFICATE() throws SQLException {
        CertificateHelper helper = new CertificateHelper();

        //helper.checkRenewal();
        //helper.orgRenew();
        //helper.adminRenew();
    }

}
