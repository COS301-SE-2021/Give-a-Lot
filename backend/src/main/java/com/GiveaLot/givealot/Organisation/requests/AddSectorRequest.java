package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddSectorRequest {
    String sector;
    String adminId;

    public AddSectorRequest(@JsonProperty("sector") String sector, @JsonProperty("adminId") String adminId) {
        this.sector = sector;
        this.adminId = adminId;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
