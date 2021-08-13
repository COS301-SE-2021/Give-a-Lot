/*
package com.GiveaLot.givealot.Organisation.model.mappers;

import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganisationInfoRowMapper implements RowMapper<OrganisationInfo> {
    @Override
    public OrganisationInfo mapRow(ResultSet rs, int i) throws SQLException {
        return new OrganisationInfo(
            rs.getString("orgId"),
            rs.getString("address"),
            rs.getInt("numberOfImages"),
            rs.getInt("numberOfReports"),
            rs.getString("website"),
            rs.getString("auditDocument"),
            rs.getString("taxReference"),
            rs.getString("auditorDetails"),
            rs.getString("committeeDetails"),
            rs.getString("ngoNumber"),
            rs.getDate("ngoDate"),
            rs.getString("twitter"),
            rs.getString("facebook"),
            rs.getString("instagram"),
            rs.getDate("establishmentDate"));
    }
}
*/
