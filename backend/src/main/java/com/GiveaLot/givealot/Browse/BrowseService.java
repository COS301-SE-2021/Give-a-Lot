package com.GiveaLot.givealot.Browse;
import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;

public interface BrowseService {
    browseResponse browse(browseRequest request);
}
