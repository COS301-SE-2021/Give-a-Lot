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

    //-------------
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
    final String sql="UPDATE public.OrganisationInfo set taxReference=? WHERE orgId=?";
    jdbcTemplate.update(sql,reference,orgId);

        return true;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) {
        final String sql="update public.OrganisationInfo set taxReference = null where orgId=?";
        jdbcTemplate.update(sql,orgId);
        return true;
    }

    @Override
    public boolean addOrgAuditor(String orgId, String auditor) {

        final String sql="update public.OrganisationInfo set auditorDetails = ? where orgId=?";

        jdbcTemplate.update(sql,auditor,orgId);
        return true;
    }

    @Override
    public boolean removeOrgAuditor(String orgId) {

        final String sql="update public.OrganisationInfo set auditorDetails = null where orgId=?";

        jdbcTemplate.update(sql,orgId);
        return true;
    }

    @Override
    public boolean addOrgCommittee(String orgId, String committee) {
        final String sql="update public.OrganisationInfo set commiteeDetails = ? where orgId=?";

        jdbcTemplate.update(sql,committee,orgId);
        return true;
    }

    @Override
    public boolean removeOrgCommittee(String orgId) {
        final String sql="update public.OrganisationInfo set commiteeDetails = null where orgId=?";

        jdbcTemplate.update(sql,orgId);
        return true;
    }

    @Override
    public boolean addOrgDonationInfo(String orgId, String info) {
        return true;
    }

    @Override
    public boolean removeOrgDonationInfo(String orgId) {
        return false;
    }

    @Override
    public boolean addOrgSocials(String orgId, String type, String website) {

        final String sql1="update public.OrganisationInfo set website = ? where orgId=?";

        jdbcTemplate.update(sql1,website,orgId);


        if(type.equals("facebook"))
        {
            final String sql="update public.OrganisationInfo set facebook = ? where orgId=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        else if(type.equals("twitter"))
        {
            final String sql="update public.OrganisationInfo set twitter = ? where orgId=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        else
        {
            final String sql="update public.OrganisationInfo set instagram = ? where orgId=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        return true;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) {

        if(type.equals("facebook"))
        {
            final String sql="update public.OrganisationInfo set facebook = null where orgId=?";

            jdbcTemplate.update(sql,orgId);
        }
        else if(type.equals("twitter"))
        {
            final String sql="update public.OrganisationInfo set twitter = null where orgId=?";

            jdbcTemplate.update(sql,orgId);
        }
        else
        {
            final String sql="update public.OrganisationInfo set instagram = null where orgId=?";

            jdbcTemplate.update(sql,orgId);
        }
        return true;
    }

    @Override
    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate) {

        final String sql="update public.OrganisationInfo set ngoNumber =? where orgId=?";
        jdbcTemplate.update(sql,ngoNumber,orgId);

        final String sql2="update public.OrganisationInfo set ngoDate=? where orgId=?";

        jdbcTemplate.update(sql2,ngoDate,orgId);
        return false;
    }

    @Override
    public boolean removeOrgNGO(String orgId) {
        final String sql="update public.OrganisationInfo set ngoNumber =null where orgId=?";
        jdbcTemplate.update(sql,orgId);

        final String sql2="update public.OrganisationInfo set ngoDate=null where orgId=?";

        jdbcTemplate.update(sql2,orgId);
        return true;
    }

    @Override
    public boolean addOrgEstDate(String orgId, Date date) {
        final String sql="update public.OrganisationInfo set establishmentDate =? where orgId=?";
        jdbcTemplate.update(sql,date,orgId);
        return true;
    }

    @Override
    public boolean removeOrgEstDate(String orgId) {

        final String sql="update public.OrganisationInfo set establishmentDate =null where orgId=?";
        jdbcTemplate.update(sql,orgId);
        return true;
    }

}
