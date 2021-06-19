package com.GiveaLot.givealot.Browse;

import com.GiveaLot.givealot.Browse.rri.browseResponseJSON;
import com.GiveaLot.givealot.Search.searchResponseJSON;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BrowseHelper {


    List<browseResponseJSON> getOrganisations()throws SQLException
    {
        try
        {
            String url = "jdbc:postgresql://hansken.db.elephantsql.com:5432/iqvyaozz";
            String username = "iqvyaozz";
            String password = "JMDPprQmLVegi673UQgH93aNEOSvt2K1";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement state = connection.createStatement();

            String sql_query = "SELECT * FROM public.\"Organisations\";";
            System.out.println(sql_query);
            ResultSet rs = state.executeQuery(sql_query);

            List<browseResponseJSON> organisationsList = new LinkedList<>();
            while(rs.next())
            {
                String tmp_org_id = rs.getString("orgId");
                String tmp_org_name = rs.getString("orgName");
                String tmp_orgDescription = rs.getString("orgDescription");
                String tmp_orgSector = rs.getString("orgSector");


                organisationsList.add(new browseResponseJSON(tmp_org_id,tmp_org_name,tmp_orgDescription,"no slogan",tmp_orgSector,"",false));
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
}
