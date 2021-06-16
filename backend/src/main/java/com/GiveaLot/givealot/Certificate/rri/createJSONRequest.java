package com.GiveaLot.givealot.Certificate.rri;


public class createJSONRequest {
    public String name;
    public String description;
    public String serverUrl;

    public String imageUrl;


    public createJSONRequest(String name, String description, String url, String image)  {
        this.name = name;
        this.description = description;
        this.serverUrl = url;
        this.imageUrl = image;
    }


}
