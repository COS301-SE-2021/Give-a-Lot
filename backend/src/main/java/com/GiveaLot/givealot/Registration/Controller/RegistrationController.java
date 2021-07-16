package com.GiveaLot.givealot.Registration.Controller;
import com.GiveaLot.givealot.Registration.RegistrationServiceImp;
import com.GiveaLot.givealot.Registration.json.*;
import com.GiveaLot.givealot.Registration.rri.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("registration/type")
public class RegistrationController {

    @Autowired
    private RegistrationServiceImp service;

    public RegistrationController()
    {

    }

    @CrossOrigin
    @PostMapping("/organisation/info")
    public tempOrganisation organisationRegistrationInfoStep(@RequestBody infoJSON postBody)
    {
        try
        {
            /*
            * read post body content
            */

            String organisationName = postBody.getOrganisationName();
            String password = postBody.getOrganisationPassword();
            String confirmPassword = postBody.getConfirmPassword();

            /*
            * set up response
            */
            System.out.println("step 1\n" + organisationName + "\n" + password + "\n" + confirmPassword);


            organisationGetInfoResponse response =  service.organisationRegistrationInfoStep(new organisationGetInfoRequest(organisationName,password,confirmPassword));

            return response.getTempOrganisation();
        }
        catch(Exception e)
        {
            System.out.println("error occurred: " + e.getMessage());
            tempOrganisation tempOrganisation = new tempOrganisation();
            tempOrganisation.setStatus(200);
            tempOrganisation.setMessage(e.getMessage());
            return tempOrganisation;
        }
    }

    @CrossOrigin
    @PostMapping("/organisation/contact")
    public tempOrganisation organisationRegistrationInfoStep(@RequestBody contactDetailsJSON postBody)
    {
        try
        {
            String organisationName = postBody.getPrevious_step_organisationName();
            String password = postBody.getPrevious_step_organisationPassword();
            String contactPerson = postBody.getContactPerson();
            String contactNumber = postBody.getContactNumber();
            String email = postBody.getEmail();

            organisationGetContactDetailsResponse response = service.organisationRegistrationContactInfoStep(new organisationGetContactDetailsRequest(contactPerson,contactNumber,email));

            tempOrganisation tempOrganisation = response.getTempOrganisation();
            tempOrganisation.setOrgName(organisationName);
            tempOrganisation.setPassword(password);
            return tempOrganisation;
        }
        catch (Exception e)
        {
            System.out.println("error occurred: " + e.getMessage());
            tempOrganisation tempOrganisation = new tempOrganisation();
            tempOrganisation.setStatus(200);
            tempOrganisation.setMessage(e.getMessage());
            return tempOrganisation;
        }
    }

    @CrossOrigin
    @PostMapping("/organisation/about")
    public tempOrganisation organisationRegistrationAboutStep(@RequestBody AboutDetailsJSON postBody)
    {
        System.out.println("started");
        try
        {
            String organisationName = postBody.getPrevious_step_organisationName();
            String password = postBody.getPrevious_step_organisationPassword();
            String contactPerson = postBody.getPrevious_step_contactPerson();
            String contactNumber = postBody.getPrevious_step_contactNumber();
            String email = postBody.getPrevious_step_email();
            String slogan = postBody.getOrganisationSlogan();
            String sector = postBody.getOrganisationSector();
            String description = postBody.getOrganisationDescription();

            System.out.println("debug about\n" + postBody.getOrganisationSlogan() + "\n" + postBody.getOrganisationDescription() + "\n" + postBody.getOrganisationSector());

            organisationGetAboutResponse response = service.organisationRegistrationAboutStep(new organisationGetAboutRequest(slogan,description,sector));

            tempOrganisation tempOrganisation = response.getTempOrganisation();
            tempOrganisation.setOrgName(organisationName);
            tempOrganisation.setPassword(password);
            tempOrganisation.setContactPerson(contactPerson);
            tempOrganisation.setContactNumber(contactNumber);
            tempOrganisation.setOrgEmail(email);

            return tempOrganisation;
        }
        catch (Exception e)
        {
            System.out.println("error occurred: " + e.getMessage());
            tempOrganisation tempOrganisation = new tempOrganisation();
            tempOrganisation.setStatus(200);
            tempOrganisation.setMessage(e.getMessage());
            return tempOrganisation;
        }
    }

    @CrossOrigin
    @PostMapping("/organisation/confirm")
    public organisationRegistrationResponseJSON confirmOrganisationRegistration(@RequestBody confirmJSON postBody)
    {
        try
        {
            String organisationName = postBody.getOrgName();
            String password = postBody.getPassword();
            String contactPerson = postBody.getContactPerson();
            String contactNumber = postBody.getContactNumber();
            String email = postBody.getOrgEmail();
            String slogan = postBody.getOrgSlogan();
            String sector = postBody.getOrgSector();
            String description = postBody.getOrgDescription();

            tempOrganisation tempOrganisation = new tempOrganisation();
            tempOrganisation.setOrgName(organisationName);
            tempOrganisation.setPassword(password);
            tempOrganisation.setContactPerson(contactPerson);
            tempOrganisation.setContactNumber(contactNumber);
            tempOrganisation.setOrgEmail(email);
            tempOrganisation.setOrgSlogan(slogan);
            tempOrganisation.setOrgSector(sector);
            tempOrganisation.setOrgDescription(description);

            organisationConfirmRegistrationRequest request = new organisationConfirmRegistrationRequest(tempOrganisation);
            organisationConfirmRegistrationResponse response = service.confirmOrganisationRegistration(request);
            return response.getOrganisationRegistrationResponseJSON();

        }
        catch (Exception e)
        {
            return new organisationRegistrationResponseJSON(200, e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/organisation/user")
    public userRegistrationResponseJSON registerBasicUser(@RequestBody userDetailsJSON postBody)
    {
        try {
            String userFirstName = postBody.getUserFirstName();
            String userLastName = postBody.getUserLastName();
            String userEmail = postBody.getUserEmail();
            String userPassword = postBody.getPassword();
            String confirmPassword = postBody.getConfirmPassword();

            userRegistrationResponse response = service.registerBasicUser(new userRegistrationRequest(userFirstName,userLastName,userEmail,userPassword));
            return response.getUserRegistrationResponseJSON();
        }
        catch(Exception e)
        {
            return new userRegistrationResponseJSON(200,e.getMessage());
        }
    }
}
