package com.GiveaLot.givealot.Organisation.json;

public class get_OrganisationResponseJSON
{
    private String http_code;
    private String response_message;
    private String org_id;
    private String org_name;
    private String org_description;


    public get_OrganisationResponseJSON(String http_code, String response_message, String org_id, String org_name, String org_description)
    {
        this.http_code = http_code;
        this.response_message = response_message;
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_description = org_description;
    }

    public void setHttp_code(String http_code) {
        this.http_code = http_code;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public String getHttp_code() {
        return http_code;
    }

    public String getResponse_message() {
        return response_message;
    }

    public String getOrg_id()
    {
        return org_id;
    }

    public void setOrg_id(String org_id)
    {
        this.org_id = org_id;
    }

    public String getOrg_name()
    {
        return org_name;
    }

    public void setOrg_name(String org_name)
    {
        this.org_name = org_name;
    }

    public String getOrg_description()
    {
        return org_description;
    }

    public void setOrg_description(String org_description)
    {
        this.org_description = org_description;
    }
}