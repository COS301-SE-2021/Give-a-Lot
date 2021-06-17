package com.GiveaLot.givealot.Organisation;

import com.GiveaLot.givealot.Organisation.dataclass.Organisation;
import java.sql.*;

public class OrganisationHelper {
    OrganisationHelper(){}

    public void addOrgToDatabase(Organisation organisation) throws SQLException {

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
            String query = "insert into organisations(orgId, orgName, orgDescription, orgSector, orgEmail, status, password, contactPerson, contactNumber) values (" + organisation.getOrgId() + "," + organisation.getOrgName() + "," + organisation.getOrgDescription() + "," + organisation.getOrgSector() + ", " + organisation.getOrgEmail() + ", " + organisation.getStatus() + ", " + organisation.getPassword() + ", " + organisation.getContactPerson() + ", " + organisation.getContactNumber() + ");";

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
}
