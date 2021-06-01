package test.java.cs.givealot.CertificateUnitTest;

public class CertificateTest {

    String nameOfOrganisation;
    String descriptionOFOrganisation;
    String Email;
    String Address;
    String Url;
    Boolean isVerified;
    Boolean addressIsValid;

    public CertificateTest(String nameOfOrganisation, String descriptionOFOrganisation, String Email, String Address, String Url){
        this.nameOfOrganisation = nameOfOrganisation;
        this.descriptionOFOrganisation = descriptionOFOrganisation;
        this.Email = Email;
        this.Address = Address;
        this.Url = Url;
        this.isVerified = false;
        this.addressIsValid = false;
    }

    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    public String getDescriptionOFOrganisation() {
        return descriptionOFOrganisation;
    }
    p
}
