package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.OrganisationData;
import com.GiveaLot.givealot.Organisation.model.OrganisationGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrganisationGalleryRepository extends JpaRepository<OrganisationGallery, Long> {
    @Query("select o from OrganisationGallery o where o.orgId = ?1")
    OrganisationData selectOrganisationImagesById(Long orgId);
}
