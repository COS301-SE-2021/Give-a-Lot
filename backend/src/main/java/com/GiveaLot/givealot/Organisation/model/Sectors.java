package com.GiveaLot.givealot.Organisation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@Entity
@Table(name="sectors")
public class Sectors {

    @Id
    String sector;
    int organisations;

    public Sectors() {

    }


    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getOrganisations() {
        return organisations;
    }

    public void setOrganisations(int organisations) {
        this.organisations = organisations;
    }
}
