package com.GiveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.Organisation.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;
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
    public Optional<Organisation> selectOrganisation(String orgId) {
        String query = "";

        return null;
    }

    @Override
    public Optional<Organisation> selectOrganisationInfo(String orgId) {
        return null;
    }

    @Override
    public Optional<Organisation> selectOrganisationPoints(String orgId) {
        return null;
    }

    @Override
    public boolean organisationExists(Organisation organisation) {
        return false;
    }

    @Override
    public boolean addOrganisation(Organisation organisation) {
        return false;
    }

    @Override
    public boolean reactivateOrganisation(String orgId) {
        return false;
    }

    @Override
    public boolean investigateOrganisation(String orgId) {
        return false;
    }

    @Override
    public boolean suspendOrganisation(String orgId) {
        return false;
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
