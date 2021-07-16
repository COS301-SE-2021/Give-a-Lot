package com.GiveaLot.givealot.Organisation.dataclass;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

public class Organisation {

    private String orgName;
    private String slogan;
    private String orgDescription;
    private String orgSector;
    private String orgEmail;
    private String orgId;
    private Status status;
    private String password;
    private String contactPerson;
    private String contactNumber;

    //Email verification

    private Boolean isVerified;

    //Extra information

    private String address;
    private Date dateFounded;
    private String image;
    private String NGONumber;
    private List<String> galleryImages;
    private String longDescription;
    private int numberOfReports;

    //Data for points

    private int points;
    private Boolean addressIsValid;
    private Boolean dateIsValid;
    private Boolean imageProvided;
    private Boolean ngoNoProvided;
    private Boolean fiveImagesProvided;
    private Boolean tenImagesProvided;
    private Boolean longDescriptionProvided;


    public Organisation()
    {
        this.orgId = null;
    }

    public Organisation(String orgEmail, Status orgStatus) throws NoSuchAlgorithmException {
        MD5 md5 = new MD5();
        this.orgEmail = orgEmail;
        this.orgId = md5.getMd5(orgEmail);
        this.status = orgStatus;
    }


    public Organisation(String orgName,String slogan, String orgDescription, String orgSector, String orgEmail, String password, String contactPerson, String contactNumber) throws NoSuchAlgorithmException {
        MD5 md5 = new MD5();

        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.orgId = md5.getMd5(orgEmail);
        this.status = status.Active;
        //Must hash
        this.password = password;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
    }

    //Getters

    public String getOrgName() {
        return orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public String getOrgSector() {
        return orgSector;
    }

    public String getPassword() {
        return password;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public String getOrgId() {
        return orgId;
    }

    public Status getStatus() {
        return status;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public Boolean getAddressIsValid() {
        return addressIsValid;
    }

    public Boolean getDateIsValid() {
        return dateIsValid;
    }

    public Boolean getFiveImagesProvided() {
        return fiveImagesProvided;
    }

    public Boolean getImageProvided() {
        return imageProvided;
    }

    public Boolean getLongDescriptionProvided() {
        return longDescriptionProvided;
    }

    public Boolean getNgoNoProvided() {
        return ngoNoProvided;
    }

    public Boolean getTenImagesProvided() {
        return tenImagesProvided;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public int getPoints() {
        return points;
    }

    public List<String> getGalleryImages() {
        return galleryImages;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getNGONumber() {
        return NGONumber;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public String getSlogan() { return slogan; }

    //Setters


    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setOrgSector(String orgSector) {
        this.orgSector = orgSector;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAddressIsValid(Boolean addressIsValid) {
        this.addressIsValid = addressIsValid;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }

    public void setDateIsValid(Boolean dateIsValid) {
        this.dateIsValid = dateIsValid;
    }

    public void setFiveImagesProvided(Boolean fiveImagesProvided) {
        this.fiveImagesProvided = fiveImagesProvided;
    }

    public void setGalleryImages(List<String> galleryImages) {
        this.galleryImages = galleryImages;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageProvided(Boolean imageProvided) {
        this.imageProvided = imageProvided;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setLongDescriptionProvided(Boolean longDescriptionProvided) {
        this.longDescriptionProvided = longDescriptionProvided;
    }

    public void setNgoNoProvided(Boolean ngoNoProvided) {
        this.ngoNoProvided = ngoNoProvided;
    }

    public void setNGONumber(String NGONumber) {
        this.NGONumber = NGONumber;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTenImagesProvided(Boolean tenImagesProvided) {
        this.tenImagesProvided = tenImagesProvided;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public void setSlogan(String slogan) { this.slogan = slogan; }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String orgEmail = "hi";
        MD5 orgId = new MD5();

        System.out.println(orgId.getMd5(orgEmail));
    }

    public static class MD5 {
        public static String getMd5(String input)
        {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(input.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
