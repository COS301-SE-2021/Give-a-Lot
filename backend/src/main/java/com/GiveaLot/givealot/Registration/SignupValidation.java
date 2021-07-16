package com.GiveaLot.givealot.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupValidation {

    /** Constructor **/
    public SignupValidation(){

    }

    /** Makes sure names conform to database constraints **/
    public boolean validateNames(String FName, String LName){

        if (FName.length()>100 || FName.length()==0){
            return false;
        }

        if (LName.length()>100 || LName.length()==0){
            return false;
        }

        return true;
    }

    /** Makes sure organisation names conform to database constraints **/
    public boolean validateOrgNames(String orgName){

        if (orgName.length()>150 || orgName.length()==0){
            return false;
        }

        return true;
    }

    /** Makes sure contact person names conform to database constraints **/
    public boolean validateContactPerson(String contact){

        if (contact.length()>150 || contact.length()==0){
            return false;
        }

        return true;
    }

    /** Makes sure contact person numbers are valid **/
    public boolean validateContactNumber(String contact){

        String regex = "^(?=.*[0-9]).{10}$";

        Pattern regexCheck = Pattern.compile(regex);

        Matcher validator = regexCheck.matcher(contact);

        if (validator.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    /** Makes sure organisation slogans conform to database constraints **/
    public boolean validateOrgSlogan(String slogan){

        if (slogan.length()>200 || slogan.length()==0){
            return false;
        }

        return true;
    }

    /** Makes sure descriptions conform to database constraints **/
    public boolean validateOrgDescription(String description){

        if (description.length()>500 || description.length()==0){
            return false;
        }
        return true;
    }

    /** Makes sure password matches the appropriate regex **/
    public boolean validatePassword(String password){

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        Pattern regexCheck = Pattern.compile(regex);

        Matcher validator = regexCheck.matcher(password);

        if (validator.matches()){
            return true;
        }
        else
        {
            return false;
        }
    }

    /** Makes sure passwords match one another **/
    public boolean validateMatchingPasswords(String password, String passwordRep){

        if (!password.equals(passwordRep)){
            return false;
        }
        return true;
    }

    /** Makes sure the email address is valid **/
    public boolean validateEmail(String email){

        String regex = "^(.+)@(.+)$";

        Pattern regexCheck = Pattern.compile(regex);

        Matcher validator = regexCheck.matcher(email);

        if(validator.matches())
        {
            return true;
        }
        else{
            return false;
        }
    }

    /** Makes sure the email is not already in the database **/
    public boolean validateUserEmailAvailable(String email) throws SQLException {

        try {
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            String query = "select * from public.\"Users\" where email = '" + email + "';";

            ResultSet rs = state.executeQuery(query);

            List<String> emails = new ArrayList<>();

            int x = 0;

            while (rs.next())
            {
                emails.add(rs.getString("email"));
                x++;
            }

            for (int i = 0; i < x; i++) {
                if (email.equals(emails.get(i))) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            throw new SQLException("Exception: Select from database could not be fulfilled \n" + e.getMessage());
        }

    }

    /** Makes sure the email is not already in the database **/
    public boolean validateOrgEmailAvailable(String email) throws SQLException {

        try {
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";

            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";

            //Setup connection
            Connection connection = DriverManager.getConnection(url, username, password);

            //Create statement
            Statement state = connection.createStatement();

            String query = "select * from public.\"Organisations\" where \"orgEmail\" = '" + email + "';";

            ResultSet rs = state.executeQuery(query);

            List<String> emails = new ArrayList<>();

            int x = 0;

            while (rs.next()) {
                emails.add(rs.getString("email"));
                x++;
            }

            for (int i = 0; i < x; i++) {
                if (email.equals(emails.get(i))) {
                    return false;
                }
            }
            return true;
        }
        catch (Exception e){
            throw new SQLException("Exception: Select from database could not be fulfilled" + e.getMessage());
        }

    }
}
