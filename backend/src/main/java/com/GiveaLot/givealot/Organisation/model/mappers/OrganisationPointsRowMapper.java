package com.GiveaLot.givealot.Organisation.model.mappers;

import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganisationPointsRowMapper implements RowMapper<OrganisationPoints> {

    @Override
    public OrganisationPoints mapRow(ResultSet rs, int i) throws SQLException {
        OrganisationPoints organisationPoints = new OrganisationPoints(
                rs.getString("orgId"),
                rs.getInt("points"),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getBoolean(""),
                rs.getString(""),
                rs.getBoolean(""),
                rs.getInt(""));

        return organisationPoints;
    }
}
