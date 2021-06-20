package com.GiveaLot.givealot.Organisation;
import com.GiveaLot.givealot.Organisation.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Organisation.rri.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

public interface OrganisationService {
    /**
     * This use case returns a response indicating that the organisation has been suspended
     * @param request addOrganisationRequest to use case
     * @param request reactivateOrganisationRequest to use case
     * @param request investigateOrganisationRequest to use case
     * @param request suspendOrganisationRequest to use case
     * @return Return the status of the organisation
     */

    addOrganisationResponse addOrganisation(addOrganisationRequest request)throws InvalidRequestException;
    reactivateOrganisationResponse reactivateOrganisation(reactivateOrganisationRequest request)throws InvalidRequestException;
    investigateOrganisationResponse investigateOrganisation(investigateOrganisationRequest request)throws InvalidRequestException;
    suspendOrganisationResponse suspendOrganisation(suspendOrganisationRequest request)throws InvalidRequestException;

    void setupServerProperties();
    MimeMessage draftEmail() throws AddressException, MessagingException, IOException;
    void sendEmail() throws MessagingException;
}
