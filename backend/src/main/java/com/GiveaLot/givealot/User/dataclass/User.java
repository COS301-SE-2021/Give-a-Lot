package com.GiveaLot.givealot.User.dataclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false,
            nullable = false,
            unique = true
    )
    private Long id;

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
            columnDefinition = "TEXT",
            unique = true
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
            name = "activation_date",
            columnDefinition = "TEXT"
    )
    private String activateDate;



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

    public User(Long id, String firstname, String lastname, String email, Boolean isAdmin, String password, String activateDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.isAdmin = isAdmin;
        this.password = password;
        this.activateDate = activateDate;
    }

    ////////////////////////////////////////////////// GETTERS //////////////////////////////////////////////////


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

    public String getActivateDate() {
        return activateDate;
    }

    public long getId() {
        return id;
    }


    public Boolean getAdmin() {
        return isAdmin;
    }



    ////////////////////////////////////////////////// SETTERS //////////////////////////////////////////////////


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



    public void setActivateDate(String activateDate) {
        this.activateDate = activateDate;
    }



    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}