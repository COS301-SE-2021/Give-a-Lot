package com.GiveaLot.givealot.FaceRecognition.repository;

import com.GiveaLot.givealot.FaceRecognition.dataclass.FaceBlur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BlurRepository extends JpaRepository<FaceBlur, Long> {
    @Query("select o from FaceBlur o where o.org_id = ?1")
    FaceBlur selectBlurDataById(Long orgId);

    @Modifying
    @Transactional
    @Query("UPDATE FaceBlur o SET o.image_bytes = ?2 WHERE o.org_id = ?1")
    Integer updateBlur(Long orgId, byte[] data);
}
