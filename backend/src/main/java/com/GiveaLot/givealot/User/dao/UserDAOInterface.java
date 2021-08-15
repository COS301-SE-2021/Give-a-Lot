package com.GiveaLot.givealot.User.dao;


import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface UserDAOInterface extends JpaRepository<User, String> {


    ////////////////////////////////////////////////////////// SELECT //////////////////////////////////////////////////////////
    @Query("SELECT s FROM User s WHERE s.email = ?1")
     User findUserByEmail(String email);

    @Query("SELECT s FROM User s WHERE s.email = ?1 AND s.isAdmin = True")
     User isAdmin(String username);

    @Query("SELECT s FROM User s WHERE s.resetCode = ?1")
     User findUserByResetCode(String resetCode);

    @Query("SELECT s FROM User s WHERE s.activationCode = ?1")
     User UserfindUsersByActivationCode(String activationCode);

    @Query("SELECT s FROM User s WHERE s.jwt_token = ?1")
    User findUserByJWTToken(String JWTToken);

    ////////////////////////////////////////////////////////// UPDATE //////////////////////////////////////////////////////////

    @Modifying
    @Query("UPDATE User u SET u.email = ?2 WHERE u.id = ?1")
    int updateEmail(UUID UserID, String email);

    @Modifying
    @Query("UPDATE User u SET u.isAdmin = ?2 WHERE u.id = ?1")
    int updateAdmin(UUID UserID, boolean isAdmin);

    @Modifying
    @Query("UPDATE User u SET u.password = ?2 WHERE u.resetCode = ?1")
    int updatePassword(String resetCode, String password);


    @Modifying
    @Query("UPDATE User u SET u.resetExpiration = ?2, u.resetCode = ?3 WHERE u.id = ?1")
    int setResetExpirationAndResetCode(String UserID, LocalDateTime resetExpiration, String resetCode);

    @Modifying
    @Query("UPDATE User u SET u.activateDate = ?2 WHERE u.id = ?1")
    int setActivateDate(String UserID, LocalDateTime activateDate);

    @Modifying
    @Query("UPDATE User u SET u.activationCode = ?2 WHERE u.id = ?1")
    int setActivationCode(String UserID, String activationCode);

    @Modifying
    @Query("UPDATE User u SET u.lastLoggedIn = ?2 WHERE u.id = ?1")
    int setLastLoggedIn(UUIeD UserID, LocalDateTime now);

    @Modifying
    @Query("UPDATE User u SET u.jwt_token = ?2 WHERE u.id = ?1")
    int setJWTToken(String UserID, String jwtToken);

    ////////////////////////////////////////////////////////// DELETE //////////////////////////////////////////////////////////

    @Modifying
    @Query("DELETE FROM User u WHERE u.email = ?1")
    int deleteByEmail(String email);

    @Modifying
    @Query("DELETE FROM User u WHERE u.resetCode = ?1")
    int deleteByResetCode(String resetCode);



}
