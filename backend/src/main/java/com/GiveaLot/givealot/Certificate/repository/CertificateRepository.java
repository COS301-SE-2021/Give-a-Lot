package com.GiveaLot.givealot.Certificate.repository;
//


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CertificateRepository extends JpaRepository {

    @Query("select o from Certificate o where o.org_id =?1")
    Certificate selectCertificateById(Long orgId);

    @Query("select o.points from Certificate o where o.org_id =?1")
    Certificate selectPointsById(Long orgId);

    @Modifying
    @Transactional
    @Query("update Certificate o set o.orgRenewal = ?2 where o.org_id = ?1")
    void updateOrgRenewal(Long orgId, boolean renew);

    @Modifying
    @Transactional
    @Query("update Certificate o set o.adminRenewal = ?2 where o.org_id = ?1")
    void updateAdminRenewal(Long orgId, boolean renew);

    @Modifying
    @Transactional
    @Query("update Certificate o set o.points = false where o.org_id = ?1")
    void updatePoints(Long orgId);

}
