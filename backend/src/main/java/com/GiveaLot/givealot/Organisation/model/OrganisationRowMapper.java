package com.GiveaLot.givealot.Organisation.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganisationRowMapper implements RowMapper<Organisation> {


    @Override
    public Organisation mapRow(ResultSet rs, int i) throws SQLException {
        Organisation organisation = new Organisation(
                rs.getString("orgId"),
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
        return organisation;
    }
}
