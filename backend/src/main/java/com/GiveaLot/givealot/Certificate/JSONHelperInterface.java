package com.GiveaLot.givealot.Certificate;

import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.JSONException;


public interface JSONHelperInterface {

    /**
     * Generates a new Certificate .
     *
     * @param data:JSON Object
     * @return String that holds the created JSON
     * @throws JSONException    if JSON could not be generated for some reason
     */


    String createJSONObject(JSON data) throws JSONException;
    String createFile(String obj) throws JSONException;

}
