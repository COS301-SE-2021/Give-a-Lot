package com.GiveaLot.givealot.Certificate.repository;
//


import com.GiveaLot.givealot.Certificate.dataclass.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {

    @Query("select o from Certificate where o.orgId =?1")
    Certificate selectCertificateById(Long orgId);

    @Query()
    Certificate selectCertificateByHash(String certificateHash);

    @Modifying
    @Transactional
    @Query()
    void updateOrgRenewal(Long orgId);

    @Modifying
    @Transactional
    @Query()
    void updateAdminRenewal(Long orgId);


}
