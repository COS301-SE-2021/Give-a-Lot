package com.GiveaLot.givealot.Organisation.model.mappers;

import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganisationPointsRowMapper implements RowMapper<OrganisationPoints> {

    @Override
    public OrganisationPoints mapRow(ResultSet rs, int i) throws SQLException {

        return new OrganisationPoints(
                rs.getString("orgId"),
                rs.getInt("points"),
                rs.getBoolean("addressIsValid"),
                rs.getBoolean("websiteISValid"),
                rs.getBoolean("auditIsValid"),
                rs.getBoolean("taxRefIsValid"),
                rs.getBoolean("auditorIsValid"),
                rs.getBoolean("committeeIsValid"),
                rs.getBoolean("ngoNoIsValid"),
                rs.getBoolean("ngoDateIsValid"),
                rs.getBoolean("instagramIsValid"),
                rs.getBoolean("facebookIsValid"),
                rs.getBoolean("twitterIsValid"),
                rs.getBoolean("estDateIsValid"),
                rs.getInt("numberOfImages"));
    }
}
