package com.GiveaLot.givealot.User.dataclass;

public class User
{
    private String nameOfOrganisation;
    private String descriptionOFOrganisation;
    private String Email;
    private String Address;
    private String Url;
    private Boolean isVerified;
    private Boolean addressIsValid;

    public User()
    {

    }

    public User(String nameOfOrganisation,
                String descriptionOFOrganisation,
                String email,
                String address,
                String url,
                Boolean isVerified,
                Boolean addressIsValid)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        Email = email;
        this.Address = address;
        this.Url = url;
        this.isVerified = isVerified;
        this.addressIsValid = addressIsValid;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public Boolean getAddressIsValid() {
        return addressIsValid;
    }

    public String getAddress() {
        return Address;
    }

    public String getDescriptionOFOrganisation() {
        return descriptionOFOrganisation;
    }

    public String getEmail() {
        return Email;
    }

    public String getUrl() {
        return Url;
    }
}