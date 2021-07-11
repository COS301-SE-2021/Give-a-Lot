package com.GiveaLot.givealot.Registration;


import com.GiveaLot.givealot.Registration.Exceptions.OrganisationException;
import com.GiveaLot.givealot.Registration.Exceptions.PasswordException;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;
import com.GiveaLot.givealot.Registration.rri.organisationGetInfoRequest;
import com.GiveaLot.givealot.Registration.rri.organisationGetInfoResponse;
import org.springframework.stereotype.Service;

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
}
