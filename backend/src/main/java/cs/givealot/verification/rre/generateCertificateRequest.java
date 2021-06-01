package main.java.cs.givealot.verification.rre;

public class generateCertificateRequest{

    private String name_of_organisation;
    private String description_of_organisation;
    private String email_of_organisation;
    private String address_of_organisation;
    private String url_of_organisation;

    public generateCertificateRequest(String name_of_organisation,
                                      String description_of_organisation,
                                      String email_of_organisation,
                                      String address_of_organisation)
    {
        this.name_of_organisation = name_of_organisation;
        this.description_of_organisation = description_of_organisation;
        this.email_of_organisation = email_of_organisation;
        this.address_of_organisation = address_of_organisation;
    }
}