//package com.GiveaLot.givealot.TEMP;
//
//import com.GiveaLot.givealot.Organisation.model.Organisations;
//import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
//import com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository;
//import com.GiveaLot.givealot.Organisation.repository.OrganisationRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.time.LocalDate;
//
//@SpringBootTest
//class OrganisationRepositoryTest {
//
//    @Autowired
//    private OrganisationRepository repository;
//
//    @Autowired
//    private com.GiveaLot.givealot.Organisation.repository.OrganisationInfoRepository OrganisationInfoRepository;
//
//    @Test
//    public void selectOrgTest()
//    {
//        Organisations res = repository.selectOrganisationById(10L);
//        System.out.println(res);
//    }
//
//    @Test
//    public void registerOrganisationTest()
//    {
//        Organisations org = Organisations.builder()
//                .orgDescription("register test description")
//                .orgEmail("hello@gmail.com")
//                .orgSector("my sector")
//                .contactPerson("Norman")
//                .directory("some dir")
//                .slogan("slogan register")
//                .status("active")
//                .contactNumber("0889343234")
//                .password("somestrongpassword")
//                .orgName("my AddOrganisationRequest")
//                .build();
//
//        System.out.println(repository.save(org));
//        OrganisationInfo organisationInfo = new OrganisationInfo();
//        LocalDate date = LocalDate.now();
//        //organisationInfo.setEstablishmentDate(date.toString());
//        OrganisationInfoRepository.save(organisationInfo);
//    }
//
//    @Test
//    public void changeStatus()
//    {
//        try {
//            System.out.println("change status test");
//            System.out.println(repository.updateStatus(10L, "suspended".toLowerCase()));
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
//    }
//
//    @Test
//    void getOrgId()
//    {
//        System.out.println("getting org ID");
//        System.out.println(repository.getOrgId("orgEmail@gmail.com"));
//    }
//}