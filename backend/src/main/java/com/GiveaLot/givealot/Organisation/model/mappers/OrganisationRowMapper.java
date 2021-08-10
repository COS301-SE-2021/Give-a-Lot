package com.GiveaLot.givealot.Organisation.model.mappers;


import com.GiveaLot.givealot.Organisation.model.Organisation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class OrganisationRowMapper implements RowMapper<Organisation> {


    @Override
    public Organisation mapRow(ResultSet rs, int i) throws SQLException {
        return new Organisation(

                rs.getLong("orgId"),
                rs.getString("orgName"),
                rs.getString("orgSlogan"),
                rs.getString("orgDescription"),
                rs.getString("orgSector"),
                rs.getString("orgEmail"),
                rs.getString("status"),
                rs.getString("contactPerson"),
                rs.getString("contactNumber"),
                rs.getString("directory"),
                rs.getString(""));
    }
}
