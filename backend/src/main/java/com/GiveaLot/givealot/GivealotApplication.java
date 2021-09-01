package com.GiveaLot.givealot;

import com.GiveaLot.givealot.Blockchain.service.BlockchainService;
import com.GiveaLot.givealot.Certificate.repository.CertificateRepository;
import com.GiveaLot.givealot.Certificate.service.CertificateService;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
import com.GiveaLot.givealot.Organisation.requests.AddOrgImageRequest;
import com.GiveaLot.givealot.Organisation.requests.AddOrgWebsiteRequest;
import com.GiveaLot.givealot.Organisation.service.OrganisationService;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.service.ReportService;
import com.GiveaLot.givealot.User.requests.RegisterUserRequest;
import com.GiveaLot.givealot.User.requests.SetAdminRequest;
import com.GiveaLot.givealot.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class GivealotApplication implements CommandLineRunner {

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
    ReportService reportService;

    @Autowired
    UserService userService;


    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(GivealotApplication.class, args);
    }




//    @Override
//    public  void run(String... args) throws Exception {
//        System.out.println(blockchainService.deploySmartContract());
//    }

    /** Add an organisation **/

	@Override
	public  void run(String... args) throws Exception {
		Organisations organisations = new Organisations();
		organisations.setOrgId(123L);
		organisations.setPassword("iloveyou");
		organisations.setContactNumber("Contact Number");
		organisations.setOrgEmail("meeetest3@gmail.com");
		organisations.setStatus("Status");
		organisations.setOrgSector("disability");
		organisations.setContactPerson("Contact Person");
		organisations.setSlogan("Slogan");
		organisations.setOrgDescription("Org Description");
		organisations.setOrgName("The Worker Co.");
		organisations.setDirectory("/tmp");
        organisations.setDateAdded("2020-01-01");
		organisationService.addOrganisation(organisations);

	}

	/** Compare valid certificate **/
//	@Override
//	public  void run(String... args) throws Exception {
//		File test = new File("frontend/givealot/localFiles/20/certificate/CertificateComplete.pdf");
//		System.out.println(certificateService.compareCertificate(test));
//	}

	/** Compare invalid Certificate **/

//	@Override
//	public  void run(String... args) throws Exception {
//		File test = new File("DemoMaterial/2.pdf");
//		System.out.println(certificateService.compareCertificate(test));
//	}

    /** Upgrade a certificate **/

//	@Override
//	public  void run(String... args) throws Exception {
//		certificateRepository.updatePoints(34L,20);
//		System.out.println(certificateService.updateCertificate(34));
//	}

    /** Add an image to the system **/
//	@Override
//	public  void run(String... args) throws Exception {
//		AddOrgImageRequest imageRequest = new AddOrgImageRequest(20L,new File("DemoMaterial/testimage.JPG"));
//		organisationService.addOrgImage(imageRequest);
//	}

    /** Add a website to the system **/
//	@Override
//	public  void run(String... args) throws Exception {
//		AddOrgWebsiteRequest websiteRequest = new AddOrgWebsiteRequest(20L,"http:/organisationweb.co.za");
//		organisationService.addOrgWebsite(websiteRequest);
//	}

    /** Validate a website on the system **/
//	@Override
//	public  void run(String... args) throws Exception {
//		AddOrgWebsiteRequest websiteRequest = new AddOrgWebsiteRequest(20L,"http:/organisationweb.co.za");
//		organisationService.confirmValidity(20L,4L,"website",true);
//	}

    /** Report Organisation **/
//	@Override
//	public  void run(String... args) throws Exception {
//		Report report = new Report(
//				20L,
//				"The New Org",
//				"this organisation has been stealing money",
//				"Fraud",
//				"thequestion@gmail.com"
//		);
//		System.out.println(reportService.createReportFile(report).getMessage());
//	}

    /** Add user **/
//    @Override
//    public void run(String... args) throws Exception {
//        RegisterUserRequest request = new RegisterUserRequest("The cool guy", "McGee", "coolmail@gmail.com", "password");
//        System.out.println(userService.Register(request).getMessage());
//    }

    /** Set Admin **/
//    @Override
//    public void run(String... args) throws Exception {
//        SetAdminRequest request = new SetAdminRequest( "coolmail@gmail.com", "admin@email.com");
//        System.out.println(userService.SetAdmin(request));
//    }


}
