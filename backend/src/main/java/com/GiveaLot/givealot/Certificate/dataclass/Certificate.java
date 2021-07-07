package com.GiveaLot.givealot.Certificate.dataclass;

public class Certificate {

    String nameOfOrganisation;
    String descriptionOFOrganisation;
    String Email;
    String Address;
    String Url;
    Boolean isVerified;
    Boolean addressIsValid;

    public Certificate(){
        this.nameOfOrganisation = "";
        this.descriptionOFOrganisation = "";
        this.Email = "";
        this.Address = "";
        this.Url = "";
        this.isVerified = false;
        this.addressIsValid = false;
    }

    public Certificate(String nameOfOrganisation, String descriptionOFOrganisation, String Email, String Address, String Url){
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        this.Email = Email;
        this.Address = Address;
        this.Url = Url;
        this.isVerified = false;
        this.addressIsValid = false;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public String getDescriptionOFOrganisation() {
        return descriptionOFOrganisation;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getUrl() {
        return Url;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public Boolean getAddressIsValid() {
        return addressIsValid;
    }

    public void setNameOfOrganisation(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public void setDescriptionOFOrganisation(String descriptionOFOrganisation) {
        this.descriptionOFOrganisation = descriptionOFOrganisation;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public void setAddressIsValid(Boolean addressIsValid) {
        this.addressIsValid = addressIsValid;
    }



}
