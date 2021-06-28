package com.GiveaLot.givealot.Browse;

import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.mockData.mockUsers;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BrowseServiceImp implements BrowseService
{
    /*
    *   @Todo get user preferred organisations by learning the user's usage patterns
    *   @Todo filter by country, sector, distance from you (near client or further away)
    * */
    public browseResponse browse(browseRequest request) throws Exception
    {

        if(request == null)
        {
            throw new Exception("Exception: browse request object not instantiated");
        }
        /*the helper is responsible for the database query logic*/
        BrowseHelper browseHelper = new BrowseHelper();
        browseResponse browseResponse = new browseResponse();

        try
        {
            /*create a response object which will set the JSON object*/
            browseResponse.setOrganisations(browseHelper.getOrganisations());
            System.out.println("Browse: success");
            return browseResponse;
        }
        catch (Exception e)
        {
            System.out.println("error getting organisations");/*for the developer*/
            throw new Exception(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        /**/
        try
        {
            /*check for a null request*/
            BrowseServiceImp BrowseServiceImp = new BrowseServiceImp();
            //BrowseServiceImp.browse(null);

            /*check for a non-null request*/
            BrowseServiceImp.browse(new browseRequest());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
