package com.GiveaLot.givealot.Certificate.dataclass;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JSON {
    public String name;
    public String description;
    public String serverUrl;
    public String verificationCode;
    public String imageUrl;

    public JSON(){
        this.name = "";
        this.description = "";
        this.serverUrl = "";
        this.verificationCode = "";
        this.imageUrl = "";
    }

    public JSON( String name, String description, String url, String image) throws NoSuchAlgorithmException {
        this.name = name;
        this.description = description;
        this.serverUrl = url;
        this.verificationCode = generateVerificationCode(name);
        this.imageUrl = image;
        //System.out.println(this.verificationCode);
    }
    private String generateVerificationCode(String key) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(key.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        while(hashtext.length() < 32 ) {
            hashtext = "0" + hashtext;
        }
        hashtext = hashtext.toUpperCase();
        return hashtext;
    }
}
