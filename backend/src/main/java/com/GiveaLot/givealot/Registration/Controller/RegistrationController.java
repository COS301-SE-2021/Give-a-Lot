package com.GiveaLot.givealot.Registration.Controller;
import com.GiveaLot.givealot.Registration.RegistrationServiceImp;
import com.GiveaLot.givealot.Registration.json.getInfoJSON;
import com.GiveaLot.givealot.Registration.json.tempOrganisation;
import com.GiveaLot.givealot.Registration.rri.organisationGetInfoRequest;
import com.GiveaLot.givealot.Registration.rri.organisationGetInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration/type")
public class RegistrationController {

    @Autowired
    private RegistrationServiceImp service;

    public RegistrationController()
    {

    }

    @PostMapping("/organisation/sendInfo")
    public tempOrganisation organisationRegistrationInfoStep(@RequestBody getInfoJSON postBody)
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




}
