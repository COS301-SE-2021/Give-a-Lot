package com.GiveaLot.givealot.Organisation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Entity(name="Organisations")
@Table(
        name="organisations",
        uniqueConstraints = {
                @UniqueConstraint(name="organisation_email_unique",columnNames = "org_email")
        }

)
public class Organisation {

    @Column(
            name="org_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String orgName;
    @Column(
            name="org_slogan",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String slogan;
    @Column(
            name="org_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String orgDescription;

    @Column(
            name="org_sector",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String orgSector;
    @Column(
            name="org_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String orgEmail;

    @Id
    @Column(
            name = "org_id",
            updatable = false,
            nullable = false
    )
    private Long orgId;

    @Column(
            name="status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String status;
    @Column(
            name="contact_person",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contactPerson;
    @Column(
            name="contact_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String contactNumber;
    @Column(
            name="directory",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String directory;
    @Column(
            name="password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;


    public Organisation(@JsonProperty Long orgId,
                        @JsonProperty String orgName,
                        @JsonProperty String slogan,
                        @JsonProperty String orgDescription,
                        @JsonProperty String orgSector,
                        @JsonProperty String orgEmail,
                        @JsonProperty String status,
                        @JsonProperty String contactPerson,
                        @JsonProperty String contactNumber,
                        @JsonProperty String directory,
                        @JsonProperty String password
    )
    {
        this.orgName = orgName;
        this.slogan = slogan;
        this.orgDescription = orgDescription;
        this.orgSector = orgSector;
        this.orgEmail = orgEmail;
        this.orgId = orgId;
        this.status = status;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
        this.directory = directory;
        this.password =password;
    }

    public Organisation() {

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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getPassword() {
        return password;
    }

    public void setPassworrd(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "orgName='" + orgName + '\'' +
                ", slogan='" + slogan + '\'' +
                ", orgDescription='" + orgDescription + '\'' +
                ", orgSector='" + orgSector + '\'' +
                ", orgEmail='" + orgEmail + '\'' +
                ", orgId='" + orgId + '\'' +
                ", status='" + status + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", directory='" + directory + '\'' +
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
