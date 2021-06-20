package com.GiveaLot.givealot.Organisation;

public class get_OrganisationResponseJSON
{
    private String org_id;
    private String org_name;
    private String org_description;

    public get_OrganisationResponseJSON(String org_id, String org_name, String org_description)
    {
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_description = org_description;
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