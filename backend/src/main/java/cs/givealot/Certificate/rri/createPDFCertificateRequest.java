package main.java.cs.givealot.Certificate.rri;

public class createPDFCertificateRequest {
    public String name;
    public String description;
    public String email;
    public String address;
    public String url;

    public createPDFCertificateRequest(String name, String description, String email, String address, String url) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.address = address;
        this.url = url;
    }
}
