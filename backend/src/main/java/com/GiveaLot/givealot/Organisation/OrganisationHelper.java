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
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();
            System.out.println("Success");
            //organisations is a table
            String query = "insert into Organisation(orgId, orgName, orgDescription, orgSector, orgEmail, status, password, contactPerson, contactNumber) values (" + organisation.getOrgId() + "," + organisation.getOrgName() + "," + organisation.getOrgDescription() + "," + organisation.getOrgSector() + ", " + organisation.getOrgEmail() + ", " + organisation.getStatus().toString() + ", " + organisation.getPassword() + ", " + organisation.getContactPerson() + ", " + organisation.getContactNumber() + ");";
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
            String query = "update organisations set status = 'UnderInvestigation' where orgId = " + organisation.getOrgId() + ";";

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
            String query = "update organisations set status = 'Suspended' where orgId = " + organisation.getOrgId() + ";";

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
//        String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/";
//
//        String username = "iqvyaozz";
//        String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
//        System.out.println("Success");
//        //Setup connection
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        System.out.println("Success");
//        Statement state = connection.createStatement();

        Organisation org = new Organisation("The OG Charity", "We've been here since the start", "Diseases", "ogcharity@gmail.com","password", "Mr. Charity Guy", "0823322444");
        OrganisationHelper helper = new OrganisationHelper();
        helper.addOrg(org);
    }
}
