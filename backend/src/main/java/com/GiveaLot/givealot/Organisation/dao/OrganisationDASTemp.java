package com.GiveaLot.givealot.Organisation.dao;

import com.GiveaLot.givealot.datasource.TempDataSource;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import com.GiveaLot.givealot.Organisation.model.OrganisationInfo;
import com.GiveaLot.givealot.Organisation.model.OrganisationPoints;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationInfoRowMapper;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationPointsRowMapper;
import com.GiveaLot.givealot.Organisation.model.mappers.OrganisationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository("OrganisationTemp")
public class OrganisationDASTemp implements OrganisationDAOInterface{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrganisationDASTemp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Organisation selectOrganisation(String orgId) throws Exception {
        String query = "SELECT * FROM \"Organisations\" WHERE \"orgId\" = ?";

        String preparedID = "'" + orgId + "'";


        return jdbcTemplate.queryForObject(query, new OrganisationRowMapper(), preparedID);

//            Organisation organisation = jdbcTemplate.queryForObject(query, new OrganisationRowMapper(), orgId);
//
//            assert organisation != null;
//            if (organisation.getOrgName().isEmpty()) {
//                return null;
//            }

            //return organisation;

    }

    @Override
    public OrganisationInfo selectOrganisationInfo(String orgId) throws Exception {
        String query = "SELECT * FROM \"OrganisationInfo\" WHERE \"orgId\" = '" + orgId + "';";

        try {
            OrganisationInfo organisationInfo = jdbcTemplate.queryForObject(query, new OrganisationInfoRowMapper());

            if (organisationInfo.getOrgId().isEmpty())
            {
                return null;
            }

            return organisationInfo;
        }
        catch (Exception e)
        {
            throw new Exception("sel_org_info " + e.toString());
        }
    }

    @Override
    public OrganisationPoints selectOrganisationPoints(String orgId) throws Exception {
        String query = "SELECT * FROM \"OrganisationPoints\" WHERE \"orgId\" = " + orgId + ";";

        try {
            OrganisationPoints organisationPoints = jdbcTemplate.queryForObject(query, new OrganisationPointsRowMapper());

            if (organisationPoints.getOrgId().isEmpty()) {
                return null;
            }

            return organisationPoints;
        }
        catch(Exception e)
        {
            throw new Exception("sel_org_pts " + e.toString());
        }
    }

    @Override
    //Check
    public boolean organisationExists(Organisation organisation) {
        String query = "select \"orgId\" from public.\"Organisations\";";

        Organisation org = jdbcTemplate.queryForObject(query,new OrganisationRowMapper());

        if (organisation.getOrgId().equals(org.getOrgId())){
            return true;
        }
        return false;
    }

