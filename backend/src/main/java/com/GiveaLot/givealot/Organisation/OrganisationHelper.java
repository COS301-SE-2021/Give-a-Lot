package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrganisationHelper {
    public OrganisationHelper(){}


    public void orgExists(Organisation organisation) throws SQLException, OrgException {
        String serverName = "hansken.db.elephantsql.com";
        String mydatabase = "Givealot";
        String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

        String username = "iqvyaozz";
        String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
        System.out.println("Success");
        //Setup connection
        Connection connection = DriverManager.getConnection(url, username, password);

        //Create statement
        Statement state = connection.createStatement();

        String existsQuery = "select \"orgId\" from public.\"Organisations\";";

        ResultSet exists = state.executeQuery(existsQuery);

        List<String> ids = new ArrayList<>();

        int x = 0;

        while(exists.next()){
            ids.add(exists.getString("orgId"));
            x++;
        }


        try {

            for (int i = 0; i < x; i++) {
                if (organisation.getOrgId().equals(ids.get(i))) {
                    //System.out.println("exception");
                    throw new OrgException("Exception: Organisation is already registered");

//                } else {
//                    System.out.println(organisation.getOrgId() + " / " + ids.get(i));
//                }
                }
            }
        }
        catch(OrgException e) {
            throw new OrgException("Exception: Organisation is already registered");
        }

    }

    public void addOrg(Organisation organisation) throws SQLException, OrgException {

        if (organisation.getOrgId()==null){
            throw new OrgException("Exception: Organisation data is null");
        }

        try {

            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            java.util.Date dateCurrent = new Date();
            java.util.Date dateEx = new Date();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            String dateCreated = format.format(dateCurrent);

            int year = dateCurrent.getYear();
            dateEx.setYear(year+1);
            String dateExpiry = format.format(dateEx);


            //organisations is a table
            //String query = "create database newDB;";
            String query1 = "insert into public.\"Organisations\"(\"orgName\", \"orgDescription\", \"orgSector\", \"orgEmail\", \"orgId\", status, password, \"contactPerson\", \"contactNumber\") values ('" + organisation.getOrgName() + "','" + organisation.getOrgDescription() + "','" + organisation.getOrgSector() + "','" + organisation.getOrgEmail() + "','" + organisation.getOrgId() + "','"+ organisation.getStatus().toString() + "','" + organisation.getPassword() + "','" + organisation.getContactPerson() + "','" + organisation.getContactNumber() + "');";
            String query2 = "insert into public.\"OrganisationPoints\"(\"orgId\") values ('" + organisation.getOrgId() + "');";
            String query3 = "insert into public.\"OrganisationInfo\"(\"orgId\") values ('" + organisation.getOrgId() + "');";
            String query4 = "insert into public.\"Certificate\"(\"orgId\", \"dateCreated\", \"dateExpiry\") values ('" + organisation.getOrgId() + "','" + dateCreated + "','" + dateExpiry +"');";
            System.out.println(query4);

            //execute the query
            state.executeUpdate(query1);
            state.executeUpdate(query2);
            state.executeUpdate(query3);
            state.executeUpdate(query4);

            System.out.println("Successfully Executed Update");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void reactivateOrg(Organisation organisation) throws SQLException, OrgException {

        Status status = Status.Active;

        if (organisation.getStatus()==status){
            throw new OrgException("Exception: Organisation is already active");
        }

        try {
            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update public.\"Organisations\" set status = 'Active' where \"orgId\" = '" + organisation.getOrgId() + "';";
            //System.out.println(query);

            //execute the query
            state.executeUpdate(query);

            System.out.println("Successfully Executed Update");

        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void investigateOrg(Organisation organisation) throws SQLException, OrgException {

        Status status = Status.UnderInvestigation;
        if (organisation.getStatus()==status){
            throw new OrgException("Exception: Organisation is already under investigation");
        }

        try {
            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update public.\"Organisations\" set status = 'UnderInvestigation' where \"orgId\" = '" + organisation.getOrgId() + "';";
            //System.out.println(query);

            //execute the query
            state.executeUpdate(query);

            System.out.println("Successfully Executed Update");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void suspendOrg(Organisation organisation) throws SQLException, OrgException {

        Status status = Status.Suspended;
        if (organisation.getStatus()==status){
            throw new OrgException("Exception: Organisation is already suspended");
        }

        try {
            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update public.\"Organisations\" set status = 'Suspend' where \"orgId\" = '" + organisation.getOrgId() + "';";
            //System.out.println(query);

            //execute the query
            state.executeUpdate(query);

            System.out.println("Successfully Executed Update");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, OrgException {

//        String serverName = "hansken.db.elephantsql.com";
//        String mydatabase = "Givealot";
//        String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";
//
//        String username = "iqvyaozz";
//        String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
//        System.out.println("Success");
//        //Setup connection
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        System.out.println("Success");
//        Statement state = connection.createStatement();
//        //String query = "SELECT SCHEMA_NAME FROM information_schema.schemata;";
//        String query = "select * from public.\"Organisations\"";
//        //String query = "SELECT table_name FROM information_schema.TABLES where TABLE_NAME = 'Organisations';";
//        System.out.println(query);
//        System.out.println("Success");
//
//        ResultSet rs = state.executeQuery(query);
//
//        while (rs.next()) {
//            System.out.println(rs.getString(1));
//        }

        Organisation org = new Organisation("The Old Orgssss", "We are old heressss", "Diseasess", "oldorg@gmail.comssss","password", "Mr. Old Orgsss", "0823322423");
        OrganisationHelper helper = new OrganisationHelper();
        helper.orgExists(org);


    public boolean user_isAdmin(String userID)
    {
        /*needs implementing*/
        return true;
    }
}
