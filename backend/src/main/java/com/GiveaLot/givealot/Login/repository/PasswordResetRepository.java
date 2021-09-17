package com.GiveaLot.givealot.Login.repository;

import com.GiveaLot.givealot.Login.model.PasswordResetToken;
import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PasswordResetRepository extends JpaRepository<PasswordResetToken,Long>
{
    @Query("SELECT s FROM PasswordResetToken s WHERE s.token = ?1")
    PasswordResetToken findToken(String token);
}
