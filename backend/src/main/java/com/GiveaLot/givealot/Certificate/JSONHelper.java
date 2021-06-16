package com.GiveaLot.givealot.Certificate;

import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.JSONException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class JSONHelper {

    public JSONHelper() {
    }

    public String createJSONObject(JSON data) throws JSONException {
        String metadata = "{\"name\":\"" + data.name + "\", \"description\":\"" + data.description + "\", \"serverUrl\":\"" + data.serverUrl + "\", \"verificationCode\":\"" + data.verificationCode + "\", \"imageUrl\" :\"" + data.imageUrl + "\"}";
        //System.out.println(metadata);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().disableHtmlEscaping().setLenient();
        Gson gson = builder.create();
        metadata = gson.toJson(data);
        //System.out.println(metadata);
        createFile(metadata);
        return metadata;
    }

    public String createFile(String obj) throws JSONException {
        try {
            FileWriter jsonObj = new FileWriter("C:\\generateCertificates\\JSON.txt");
            jsonObj.write(obj);
            jsonObj.close();
            return obj;
        } catch (IOException e) {
            throw new JSONException("JSON file could not be created");
        }
    }
}
