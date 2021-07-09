package com.GiveaLot.givealot.Registration.rri;

/*step 1*/
public class organisationGetInfoRequest
{
    private String nameOfOrganisation;
    private String password;
    private String passwordConfirmation;

    /*
    * organisation key is not neccessary here as this is the first
    * step.
    * */

    public organisationGetInfoRequest(String nameOfOrganisation, String password, String passwordConfirmation) {
        this.nameOfOrganisation = nameOfOrganisation;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public void setNameOfOrganisation(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}

