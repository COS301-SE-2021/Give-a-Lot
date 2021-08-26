package com.GiveaLot.givealot.Organisation.repository;

import com.GiveaLot.givealot.Organisation.model.Sectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface sectorsRepository extends JpaRepository<Sectors,String>
{
    @Query("SELECT distinct s.sector FROM Sectors AS s")
    List<String> getSectors();
}