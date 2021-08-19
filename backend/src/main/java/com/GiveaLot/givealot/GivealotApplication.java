package com.GiveaLot.givealot;

import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.service.CertificateService;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GivealotApplication implements CommandLineRunner{

	@Autowired
	OrganisationRepository organisationRepository;

	@Autowired
	OrganisationService organisationService;

	@Autowired
	CertificateRepository certificateRepository;

	@Autowired
	CertificateService certificateService;

	@Autowired
	BlockchainService blockchainService;


	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(GivealotApplication.class, args);
	}




//	@Override
//	@Description("Valid Certificate")
//	public  void run(String... args) throws Exception {
//		File test = new File("DemoMaterial/1.pdf");
//		System.out.println(certificateService.compareCertificate(test));
//	}

//	@Override
//	@Description("Invalid Certificate")
//	public  void run(String... args) throws Exception {
//		File test = new File("DemoMaterial/2.pdf");
//		System.out.println(certificateService.compareCertificate(test));
//	}

	@Override
	public  void run(String... args) throws Exception {
		certificateRepository.updatePoints(33L,40);
		System.out.println(certificateService.updateCertificate(33));
	}

//	@Override
//	public  void run(String... args) throws Exception {
//		Organisations organisations = new Organisations();
//		organisations.setOrgId(123L);
//		organisations.setPassword("iloveyou");
//		organisations.setContactNumber("Contact Number");
//		organisations.setOrgEmail("futuremoroke@gmail.com");
//		organisations.setStatus("Status");
//		organisations.setOrgSector("Animals");
//		organisations.setContactPerson("Contact Person");
//		organisations.setSlogan("Slogan");
//		organisations.setOrgDescription("Org Description");
//		organisations.setOrgName("The Kgomotso Corporation");
//		organisations.setDirectory("/tmp");
//		organisationService.addOrganisation(organisations);
//
//	}





}
