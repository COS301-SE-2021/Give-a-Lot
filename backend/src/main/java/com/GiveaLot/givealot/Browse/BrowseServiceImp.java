package com.GiveaLot.givealot.Browse;

import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.User.dataclass.User;
import com.GiveaLot.givealot.User.mockData.mockUsers;

import java.util.LinkedList;
import java.util.List;

public class BrowseServiceImp implements BrowseService
{
    public browseResponse search(browseRequest request)
    {
        /*
        * Exception handling left for later
        * */

        mockUsers mockusers = new mockUsers();
        browseResponse browseResponse = new browseResponse();
        browseResponse.setOrganisations(mockusers.getUsersListView());
        return browseResponse;
    }
}
