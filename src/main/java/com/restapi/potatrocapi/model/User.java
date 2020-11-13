package com.restapi.potatrocapi.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
@Entity
@Table(name = "user", schema = "potatroc")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long user_id;

    @Column(name = "authid")
    private String authid;

    @Column(name = "email")
    private String email;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "admin", columnDefinition = "boolean default false")
    private boolean admin;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name = "location_user_id")
    @JsonIgnoreProperties("user")
    private Location location;

    public User() {
    }

    public User( String authid, String email, String pseudo, String name, String surname, Location location, boolean admin){
        this.authid = authid;
        this.email = email;
        this.pseudo = pseudo;
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.admin = admin;
    }
    public void setId( long user_id ) {
        this.user_id =  user_id;
    }
    public long getId() {
        return user_id;
    }

    public void setAuthid (String authid) {
        this.authid = authid;
    }
    public String getAuthid() {
        return this.authid;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getPseudo() {
        return this.pseudo;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return this.surname;
    }

    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }

    public void setAdmin(boolean admin){
        this.admin = admin;
    }
    public boolean getAdmin(){
        return this.admin;
    }
}
