package com.GiveaLot.givealot.User.dataclass;

public class User
{
    private String nameOfOrganisation;
    private String descriptionOFOrganisation;
    private String Email;
    private String Address;
    private String image;

    private Boolean isVerified;


    public User()
    {

    }

    public User(String nameOfOrganisation,
                String descriptionOFOrganisation,
                String email,
                String address,
                String image,
                Boolean isVerified)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        Email = email;
        this.Address = address;
        this.image = image;
        this.isVerified = isVerified;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public Boolean getVerified() {
        return isVerified;
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
}