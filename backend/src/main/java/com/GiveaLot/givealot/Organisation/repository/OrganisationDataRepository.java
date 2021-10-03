package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.OrganisationData;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrganisationDataRepository extends JpaRepository <OrganisationData, Long>{

    @Query("select o from OrganisationData o where o.orgId = ?1")
    OrganisationData selectOrganisationDataById(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.auditDoc = ?2 WHERE o.orgId = ?1")
    Integer updateAuditDoc(Long orgId, byte[] data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.qrCode = ?2 WHERE o.orgId = ?1")
    Integer updateQRCode(Long orgId, byte[] data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.image1 = ?2 WHERE o.orgId = ?1")
    Integer updateImage1(Long orgId, byte[] data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.image2 = ?2 WHERE o.orgId = ?1")
    Integer updateImage2(Long orgId, byte[] data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.image3 = ?2 WHERE o.orgId = ?1")
    Integer updateImage3(Long orgId, byte[] data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.image4 = ?2 WHERE o.orgId = ?1")
    Integer updateImage4(Long orgId, String data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.image5 = ?2 WHERE o.orgId = ?1")
    Integer updateImage5(Long orgId, String data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.certificate = ?2 WHERE o.orgId = ?1")
    Integer updateCertificate(Long orgId, String data);

    @Modifying
    @Transactional
    @Query("UPDATE OrganisationData o SET o.certificateImage = ?2 WHERE o.orgId = ?1")
    Integer updateCertificateImage(Long orgId, String data);
}
