package com.GiveaLot.givealot.Login.model;

import com.GiveaLot.givealot.User.dataclass.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "token",nullable = false)
    private String token;


    @Column(name = "email",nullable = false)
    private String userEmail;

    public PasswordResetToken(String token, String userEmail) {
        this.token = token;
        this.userEmail = userEmail;
    }

    public PasswordResetToken() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}