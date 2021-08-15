package com.GiveaLot.givealot.User.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email"),
                @UniqueConstraint(name = "reset_code_unique", columnNames = "reset_code")
        }
)
public class User{

    @Id
    @GeneratedValue(
            generator = "user_sequence"
    )
    @GenericGenerator(
            name = "user_sequence",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private String id;

    @Column(
            name = "firstname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
            name = "lastname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "is_admin",
            nullable = false,
            columnDefinition = "BOOLEAN"
    )
    private Boolean isAdmin = false;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;



    @Column(
            name = "activation_code",
            columnDefinition = "TEXT"
    )
    private String activationCode;

    @Column(
            name = "activate_date",
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime activateDate;

    @Column(
            name = "reset_code",
            columnDefinition = "TEXT"
    )
    private String resetCode;

    @Column(
            name = "reset_expiration",
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime resetExpiration;



    @Column (
            name = "last_logged_in",
            columnDefinition = "TIMESTAMP"
    )
    private LocalDateTime lastLoggedIn;


    @Column(
            name = "jwt_token",
            columnDefinition = "TEXT"
    )
    private String jwt_token;


    ////////////////////////////////////////////////// FUNCTIONS //////////////////////////////////////////////////

    public User() {
    }

    public User(String firstname,
                String lastname,
                String email,
                String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }


    ////////////////////////////////////////////////// GETTERS //////////////////////////////////////////////////

    public LocalDateTime getLastLoggedIn() {
        return lastLoggedIn;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getActivationCode() {
        return activationCode;
    }

    public LocalDateTime getActivateDate() {
        return activateDate;
    }

    public String getId() {
        return id;
    }

    public String getResetCode() {
        return resetCode;
    }

    public LocalDateTime getResetExpiration() {
        return resetExpiration;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getJwt_token() {
        return jwt_token;
    }


    ////////////////////////////////////////////////// SETTERS //////////////////////////////////////////////////

    public void setJwt_token(String jwt_token) {
        this.jwt_token = jwt_token;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setActivateDate(LocalDateTime activateDate) {
        this.activateDate = activateDate;
    }

    public void setResetCode(String resetCode) {
        this.resetCode = resetCode;
    }

    public void setResetExpiration(LocalDateTime resetExpiration) {
        this.resetExpiration = resetExpiration;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public void setLastLoggedIn(LocalDateTime lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\''+
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", activateDate=" + activateDate +
                ", resetCode='" + resetCode + '\'' +
                ", resetExpiration=" + resetExpiration  + '\''+
                ", isAdmin=" + isAdmin  + '\''+
                ", lastLoggedIn=" + lastLoggedIn  + '\''+
                '}';
    }

}