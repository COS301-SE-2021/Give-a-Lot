package com.GiveaLot.givealot.Certificate.dataclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "certificate"
)
public class Certificate {
    @Column(
            name = "dateCreated",
            updatable = true,
            nullable = false
    )
    String dateCreated;
    @Column(
            name = "dateExpiry",
            updatable = true,
            nullable = false
    )
    String dateExpiry;
    @Id
    @Column(
            name = "orgId",
            updatable = false,
            nullable = false
    )
    long org_id;

    @Column(
            name = "orgRenewal",
            updatable = false,
            nullable = false
    )
    boolean orgRenewal;

    @Column(
            name = "adminRenewal",
            updatable = true,
            nullable = false
    )
    boolean adminRenewal;

    @Column(
            name = "certLevel",
            updatable = true,
            nullable = false
    )
    int level;

    public Certificate(){
        //Dependant on what will be on the certificate
        this.dateCreated = "";
        this.dateExpiry = "";
        this.level = 0;
    }

    public Certificate(String dateCreated, String dateExpiry, int level){
        this.dateCreated = dateCreated;
        this.dateExpiry = dateExpiry;
        this.level = 0;
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

    public int getLevel() {
        return level;
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

    public void setLevel(int level) {
        this.level = level;
    }
}
