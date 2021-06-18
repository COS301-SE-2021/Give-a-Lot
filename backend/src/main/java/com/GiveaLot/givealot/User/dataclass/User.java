package com.GiveaLot.givealot.User.dataclass;

import java.util.List;

public class User
{
    private String nameOfOrganisation;
    private String date_founded;
    private List<String> gallery_images;
    private String descriptionOFOrganisation;
    private String Email;
    private String Address;
    private String url_logo;
    private String source_name;
    private String source_image;
    private String sector;
    private Boolean isVerified;
    private Boolean addressIsValid;
    private String sloganOfOrganisation;
    private String shortDescription;
    private String organisation_id;

    public User()
    {

    }

    /* constructor used to get browse info - list */
    public User(String nameOfOrganisation,String sloganOfOrganisation,String shortDescription,String sector,Boolean isVerified,String url_logo,String organisation_id)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.sloganOfOrganisation = sloganOfOrganisation;
        this.shortDescription = shortDescription;
        this.sector = sector;
        this.isVerified = isVerified;
        this.url_logo = url_logo;
        this.organisation_id = organisation_id;
    }

    /* constructor used to get detailed view of the organisation */
    public User(String nameOfOrganisation, String descriptionOFOrganisation, String date_founded, List<String> gallery_images, String organisation_id)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        this.date_founded = date_founded;
        this.gallery_images = gallery_images;
        this.organisation_id = organisation_id;
    }

    public User(String nameOfOrganisation,
                String descriptionOFOrganisation,
                String email,
                String address,
                String url_logo,
                String source_image,
                String source_name,
                String sector,
                Boolean isVerified,
                Boolean addressIsValid,
                String sloganOfOrganisation,
                String shortDescription,
                String organisation_id)
    {
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        Email = email;
        this.Address = address;
        this.url_logo = url_logo;
        this.source_image = source_image;
        this.source_name = source_name;
        this.sector = sector;
        this.isVerified = isVerified;
        this.addressIsValid = addressIsValid;
        this.sloganOfOrganisation = sloganOfOrganisation;
        this.shortDescription = shortDescription;
        this.organisation_id = organisation_id;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public String getOrganisation_id() {
        return organisation_id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getSloganOfOrganisation() {
        return sloganOfOrganisation;
    }

    public List<String> getGallery_images() {
        return gallery_images;
    }

    public String getDate_founded() {
        return date_founded;
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

    public String getUrl_logo() {
        return url_logo;
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