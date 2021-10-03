package com.GiveaLot.givealot.Organisation.repository;
import com.GiveaLot.givealot.Organisation.model.OrganisationGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface OrganisationGalleryRepository extends JpaRepository<OrganisationGallery, Long> {
}
