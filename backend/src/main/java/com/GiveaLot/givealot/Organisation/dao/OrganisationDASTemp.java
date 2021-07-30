package com.GiveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.Organisation.datasource.TempDataSource;
import com.GiveaLot.givealot.Organisation.exceptions.OrganisationException;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationInfoRowMapper;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationPointsRowMapper;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


@Repository("temp")
public class OrganisationDASTemp implements OrganisationDAOInterface{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrganisationDASTemp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Organisation selectOrganisation(String orgId) {
        String query = "SELECT * FROM \"Organisations\" WHERE \"orgId\" = " + orgId + ";";

        Organisation organisation = jdbcTemplate.queryForObject(query, new OrganisationRowMapper());

        if(organisation.getOrgName().isEmpty()){
            return null;
        }

        return organisation;
    }

    @Override
    public OrganisationInfo selectOrganisationInfo(String orgId) {
        String query = "SELECT * FROM \"OrganisationInfo\" WHERE \"orgId\" = " + orgId + ";";

        OrganisationInfo organisationInfo = jdbcTemplate.queryForObject(query, new OrganisationInfoRowMapper());

        if(organisationInfo.getOrgId().isEmpty()){
            return null;
        }

        return organisationInfo;
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) {
        String query = "SELECT * FROM \"OrganisationPoints\" WHERE \"orgId\" = " + orgId + ";";

        OrganisationPoints organisationPoints = jdbcTemplate.queryForObject(query, new OrganisationPointsRowMapper());

        if(organisationPoints.getOrgId().isEmpty()){
            return null;
        }

        return organisationPoints;
    }

    @Override
    public boolean organisationExists(Organisation organisation) {
        String query = "select \"orgId\" from public.\"Organisations\";";

        Organisation org = jdbcTemplate.queryForObject(query,new OrganisationRowMapper());

        if (organisation.getOrgId().equals(org.getOrgId())){
            return true;
        }
        return false;
    }

    @Override
    public boolean addOrganisation(Organisation organisation) {

        /** Sets up Dates for certificate **/

        java.util.Date dateCurrent = new Date();
        java.util.Date dateEx = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateCreated = format.format(dateCurrent);

        int year = dateCurrent.getYear();
        dateEx.setYear(year+1);
        String dateExpiry = format.format(dateEx);

        Organisation.MD5 md5 = new Organisation.MD5();

        /** Salts and hashes password **/

        String salt = md5.getMd5(organisation.getOrgEmail());

        String salted = md5.getMd5(organisation.getPassword() + salt);

        /** Create server directory **/

        String filepath = "";

        organisation.setDirectory(filepath);


        /** Adds the organisation to all the respective tables **/

        jdbcTemplate.update(
                "insert into public.\"Organisations\"(\"orgName\", \"orgSlogan\", \"orgDescription\", \"orgSector\", \"orgEmail\", \"orgId\", \"status\", \"password\", \"contactPerson\", \"contactNumber\", \"directory\") values (?,?,?,?,?,?,?,?,?,?,?)",
                organisation.getOrgName(),organisation.getSlogan(),organisation.getOrgDescription(),organisation.getOrgSector(),organisation.getOrgEmail(),organisation.getOrgId(),organisation.getStatus().toString(),salted,organisation.getContactPerson(),organisation.getContactNumber(),organisation.getDirectory()
        );
        jdbcTemplate.update(
                "insert into public.\"OrganisationPoints\"(\"orgId\") values (?)",
                organisation.getOrgId()
        );
        jdbcTemplate.update(
                "insert into public.\"OrganisationInfo\"(\"orgId\") values (?)",
                organisation.getOrgId()
        );
        jdbcTemplate.update(
                "insert into public.\"Certificate\"(\"orgId\", \"dateCreated\", \"dateExpiry\") values (?,?,?)",
                organisation.getOrgId(),dateCreated,dateExpiry
        );

        return true;
    }

    @Override
    public boolean reactivateOrganisation(String orgId) {
        Organisation org = selectOrganisation(orgId);

        if (org.getStatus().equals("Active")){
            return false;
        }
        jdbcTemplate.update(
                "update public.\"Organisations\" set status = 'Active' where \"orgId\" = (?)",
                orgId
                );
        return true;
    }

    @Override
    public boolean investigateOrganisation(String orgId) {
        Organisation org = selectOrganisation(orgId);

        if (org.getStatus().equals("UnderInvestigation")){
            return false;
        }
        jdbcTemplate.update(
                "update public.\"Organisations\" set status = 'UnderInvestigation' where \"orgId\" = (?)",
                orgId
        );
        return true;
    }

    @Override
    public boolean suspendOrganisation(String orgId) {
        Organisation org = selectOrganisation(orgId);

        if (org.getStatus().equals("Suspended")){
            return false;
        }
        jdbcTemplate.update(
                "update public.\"Organisations\" set status = 'Suspended' where \"orgId\" = (?)",
                orgId
        );
        return true;
    }

    @Override
    public boolean addOrgWebsite(String orgId, String website) {
        return false;
    }

    @Override
    public boolean removeOrgWebsite(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAddress(String orgId, String address) {
        return false;
    }

    @Override
    public boolean removeOrgAddress(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgImage(String orgId, File image) {
        return false;
    }

    @Override
    public boolean removeOrgImage(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAuditDoc(String orgId, File audit) {
        return false;
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgTaxRef(String orgId, String reference) {
        return false;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgAuditor(String orgId, String auditor) {
        return false;
    }

    @Override
    public boolean removeOrgAuditor(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgCommittee(String orgId, String committee) {
        return false;
    }

    @Override
    public boolean removeOrgCommittee(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgDonationInfo(String orgId, String info) {
        return false;
    }

    @Override
    public boolean removeOrgDonationInfo(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgSocials(String orgId, String type, String website) {
        return false;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) {
        return false;
    }

    @Override
    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate) {
        return false;
    }

    @Override
    public boolean removeOrgNGO(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgEstDate(String orgId, Date date) {
        return false;
    }

    @Override
    public boolean removeOrgEstDate(String orgId) {
        return false;
    }

}
