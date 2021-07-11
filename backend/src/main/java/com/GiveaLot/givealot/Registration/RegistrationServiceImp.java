package com.GiveaLot.givealot.Registration;


import com.GiveaLot.givealot.Registration.Exceptions.*;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;
import com.GiveaLot.givealot.Registration.rri.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RegistrationServiceImp
{
  public RegistrationServiceImp()
  {

  }

    public organisationGetInfoResponse organisationRegistrationInfoStep(organisationGetInfoRequest request) throws PasswordException, OrganisationException
    {
      SignupValidation validation = new SignupValidation();
      if(!validation.validateMatchingPasswords(request.getPassword(), request.getPasswordConfirmation()))
      {
        /*
         * check if passwords are similar or not
         * */
        throw new PasswordException("passwords do not match");
      }
      else if(!validation.validatePassword(request.getPassword()))
      {
        /*
        * checks the strength of the password
        * */
        throw new PasswordException("weak password, length must be 8 characters long and it must contain aA-zZ, a number and a character");
      }
      else if(!validation.validateOrgNames(request.getNameOfOrganisation()))
      {
        /*
         * checks if the length of the passwords meets the database constraints
         * */
        throw new OrganisationException("organisation name too long");
      }

      tempOrganisation tempOrganisation = new tempOrganisation();

      /*
      * by default, all other parameters are set to null
      * */

      tempOrganisation.setStatus(200);
      tempOrganisation.setMessage("ok");
      tempOrganisation.setOrgName(request.getNameOfOrganisation());
      tempOrganisation.setPassword(request.getPassword());

      organisationGetInfoResponse response = new organisationGetInfoResponse(tempOrganisation);
      return response;
    }

  public organisationGetContactDetailsResponse organisationRegistrationContactInfoStep(organisationGetContactDetailsRequest request) throws SQLException, EmailException, NumberException, NameSurnameException {
    SignupValidation validation = new SignupValidation();

      if (!validation.validateEmail(request.getEmail())) {
        throw new EmailException("invalid imail provided");
      } /*else if (!validation.validateEmailAvailable(request.getEmail())) {
        throw new EmailException("email already exists");
      }*/ else if (!validation.validateContactNumber(request.getContactNumber())) {
        throw new NumberException("invalid number");
      } else if(!validation.validateContactPerson(request.getContactPerson())){
        throw new NameSurnameException("name invalid");
      }

    tempOrganisation tempOrganisation = new tempOrganisation();

    /*
     * by default, all other parameters are set to null
     * */

    tempOrganisation.setStatus(200);
    tempOrganisation.setMessage("ok");
    tempOrganisation.setContactNumber(request.getContactNumber());
    tempOrganisation.setContactPerson(request.getContactPerson());
    tempOrganisation.setOrgEmail(request.getEmail());

    organisationGetContactDetailsResponse response = new organisationGetContactDetailsResponse(tempOrganisation);
    return response;
  }

  public organisationGetAboutResponse organisationRegistrationAboutStep(organisationGetAboutRequest request) throws OrganisationException {
    SignupValidation validation = new SignupValidation();
    if(!validation.validateOrgDescription(request.getOrganisationDescription()))
    {
      throw new OrganisationException("short description too long");
    }
    else if(!validation.validateOrgSlogan(request.getOrganisationSlogan()))
    {
      throw new OrganisationException("slogan description too long");
    }

    tempOrganisation tempOrganisation = new tempOrganisation();

    /*
     * by default, all other parameters are set to null
     * */

    tempOrganisation.setStatus(200);
    tempOrganisation.setMessage("ok");
    tempOrganisation.setOrgSector(request.getOrganisationSector());
    tempOrganisation.setOrgDescription(request.getOrganisationDescription());
    tempOrganisation.setOrgSlogan(request.getOrganisationSlogan());

    organisationGetAboutResponse response = new organisationGetAboutResponse(tempOrganisation);
    return response;

  }
}
