package com.GiveaLot.givealot.Certificate.model;


public class Certificate {
    String dateCreated;
    String dateExpiry;
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

    public void setLevel(int level) {
        this.level = level;
    }
}