    @Override
    public boolean addOrganisation(Organisation organisation) throws Exception {

        /** Sets up Dates for certificate **/

        try {
            java.util.Date dateCurrent = new Date();
            java.util.Date dateEx = new Date();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            String dateCreated = format.format(dateCurrent);

            int year = dateCurrent.getYear();
            dateEx.setYear(year + 1);
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
                    organisation.getOrgName(), organisation.getSlogan(), organisation.getOrgDescription(), organisation.getOrgSector(), organisation.getOrgEmail(), organisation.getOrgId(), organisation.getStatus().toString(), salted, organisation.getContactPerson(), organisation.getContactNumber(), organisation.getDirectory()
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
                    organisation.getOrgId(), dateCreated, dateExpiry
            );

            return true;
        }
        catch(Exception e)
        {
            throw new Exception("add_org_exp : " + e.toString());
        }
    }

    @Override
    public boolean reactivateOrganisation(String orgId) throws Exception {

        try {
            Organisation org = selectOrganisation(orgId);

            if (org.getStatus().equals("Active")) {
                return false;
            }
            jdbcTemplate.update(
                    "update public.\"Organisations\" set status = 'Active' where \"orgId\" = (?)",
                    orgId
            );
            return true;
        }
        catch (Exception e)
        {
            throw new Exception("rct_org_excp: " + e.toString());
        }
    }

    @Override
    public boolean investigateOrganisation(String orgId) throws Exception {
        try
        {
            Organisation org = selectOrganisation(orgId);

            if (org != null && org.getStatus().equals("UnderInvestigation")) {
                return false;
            }
            jdbcTemplate.update(
                    "update public.\"Organisations\" set status = 'UnderInvestigation' where \"orgId\" = (?)",
                    orgId
            );
            return true;
        }
        catch(Exception e)
        {
            throw new Exception("inv_org_excp " + e.toString());
        }
    }

    @Override
    public boolean suspendOrganisation(String orgId) throws Exception {
        try {
            Organisation org = selectOrganisation(orgId);

            if (org == null) {
                return false;
            }
            jdbcTemplate.update(
                    "update public.\"Organisations\" set status = 'Suspended' where \"orgId\" = (?)",
                    orgId
            );
            return true;
        }
        catch(Exception e)
        {
            throw new Exception("sus_org_excp " + e.toString());
        }
    }

    @Override
    public boolean addOrgWebsite(String orgId, String website) throws Exception {

        try {
            Organisation org = selectOrganisation(orgId);

            if (org.getStatus().equals("Suspended")) {
                return false;
            }

            final String sql = "update public.\"OrganisationInfo\" set website=? WHERE \"orgId\"=?";
            jdbcTemplate.update(sql, website, orgId);

            return true;
        }catch (Exception e)
        {
            throw new Exception("add_web_excp " + e.toString());
        }
    }

    @Override
    public boolean removeOrgWebsite(String orgId) throws Exception{

        try {
            String query = "update public.\"OrganisationInfo\" set \"website\" = null where \"orgId\" = ?";
            jdbcTemplate.update(query, orgId);
            String query1 = "update public.\"OrganisationPoints\" set \"websiteIsValid\" = false where \"orgId\" = ?";
            jdbcTemplate.update(query1, orgId);
            String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 10 where \"orgId\" = ?";
            jdbcTemplate.update(query2, orgId);

            return true;
        }catch (Exception e)
        {
            throw new Exception("rem_web_excp " + e.toString());
        }
    }

    @Override
    public boolean addOrgAddress(String orgId, String address) {
        final String sql="update public.\"OrganisationInfo\" set address=? WHERE \"orgId\"=?";
        jdbcTemplate.update(sql,address,orgId);
        return true;
    }

    @Override
    public boolean removeOrgAddress(String orgId) throws Exception {
        try
        {
            /*
            * always returns true even the organisation id doesnt exist.
            * please check this
            */

            String query = "update public.\"OrganisationInfo\" set \"address\" = null where \"orgId\" = ?";
            jdbcTemplate.update(query, orgId);
            String query1 = "update public.\"OrganisationPoints\" set \"addressIsValid\" = false where \"orgId\" = ?";
            jdbcTemplate.update(query1, orgId);
            String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 10 where \"orgId\" =  ?";
            jdbcTemplate.update(query2, orgId);
            return true;
        }
        catch (Exception e)
        {
            throw new Exception("rem_addr_excp " + e.toString());
        }
    }

    @Override
    public boolean addOrgImage(String orgId, File image) {
        return false;
    }

    @Override
    public boolean removeOrgImage(String orgId) {
        String query = "update public.\"OrganisationInfo\" set \"numberOfImages\" = \"numberOfImages\" - 1 where \"orgId\" = ?";
        jdbcTemplate.update(query,orgId);
        String query1 = "update public.\"OrganisationPoints\" set \"numberOfImages\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 10 where \"orgId\" =?";
        jdbcTemplate.update(query2,orgId);
        return false;

    }

    //-------------
    @Override
    public boolean addOrgAuditDoc(String orgId, File audit) {

        return false;
    }

    @Override
    public boolean removeOrgAuditDoc(String orgId) {
        String query = "update public.\"OrganisationInfo\" set \"auditDocument\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query,orgId);
        String query1 = "update public.\"OrganisationPoints\" set \"auditIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 15 where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);

        return true;    }

    @Override
    public boolean addOrgTaxRef(String orgId, String reference) {

    final String sql="update public.\"OrganisationInfo\" set \"taxReference\"=? WHERE \"orgId\"=?";
    jdbcTemplate.update(sql,reference,orgId);

        return true;
    }

    @Override
    public boolean removeOrgTaxRef(String orgId) {
        String query = "update public.\"OrganisationInfo\" set \"taxReference\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query,orgId);
        String query1 = "update public.\"OrganisationPoints\" set \"taxRefIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 5 where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);
        return true;
    }

    @Override
    public boolean addOrgAuditor(String orgId, String auditor) {

        final String sql="update public.\"OrganisationInfo\" set \"auditorDetails\" = ? where \"orgId\"=?";

        jdbcTemplate.update(sql,auditor,orgId);
        return true;
    }

    @Override
    public boolean removeOrgAuditor(String orgId) {

        String query = "update public.\"OrganisationInfo\" set \"auditorDetails\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query,orgId);

        String query1 = "update public.\"OrganisationPoints\" set \"auditorIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 10 where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);
        return true;
    }

    @Override
    public boolean addOrgCommittee(String orgId, String committee) {
        final String sql="update public.\"OrganisationInfo\"  set \"committeeDetails\" = ? where \"orgId\"=?";

        jdbcTemplate.update(sql,committee,orgId);
        return true;
    }

    @Override
    public boolean removeOrgCommittee(String orgId) {
        String query = "update public.\"OrganisationInfo\" set \"committeeDetails\" = null where \"orgId\" =?";
        jdbcTemplate.update(query,orgId);

        String query1 = "update public.\"OrganisationPoints\" set \"committeeIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 5 where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);
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
    public boolean addOrgSocials(String orgId, String type) {

        if(type.equals("facebook"))
        {
            final String sql="update public.\"OrganisationInfo\"  set facebook = ? where \"orgId\"=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        else if(type.equals("twitter"))
        {
            final String sql="update public.\"OrganisationInfo\" set twitter = ? where \"orgId\"=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        else
        {
            final String sql="update public.\"OrganisationInfo\"  set instagram = ? where \"orgId\"=?";

            jdbcTemplate.update(sql,type,orgId);
        }
        return true;
    }

    @Override
    public boolean removeOrgSocials(String orgId, String type) {

        if(type.equals("twitter")) {
            String query = "update public.\"OrganisationInfo\" set twitter = null where \"orgId\" = ?";
            jdbcTemplate.update(query,orgId);
            String query1 = "update public.\"OrganisationPoints\" set \"points\" = points-5 where \"orgId\" =?";

            jdbcTemplate.update(query1,orgId);
            String query2 = "update public.\"OrganisationPoints\" set \"twitterIsValid\" = false where \"orgId\" = ?";
            jdbcTemplate.update(query2,orgId);
        }
        if(type.equals("facebook")) {
            String query = "update public.\"OrganisationInfo\" set facebook = null where \"orgId\" = ?";
            jdbcTemplate.update(query,orgId);
            String query1 = "update public.\"OrganisationPoints\" set \"points\" = points-5 where \"orgId\" = ?";

            jdbcTemplate.update(query1,orgId);
            String query2 = "update public.\"OrganisationPoints\" set \"facebookIsValid\" = false where \"orgId\" = ?";
            jdbcTemplate.update(query2,orgId);
        }
        if(type.equals("instagram")) {
            String query = "update public.\"OrganisationInfo\" set instagram = null where \"orgId\" = ?";
            jdbcTemplate.update(query,orgId);
            String query1 = "update public.\"OrganisationPoints\" set \"points\" = points-5 where \"orgId\" = ?";

            jdbcTemplate.update(query1,orgId);
            String query2 = "update public.\"OrganisationPoints\" set \"instagramIsValid\" = false where \"orgId\" = ?";
            jdbcTemplate.update(query2,orgId);
        }
        return true;
    }

    @Override
    public boolean addOrgNGO(String orgId, String ngoNumber, Date ngoDate) {

        final String sql="update public.\"OrganisationInfo\"  set \"ngoNumber\" =? where \"orgId\"=?";
        jdbcTemplate.update(sql,ngoNumber,orgId);

        final String sql2="update public.\"OrganisationInfo\"  set \"ngoDate\"=? where \"orgId\"=?";

        jdbcTemplate.update(sql2,ngoDate,orgId);
        return false;
    }

    @Override
    public boolean removeOrgNGO(String orgId) {
        String query1 = "update public.\"OrganisationInfo\" set \"ngoNumber\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationInfo\" set \"ngoDate\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);

        String query4 = "update public.\"OrganisationPoints\" set \"ngoNoIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query4,orgId);

        String query5 = "update public.\"OrganisationPoints\" set \"points\" = points - 15 where \"orgId\" = ?";
        jdbcTemplate.update(query5,orgId);
        return true;
    }

    @Override
    public boolean addOrgEstDate(String orgId, Date date) {
        final String sql="update public.\"OrganisationInfo\"  set \"establishmentDate\" =? where \"orgId\"=?";
        jdbcTemplate.update(sql,date,orgId);
        return true;
    }

    @Override
    public boolean removeOrgEstDate(String orgId) {

        String query = "update public.\"OrganisationInfo\" set \"establishmentDate\" = null where \"orgId\" = ?";
        jdbcTemplate.update(query,orgId);
        String query1 = "update public.\"OrganisationPoints\" set \"estDateIsValid\" = false where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgId);
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points - 5 where \"orgId\" = ?";
        jdbcTemplate.update(query2,orgId);
        return true;
    }

    @Override
    public boolean adminValidateOrgEstDate(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"estDateIsValid\" = true where \"orgId\" = '" + orgid + "';";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = '" + orgid + "';";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);

        return true;
    }

    @Override
    public boolean adminValidateOrgNGO(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"ngoNoIsValid\" = true where \"orgId\" = ?";
        String query3 = "update public.\"OrganisationPoints\" set \"points\" = points + 15 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query3,orgid);
        return true;
    }

    @Override
    public boolean adminValidatOrgSocials(String orgid, String type) {
        if(type.equals("twitter")) {
            String query = "update public.\"OrganisationPoints\" set \"points\" = points+5 where \"orgId\" = ?";

            String query1 = "update public.\"OrganisationPoints\" set \"twitterIsValid\" = true where \"orgId\" = ?";
            jdbcTemplate.update(query,orgid);
            jdbcTemplate.update(query1,orgid);
        }
        if(type.equals("facebook")) {
            String query = "update public.\"OrganisationPoints\" set \"points\" = points+5 where \"orgId\" = ?";
            String query1 = "update public.\"OrganisationPoints\" set \"facebookIsValid\" = true where \"orgId\" = ?";
            jdbcTemplate.update(query,orgid);
            jdbcTemplate.update(query1,orgid);
        }
        if(type.equals("instagram")) {
            String query = "update public.\"OrganisationPoints\" set \"points\" = points+5 where \"orgId\" = ?";
            String query1 = "update public.\"OrganisationPoints\" set \"instagramIsValid\" = true where \"orgId\" =?";
            jdbcTemplate.update(query,orgid);
            jdbcTemplate.update(query1,orgid);
        }
        return true;
    }

    @Override
    public boolean adminValidateOrgDonationInfo(String orgid) {

        return false;
    }

    @Override
    public boolean adminValidateOrgCommittee(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"committeeIsValid\" = true where \"orgId\" = ?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateAuditor(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"auditorIsValid\" = true where \"orgId\" =?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateOrgTaxRef(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"taxRefIsValid\" = true where \"orgId\" = ?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 5 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateAuditDoc(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"auditIsValid\" = true where \"orgId\" =?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 15 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateNoOfImages(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"addressIsValid\" = true where \"orgId\" = ?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateAdress(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"addressIsValid\" = true where \"orgId\" = ?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" =?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    @Override
    public boolean adminValidateWebsite(String orgid) {
        String query1 = "update public.\"OrganisationPoints\" set \"websiteIsValid\" = true where \"orgId\" = ?";
        String query2 = "update public.\"OrganisationPoints\" set \"points\" = points + 10 where \"orgId\" = ?";
        jdbcTemplate.update(query1,orgid);
        jdbcTemplate.update(query2,orgid);
        return true;
    }

    public static void main(String[] args) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        OrganisationDASTemp temp = new OrganisationDASTemp(jdbcTemplate);
        Organisation org = temp.selectOrganisation("0c0585b5fd5b5be2d0127028727fa784");
        System.out.println(org.getOrgName());
    }

}
