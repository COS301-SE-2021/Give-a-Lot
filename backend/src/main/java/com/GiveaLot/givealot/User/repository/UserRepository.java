package com.GiveaLot.givealot.User.repository;

import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    ////////////////////////////////////////////////////////// SELECT //////////////////////////////////////////////////////////
    @Query("SELECT s FROM User s WHERE s.email = ?1")
    User findUserByEmail(String email);


    @Query("SELECT s FROM User s WHERE s.id = ?1")
    User findUserById(long user_id);

    @Query("SELECT s FROM User s WHERE s.email = ?1 AND s.isAdmin = True")
    User isAdmin(String email);

    @Query("SELECT s FROM User s WHERE s.id = ?1 AND s.isAdmin = True")
    User isAdmin(long user_id);



    ///////////////////////////////////////////////////////// UPDATE //////////////////////////////////////////////////////////

    @Modifying
    @Query("UPDATE User u SET u.email = ?2 WHERE u.id = ?1")
    int updateEmail(long UserID, String email);

    @Modifying
    @Query("UPDATE User u SET u.lastname = ?2 WHERE u.id = ?1")
    int updateLastname(long UserID, String lastname);

    @Modifying
    @Query("UPDATE User u SET u.firstname = ?2 WHERE u.id = ?1")
    int updateFirstname(long UserID, String firstname);

    @Modifying
    @Query("UPDATE User u SET u.isAdmin = ?2 WHERE u.email = ?1")
    int updateAdmin(String UserEmail, boolean isAdmin);

    @Modifying
    @Query("UPDATE User u SET u.password = ?2 WHERE u.email = ?1")
    int updatePassword(String email, String password);

    @Modifying
    @Query("UPDATE User u SET u.activateDate = ?2 WHERE u.id = ?1")
    int setActivateDate(long UserID, LocalDateTime activateDate);


    ////////////////////////////////////////////////////////// DELETE //////////////////////////////////////////////////////////

    @Modifying
    @Query("DELETE FROM User u WHERE u.email = ?1")
    int deleteByEmail(String email);
}

