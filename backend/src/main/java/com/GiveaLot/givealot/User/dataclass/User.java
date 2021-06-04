package com.GiveaLot.givealot.User.dataclass;

public class User
{
    private String nameOfOrganisation;
    private String descriptionOFOrganisation;
    private String Email;
    private String Address;
    private String image;
    private String source_name;
    private String source_image;
    private String sector;
    private Boolean isVerified;
    private Boolean addressIsValid;

    public User()
    {

    }

    public User(String nameOfOrganisation,
                String descriptionOFOrganisation,
                String email,
                String address,
                String image,
                String source_image,
                String source_name,
                String sector,
                Boolean isVerified,
                Boolean addressIsValid)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        Email = email;
        this.Address = address;
        this.image = image;
        this.source_image = source_image;
        this.source_name = source_name;
        this.sector = sector;
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

    public String getImage() {
        return image;
    }

    public String getSource_image() {
        return source_image;
    }

    public String getSource_name() {
        return source_name;
    }
    public String getSector() {
        return sector;
    }
}