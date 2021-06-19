package com.GiveaLot.givealot.Search;

public class searchResponseJSON {
    private String org_id;
    private String org_name;
    private String org_short_description;
    private String org_sector;
    private String org_email;
    private String org_status;
    private String org_contactPerson;
    private String org_contactNumber;


    public searchResponseJSON(String org_id, String org_name,String org_short_description,String org_sector, String org_email, String org_status, String org_contactPerson, String org_contactNumber) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_short_description = org_short_description;
        this.org_sector = org_sector;
        this.org_email = org_email;
        this.org_status = org_status;
        this.org_contactPerson = org_contactPerson;
        this.org_contactNumber = org_contactNumber;
    }

    public String getOrg_email() {
        return org_email;
    }

    public String getOrg_id() {
        return org_id;
    }

    public String getOrg_contactNumber() {
        return org_contactNumber;
    }

    public String getOrg_contactPerson() {
        return org_contactPerson;
    }

    public String getOrg_name() {
        return org_name;
    }

    public String getOrg_sector() {
        return org_sector;
    }

    public String getOrg_short_description() {
        return org_short_description;
    }

    public String getOrg_status() {
        return org_status;
    }
}
