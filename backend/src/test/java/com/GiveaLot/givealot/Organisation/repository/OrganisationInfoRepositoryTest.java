package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.dataclass.organisationInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrganisationInfoRepositoryTest {

    @Autowired
    OrganisationInfoRepository repository;

    @Test
    void selectOrganisationInfo() {
        organisationInfo organisationInfo = repository.selectOrganisationInfo("uniqueId1");
        System.out.println(organisationInfo);
    }

    @Test
    void addOrgWebsite() {
        Integer res = repository.addOrgWebsite("uniqueId1", "www.test.org");
        System.out.println(res);
    }
}