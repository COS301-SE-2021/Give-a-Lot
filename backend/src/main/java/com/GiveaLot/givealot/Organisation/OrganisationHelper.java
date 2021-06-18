package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class OrganisationHelper {
    OrganisationHelper(){}

    public void addOrg(Organisation organisation) throws SQLException {

        try {

            String serverName = "hansken.db.elephantsql.com";
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();
            System.out.println("Success");
            //organisations is a table
            //String query = "create database newDB;";
            String query = "insert into public.\"Organisations\"(\"orgName\", \"orgDescription\", \"orgSector\", \"orgEmail\", \"orgId\", status, password, \"contactPerson\", \"contactNumber\") values ('" + organisation.getOrgName() + "','" + organisation.getOrgDescription() + "','" + organisation.getOrgSector() + "','" + organisation.getOrgEmail() + "','" + organisation.getOrgId() + "','"+ organisation.getStatus().toString() + "','" + organisation.getPassword() + "','" + organisation.getContactPerson() + "','" + organisation.getContactNumber() + "');";
            System.out.println(query);
            System.out.println("Success");
            //execute the query
            ResultSet rs = state.executeQuery(query);
            System.out.println("Success");
            try{
            rs.close();
            state.close();
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Success");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void reactivateOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "hansken.db.elephantsql.com";
            //database name
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/" + mydatabase;

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();
            System.out.println("Success");
            //organisations is a table
            String query = "update Organisation set status = 'Active' where orgId = " + organisation.getOrgId() + ";";
            System.out.println("Success");
            //execute the query
            ResultSet rs = state.executeQuery(query);
            System.out.println("Success");
            try{
                rs.close();
                state.close();
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Success");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void investigateOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "hansken.db.elephantsql.com";
            //database name
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/" + mydatabase;

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update Organisations set status = 'UnderInvestigation' where orgId = " + organisation.getOrgId() + ";";

            //execute the query
            ResultSet rs = state.executeQuery(query);

            try{
                rs.close();
                state.close();
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Success");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public void suspendOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "hansken.db.elephantsql.com";
            //database name
            String mydatabase = "Givealot";
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/" + mydatabase;

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update iqvyaozz.Givealot.Organisations set status = 'Suspended' where orgId = " + organisation.getOrgId() + ";";

            //execute the query
            ResultSet rs = state.executeQuery(query);

            try{
                rs.close();
                state.close();
            } catch(SQLException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Success");
        }
        catch (Exception e){
            throw new SQLException("Exception: Insert into database could not be fulfilled");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

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

        Organisation org = new Organisation("The CG Charity", "Weve been here since the end", "Diseases", "clgcharity@gmail.com","password", "Mrs. Charity Woman", "0823322445");
        OrganisationHelper helper = new OrganisationHelper();
        helper.addOrg(org);
    }
}
