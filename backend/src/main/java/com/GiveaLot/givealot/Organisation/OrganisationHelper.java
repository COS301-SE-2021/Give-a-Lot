package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import java.sql.*;

public class OrganisationHelper {
    OrganisationHelper(){}

    public void addOrg(Organisation organisation) throws SQLException {
        String mydatabase = "Givealot";
        try {

            //database name

            String url = "jdbc:postgresql://localhost/" + mydatabase;

            String username = "admin";
            String password = "admin";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "INSERT INTO /Givealot/.Organisations(OrgID, OrgName, OrgDescription, OrgSector, OrgEmail, Status, Password, ContactPerson, ContactNumber) VALUES (" + organisation.getOrgId() + "," + organisation.getOrgName() + "," + organisation.getOrgDescription() + "," + organisation.getOrgSector() + ", " + organisation.getOrgEmail() + ", " + organisation.getStatus() + ", " + organisation.getPassword() + ", " + organisation.getContactPerson() + ", " + organisation.getContactNumber() + ");";

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

    public void reactivateOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "127.0.0.1";
            //database name
            String mydatabase = "Givealot";

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update /Givealot/.Organisations set status = 'Active' where orgId = " + organisation.getOrgId() + ";";

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

    public void investigateOrg(Organisation organisation) throws SQLException {

        try {
            String serverName = "127.0.0.1";
            //database name
            String mydatabase = "Givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update /Givalot/ Organisations set status = 'UnderInvestigation' where orgId = " + organisation.getOrgId() + ";";

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
            String serverName = "127.0.0.1";
            //database name
            String mydatabase = "Givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
            String query = "update /Givalot/organisations set status = 'Suspended' where orgId = " + organisation.getOrgId() + ";";

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

      //  Class.forName("com.mysql.jdbc.Driver");

        String serverName = "sql4.freemysqlhosting.net:3306/sql4419888";
        //database name
        String mydatabase = "Givealot";

        String url="jdbc:postgresql://sql4.freemysqlhosting.net:3306/sql4419888";


        String username = "sql4419888";
        String password = "RE3E8mnLKV";
        System.out.println("Success");
        //Setup connection
        Connection connection = DriverManager.getConnection(url, username, password);

        System.out.println("Success");
        Statement state = connection.createStatement();
    }
}
