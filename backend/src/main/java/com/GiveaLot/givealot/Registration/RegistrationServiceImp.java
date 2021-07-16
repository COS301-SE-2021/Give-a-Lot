package com.GiveaLot.givealot.Registration;


import com.GiveaLot.givealot.Organisation.json.OrganisationResponseJSON;
import com.GiveaLot.givealot.Organisation.controller.OrganisationController;
import com.GiveaLot.givealot.Organisation.rri.addOrganisationRequest;
import com.GiveaLot.givealot.Registration.Exceptions.*;
import com.GiveaLot.givealot.Registration.json.organisationRegistrationResponseJSON;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;
import com.GiveaLot.givealot.Registration.json.userRegistrationResponseJSON;
import com.GiveaLot.givealot.Registration.rri.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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
      } else if (!validation.validateEmailAvailable(request.getEmail())) {
        throw new EmailException("email already exists");
      } else if (!validation.validateContactNumber(request.getContactNumber())) {
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

    public userRegistrationResponse registerBasicUser(userRegistrationRequest request) throws PasswordException, NameSurnameException, EmailException
    {
      SignupValidation validation = new SignupValidation();

      if(!validation.validateEmail(request.getEmail()))
      {
        throw new EmailException("invalid email provided");
      }
      else if(!validation.validateNames(request.getFirstName(), request.getLastName()))
      {
        throw new NameSurnameException("name or surname too short or too long");
      }
      else if(!validation.validatePassword(request.getPassword()))
      {
        throw new PasswordException("weak password, length must be 8 characters long and it must contain aA-zZ, a number and a character");
      }
      /*
      *  add code to register the user to the db
      * */

      userRegistrationResponseJSON jsonRes = new userRegistrationResponseJSON(200, "registered");
      userRegistrationResponse response = new userRegistrationResponse(jsonRes);
      return response;
    }

    public organisationConfirmRegistrationResponse confirmOrganisationRegistration(organisationConfirmRegistrationRequest request) throws Exception {
      SignupValidation validation = new SignupValidation();

      /*
      * Validate all the data in the temp Organisation object
      * */
      if(!validation.validatePassword(request.getTempOrganisation().getPassword()))
      {
        throw new PasswordException("weak password, length must be 8 characters long and it must contain aA-zZ, a number and a character");
      }
      else if(!validation.validateOrgNames(request.getTempOrganisation().getOrgName()))
      {
        throw new OrganisationException("organisation name too long");
      }
      else if (!validation.validateEmail(request.getTempOrganisation().getOrgEmail()))
      {
        throw new EmailException("invalid imail provided");
      }
      else if (!validation.validateEmailAvailable(request.getTempOrganisation().getOrgEmail())) {
        throw new EmailException("email already exists");
      }
      else if (!validation.validateContactNumber(request.getTempOrganisation().getContactNumber()))
      {
        throw new NumberException("invalid number");
      }
      else if(!validation.validateContactPerson(request.getTempOrganisation().getContactPerson()))
      {
        throw new NameSurnameException("name invalid");
      }
      else if(!validation.validateOrgDescription(request.getTempOrganisation().getOrgDescription()))
      {
        throw new OrganisationException("short description too long");
      }
      else if(!validation.validateOrgSlogan(request.getTempOrganisation().getOrgSlogan()))
      {
        throw new OrganisationException("slogan description too long");
      }

      /*
       *  register the user to the db
       * */

      addOrganisationRequest  new_org  = new addOrganisationRequest(request.getTempOrganisation().getOrgName(),
                                                                    request.getTempOrganisation().getOrgSlogan(),
                                                                    request.getTempOrganisation().getOrgDescription(),
                                                                    request.getTempOrganisation().getOrgSector(),
                                                                    request.getTempOrganisation().getOrgEmail(),
                                                                    request.getTempOrganisation().getPassword(),
                                                                    request.getTempOrganisation().getContactPerson(),
                                                                    request.getTempOrganisation().getContactNumber());
      try
      {
        OrganisationController organisationController = new OrganisationController();
        List<OrganisationResponseJSON> res = organisationController.add_organisation(new_org);

        if(res != null)
        {
          System.out.println("got response from controller");
          System.out.println(res.get(0).getCode() + "\n" + res.get(0).getStatus());
        }
        else
        {
          System.out.println("possible errors in the controller");
        }

        organisationRegistrationResponseJSON json = new organisationRegistrationResponseJSON(200, "registered successfully");
        organisationConfirmRegistrationResponse response = new organisationConfirmRegistrationResponse(json);
        return response;
      }
      catch (Exception e)
      {
        throw new Exception(e.getMessage());
      }
    }
}
