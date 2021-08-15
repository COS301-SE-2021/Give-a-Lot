package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.organisationInfo;
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
        organisationInfo organisationInfo = repository.selectOrganisationInfo(10L);
        System.out.println(organisationInfo);
    }

    @Test
    void addOrgWebsite() {
        Integer res = repository.addOrgWebsite(10L, "www.test.org");
        System.out.println(res);
    }

    @Test
    void removeOrgWebsite() {
        Integer res = repository.removeOrgWebsite(10L);
        System.out.println(res);
    }

    @Test
    void addOrgAddress() {
        Integer res = repository.addOrgAddress(10L, "82 givealot str, pretoria, 1801, SA");
        System.out.println(res);
    }

    @Test
    void removeOrgAddress() {
        Integer res = repository.removeOrgAddress(10L);
        System.out.println(res);
    }

    @Test
    void addTwitter() {
    }

    @Test
    void addInstagram() {
    }

    @Test
    void addFacebook() {
    }

    @Test
    void removeTwitter() {
    }

    @Test
    void removeInstagram() {
    }

    @Test
    void removeFacebook() {
    }
}