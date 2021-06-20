package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrganisationHelper {
    public OrganisationHelper(){}

    public void addOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "hanskeyn.db.elephantsql.com";
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

    public void reactivateOrg(Organisation organisation) throws SQLException {

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

    public void investigateOrg(Organisation organisation) throws SQLException {

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

    public void suspendOrg(Organisation organisation) throws SQLException {

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

        Organisation org = new Organisation("The Old Orgss", "We are old heress", "Diseasess", "oldorg@gmail.comss","password", "Mr. Old Orgss", "0823322422");
        OrganisationHelper helper = new OrganisationHelper();
        helper.addOrg(org);

    }
}
