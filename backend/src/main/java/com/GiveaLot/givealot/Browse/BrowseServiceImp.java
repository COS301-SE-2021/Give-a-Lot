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
    public browseResponse browse(browseRequest request)
    {
        /*
        * Exception handling left for later
        * */

        String request_type = "list";

        mockUsers mockusers = new mockUsers();
        browseResponse browseResponse = new browseResponse();
        browseResponse.setOrganisations(mockusers.getUsersListView());
        return browseResponse;
    }
}
