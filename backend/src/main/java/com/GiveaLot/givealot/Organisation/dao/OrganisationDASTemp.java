package com.GiveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.OrganisationRowMapper;
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
        String query = "SELECT * FROM \"Organisations\" WHERE \"orgId\" = " + orgId + ";";

        Organisation organisation = jdbcTemplate.queryForObject(query, new OrganisationRowMapper());

        if(organisation.getOrgName().isEmpty()){
            return Optional.empty();
        }

        return Optional.of(organisation);
    }

    @Override
    public Optional<OrganisationInfo> selectOrganisationInfo(String orgId) {
        String query = "SELECT * FROM \"OrganisationInfo\" WHERE \"orgId\" = " + orgId + ";";

        OrganisationInfo organisationInfo = jdbcTemplate.queryForObject(query, new OrganisationInfoRowMapper());

        if(organisationInfo.getOrgId().isEmpty()){
            return Optional.empty();
        }

        return Optional.of(organisationInfo);
    }

    @Override
    public Optional<OrganisationPoints> selectOrganisationPoints(String orgId) {
        String query = "SELECT * FROM \"OrganisationPoints\" WHERE \"orgId\" = " + orgId + ";";

        OrganisationPoints organisationPoints = jdbcTemplate.queryForObject(query, new OrganisationPointsRowMapper());

        if(organisationPoints.getOrgId().isEmpty()){
            return Optional.empty();
        }

        return Optional.of(organisationPoints);
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
