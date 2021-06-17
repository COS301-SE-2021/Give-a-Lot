package com.GiveaLot.givealot.Organisation.dataclass;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.security.MessageDigest;
import java.util.Base64;

public class Organisation {

    String orgName;
    String orgDescription;
    String orgSector;
    String orgEmail;
    String orgId;
    Status status;
    String password;
    String contactPerson;
    String contactNumber;


    public Organisation(String orgEmail, Status orgStatus) throws NoSuchAlgorithmException {
        MD5 md5 = new MD5();

        this.orgEmail = orgEmail;
        this.orgId = md5.getMd5(orgEmail);
        this.status = orgStatus;

    }


    public Organisation(String orgName, String orgDescription, String orgSector, String orgEmail, String password, String contactPerson, String contactNumber) throws NoSuchAlgorithmException {
        MD5 md5 = new MD5();

        this.orgName = orgName;
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
