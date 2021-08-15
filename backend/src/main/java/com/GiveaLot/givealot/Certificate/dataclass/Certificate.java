package com.GiveaLot.givealot.Certificate.dataclass;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(
        name = "certificate"
)
public class Certificate {
    @Column(
            name = "date_created",
            updatable = true,
            nullable = false
    )
    String dateCreated;
    @Column(
            name = "date_expiry",
            updatable = true,
            nullable = false
    )
    String dateExpiry;
    @Id
    @Column(
            name = "org_id",
            updatable = false,
            nullable = false
    )
    long org_id;

    @Column(
            name = "org_renewal",
            updatable = false,
            nullable = false
    )
    boolean orgRenewal;

    @Column(
            name = "admin_renewal",
            updatable = true,
            nullable = false
    )
    boolean adminRenewal;

    @Column(
            name = "points",
            updatable = true,
            nullable = false
    )
    int points;

    public Certificate(){
        //Dependant on what will be on the certificate
        this.dateCreated = "";
        this.dateExpiry = "";
        this.points = 0;
    }

    public Certificate(String dateCreated, String dateExpiry, int level){
        this.dateCreated = dateCreated;
        this.dateExpiry = dateExpiry;
        this.points = level;
        this.adminRenewal = true;
        this.orgRenewal = true;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public int getPoints() {
        return points;
    }

    public long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(long org_id) {
        this.org_id = org_id;
    }

    public boolean isOrgRenewal() {
        return orgRenewal;
    }

    public void setOrgRenewal(boolean orgRenewal) {
        this.orgRenewal = orgRenewal;
    }

    public boolean isAdminRenewal() {
        return adminRenewal;
    }

    public void setAdminRenewal(boolean adminRenewal) {
        this.adminRenewal = adminRenewal;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
