package com.GiveaLot.givealot.Certificate.model;

public class Certificate {
    String nameOfOrganisation;
    String descriptionOFOrganisation;
    String email;
    String address;
    String url;
    int level;

    public Certificate(){
        //Dependant on what will be on the certificate
        this.nameOfOrganisation = "";
        this.descriptionOFOrganisation = "";
        this.email = "";
        this.address = "";
        this.url = "";
        this.level = 0;
    }

    public Certificate(String nameOfOrganisation, String descriptionOFOrganisation, String email, String address, String url, int level){
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        this.email = email;
        this.address = address;
        this.url = url;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public String getDescriptionOFOrganisation() {
        return descriptionOFOrganisation;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUrl() {
        return url;
    }

    public void setNameOfOrganisation(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public void setDescriptionOFOrganisation(String descriptionOFOrganisation) {
        this.descriptionOFOrganisation = descriptionOFOrganisation;
    }

    public void setEmail(String email) {
        email = email;
    }

    public void setAddress(String address) {
        address = address;
    }

    public void setUrl(String url) {
        url = url;
    }


}
