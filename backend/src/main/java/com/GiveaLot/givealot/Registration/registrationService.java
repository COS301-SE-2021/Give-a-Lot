package com.GiveaLot.givealot.Registration;

import com.GiveaLot.givealot.Registration.rri.*;

public interface registrationService
{
    organisationConfirmRegistrationResponse confirmOrganisationRegistration(organisationConfirmRegistrationRequest request);
    userRegistrationResponse registerGeneralUser(userRegistrationRequest request);
    organisationGetAboutResponse storeOrganisationGetAboutInfo(organisationGetAboutRequest request);
    organisationGetContactDetailsResponse storeOrganisationContactDetails(organisationGetContactDetailsRequest request);
    organisationGetImageResponse storeOrganisationImage(organisationGetImageUrlRequest request);
    organisationGetInfoResponse storeOrganisationInfo(organisationGetInfoRequest request);
}
