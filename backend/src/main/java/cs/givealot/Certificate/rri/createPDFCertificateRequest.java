package main.java.cs.givealot.Certificate.rri;

public class createPDFCertificateRequest {
    private String name;
    private String description;
    private String email;
    private String address;
    private String url;

    public createPDFCertificateRequest(String name, String description, String email, String address, String url) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.address = address;
        this.url = url;
    }
}
