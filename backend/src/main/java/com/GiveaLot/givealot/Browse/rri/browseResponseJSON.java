package com.GiveaLot.givealot.Browse.rri;

public class browseResponseJSON
{
    private String org_id;
    private String org_name;
    private String org_short_description;
    private String org_slogan;
    private String org_sector;
    private String org_logo_url;
    private boolean org_is_verified;

    public browseResponseJSON(String org_id, String org_name, String org_short_description, String org_slogan, String org_sector, String org_logo_url, boolean org_is_verified) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_short_description = org_short_description;
        this.org_slogan = org_slogan;
        this.org_sector = org_sector;
        this.org_logo_url = org_logo_url;
        this.org_is_verified = org_is_verified;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_short_description() {
        return org_short_description;
    }

    public void setOrg_short_description(String org_short_description) {
        this.org_short_description = org_short_description;
    }

    public String getOrg_slogan() {
        return org_slogan;
    }

    public void setOrg_slogan(String org_slogan) {
        this.org_slogan = org_slogan;
    }

    public String getOrg_sector() {
        return org_sector;
    }

    public void setOrg_sector(String org_sector) {
        this.org_sector = org_sector;
    }

    public String getOrg_logo_url() {
        return org_logo_url;
    }

    public void setOrg_logo_url(String org_logo_url) {
        this.org_logo_url = org_logo_url;
    }

    public boolean getOrg_is_verified() {
        return org_is_verified;
    }

    public void setOrg_is_verified(boolean org_is_verified) {
        this.org_is_verified = org_is_verified;
    }
}
