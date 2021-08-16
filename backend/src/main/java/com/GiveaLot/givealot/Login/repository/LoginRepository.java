package com.GiveaLot.givealot.Login.repository;

import com.GiveaLot.givealot.User.dataclass.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository {


    @Query("SELECT s FROM User s WHERE s.email = ?1")
    User findUserByEmail(String email);

    @Query("SELECT s FROM Organisations s WHERE s.orgEmail = ?1")
    User findOrganisationByEmail(String email);


}
