package com.GiveaLot.givealot.Registration.rri;

public class organisationGetContactDetailsRequest
{
    private String contactPerson;
    private String contactNumber;
    private String email;
    private String organisationKey;

    public organisationGetContactDetailsRequest(String contactPerson, String contactNumber, String email, String organisationKey) {
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.email = email;
        this.organisationKey = organisationKey;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisationKey() {
        return organisationKey;
    }

    public void setOrganisationKey(String organisationKey) {
        this.organisationKey = organisationKey;
    }
}
