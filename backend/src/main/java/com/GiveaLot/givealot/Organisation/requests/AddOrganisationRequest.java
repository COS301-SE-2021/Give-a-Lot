package com.GiveaLot.givealot.Organisation.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AddOrganisationRequest {

    private long orgId;
    private String orgName;
    private String slogan;
    private String orgDescription;
    private String orgSector;
    private String orgEmail;
    private String status;
    private String contactPerson;
    private String contactNumber;
    private String password;


    public AddOrganisationRequest(@JsonProperty ("orgName") String orgName,
                                  @JsonProperty ("slogan") String slogan,
                                  @JsonProperty ("orgDescription") String orgDescription,
                                  @JsonProperty ("orgSector") String orgSector,
                                  @JsonProperty ("orgEmail") String orgEmail,
                                  @JsonProperty ("contactPerson") String contactPerson,
                                  @JsonProperty ("contactNumber") String contactNumber,
                                  @JsonProperty ("password") String password
    )
    {
        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
        this.password =password;
    }

    public AddOrganisationRequest(long orgId,
                                  String orgName,
                                  String slogan,
                                  String orgDescription,
                                  String orgSector,
                                  String orgEmail,
                                  String status,
                                  String contactPerson,
                                  String contactNumber,
                                  String password
    )
    {
        this.orgId = orgId;
        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.status = status;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
        this.password =password;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName(){
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgSector() {
        return orgSector;
    }

    public void setOrgSector(String orgSector) {
        this.orgSector = orgSector;
    }

    public String getOrgEmail() {
        return orgEmail;
    }

    public void setOrgEmail(String orgEmail) {
        this.orgEmail = orgEmail;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassworrd(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AddOrganisationRequest{" +
                "orgName='" + orgName + '\'' +
                ", slogan='" + slogan + '\'' +
                ", orgDescription='" + orgDescription + '\'' +
                ", orgSector='" + orgSector + '\'' +
                ", orgEmail='" + orgEmail + '\'' +
                ", status='" + status + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class MD5 {
        public String getMd5(String input)
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
