package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import com.GiveaLot.givealot.Organisation.dataclass.Status;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class OrganisationHelper {
    OrganisationHelper(){}

    public void addOrg(Organisation organisation) throws SQLException {

        try {


            String serverName = "127.0.0.1";
            //database name
            String mydatabase = "givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
           String query = "INSERT INTO Organisation(orgId, orgName, orgDescription, orgSector, orgEmail, status, password, contactPerson, contactNumber) VALUES (" + organisation.getOrgId() + "," + organisation.getOrgName() + "," + organisation.getOrgDescription() + "," + organisation.getOrgSector() + ", " + organisation.getOrgEmail() + ", " + organisation.getStatus() + ", " + organisation.getPassword() + ", " + organisation.getContactPerson() + ", " + organisation.getContactNumber() + ");";

            //execute the query
            ResultSet rs = state.executeQuery(query);

            try{
          //  rs.close();
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
            String mydatabase = "givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
        //    String query = "update organisations set status = 'Active' where orgId = " + organisation.getOrgId() + ";";

            //execute the query
         //   ResultSet rs = state.executeQuery(query);

            try{
          //      rs.close();
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
            String mydatabase = "givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
         //   String query = "update organisations set status = 'UnderInvestigation' where orgId = " + organisation.getOrgId() + ";";

            //execute the query
          //  ResultSet rs = state.executeQuery(query);

            try{
         //       rs.close();
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
            String mydatabase = "givealot";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";
            String password = "password123";
            System.out.println("Success");
            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Success");
            Statement state = connection.createStatement();

            //organisations is a table
        //    String query = "update organisations set status = 'Suspended' where orgId = " + organisation.getOrgId() + ";";

            //execute the query
        //    ResultSet rs = state.executeQuery(query);

            try{
       //         rs.close();
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

        String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/";

        String username = "iqvyaozz";
        String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

        //Setup connection
        Connection connection = DriverManager.getConnection(url, username, password);


        Statement state = connection.createStatement();

        Organisation organisation = new Organisation("23323", "Avtive","scsc","aaas","cdsmcld","ksmskc","mclsmc");

        //organisations is a table
        String query = "INSERT INTO Organisation(orgId, orgName, orgDescription, orgSector, orgEmail, status, password, contactPerson, contactNumber) VALUES(?,?,?,?,?,?,?,?,?)";

        //execute the query
        long id=0;
            try (PreparedStatement pstmt = connection.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, organisation.getOrgId());
                pstmt.setString(2, organisation.getOrgName());
                pstmt.setString(3, organisation.getOrgDescription());
                pstmt.setString(4, organisation.getOrgSector());
                pstmt.setString(5, organisation.getOrgEmail());
                pstmt.setString(6, organisation.getStatus().toString());
                pstmt.setString(7,  organisation.getPassword());
                pstmt.setString(8, organisation.getContactPerson());
                pstmt.setString(9, organisation.getContactNumber());


                int affectedRows = pstmt.executeUpdate();
                // check the affected rows
                if (affectedRows > 0) {
                    // get the ID back
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            id = rs.getLong(1);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        System.out.println("Success");
    }
}
