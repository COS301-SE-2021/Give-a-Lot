package com.GiveaLot.givealot.Search;

import com.GiveaLot.givealot.Organisation.OrganisationHelper;
import com.GiveaLot.givealot.Organisation.dataclass.Organisation;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
/*
* Note to self: this class will
* be used to connect to the database and perform all necessary
* queries required by service implement
* */
public class searchHelper {

    /*
    * Query the database and return all organisations
    * matching the search string
    * */
    List<searchResponseJSON> get_organisations_by_name(String org_name) throws SQLException
    {
        try
        {
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";
            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement state = connection.createStatement();

            String sql_query = "SELECT * FROM public.\"Organisations\" WHERE \"orgName\" LIKE '%"+org_name+"%';";
            System.out.println(sql_query);
            ResultSet rs = state.executeQuery(sql_query);


            System.out.println("results from query");
            List<searchResponseJSON> organisationsList = new LinkedList<>();
            while(rs.next())
            {
                String tmp_org_id = rs.getString("orgId");
                String tmp_org_name = rs.getString("orgName");
                String tmp_orgDescription = rs.getString("orgDescription");
                String tmp_orgSector = rs.getString("orgSector");
                String tmp_org_status = rs.getString("status");
                String tmp_orgEmail = rs.getString("orgEmail");
                String tmp_orgPassword = rs.getString("password");
                String tmp_contactPerson = rs.getString("contactPerson");
                String tmp_contactNumber = rs.getString("contactNumber");

                System.out.println(tmp_org_id + " " + tmp_org_name + " " + tmp_orgDescription + " " + tmp_orgSector + " " + tmp_orgEmail + " " + tmp_orgPassword + " " + tmp_contactPerson + " " + tmp_contactNumber);
                organisationsList.add(new searchResponseJSON(tmp_org_id,tmp_org_name,tmp_orgDescription,tmp_orgSector,tmp_orgEmail,tmp_org_status,tmp_contactPerson,tmp_contactNumber));
            }

            if(organisationsList.size() == 0)
                return null;
            else return organisationsList;
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new SQLException("Exception: database could not be reached!");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("search test");
        try
        {
            boolean test_db = false;
            if(test_db)
            {
                List<Organisation> organisationsList = new LinkedList<>();
                organisationsList.add(new Organisation("givers of hope", "the givers of hope short description word limited", "youth", "givers@hope.com", "123password", "Ragnar Lothbrok", "0723456789"));
                organisationsList.add(new Organisation("Access Isreal", "Giving you the freedom", "embassador", "Isreal@Access.com", "123password", "Peter Mohammed", "0223456789"));
                organisationsList.add(new Organisation("AIDS-Free World", "living your best life with your status", "health", "AIDSFree@World.com", "123password", "Michelle Cole", "0123456789"));
                organisationsList.add(new Organisation("Global Deaf Connection", "we at the organisation will always hear you shame", "youth", "Global@Connection.com", "123password", "Rudock Miller", "0323456789"));
                organisationsList.add(new Organisation("G3ict – Global Initiative for Inclusive Technologies", "We at the gobal nton we are about technology and empowering the digital age", "tehonolgy", "G3ict@Initiative.com", "123password", "Bill Doors", "0733456789"));
                organisationsList.add(new Organisation("Save The Children", "We at save the children we provide children with the safety and care their fragile minds deserve.", "children", "Children@Save.com", "123password", "Christine Miller", "0223456789"));
                organisationsList.add(new Organisation("International Paralympic Committee", "we ensure equal rights to the physically limited in olympics", "sports", "Paralympic@International.com", "123password", "Joyce Maradona", "0743456789"));
                organisationsList.add(new Organisation("Society for Mental Health Care", "the society for mental health care helps tackle depression in our society", "health", "Mental@Society.com", "123password", "Agnes Muranga", "0793456789"));

                OrganisationHelper OrganisationHelper = new OrganisationHelper();
                OrganisationHelper.addOrg(organisationsList.get(6));
                OrganisationHelper.addOrg(organisationsList.get(7));
            }

            searchHelper searchHelper = new searchHelper();
            searchHelper.get_organisations_by_name("the");

        }
        catch (Exception e)
        {
            System.out.println("Test failed " + e);
        }

        System.out.println("Test ended");
    }
}
