package com.GiveaLot.givealot;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class GivealotApplication  {


	@Autowired
	private OrganisationServiceImp serviceImp;

	public static void main(String[] args) {
		SpringApplication.run(GivealotApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Organisations org = new Organisations();
//		org.setOrgId(123L);
//		org.setPassword("iloveyou");
//		org.setContactNumber("Contact Number2");
//		org.setOrgEmail("jane.doe@example2.org");
//		org.setStatus("Status");
//		org.setOrgSector("Org Sector");
//		org.setContactPerson("Contact Person");
//		org.setSlogan("Slogan2");
//		org.setOrgDescription("Org Description");
//		org.setOrgName("Org Name New2");
//		org.setDirectory("/tmp");
//
//		serviceImp.addOrganisation(org);
//	}


}
