package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.dataclass.OrganisationRepo;
import com.GiveaLot.givealot.Organisation.dataclass.organisationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
class OrganisationRepositoryTest {
    @Autowired
    private OrganisationRepository repository;
    @Autowired
    private OrganisationInfoRepository OrganisationInfoRepository;

    @Test
    public void selectOrgTest()
    {
        OrganisationRepo res = repository.selectOrganisation("9998");
        System.out.println(res);
    }

    @Test
    public void registerOrganisationTest()
    {
        OrganisationRepo org = OrganisationRepo.builder()
                .orgId("uniqueId1")
                .orgDescription("register test description")
                .orgEmail("hello@gmail.com")
                .orgSector("my sector")
                .contactPerson("Norman")
                .directory("some dir")
                .slogan("slogan register")
                .status("active")
                .contactNumber("0889343234")
                .password("somestrongpassword")
                .orgName("my Organisation")
                .build();

        System.out.println(repository.save(org));
        organisationInfo organisationInfo = new organisationInfo();
        organisationInfo.setOrgId("uniqueId1");
        LocalDate date = LocalDate.now();
        organisationInfo.setEstablishmentDate(date.toString());
        OrganisationInfoRepository.save(organisationInfo);
    }

    @Test
    public void changeStatus()
    {
        try {
            System.out.println("change status test");
            System.out.println(repository.updateStatus("uniqueId1", "suspended".toLowerCase()));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}