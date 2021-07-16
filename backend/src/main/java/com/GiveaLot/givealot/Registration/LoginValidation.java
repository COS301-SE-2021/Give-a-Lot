package com.GiveaLot.givealot.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginValidation {
    /** Makes sure the email is not already in the database **/
    public boolean validateOrgLogin(String email, String passsword) throws SQLException {

        try {
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            String query = "select * from public.\"Organisations\" where email = '" + email + "';";

            ResultSet rs = state.executeQuery(query);

            List<String> emails = new ArrayList<>();
            List<String> passwords = new ArrayList<>();

            int x = 0;

            while (rs.next()) {
                emails.add(rs.getString("email"));
                passwords.add(rs.getString("password"));
                x++;
            }

            for (int i = 0; i < x; i++) {
                if (email.equals(emails.get(i))) {
                    return false;
                }
            }
            for (int i = 0; i < x; i++) {
                if (passsword.equals(passwords.get(i))) {
                    return false;
                }
            }

            /** Start session **/
            return true;
        }
        catch (Exception e){
            throw new SQLException("Exception: Select from database could not be fulfilled");
        }
    }
}
