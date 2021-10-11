package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.OrganisationData;
import com.GiveaLot.givealot.Organisation.model.OrganisationGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganisationGalleryRepository extends JpaRepository<OrganisationGallery, Long> {
    @Query("select o from OrganisationGallery o where o.orgId = ?1")
    List<OrganisationData> selectOrganisationImagesById(Long orgId);


    @Query("select o.image from OrganisationGallery o where o.orgId = ?1 AND o.name = ?2")
    byte[] getOrganisationGalleryImages(Long orgId, String name);
}
